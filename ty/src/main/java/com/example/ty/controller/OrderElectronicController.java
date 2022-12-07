package com.example.ty.controller;


import com.example.ty.common.Result;
import com.example.ty.service.IOrderElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/orderelectronic")
public class OrderElectronicController {
//    @Autowired
    @Resource
    private IOrderElectronicService iOrderElectronicService;
    @GetMapping("/myorder")
    public Result orderdetail(Integer id){
        //iUserService.list();
        System.out.println(iOrderElectronicService.orderdetail(id));
        return Result.success(iOrderElectronicService.orderdetail(id),"我的订单查找成功");
    }


}
