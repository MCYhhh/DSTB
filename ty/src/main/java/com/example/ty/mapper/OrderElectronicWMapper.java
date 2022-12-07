package com.example.ty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ty.bean.vo.OrderElectronicVo;
import com.example.ty.bean.vo.OrderElectronicWVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface OrderElectronicWMapper extends BaseMapper<OrderElectronicWVo>{
    List<OrderElectronicWVo> orderdetail_w(Integer id);
}
