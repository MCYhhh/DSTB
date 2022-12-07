import myAxios from '../utils/request'

// 查询所有用户api
export function listAllApi() {
    return myAxios({
        url: '/user/findAll',
        method: 'get'
    })
}

// 分页查询所有用户api
export function pageUserApi(json) {
    return myAxios({
        url: '/user/pagedefine',
        method: 'post',
        data: json
    })
}

// 用户登录api
export function loginUserApi(json) {
    return myAxios({
        url: '/user/login',
        method: 'post',
        data: json
    })
}

// 用户注册api 
export function registerUserApi(json) {
    return myAxios({
        url: '/user/register',
        method: 'post',
        data: json
    })
}

// 公司人员登录api
export function loginWokerApi(json) {
    return myAxios({
        url: '/worker/login',
        method: 'post',
        data: json
    })
}

// 查询所有产品api
export function FindElectronicsApi() {
    return myAxios({
        url: '/electronics/findAll',
        method: 'get',
    })
}


// 模糊查询用户api
export function BlurUserApi(json) {
    return myAxios({
        url: '/user/blur',
        method: 'post',
        data:json
    })
}

// 查询用户的订单
export function MyOrderApi(uid) {
    return myAxios({
        url: '/orderelectronic/myorder?id='+uid +"&token="+localStorage.getItem("user").token,
        method: 'get',
        data:uid
    })
}

// 查询销售人员的客户
export function MyUserApi(wid) {
    return myAxios({
        url: '/orderuser/myuser?id='+wid +"&token="+localStorage.getItem("user").token,
        method: 'get',
        data:wid
    })
}

// 查询销售人员负责的订单
export function MyUserOrderApi(wid) {
    return myAxios({
        url: '/orderelectronicw/myorder?id='+wid +"&token="+localStorage.getItem("user").token,
        method: 'get',
        data:wid
    })
}

// 查询所有销售人员api
export function listAllWorker0Api() {
    return myAxios({
        url: '/worker/findAll',
        method: 'get'
    })
}
