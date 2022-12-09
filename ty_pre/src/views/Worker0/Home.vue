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

        <!-- 编辑界面 -->
    <el-dialog :title="title" :visible.sync="editFormVisible" width="30%" @click='closeDialog("edit")'>
      <el-form label-width="120px" :model="editForm" ref="editForm" :rules="rules">
        <el-form-item label="产品id" prop="eid">
          <el-input size="small" v-model="editForm.systemNo" auto-complete="off" placeholder="请输入产品编码"></el-input>
        </el-form-item>
        <el-form-item label="品牌" prop="ebrand">
          <el-input size="small" v-model="editForm.roleName" auto-complete="off" placeholder="请输入产品品牌"></el-input>
        </el-form-item>
        <el-form-item label="名称" prop="emodel">
          <el-input size="small" v-model="editForm.roleNo" auto-complete="off" placeholder="请输入产品名称"></el-input>
        </el-form-item>
        <el-form-item label="价格" prop="eprice">
          <el-input size="small" v-model="editForm.roleNo" auto-complete="off" placeholder="请输入产品价格"></el-input>
        </el-form-item>
        <el-form-item label="颜色" prop="ecolor">
          <el-input size="small" v-model="editForm.roleNo" auto-complete="off" placeholder="请输入产品颜色"></el-input>
        </el-form-item>
        <el-form-item label="介绍" prop="edesp">
          <el-input size="small" v-model="editForm.roleNo" auto-complete="off" placeholder="请输入产品介绍"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button size="small" @click='closeDialog("edit")'>取消</el-button>
        <el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">保存</el-button>
      </div>
    </el-dialog>

    </div>
</template>

<script>
import { FindElectronicsApi,changeElectronicApi  } from "@/api/index";
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