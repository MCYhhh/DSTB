package com.example.ty.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ty.bean.User;
import com.example.ty.bean.vo.OrderElectronicVo;

import java.util.List;

//import javax.annotation.Resource;

public interface IOrderElectronicService extends IService<OrderElectronicVo> {
//    @Resource

    List<OrderElectronicVo> orderdetail(Integer id);


}
