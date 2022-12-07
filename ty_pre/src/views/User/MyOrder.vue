<template>
    <el-table :data="tableData"
                style="width: 100%"
                :header-cell-style="{background:'#E4E7ED'}">
        <el-table-column prop="oid" label="订单id" width="120">
        </el-table-column>
        <el-table-column prop="eid" label="产品id" width="120">
        </el-table-column>
          <el-table-column prop="ebrand" label="品牌" width="140">
        </el-table-column>
         <el-table-column prop="emodel" label="名称" width="140">
        </el-table-column>
        <el-table-column prop="eprice" label="价格" width="140">
        </el-table-column>
        <!-- <el-table-column prop="eimage" label="图片" width="140">
        </el-table-column> -->
        <el-table-column prop="ecolor" label="颜色" width="140">
        </el-table-column>
          <el-table-column prop="edesp" label="介绍" width="140">
        </el-table-column>
         <el-table-column prop="wid" label="负责人" width="140">
        </el-table-column>
         <el-table-column prop="otime" label="购买时间" width="140">
        </el-table-column>
         <el-table-column prop="operate" label="操作">
          <el-button type="success">编辑</el-button>
          <el-button type="danger">删除</el-button>
        </el-table-column>
      </el-table>
</template>
<script>
import { MyOrderApi } from "@/api/index";
export default {
   name:'MyOrder',
   data(){
    return{
        tableData: [],
    }
   },
   methods:{
    async loadGet(){
        let uid =JSON.parse(localStorage.getItem('user')).uid
        console.log(uid)
         const { data: res } = await MyOrderApi(uid);
        console.log(res)  
        this.tableData=res.data;
    }
   },
   created(){
        this.loadGet();
        // console.log(JSON.parse(localStorage.getItem('user')).uid)
   }

}
</script>