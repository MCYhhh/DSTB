package com.example.ty.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ty.bean.vo.OrderElectronicVo;
import com.example.ty.mapper.OrderElectronicMapper;
import com.example.ty.service.IOrderElectronicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OrderElectronicServiceImpl extends ServiceImpl<OrderElectronicMapper, OrderElectronicVo> implements IOrderElectronicService {
   @Resource
    private OrderElectronicMapper userodermapper ;
    @Override
    public List<OrderElectronicVo> orderdetail(Integer id) {
        return userodermapper.orderdetail(id);
    }

}
