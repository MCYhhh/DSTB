package com.example.ty.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ty.bean.Electronics;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ty.bean.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MCY
 * @since 2022-11-08
 */
public interface IElectronicsService extends IService<Electronics> {

    IPage pagedefine(Page<Electronics> page);
}
