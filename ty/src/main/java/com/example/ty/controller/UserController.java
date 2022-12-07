package com.example.ty.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ty.bean.Addition.UserAddition;
import com.example.ty.bean.User;
import com.example.ty.common.QueryPageParam;
import com.example.ty.common.Result;
import com.example.ty.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


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
//@CrossOrigin
public class UserController {
    @Autowired
    private IUserService iUserService;
//    @Autowired
//    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Result login(@RequestBody UserAddition userAddition) {
        if (StrUtil.isBlank(userAddition.getUaccount()) || StrUtil.isBlank(userAddition.getUpwd())) {
            return Result.error(400, "参数不足错误");
        }
        UserAddition userAddition1 = iUserService.login(userAddition);
        System.out.println(userAddition1);
        System.out.println(Result.success(userAddition1,"登录成功").getCode());
        return Result.success(userAddition1,"登录成功");
    }

//        单纯注册，未加入token认证
//    @PostMapping("/login")
//    public Result login(@RequestBody User user) {
//        List list = iUserService.lambdaQuery()
//                .eq(User::getUaccount, user.getUaccount())
//                .eq(User::getUpwd, user.getUpwd()).list();
//        System.out.println(user.getUaccount());
//        System.out.println(list);
//        return list.size()>0?Result.success(list.get(0),"登录成功"):Result.error();
//    }

    @PostMapping("/register")
    public Result register(@RequestBody UserAddition userAddition) {
        String uaccount = userAddition.getUaccount();
        String upwd = userAddition.getUpwd();
        if (StrUtil.isBlank(uaccount) || StrUtil.isBlank(upwd)) {
            return Result.error(400, "参数不足错误");
        }
        return Result.success(iUserService.register(userAddition),"注册成功");
    }


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
        return Result.success(iUserService.list(),"查询成功");
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
        return Result.success(iUserService.updateById(user),"修改成功");
    }

    //新增或修改
    @PostMapping("/saveOrmodify")
    public Result saveOrmodify(@RequestBody User user){
       // iUserService.saveOrUpdate(user);
        return Result.success(iUserService.saveOrUpdate(user),"修改成功");
    }

    //删除
    @DeleteMapping("/delete")
    public Result delete(Integer uid){
        iUserService.removeById(uid);
        return Result.success();
    }

    //查询（模糊、匹配）
    @PostMapping("/blur")
    public Result blur(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if(StrUtil.isBlank(user.getUname()))
            return Result.error();
        lambdaQueryWrapper.like(User::getUname,user.getUname());
       // lambdaQueryWrapper.eq(User::getUname,user.getUname()); 完全匹配
        return Result.success(iUserService.list(lambdaQueryWrapper),"查询成功");
    }

    //分页查询
    @PostMapping("/page")
    public Result page(@RequestBody QueryPageParam queryPageParam){
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

        return Result.success(result.getRecords(),"查询成功");
    }

    //分页查询
    @PostMapping("/pagedefine")
    public Result pagedefine(@RequestBody QueryPageParam queryPageParam){
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
        System.out.println("total=="+result.getRecords());
        return Result.success(result.getRecords(),"查询成功");
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
   //通过Wid来查找订单，从而找到Wid对应的客户信息

}
