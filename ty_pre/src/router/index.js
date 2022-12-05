import Vue from 'vue'
import Router from 'vue-router'

import '../assets/global.css'
import Layout from "@/Layout/index";
// import LoginUser from '@/views/LoginUser'
// import LoginWorker from '@/views/LoginWorker'
// import Register from '@/views/Register'
// import Home from '@/views/User/Home'
// import Type from '@/views/Type'

import VueRouter from 'vue-router';
import { path } from 'chromedriver';

Vue.use(Router)

// const router= new Router({
//   mode:"history",
//   routes: [
//     {
//       path: "/",
//       redirect: "/type"

//     },
//     {  
//       path: "/layout",
//       redirect: localStorage.getItem("user") ? '/layout/user' : '/type',
//       component: layOut,
//       children: [ 					 // 通过children配置子级路由
//           {
//               path: 'user',	        // 用户首页
//               component: Home,
//               // meta: {
//               //     isShow: true,
//               //     span: 19
//               // }
//           },
//           {
//             path: 'worker0',	        // 销售人员页面
//             component: () => import ('@/views/Worker0/myCustomer.vue'),
//             redirect: "layout/worker0/mycustomer",
//             children: [
//               {
//                 path: "mycustomer",
//                 component: () => import ('@/views/Worker0/myCustomer.vue'),
//               }
//             ]
//             // meta: {
//             //     isShow: true,
//             //     span: 19
//             // }
//         },
//         ]
//     },
//     {
//       path: '/loginWorker',
//       name: 'LoginWorker',
//       component: LoginWorker
//       // component: () => import ('@/view/Login.vue'),
//     },
//     {
//       path: '/register',
//       name: 'Register',
//       component: Register
//     },
//     {
//       path: '/loginUser',
//       name: 'LoginUser',
//       component: LoginUser 
//     },
//     {
//       path: '/type',
//       name: 'Type',
//       component: Type
//     }
//   ]
// })

//根据复用数据动态显示路由

const routes=[
  {
    path: '/',
    redirect: '/type'
  },
  {
    path: '/type',
    name: 'Type',
    component: () => import ('@/views/Type')
  },
    {
    path: '/loginWorker',
    name: 'LoginWorker',
    component: () => import ('@/views/LoginWorker')
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import ('@/views/Register')
  },
  {
    path: '/loginUser',
    name: 'LoginUser',
    component: () => import ('@/views/LoginUser') 
  },
  {
    path: '/user',
    name: 'UserHome',
    // component: Layout,
    component: () => import ('@/views/User/UserHome'),
    children:[
      {
      path: "/home",  //用户首页
      // name:"Home",
      component:()=>import('@/views/User/Home')
    },
    {
      path: "/myOrder",  //我的订单
      name:"MyOrder",
      component:()=>import('@/views/User/MyOrder')
    },
    {
      path: "/collect",  //我的收藏
      name:"Collect",
      component:()=>import('@/views/User/Collect')
    },
    {
      path: "/mine",  //个人中心
      name:"MineUser",
      component:()=>import('@/views/User/Mine')
    }
    ] 
  },
  {
    path: '/worker0',
    name: 'Worker0Home',
    // component: Layout,
    component: () => import ('@/views/Worker0/Worker0Home'),
    children:[
      {
      path: "/home0",  //销售人员首页
      // name:"Home",
      component:()=>import('@/views/Worker0/Home')
    },
    {
      path: "/mycustomer",  //客户管理
      name:"myCustomer",
      component:()=>import('@/views/Worker0/myCustomer')
    },
    {
      path: "/process",  //客户跟进
      name:"Process",
      component:()=>import('@/views/Worker0/Process')
    },
    {
      path: "/order",  //订单管理
      name:"Order",
      component:()=>import('@/views/Worker0/Order')
    },
    {
      path: "/mine0",  //个人中心
      name:"MineWorker0",
      component:()=>import('@/views/Worker0/Mine')
    }
    ] 
  },
  {
    path: '/worker1',
    name: 'Worker1Home',
    // component: Layout,
    component: () => import ('@/views/Worker1/Worker1Home'),
    children:[
      {
      path: "/home1",  //销售人员首页
      // name:"Home",
      component:()=>import('@/views/Worker1/Home')
    },
    {
      path: "/wcustomer",  //客户管理
      name:"Wcustomer",
      component:()=>import('@/views/Worker1/Wcustomer')
    },
    {
      path: "/sale",  //销售管理
      name:"Sale",
      component:()=>import('@/views/Worker1/Sale')
    },
    {
      path: "/worder",  //订单管理
      name:"Order",
      component:()=>import('@/views/Worker1/Order')
    },
    {
      path: "/mine1",  //个人中心
      name:"MineWorker1",
      component:()=>import('@/views/Worker1/Mine')
    }
    ] 
  },
]


// navData.forEach(item => {
//   routes.push({
//     path: item.path,
//     name: item.name,
//     meta: {title:item.title},
//     component: ()=>import("../Layout/index/"+item.component)
//   })
  
// });

const router=new VueRouter({
  // linkActiveClass:'select',
  routes
})

export default router


//挂载路由导航守卫---路由拦截
// router.beforeEach((to,from,next)=>{
//   // to表示将要访问的路径
//   // from表示从哪个路径访问
//   // next是一个函数，表示放行
//   // next（）放行   next('/login)  强制跳转
//   if(to.path==='/loginUser') return next();
//   // 获取token
//   const tokenStr=window.localStorage.getItem('token')
//   if(!tokenStr) return next('/login')
//   next()
// })
// export default router

