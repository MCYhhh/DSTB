package com.example.ty.mapper;

import com.example.ty.bean.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author MCY
 * @since 2022-11-08
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
