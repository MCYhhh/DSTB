<template>
<!-- <div style="display: flex" > -->
   

<el-container style="height: 100%; border: 1px solid #eee">
  <el-aside :width="aside_width" style="background-color: rgb(238, 241, 246);height: 100%; margin-left:-1px">
    <Aside :isCollapse="isCollapse"></Aside>
  </el-aside>
  <el-container>
    <el-header style="text-align: right; font-size: 12px ;border-bottom: rgba(168,168,168,.3) 1px solid">
    <Header @doCollapse="doCollapse" :icon="icon"></Header>
    </el-header>
    
    <el-main>
   <Main></Main>
    </el-main>
  </el-container>
</el-container>
<!-- </div> -->
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
import Aside from "./Aside.vue"
import Main from "./Main.vue"
import Header from "./Header.vue"

  export default {
    name: "Index",
    components: {Header,Aside,Main},
    data(){
        return{
            isCollapse:false,
            aside_width:'200px',
            icon:'el-icon-s-fold'
        }
    },
    methods: {
       doCollapse(){
            console.log("jajjjj")
            this.isCollapse=!this.isCollapse
            if(!this.isCollapse)   {  //展开
                this.aside_width='200px',
                this.icon='el-icon-s-fold'
            }
            else{  //收起
                this.aside_width='64px',
                this.icon='el-icon-s-unfold'
            }
        },

    }
  };
</script>
