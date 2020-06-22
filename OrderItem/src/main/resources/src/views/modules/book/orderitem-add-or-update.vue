<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="quantity">
      <el-input v-model="dataForm.quantity" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="subtotal">
      <el-input v-model="dataForm.subtotal" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="bid">
      <el-input v-model="dataForm.bid" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="bname">
      <el-input v-model="dataForm.bname" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="currprice">
      <el-input v-model="dataForm.currprice" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="imageB">
      <el-input v-model="dataForm.imageB" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="oid">
      <el-input v-model="dataForm.oid" placeholder=""></el-input>
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
          orderitemid: 0,
          quantity: '',
          subtotal: '',
          bid: '',
          bname: '',
          currprice: '',
          imageB: '',
          oid: ''
        },
        dataRule: {
          quantity: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          subtotal: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          bid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          bname: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          currprice: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          imageB: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          oid: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.orderitemid = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.orderitemid) {
            this.$http({
              url: this.$http.adornUrl(`/book/orderitem/info/${this.dataForm.orderitemid}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.quantity = data.orderitem.quantity
                this.dataForm.subtotal = data.orderitem.subtotal
                this.dataForm.bid = data.orderitem.bid
                this.dataForm.bname = data.orderitem.bname
                this.dataForm.currprice = data.orderitem.currprice
                this.dataForm.imageB = data.orderitem.imageB
                this.dataForm.oid = data.orderitem.oid
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
              url: this.$http.adornUrl(`/book/orderitem/${!this.dataForm.orderitemid ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'orderitemid': this.dataForm.orderitemid || undefined,
                'quantity': this.dataForm.quantity,
                'subtotal': this.dataForm.subtotal,
                'bid': this.dataForm.bid,
                'bname': this.dataForm.bname,
                'currprice': this.dataForm.currprice,
                'imageB': this.dataForm.imageB,
                'oid': this.dataForm.oid
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
