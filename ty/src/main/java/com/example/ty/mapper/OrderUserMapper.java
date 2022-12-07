package com.example.ty.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ty.bean.vo.OrderElectronicVo;

import java.util.List;

import com.example.ty.bean.vo.OrderUserVo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface OrderUserMapper extends BaseMapper<OrderUserVo>{
    List<OrderUserVo> orderuser(Integer id);
}
