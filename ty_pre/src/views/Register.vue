<template>
    <div class="login_container">
        <div class="login_box">
            <!-- 头像区域 -->
            <div class="avator_box">
                <img src="../assets/image/logo(白).png" alt="">
            </div>
            <div class="login_content">
                <!-- 登录表单 -->
                <el-form ref="registerFormRef" :model="registerForm" :rules="registerFormRules" label-width="80px" >
                    <el-form-item label="用户账号" prop="uaccount" class="item">
                        <el-input v-model="registerForm.uaccount" prefix-icon="el-icon-user-solid" ></el-input>
                    </el-form-item>
                     <el-form-item label="用户昵称" prop="uname" class="item">
                        <el-input v-model="registerForm.uname" prefix-icon="el-icon-help" ></el-input>
                    </el-form-item>
                    <el-form-item label="用户密码" prop="upwd" class="item">
                        <el-input v-model="registerForm.upwd" prefix-icon="el-icon-unlock" type="password"></el-input>
                    </el-form-item>
                    <el-form-item label="确认密码" prop="checkupwd" class="item">
                        <el-input v-model="registerForm.checkupwd" prefix-icon="el-icon-unlock" type="password"></el-input>
                    </el-form-item>
                    <el-form-item label="用户性别" prop="usex" class="item">
                      <el-radio v-model="registerForm.usex" label="1" >男</el-radio>
                      <el-radio v-model="registerForm.usex" label="2" >女</el-radio>
                    </el-form-item>
                      <el-form-item label="用户电话" prop="utel" class="item">
                        <el-input v-model="registerForm.utel" prefix-icon="el-icon-phone-outline" ></el-input>
                    </el-form-item>
                    <el-form-item class="btn">
                        <el-button type="primary" round @click="register">注册</el-button>
                        <el-button type="info" round @click="resetRegisterForm">重置</el-button>
                          <!-- 前往登录 -->
                        <el-link type="warning" @click="$router.push('/loginUser')" style="color:#909399" :underline="false">已注册？前往登录</el-link>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>

<script>
// import { defineComponent } from '@vue/composition-api'
// prop属性设置为需校验的字段名
import { registerUserApi } from "@/api/index";
export default ({
  name: "myRegister",
    data(){
      var isPhone=(rule,value,callback)=>{
               var reg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
                if(this.registerForm.utel.length ===11){
                    if(!reg.test(this.registerForm.utel)){
                        callback("请输入正确的电话号码");
                    }else {
                         callback();
                    }
                }else {
                  if(!value)
                    return callback(new Error("电话号码不能为空"));
                  else
                    callback("请输入正确的电话号码");
                }
      }
      var recheckupwd = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.registerForm.upwd) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };

        return{
            //这是登录表单的数据绑定对象
            registerForm:{
                uaccount: '',
                upwd: '',
                uname:"",
                usex:"",
                uimage:"1",
                utel:"",
                usite:"1",
                checkupwd: ''
            },
            //这是表单的验证规则对象
            registerFormRules: {
                uaccount: [
                    { required: true, message: '请输入用户账号', trigger: 'blur' },
                    { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
                ],
                uname: [
                    { required: true, message: '请输入用户昵称', trigger: 'blur' },
                ],
                upwd: [
                    { required: true, message: '请输入用户密码', trigger: 'blur' },
                    { min: 6, max: 20, message: '长度在 6 到 20 个字符', trigger: 'blur' },
                    { trigger: 'blur' }
                ],
                utel: [{ validator: isPhone,required: true , trigger: "blur"}],
                checkupwd: [{ validator: recheckupwd, required: true ,trigger: "blur" }],
                usex: [{ required: true, message: '请选择用户性别', trigger: 'blur' },],
            }
        }
    },
    methods: {
      //点击重置按钮，重置表单
      resetRegisterForm() {
         // console.log(this)
        this.$refs.registerFormRef.resetFields();
      },
      register(){
        this.$refs.registerFormRef.validate(async (valid) =>{
          // console.log(valid)
          // this.$refs[this.registerForm].validate( async (valid) => {
          if(valid){
            if(this.registerForm.usex==="1")
              this.registerForm.usex="男"
            else
              this.registerForm.usex="女"
            console.log(this.registerForm)
            const json=JSON.stringify(this.registerForm);
            const {data: res}=await registerUserApi(json);
            // console.log(res);
            if(res.code!==200)
                return this.$message.error("注册失败");
            this.$message.success("注册成功");
             this.$router.push('loginUser')
          }
        })
      }
    },

})
</script>
<style lang="sss" scoped>
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
    height: 490px;
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
.item .el-form-item__label{
    color: rgb(255, 255, 255);
  }

</style>