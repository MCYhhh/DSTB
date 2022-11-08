package com.example.ty.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.ty.bean.User;
import com.example.ty.bean.Worker;
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

}
