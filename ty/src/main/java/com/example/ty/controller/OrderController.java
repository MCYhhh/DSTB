package com.example.ty.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.ty.bean.Electronics;
import com.example.ty.bean.Order;
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

    //查找所有
    @GetMapping("/findAll")
    public List<Order> listall(){
        return iOrderService.list();
    }

    //新增
    @PostMapping("/save")
    public boolean save(@RequestBody Order order){
        return iOrderService.save(order);
    }
    //修改
    @PostMapping("/modify")
    public boolean modify(@RequestBody Order order){
        return iOrderService.updateById(order);
    }
    //新增或修改
    @PostMapping("/saveOrmodify")
    public boolean saveOrmodify(@RequestBody Order order){
        return iOrderService.saveOrUpdate(order);
    }
    //删除
    @GetMapping("/delete")
    public boolean delete(Integer oid){
        return iOrderService.removeById(oid);
    }

    //查询（模糊、匹配）
    //模糊查询时间
    @PostMapping("/blur")
    public List<Order> blur(@RequestBody Order order){
        LambdaQueryWrapper<Order> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Order::getOtime,order.getOtime());
        return iOrderService.list(lambdaQueryWrapper);
    }


}
