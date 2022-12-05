<template>
    <div id="module" style="position: relative;">
        <el-container style="height: 100%; border: 1px solid #eee">
        <el-aside :width="aside_width" style="background-color: rgb(238, 241, 246);height: 100%; margin-left:-1px">
            <Nav0 :isCollapse="isCollapse"></Nav0>
        </el-aside>
            <el-container>
                <el-header style="text-align: right; font-size: 12px ;border-bottom: rgba(168,168,168,.3) 1px solid">
                <Header @doCollapse="doCollapse" :icon="icon"></Header>
                </el-header>
            <!-- 右侧主体 -->
            <el-main>
                <router-view/>
            </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import Nav0 from '@/components/Nav0'   //引入导航栏
import Header from '@/components/Header'   //引入导航栏
export default {
    name:'Worker0Home',
    components:{Nav0,Header},
    data(){
        return{
            isCollapse:false,
            aside_width:'200px',
            icon:'el-icon-s-fold'
        }
    },
    methods:{
        goBack(){
            this.$router.push("/type");
        },
         doCollapse(){
            console.log("jajjjj")
            this.isCollapse=!this.isCollapse
            if(!this.isCollapse)   {  //展开
                this.aside_width='200px',
                this.icon='el-icon-s-fold'
            }
            else{  //收起
                this.aside_width='50px',
                this.icon='el-icon-s-unfold'
            }
        },
    }
}
</script>