package com.example.ty.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ty.bean.Electronics;
import com.example.ty.bean.User;
import com.example.ty.mapper.ElectronicsMapper;
import com.example.ty.mapper.UserMapper;
import com.example.ty.service.IElectronicsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ElectronicsServiceImpl extends ServiceImpl<ElectronicsMapper, Electronics> implements IElectronicsService {

    @Resource
    private ElectronicsMapper electronicsMapper;
    @Override
    public IPage pagedefine(Page<Electronics> page) {
        return electronicsMapper.pagedefine(page);
    }
}
