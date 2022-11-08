package com.example.ty.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ty.bean.User;
import com.example.ty.mapper.UserMapper;
import com.example.ty.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MCY
 * @since 2022-11-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public IPage pagedefine(IPage<User> page) {
        return userMapper.pagedefine(page);
    }
}
