package com.example.ty.controller;

import com.example.ty.common.Result;
import com.example.ty.service.IOrderElectronicWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/orderelectronicw")
public class OrderElectronicWController {
    @Resource
    private IOrderElectronicWService service;
    @GetMapping("/myorder")
    public Result orderdetail_w(Integer id){
        //iUserService.list();
//        System.out.println(iOrderElectronicService.orderdetail(id));

        return Result.success(service.orderdetail_w(id),"我负责的订单查找成功");
    }
}
