package com.example.ty.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ty.bean.Addition.UserAddition;
import com.example.ty.bean.Addition.WorkerAddition;
import com.example.ty.bean.User;
import com.example.ty.bean.Worker;
import com.example.ty.exception.ServiceException;
import com.example.ty.mapper.UserMapper;
import com.example.ty.mapper.WorkerMapper;
import com.example.ty.service.IWorkerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ty.utils.JwtUtil;
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
public class WorkerServiceImpl extends ServiceImpl<WorkerMapper, Worker> implements IWorkerService {
    @Resource
    private WorkerMapper workerMapper;

    @Override
    public WorkerAddition login(WorkerAddition workerAddition) {

        Worker one = confirmUserInfo(workerAddition);
        if (one != null) {
            BeanUtil.copyProperties(one, workerAddition, true);
            // 设置token
            String token = JwtUtil.getToken(one.getWid().toString(), one.getWpwd());
            workerAddition.setToken(token);
            return workerAddition;
        } else {
            throw new ServiceException(600, "用户名或密码错误");
        }
    }

    //此方法用于验证用户登录信息是否正确，必须用户加密码用户类型都存在，才是验证成功！
    private Worker confirmUserInfo(WorkerAddition workerAddition) {
        QueryWrapper<Worker> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("Waccount", workerAddition.getWaccount());
        queryWrapper.eq("Wpwd", workerAddition.getWpwd());
//        queryWrapper.eq("Wtype", workerAddition.getWtype());
        Worker one;
        try {
            one = getOne(queryWrapper); // 从数据库查询用户信息
        } catch (Exception e) {
//            LOG.error(e);
            throw new ServiceException(500, "系统错误");
        }
        return one;
    }

}
