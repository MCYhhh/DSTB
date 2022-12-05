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