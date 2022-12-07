<template>
    <div>
        <el-card class="box-card" style="margin-left:-15px">
            <el-row :gutter="30">
                <el-col :span="7">
                    <el-input placeholder="请输入内容"
                    clearable>
                        <el-button slot="append" icon="el-icon-search"></el-button>
                    </el-input>
                </el-col>
                <el-col :span="4">
                    <el-button type="primary">添加客户</el-button>
                </el-col>
            </el-row>

              <!-- 用户列表 -->
            <el-table :data="userList" border stripe style="margin-top:15px">
                <el-table-column type="index" label="序号" width="50px"></el-table-column>
                <el-table-column label="用户id" prop="uid"></el-table-column>
                <el-table-column label="用户账号" prop="uaccount"></el-table-column>
                <el-table-column label="用户姓名" prop="uname"></el-table-column>
                <el-table-column label="用户性别" >
                    <template slot-scope="scope">
                        <el-tag
                            :type="scope.row.usex === '女' ? 'primary' : 'success'"
                            disable-transitions>{{scope.row.usex==="女"?"女":"男"}}</el-tag>
                    </template>
                </el-table-column>
                <el-table-column label="用户电话" prop="utel"></el-table-column>
                <el-table-column label="用户地址" prop="usite"></el-table-column>
                <el-table-column label="操作" >
                    <template slot-scope="scope">
                        <!-- 修改 -->
                        <el-tooltip class="item" effect="dark" content="修改客户" placement="top" :enterable="false">
                            <el-button type="primary" icon="el-icon-edit"></el-button>
                        </el-tooltip>
                        <!-- 删除 -->
                         <el-tooltip class="item" effect="dark" content="删除客户"  placement="top" :enterable="false">
                            <el-button type="danger" icon="el-icon-delete"></el-button>
                        </el-tooltip>
                    </template>
                </el-table-column>
            </el-table>
            <!-- 分页 -->
            <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page.sync="queryInfo.pageNum"
                :page-sizes="[1, 2, 5, 10]"
                :page-size="1"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total">
    </el-pagination>
        </el-card>
    </div>

</template>
<script>
import { MyUserApi } from "@/api/index";
export default {
    name: 'myCustomer' ,
     data() {
      return {  //获取用户列表的参数
      queryInfo:{
        pageSize: 10,
        pageNum: 1
      },
      userList: [],
      total:0,
    //   getUserListblur:[]   //搜索框查找
      }
    },
    methods:{
      async getUserList(){
        // const json=JSON.stringify(this.queryInfo);
        let wid=JSON.parse(localStorage.getItem("user")).wid
        const {data: res}= await MyUserApi(wid);
        console.log(res);
        if(res.code!=200)
            return this.$message.error("获取用户列表失败");
        this.userList=res.data
        console.log("1111")
        console.log(this.userList)
        this.total=res.total
       },
    //    监听pagesize改变的事件
        handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
        this.queryInfo.pageSize=val;
        this.getUserList()
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
        this.queryInfo.pageNum=val;
        this.getUserList()
      }
    },
    // async getUserListblur(){
    //     const json=JSON.stringify(this.queryInfo);
    //     const {data: res}= await BlurUserApi(json);
    //      if(res.code!=200)
    //         return this.$message.error("查询失败");
    //     console.log(res)

    // },
    created(){  
        this.getUserList()
    },
}
</script>

<style scoped>
    .el-card{
        box-shadow: 0 1px 1px rgba(0,0,0, 0.15);
    }
</style>