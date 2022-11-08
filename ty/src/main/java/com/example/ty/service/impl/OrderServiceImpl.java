package com.example.ty.service.impl;

import com.example.ty.bean.Order;
import com.example.ty.mapper.OrderMapper;
import com.example.ty.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MCY
 * @since 2022-11-08
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}
