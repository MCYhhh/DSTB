package com.example.ty.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ty.bean.Electronics;
import com.example.ty.bean.User;
import com.example.ty.bean.Worker;
import com.example.ty.common.QueryPageParam;
import com.example.ty.common.Result;
import com.example.ty.service.IElectronicsService;
import com.example.ty.service.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MCY
 * @since 2022-11-08
 */
@RestController
@RequestMapping("/electronics")
public class ElectronicsController {
    @Autowired
    private IElectronicsService iElectronicsService ;

    //查询所有
    @GetMapping("/findAll")
    public Result listall(){
        //iUserService.list();
        return Result.success(iElectronicsService.list(),"查询成功");
    }

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Electronics electronics){

        return Result.success(iElectronicsService.save(electronics),"添加成功");
    }

    //修改
    @PostMapping("/modify")
    public Result modify(@RequestBody Electronics electronics){
        //iUserService.updateById(user);
        return Result.success(iElectronicsService.updateById(electronics),"修改成功");
    }

    //新增或修改
    @PostMapping("/saveOrmodify")
    public Result saveOrmodify(@RequestBody Electronics electronics){
        // iUserService.saveOrUpdate(user);
        return Result.success(iElectronicsService.saveOrUpdate(electronics),"修改成功");
    }

    //删除
    @DeleteMapping("/delete")
    public Result delete(Integer uid){
        return Result.success(iElectronicsService.removeById(uid),"删除成功");
    }


    //查询（模糊、匹配）
    @PostMapping("/blur")
    public List<Electronics> blur(@RequestBody Electronics electronics){
        LambdaQueryWrapper<Electronics> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Electronics::getEbrand,electronics.getEbrand());
        return iElectronicsService.list(lambdaQueryWrapper);
    }

    //分页查询
    @PostMapping("/pagedefine")
    public Result pagedefine(@RequestBody QueryPageParam queryPageParam){
        HashMap param=queryPageParam.getParam();
//        String uname=(String)param.get("uname");
//        System.out.println("uaccount==="+param.get("uaccount"));
//        System.out.println("uname==="+param.get("uname"));
//        System.out.println("upwd==="+param.get("upwd"));

        Page<Electronics> page=new Page();
        page.setCurrent(queryPageParam.getPageNum());
        page.setSize(queryPageParam.getPageSize());
//        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(User::getUname,uname);

        IPage result=iElectronicsService.pagedefine(page);
        System.out.println("total=="+result.getTotal());
        return Result.success(result.getRecords(),"查询成功");
    }



}
