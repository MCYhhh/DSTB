package com.example.ty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ty.bean.vo.OrderElectronicVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderElectronicMapper extends BaseMapper<OrderElectronicVo>{
    List<OrderElectronicVo> orderdetail(Integer id);
}








