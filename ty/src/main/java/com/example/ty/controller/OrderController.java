package com.example.ty.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.ty.bean.Electronics;
import com.example.ty.bean.Order;
import com.example.ty.bean.User;
import com.example.ty.common.Result;
import com.example.ty.service.IElectronicsService;
import com.example.ty.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService ;

    //根据uid查询特定的
    @GetMapping("/{oid}")
    public Result findOne(Integer oid){
//        iUserService.getById(uid);
        return Result.success(iOrderService.getById(oid),"特定用户查询成功");
    }


    //查询所有
    @GetMapping("/findAll")
    public Result listall(){
        //iUserService.list();
        return Result.success(iOrderService.list(),"查询成功");
    }

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Order order){
//        iOrderService.save(order);
        return Result.success(iOrderService.save(order),"添加成功");
    }

    //修改
    @PostMapping("/modify")
    public Result modify(@RequestBody Order order){
        //iUserService.updateById(user);
        return Result.success(iOrderService.updateById(order),"修改成功");
    }

    //新增或修改
    @PostMapping("/saveOrmodify")
    public Result saveOrmodify(@RequestBody Order order){
        // iUserService.saveOrUpdate(user);
        return Result.success(iOrderService.saveOrUpdate(order),"修改成功");
    }

    //删除
    @DeleteMapping("/delete")
    public Result delete(Integer oid){
        iOrderService.removeById(oid);
        return Result.success();
    }


}
