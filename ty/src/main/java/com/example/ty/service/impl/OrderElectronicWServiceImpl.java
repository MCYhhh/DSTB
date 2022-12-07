package com.example.ty.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ty.bean.vo.OrderElectronicWVo;
import com.example.ty.mapper.OrderElectronicWMapper;
import com.example.ty.service.IOrderElectronicWService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OrderElectronicWServiceImpl extends ServiceImpl<OrderElectronicWMapper, OrderElectronicWVo> implements IOrderElectronicWService {
    @Resource
    private OrderElectronicWMapper mapper;
    @Override
    public List<OrderElectronicWVo> orderdetail_w(Integer id) {
        return mapper.orderdetail_w(id);
    }
}
