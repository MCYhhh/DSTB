package com.example.ty.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ty.bean.Addition.UserAddition;
import com.example.ty.bean.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ty.common.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MCY
 * @since 2022-11-08
 */
public interface IUserService extends IService<User> {
    IPage pagedefine(IPage<User> page);

    UserAddition login(UserAddition userAddition);

    User register(UserAddition userAddition);

}
