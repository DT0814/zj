package com.xawl.zj.controller;

import com.xawl.zj.pojo.TbTeacherClass;
import com.xawl.zj.service.TeacherClassService;
import com.xawl.zj.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/teacherClass")
public class TeacherClassController {
    @Autowired
    private TeacherClassService teacherClassService;

    @GetMapping( "/findByTunm.action" )
    @ResponseBody
    public Result findByTunm(TbTeacherClass teacherClass) {
        List<TbTeacherClass> list = teacherClassService.findByTnum(teacherClass.getTnum());
        return Result.success(list);
    }

    @RequestMapping( "/insert.action" )
    @ResponseBody
    public Result insert(TbTeacherClass teacherClass) {
        int i = teacherClassService.insert(teacherClass);
        return Result.success(null);
    }

    @RequestMapping( "/delete.action" )
    @ResponseBody
    public Result delete(TbTeacherClass teacherClass) {
        int i = teacherClassService.delete(teacherClass);
        return Result.success(null);
    }

}
