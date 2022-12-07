<template>
    <div>
      <el-table :data="tableData"
                style="width: 100%"
                :header-cell-style="{background:'#E4E7ED'}">
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
          <el-table-column prop="edesp" label="介绍" width="210">
        </el-table-column>
         <el-table-column prop="operate" label="操作">
          <el-button type="success">编辑</el-button>
          <el-button type="danger">删除</el-button>
        </el-table-column>
      </el-table>
    </div>
</template>

<script>
import { FindElectronicsApi } from "@/api/index";
export default {
   name:'Home',
    data(){
        return {
      currentDate: new Date(),
      tableData: [
      ],
        currentPage1: 5,
        currentPage2: 5,
        currentPage3: 5,
        currentPage4: 4
    };
   },
   methods:{
   async loadGet(){
              const { data: res } = await FindElectronicsApi();
              console.log(res)
              this.tableData=res.data;
        },
    },
    created(){
        this.loadGet();
    }
}


</script>

<style>
  .time {
    font-size: 13px;
    color: #999;
  }
  
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
  
  .clearfix:after {
      clear: both
  }