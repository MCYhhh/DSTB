<template>
    <div>
    <el-card shadow="always">
        <el-descriptions class="margin-top" title="个人信息详情" :column="4" direction="vertical">
         <el-descriptions-item label="用户账号" >{{mine.waccount}}</el-descriptions-item>
        <el-descriptions-item label="用户名">{{mine.wname}}</el-descriptions-item>
        <el-descriptions-item label="手机号">{{mine.wtel}}</el-descriptions-item>
        <!-- <el-descriptions-item label="居住地" :span="2">{{usite}}</el-descriptions-item> -->
        <el-descriptions-item label="备注">
            <el-tag size="small">管理人员</el-tag>
        </el-descriptions-item>
        <el-descriptions-item label="联系地址">{{mine.wsite}}</el-descriptions-item>
    </el-descriptions>
    </el-card>
    </div>
</template>

<script>
export default {
   name:'Mine',
   data(){
    return{
        mine: {},
        form:{
        waccount:'',
        wname:'',
        wtel:'',
        wsite:''
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
