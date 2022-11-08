package com.example.ty.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ty.bean.User;
import com.example.ty.common.QueryPageParam;
import com.example.ty.common.Result;
import com.example.ty.service.IUserService;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    //查询特定的
    @GetMapping("/{uid}")
    public Result findOne(Integer uid){
        iUserService.getById(uid);
        return Result.success();
    }

    //查询所有
    @GetMapping("/findAll")
    public Result listall(){
        //iUserService.list();
        return Result.success(iUserService.list());
    }

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody User user){
        iUserService.save(user);
        return Result.success();
    }

    //修改
    @PostMapping("/modify")
    public Result modify(@RequestBody User user){
        //iUserService.updateById(user);
        return Result.success(iUserService.updateById(user));
    }

    //新增或修改
    @PostMapping("/saveOrmodify")
    public Result saveOrmodify(@RequestBody User user){
       // iUserService.saveOrUpdate(user);
        return Result.success(iUserService.saveOrUpdate(user));
    }

    //删除
    @DeleteMapping("/delete")
    public Result delete(Integer uid){
        iUserService.removeById(uid);
        return Result.success();
    }

    //查询（模糊、匹配）
    @PostMapping("/blur")
    public List<User> blur(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getUname,user.getUname());
       // lambdaQueryWrapper.eq(User::getUname,user.getUname()); 完全匹配
        return iUserService.list(lambdaQueryWrapper);
    }

    //分页查询
    @PostMapping("/page")
    public List<User> page(@RequestBody QueryPageParam queryPageParam){
        //public List<User> page(@RequestBody Hashmap map){
//        System.out.println(queryPageParam);
//        //System.out.println("pageSize==="+(String)map.get(pageSize));
//        System.out.println("pageSize==="+queryPageParam.getPageSize());
//        System.out.println("pageNum==="+queryPageParam.getPageNum());
//
//        HashMap param=queryPageParam.getParam();
//        System.out.println("uacccount==="+param.get("uaccount"));
//        System.out.println("uname==="+param.get("uname"));
//        System.out.println("upwd==="+param.get("upwd"));

        HashMap param=queryPageParam.getParam();
//        System.out.println("uaccount==="+param.get("uaccount"));
//        System.out.println("uname==="+param.get("uname"));
//        System.out.println("upwd==="+param.get("upwd"));
        String uname=(String)param.get("uname");

        Page<User> page=new Page();
        page.setCurrent(queryPageParam.getPageNum());
        page.setSize(queryPageParam.getPageSize());
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUname,uname);

        IPage result=iUserService.page(page,lambdaQueryWrapper);
        System.out.println("total=="+result.getTotal());

        return result.getRecords();
    }

    //分页查询
    @PostMapping("/pagedefine")
    public List<User> pagedefine(@RequestBody QueryPageParam queryPageParam){
        HashMap param=queryPageParam.getParam();
//        String uname=(String)param.get("uname");
//        System.out.println("uaccount==="+param.get("uaccount"));
//        System.out.println("uname==="+param.get("uname"));
//        System.out.println("upwd==="+param.get("upwd"));

        Page<User> page=new Page();
        page.setCurrent(queryPageParam.getPageNum());
        page.setSize(queryPageParam.getPageSize());
//        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.eq(User::getUname,uname);

        IPage result=iUserService.pagedefine(page);
        System.out.println("total=="+result.getTotal());

        return result.getRecords();
    }


    //分页查询
    @PostMapping("/pageresult")
    public Result pageresult(@RequestBody QueryPageParam queryPageParam){
        HashMap param=queryPageParam.getParam();

        Page<User> page=new Page();
        page.setCurrent(queryPageParam.getPageNum());
        page.setSize(queryPageParam.getPageSize());

        IPage result=iUserService.pagedefine(page);
        System.out.println("total=="+result.getTotal());

        return Result.success(result.getRecords(),result.getTotal());
    }

}
