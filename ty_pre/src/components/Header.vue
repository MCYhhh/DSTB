<template>
    <div>
        <div style="display: flex;font-size: 30px" >
        <i :class="icon" style="margin-top: 10px;cursor:pointer" @click="collapse"></i>
        <div style="flex:1; text-align:center ;letter-spacing:8px;">
            <i >欢迎来到同源有限公司管理系统</i>
        </div>
    </div>
    
      <el-dropdown style="top:-20px" >
          <span >{{$store.state.user.uname}}</span><i class="el-icon-arrow-down" style="margin-left: 10px"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item @click.native="toUser">退出登录</el-dropdown-item>
          <el-dropdown-item @click.native="loginout">退出系统</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
</template>
<style scoped>
 .el-header {
    /* background-color: #B3C0D1; */
    color: #333;
    line-height: 60px;
  }
  
  .el-aside {
    color: #333;
  }
</style>

<script>

  export default {
    name: "Header",
    props:{
        icon:String
    },
    methods:{
        toUser(){
            // console.log("to_user")
            this.$router.push('/loginUser');
        },
        loginout(){
            this.$router.push('/type');
        },
        collapse(){
            // console.log("jajjjj")
            this.$emit('doCollapse');
        },
    }
  };
</script>
