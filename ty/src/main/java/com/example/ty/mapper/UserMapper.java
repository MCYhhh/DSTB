package com.example.ty.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ty.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author MCY
 * @since 2022-11-08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    IPage pagedefine(IPage<User> page);

    List<User> throughName(String name);
}
