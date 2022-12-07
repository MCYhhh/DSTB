package com.example.ty.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ty.bean.vo.OrderElectronicWVo;

import java.util.List;


public interface IOrderElectronicWService extends IService<OrderElectronicWVo> {
    List<OrderElectronicWVo> orderdetail_w(Integer id);
}
