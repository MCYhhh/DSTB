<template>
    <div>
    <el-card shadow="always">
        <el-descriptions class="margin-top" title="个人信息详情" :column="4" direction="vertical">
         <el-descriptions-item label="用户账号" >{{mine.uaccount}}</el-descriptions-item>
        <el-descriptions-item label="用户名">{{mine.uname}}</el-descriptions-item>
        <el-descriptions-item label="手机号">{{mine.utel}}</el-descriptions-item>
        <!-- <el-descriptions-item label="居住地" :span="2">{{usite}}</el-descriptions-item> -->
        <el-descriptions-item label="备注">
            <el-tag size="small">普通用户</el-tag>
        </el-descriptions-item>
        <el-descriptions-item label="联系地址">{{mine.usite}}</el-descriptions-item>
    </el-descriptions>
    </el-card>
    </div>

</template>
<script>
export default {
   name:'MineWorker0',
   data(){
    return{
        mine: {},
        form:{
        uaccount:'',
        uname:'',
        utel:'',
        usite:''
      },
    }
   },
   methods:{
    async loadGet(){
        let user=JSON.parse(localStorage.getItem("user"))
        console.log(user)
        this.mine=user;
    }

   },
   created(){
        this.loadGet();
    }
}
</script>
<style scoped>
    .el-card{
        width: 1600px;
        margin: 10px auto;
    }
</style>