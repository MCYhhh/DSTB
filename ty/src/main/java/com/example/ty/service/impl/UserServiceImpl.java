package com.example.ty.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ty.bean.Addition.UserAddition;
import com.example.ty.bean.User;
import com.example.ty.bean.vo.OrderElectronicVo;
import com.example.ty.common.Result;
import com.example.ty.exception.ServiceException;
import com.example.ty.mapper.OrderElectronicMapper;
import com.example.ty.mapper.UserMapper;
import com.example.ty.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ty.utils.JwtUtil;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public UserAddition login(UserAddition userAddition) {

        User one = confirmUserInfo(userAddition);
        if (one != null) {
            BeanUtil.copyProperties(one, userAddition, true);
            // 设置token
            String token = JwtUtil.getToken(one.getUid().toString(), one.getUpwd());
            userAddition.setToken(token);
            return userAddition;
        } else {
            throw new ServiceException(600, "用户名或密码错误");
        }
    }

    @Override
    public User register(UserAddition userAddition) {
        User one = getUserInfo(userAddition);
        if (one == null) {
            one = new User();
            BeanUtil.copyProperties(userAddition, one, true);
            save(one);  // 把 copy完之后的用户对象存储到数据库
        } else {
            throw new ServiceException(600, "用户已存在");
        }
        return one;
    }

    @Override
    public List<User> throughName(String name) {
        return userMapper.throughName(name);
    }


    //此方法用于查询用户是否存在，只要名字一样就是存在，
    private User getUserInfo(UserAddition userAddition) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Uname", userAddition.getUname());
        // queryWrapper.eq("Upwd", userDTO.getUpwd());
        User one;
        try {
            one = getOne(queryWrapper); // 从数据库查询用户信息
        } catch (Exception e) {
//            LOG.error(e);
            throw new ServiceException(500, "系统错误");
        }
        return one;
    }

    //此方法用于验证用户登录信息是否正确，必须用户加密码都存在，才是验证成功！
    private User confirmUserInfo(UserAddition userAddition) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Uaccount", userAddition.getUaccount());
        queryWrapper.eq("Upwd", userAddition.getUpwd());
        User one;
        try {
            one = getOne(queryWrapper); // 从数据库查询用户信息
        } catch (Exception e) {
//            LOG.error(e);
            throw new ServiceException(500, "系统错误");
        }
        return one;
    }



}
