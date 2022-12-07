package com.example.ty.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ty.bean.User;
import com.example.ty.bean.vo.OrderElectronicVo;
import com.example.ty.bean.vo.OrderUserVo;

import java.util.List;

public interface IOrderUserService extends IService<OrderUserVo>{
    List<OrderUserVo> orderuser(Integer id);
}
