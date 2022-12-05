<template>
    <div>
      <el-table :data="tableData"
                style="width: 100%"
                :header-cell-style="{background:'#E4E7ED'}">
        <el-table-column prop="uid" label="用户id" width="120">
        </el-table-column>
          <el-table-column prop="uaccount" label="账号" width="140">
        </el-table-column>
         <el-table-column prop="uname" label="姓名" width="140">
        </el-table-column>
        <el-table-column prop="usex" label="性别" width="140">
            <template slot-scope="scope">
              <el-tag
                :type="scope.row.usex === '女' ? 'primary' : 'success'"
                disable-transitions>{{scope.row.usex==="女"?"女":"男"}}</el-tag>
          </template>
        </el-table-column>
          <el-table-column prop="uimage" label="头像" width="140">
        </el-table-column>
        <el-table-column prop="usite" label="地址" width="230">
        </el-table-column>
          <el-table-column prop="utel" label="电话" width="150">
        </el-table-column>
         <el-table-column prop="operate" label="操作">
          <el-button type="success">编辑</el-button>
          <el-button type="danger">删除</el-button>
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
import { pageUserApi } from '../api'
export default {
    name: 'Main' ,
     data() {
      
      // const item = {
      //   date: '2016-05-02',
      //   name: '王小虎',
      //   address: '上海市普陀区金沙江路 1518 弄'tt
      // };
      return {
        tableData: [],
        currentPage1: 5,
        currentPage2: 5,
        currentPage3: 5,
        currentPage4: 4
        // tableData: Array(20).fill(item)
      }
    },
    methods:{
      //  getCat: async function () {
    
        loadGet(){
              // const { data: res } = await pageUserApi();
              // console.log(res)
              // this.tableData = res.data;
            this.$axios.post("/user/page").then(res=>res.data).then(res=>{
                console.log(res);
                if(res.code===200)
                  this.tableData=res.data;
                else{
                  alert("获取数据失败")
                }
            })
        },
         handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      }
    },
    created(){
        this.loadGet();
    }
}
</script>