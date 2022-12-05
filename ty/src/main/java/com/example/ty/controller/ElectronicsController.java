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

    //查找所有
    @GetMapping("/findAll")
    public List<Electronics> listall(){
        return iElectronicsService.list();
    }

    //新增
    @PostMapping("/save")
    public boolean save(@RequestBody Electronics electronics){
        return iElectronicsService.save(electronics);
    }
    //修改
    @PostMapping("/modify")
    public boolean modify(@RequestBody Electronics electronics){
        return iElectronicsService.updateById(electronics);
    }
    //新增或修改
    @PostMapping("/saveOrmodify")
    public boolean saveOrmodify(@RequestBody Electronics electronics){
        return iElectronicsService.saveOrUpdate(electronics);
    }
    //删除
    @GetMapping("/delete")
    public boolean delete(Integer wid){
        return iElectronicsService.removeById(wid);
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
