<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="adminname">
      <el-input v-model="dataForm.adminname" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="adminpwd">
      <el-input v-model="dataForm.adminpwd" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          adminid: 0,
          adminname: '',
          adminpwd: ''
        },
        dataRule: {
          adminname: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          adminpwd: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.adminid = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.adminid) {
            this.$http({
              url: this.$http.adornUrl(`/book/admin/info/${this.dataForm.adminid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.adminname = data.admin.adminname
                this.dataForm.adminpwd = data.admin.adminpwd
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/book/admin/${!this.dataForm.adminid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'adminid': this.dataForm.adminid || undefined,
                'adminname': this.dataForm.adminname,
                'adminpwd': this.dataForm.adminpwd
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
