package com.example.ty.service;

import com.example.ty.bean.Addition.WorkerAddition;
import com.example.ty.bean.Worker;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MCY
 * @since 2022-11-08
 */
public interface IWorkerService extends IService<Worker> {

    WorkerAddition login(WorkerAddition workerAddition);
}
