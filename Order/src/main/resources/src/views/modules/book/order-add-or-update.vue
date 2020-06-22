<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="ordertime">
      <el-input v-model="dataForm.ordertime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="total">
      <el-input v-model="dataForm.total" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="status">
      <el-input v-model="dataForm.status" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="address">
      <el-input v-model="dataForm.address" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uid">
      <el-input v-model="dataForm.uid" placeholder=""></el-input>
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
          oid: 0,
          ordertime: '',
          total: '',
          status: '',
          address: '',
          uid: ''
        },
        dataRule: {
          ordertime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          total: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          address: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.oid = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.oid) {
            this.$http({
              url: this.$http.adornUrl(`/book/order/info/${this.dataForm.oid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.ordertime = data.order.ordertime
                this.dataForm.total = data.order.total
                this.dataForm.status = data.order.status
                this.dataForm.address = data.order.address
                this.dataForm.uid = data.order.uid
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
              url: this.$http.adornUrl(`/book/order/${!this.dataForm.oid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'oid': this.dataForm.oid || undefined,
                'ordertime': this.dataForm.ordertime,
                'total': this.dataForm.total,
                'status': this.dataForm.status,
                'address': this.dataForm.address,
                'uid': this.dataForm.uid
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
