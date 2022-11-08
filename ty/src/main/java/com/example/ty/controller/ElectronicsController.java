package com.example.ty.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.ty.bean.Electronics;
import com.example.ty.bean.Worker;
import com.example.ty.service.IElectronicsService;
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
@RequestMapping("/electronics")
public class ElectronicsController {
    @Autowired
    private IElectronicsService iElectronicsService ;

    //查找所有
    @GetMapping("/findAll")
    public List<Electronics> listall(){
        return iElectronicsService.list();
    }

    //新增
    @PostMapping("/save")
    public boolean save(@RequestBody Electronics electronics){
        return iElectronicsService.save(electronics);
    }
    //修改
    @PostMapping("/modify")
    public boolean modify(@RequestBody Electronics electronics){
        return iElectronicsService.updateById(electronics);
    }
    //新增或修改
    @PostMapping("/saveOrmodify")
    public boolean saveOrmodify(@RequestBody Electronics electronics){
        return iElectronicsService.saveOrUpdate(electronics);
    }
    //删除
    @GetMapping("/delete")
    public boolean delete(Integer wid){
        return iElectronicsService.removeById(wid);
    }

    //查询（模糊、匹配）
    @PostMapping("/blur")
    public List<Electronics> blur(@RequestBody Electronics electronics){
        LambdaQueryWrapper<Electronics> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Electronics::getEbrand,electronics.getEbrand());
        return iElectronicsService.list(lambdaQueryWrapper);
    }


}
