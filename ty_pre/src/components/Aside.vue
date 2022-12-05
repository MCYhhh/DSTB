<template>
  <div class="sidebar">
    <div class="title">同源公司有限管理系统</div>
      <ul>
          <li v-for="(v,i) in navData" :key=i>
            <router-link :to="v.path">
              <i class="iconfont" :class="v.icon"></i>
                <span>{{v.title}}</span>
            </router-link>
          </li>
      </ul>
  </div>    
</template>

<script>
import navData from "@utils/navData"    //复用数据
export default {
  name: "Home",
  data(){
    return{
       navData
        // isCollapse:false
    }
  },
    // props: {
    // isCollapse:Boolean
// }
//   data(){
    // return{
    //   user:{},
    // }
//   },
//   created() {
//     let str = sessionStorage.getItem("user") || "{}";
//     this.user = JSON.parse(str);
//   },
//   methods:{

//   }
}
</script>

<style scoped>
  .selected{
    background-color: bisque;
  }
</style>