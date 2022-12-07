<template>
    <div class="login_container">
        <div class="login_box">
            <!-- 头像区域 -->
            <div class="avator_box">
                <img src="../assets/image/logo(白).png" alt="">
            </div>
            <div class="login_content">
                <!-- 登录表单 -->
                <el-form ref="loginFormRef" :model="loginForm" :rules="loginFormRules" label-width="80px" >
                    <el-form-item label="用户账号" prop="uaccount" class="item">
                        <el-input v-model="loginForm.uaccount" prefix-icon="el-icon-user-solid" ></el-input>
                    </el-form-item>
                    <el-form-item label="用户密码" prop="upwd" class="item">
                        <el-input v-model="loginForm.upwd" prefix-icon="el-icon-unlock" type="password"></el-input>
                    </el-form-item>
                    <el-form-item class="btn">
                        <el-button type="primary" round @click="login">登录</el-button>
                        <el-button type="info" round @click="resetLoginForm">重置</el-button>
                         <!-- 如果还没有账号，跳到登录页 -->
                    <el-link type="warning" @click="$router.push('/register')" style="color:#909399" :underline="false">没有账号？去注册</el-link>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
// import { defineComponent } from '@vue/composition-api'
// prop属性设置为需校验的字段名
import { loginUserApi } from "@/api/index";
// import { setToken } from '@/utils/auth'  //引入存token
export default ({
    data(){   
        return{
            //这是登录表单的数据绑定对象
            loginForm:{
                uaccount: '',
                upwd: '',
                // checkupwd: ''
            },
            //这是表单的验证规则对象
            loginFormRules: {
                uaccount: [
                    { required: true, message: '请输入用户账号', trigger: 'blur' },
                    { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
                ],
                upwd: [
                    { required: true, message: '请输入用户密码', trigger: 'blur' },
                    { min: 6, max: 20, message: '长度在 6 到 20 个字符', trigger: 'blur' },
                    { trigger: 'blur' }
                ],
            }
        }
    },
    methods: {
      //点击重置按钮，重置表单
      resetLoginForm() {
         // console.log(this)
         this.$refs.loginFormRef.resetFields();
      },
      login(){
        this.$refs.loginFormRef.validate(async (valid) =>{
          if(valid){
            const json=JSON.stringify(this.loginForm);
            const {data: res}=await loginUserApi(json);
            console.log(res);
            if(res.code!==200)
                return this.$message.error("登录失败");
            this.$message.success("登录成功");
            console.log(res.data)
            console.log(typeof res.data)
           localStorage.setItem("type",0)
           localStorage.setItem("user",JSON.stringify((res.data)));     //存储用户信息到浏览器
            // console.log(this.$store.state.user);
            this.$router.push("/home")  //跳转到首页
 
          }
        })
      }
    },

})
</script>

<style>
.item el-form-item__label{
    color: rgb(255, 255, 255);
  }
</style>
<style scoped>
.login_container{
    background: url('../assets/image/background4.gif') no-repeat;
    background-size: 100% auto ;
    /* background-color:rgb(51, 255, 0); */
    height: 100%;
    /* background:linear-gradient(90deg,rgb(238, 209, 215),#b4d8f3); */
    width: 100%;
}
.login_box{
    width: 450px;
    height: 300px;
    background-color: azure;
    position: absolute;
    border-radius: 10px;
    left: 50%;
    top: 50%;
    transform: translate(-50%,-50%);
    background:linear-gradient(90deg,rgb(238, 209, 215),#b4d8f3);
    /* background-image:url('../assets/image/background5.gif'); 
    background-size: 100% 100% ;
    background-repeat: no-repeat;  */
}
.avator_box {
    border: 1px solid rgb(139, 179, 220);
    border-radius: 50%;
    height: 130px;
    width: 130px;
    padding: 10px;
    box-shadow: 0 0 10px gray;
    position: absolute;
    left:50%;
    transform: translate(-50%,-70%);
    background-color:rgb(163, 209, 233);
}

  .avator_box img{
  height: 100%;
  width: 100%;
  border-radius: 50%;
  background-color:rgb(244,232,213);
}
.btn{
    display: flex;
    justify-content: flex-end;
    height: 40px;
    width: 100%;
}
.login_content{
    position:absolute;
    width: 400px;
    margin-top: 70px;
    bottom: 0px;
    box-sizing: border-box;

}
</style>
