package com.xawl.zj.controller;

import com.xawl.zj.pojo.TbPoint;
import com.xawl.zj.service.PointService;
import com.xawl.zj.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping( "/point" )
public class PointController {
    @Autowired
    private PointService pointService;


    @GetMapping( "/findAll.action" )
    @ResponseBody
    public Result findAll() {
        List<TbPoint> list = pointService.findAll();
        return Result.success(list);
    }

    @RequestMapping( "/insert.action" )
    @ResponseBody
    public Result insert(TbPoint point) {
        int i = pointService.insert(point);
        return Result.success(null);
    }

    @RequestMapping( "/update.action" )
    @ResponseBody
    public Result update(TbPoint point) {
        int i = pointService.update(point);
        return Result.success(null);
    }

    @RequestMapping( "/delete.action" )
    @ResponseBody
    public Result delete(TbPoint point) {
        int i = pointService.delete(point);
        return Result.success(null);
    }
}
