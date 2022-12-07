package com.example.ty.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ty.bean.vo.OrderElectronicVo;
import com.example.ty.bean.vo.OrderUserVo;
import com.example.ty.mapper.OrderElectronicMapper;
import com.example.ty.mapper.OrderUserMapper;
import com.example.ty.service.IOrderElectronicService;
import com.example.ty.service.IOrderUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OrderUserServiceImpI extends ServiceImpl<OrderUserMapper, OrderUserVo> implements IOrderUserService{

    @Resource
    private OrderUserMapper orderusermapper ;
    @Override
    public List<OrderUserVo> orderuser(Integer id) {
        return orderusermapper.orderuser(id);
    }
}


