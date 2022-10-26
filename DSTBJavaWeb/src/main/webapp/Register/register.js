window.onload = function(){
    //给表单绑定onsubmit事件
    document.getElementById("RegisterDiv").onsubmit = function () {
        return checkUaccount && checkUname && checkUpwd && checkReupwd && checkUaccount && checkUtel;
    }

};
        function checkUaccount(){
            var uaccount=document.getElementById("uaccount").value;
            var uacontent=document.getElementById("uacontent");
            if(uaccount!="")
                uacontent.innerHTML = "<img src='/image/正确.png' width='20' height='20'>";
            else
                uacontent.innerHTML = "<img src='/image/错误.png' width='20' height='20'>";
        }

        // 校验密码
        function checkUpwd(){
            //判断密码，正则表达式：长度为6~20，且包含数字、字母、其他符号的密码
            var password = document.getElementById("upwd").value;
            var regpwd = /(?=.*[a-z])(?=.*\d)(?=.*[#@!~%^&*])[a-z\d#@!~%^&*]{6,20}/i;
            var upcontent=document.getElementById("upcontent");
            if (regpwd.test(password)) {
                upcontent.innerHTML = "<img src='/image/正确.png' width='20' height='20'>";
                return false;
            }
            else
                upcontent.innerHTML = "<img src='/image/错误.png' width='20' height='20'>";
        }
        function checkReupwd() {
            //判断两次输入密码是否一致
            var password=document.getElementById("upwd").value;
            var checkpassword=document.getElementById("checkupwd").value;
            var ucpcontent=document.getElementById("ucpcontent");
            if(password==checkpassword && checkpassword!=""){
                 ucpcontent.innerHTML = "<img src='/image/正确.png' width='20' height='20'>";
                return false;
            }
            else
               ucpcontent.innerHTML = "<img src='/image/错误.png' width='20' height='20'>";
        }
        function checkUname(){
            var uname=document.getElementById("uname").value;
            var uncontent=document.getElementById("uncontent");
            if(uname!="")
                uncontent.innerHTML = "<img src='/image/正确.png' width='20' height='20'>";
            else
                uncontent.innerHTML = "<img src='/image/错误.png' width='20' height='20'>";
        }
        function checkUtel(){
             //    判断电话号码
            var tel=document.getElementById("utel").value;
            var regtel=/^1[34578]\d{9}$/;
            var utcontent=document.getElementById("utcontent");
            if(regtel.test(tel) && tel.length==11){
                utcontent.innerHTML = "<img src='/image/正确.png' width='20' height='20'>";
                return false;
            }
            else
              utcontent.innerHTML = "<img src='/image/错误.png' width='20' height='20'>";

        }