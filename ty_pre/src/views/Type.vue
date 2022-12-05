<template>
      <div class="type" style="margin:0 auto">
        <el-radio-group v-model="radio" class="item">
            <el-radio :label="0">普通用户</el-radio>
            <el-radio :label="1">公司人员</el-radio>
        </el-radio-group>
        <el-button @click.native="toLogin">确定</el-button>
    </div>
</template>

<script>
export default {
    name: 'Type',
    data () {
      return {
        radio: 0
      };
    },
    methods:{
       toLogin(){
        if(this.radio===0)
            this.$router.push("/loginUser")
        // if(this.radio===1)
        else
            this.$router.push("/loginWorker")
        }
    },
}
</script>
<style scoped>
.item-el-radio-group{
    margin: 0 auto;
}
</style>