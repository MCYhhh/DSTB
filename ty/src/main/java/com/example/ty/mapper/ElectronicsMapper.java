package com.example.ty.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ty.bean.Electronics;
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
public interface ElectronicsMapper extends BaseMapper<Electronics> {

    IPage pagedefine(Page<Electronics> page);
}
