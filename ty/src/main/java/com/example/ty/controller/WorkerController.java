package com.example.ty.controller;


import cn.hutool.core.util.StrUtil;
import com.example.ty.bean.Addition.WorkerAddition;
import com.example.ty.bean.User;
import com.example.ty.bean.Worker;
import com.example.ty.common.Result;
import com.example.ty.service.IUserService;
import com.example.ty.service.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MCY
 * @since 2022-11-08
 */
@RestController
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private IWorkerService iWorkerService ;

//    @PostMapping("/login")
//    public Result login(@RequestBody WorkerAddition workerAddition) {
//        if (StrUtil.isBlank(workerAddition.getWaccount()) || StrUtil.isBlank(workerAddition.getWpwd())) {
//            return Result.error(400, "参数不足错误");
//        }
//        WorkerAddition workerAddition1 = iWorkerService.login(workerAddition);
//        return Result.success(workerAddition1,"登录成功");
//    }

//            单纯注册，未加入token认证
    @PostMapping("/login")
    public Result login(@RequestBody Worker worker) {
        List list = iWorkerService.lambdaQuery()
                .eq(Worker::getWaccount, worker.getWaccount())
                .eq(Worker::getWpwd, worker.getWpwd()).list();
//        System.out.println(worker.getUaccount());
        System.out.println(list.size());
        return list.size()>0?Result.success(list.get(0),"登录成功"):Result.error();
    }
}
