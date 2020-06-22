<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="quantity">
      <el-input v-model="dataForm.quantity" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="bid">
      <el-input v-model="dataForm.bid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="uid">
      <el-input v-model="dataForm.uid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="orderby">
      <el-input v-model="dataForm.orderby" placeholder=""></el-input>
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
          cartitemid: 0,
          quantity: '',
          bid: '',
          uid: '',
          orderby: ''
        },
        dataRule: {
          quantity: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          bid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          uid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          orderby: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.cartitemid = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.cartitemid) {
            this.$http({
              url: this.$http.adornUrl(`/book/cartitem/info/${this.dataForm.cartitemid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.quantity = data.cartitem.quantity
                this.dataForm.bid = data.cartitem.bid
                this.dataForm.uid = data.cartitem.uid
                this.dataForm.orderby = data.cartitem.orderby
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
              url: this.$http.adornUrl(`/book/cartitem/${!this.dataForm.cartitemid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'cartitemid': this.dataForm.cartitemid || undefined,
                'quantity': this.dataForm.quantity,
                'bid': this.dataForm.bid,
                'uid': this.dataForm.uid,
                'orderby': this.dataForm.orderby
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
