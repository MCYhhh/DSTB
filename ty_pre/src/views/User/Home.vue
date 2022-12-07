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
        <el-table-column prop="eimage" label="图片" width="140">
        </el-table-column>
        <el-table-column prop="ecolor" label="颜色" width="140">
        </el-table-column>
          <el-table-column prop="edesp" label="介绍" width="140">
        </el-table-column>

         <el-table-column prop="operate" label="操作">
             <template slot-scope="scope">
        <el-button type="success"
          @click.native.prevent="buyElectronics(scope.$index, tableData)"
          size="small">
          {{display}}
        </el-button>
      </template>
          <!-- <el-button type="success" @click="buyElectronics">购买</el-button> -->
          <!-- <el-button type="danger">删除</el-button> -->
        </el-table-column>
      </el-table>
           <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage4"
      :page-sizes="[20, 40, 60, 100]"
      :page-size="10"
      layout="total, sizes, prev, pager, next, jumper"
      :total="400">
    </el-pagination>
    </div>
  
</template>

<script>
import { FindElectronicsApi,addOrder} from "@/api/index";
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
        currentPage4: 4,
        display: "购买"
    };
   },
   methods:{
   async loadGet(){
            // async function (){
              const { data: res } = await FindElectronicsApi();
              console.log(res)
                  this.tableData=res.data;
        },
         handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      },
       async buyElectronics(index, rows){
        console.log(rows.eid)
        // const { data: res } = await addOrder();
        // // console.log(res)
        // if(res.code!=200)
        //       return this.$message.error("登录不成功");
        // this.$message.success("购买成功");
        // rows.splice(index, 1);
        // console.log("kakkkkkkak")
        // console.log(index)
        //  console.log(rows)

        // this.tableData=res.data;

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
</style>

