package com.example.ty.controller;

import com.example.ty.common.Result;
import com.example.ty.service.IOrderElectronicService;
import com.example.ty.service.IOrderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/orderuser")
public class OrderUserController {
    @Resource
    private IOrderUserService iOrderUserService;

    @GetMapping("/myuser")
    public Result orderdetail(Integer id) {
        //iUserService.list();
//        System.out.println(iOrderElectronicService.orderdetail(id));

        return Result.success(iOrderUserService.orderuser(id), "我的客户查找成功");
    }
}
