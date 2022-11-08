package com.example.ty.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ty.bean.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

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

}
