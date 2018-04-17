package com.xawl.zj.controller;

import com.xawl.zj.pojo.TbClass;
import com.xawl.zj.service.ClassService;
import com.xawl.zj.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping( "/class" )
public class ClassContorller {
    @Autowired
    private ClassService classService;

    @GetMapping( "/findAll.action" )
    @ResponseBody
    public Result findAll() {
        List<TbClass> list = classService.findAll();
        return Result.success(list);
    }

    @RequestMapping( "/insert.action" )
    @ResponseBody
    public Result insert(TbClass tbClass) {
        int i = classService.insert(tbClass);
        return Result.success(null);
    }

    @RequestMapping( "/update.action" )
    @ResponseBody
    public Result update(TbClass tbClass) {
        int i = classService.update(tbClass);
        return Result.success(null);
    }

    @RequestMapping( "/delete.action" )
    @ResponseBody
    public Result delete(TbClass tbClass) {
        int i = classService.delete(tbClass);
        return Result.success(null);
    }
}
