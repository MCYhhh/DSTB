// 基于axios封装，网络请求的函数
import axios from "axios";
// import { getToken } from "./auth";

//创建一个自定义的axios方法（比原axios多了个基地址）
// axios函数请求的url地址前面会被拼接基地址，然后axios请求baseURL+url后台完整地址
// axios.defaults.headers["Content-Type"] = "application.json ; charset=utf-8"

const myAxios = axios.create({
    baseURL: "http://localhost:8082"
})


// request 拦截器---请求拦截器
// 可以自请求发送前对请求做一些处理
// 比如统一加token，对请求参数统一加密
myAxios.interceptors.request.use(config => {
    config.headers['Content-Type'] = 'application/json;charset=utf-8';
    let user = JSON.parse(localStorage.getItem("user")) ? JSON.parse((localStorage.getItem("user"))) : null
    if (user) {
        console.log(user.token)
        config.headers['token'] = user.token;  // 设置请求头
    }
    return config;
})

// 响应拦截器
myAxios.interceptors.response.use(res=>{
    return res
}),err=>{
    return Promise.reject(err)
}

export default myAxios

// response 拦截器---响应拦截器
// 可以在接口响应后统一处理结果
// ######注意注意这里会将后端返回的结果做处理，可能接受不到后端传来的code，msg等
// myAxios.interceptors.response.use(
//     response => {
//         let res = response.data;
//         // 如果是返回的文件
//         if (response.config.responseType === 'blob') {
//             return res
//         }
//         // 兼容服务端返回的字符串数据
//         if (typeof res === 'string') {
//             res = res ? JSON.parse(res) : res
//         }
//         return res;
//     },
//     error => {
//         console.log('err' + error) // for debug
//         return Promise.reject(error)
//     }
// )

