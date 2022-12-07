<template>
    <!-- 左侧导航栏 -->
     <el-menu
      default-active="1"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      style="height:100vh;width:200px;"
      router>

        <el-menu-item :index="v.url" v-for="v in items" :key="v.url">
            <i :class="v.icon"></i>
            <span slot="title">{{v.title}}</span>
        </el-menu-item>
     </el-menu>

</template>

<script>
export default {
  name: 'Nav0',
  data(){
    return{
        items:[
            {title:'首页',icon:'el-icon-s-home',url:'/home0'},
            {title:'客户管理',icon:'el-icon-s-custom',url:'/mycustomer'},
            // {title:'客户跟进',icon:'el-icon-s-management',url:'/process'},
             {title:'订单管理',icon:'el-icon-s-order',url:'/order'},
            {title:'个人中心',icon:'el-icon-house',url:'/mine0'},
        ]
    }
  },
  methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    },
}
</script>