package com.xawl.zj.controller;

import com.xawl.zj.pojo.TbStudent;
import com.xawl.zj.service.StudentService;
import com.xawl.zj.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping( "/student" )
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping( "/findAll.action" )
    @ResponseBody
    public Result findAll() {
        List<TbStudent> list = studentService.findAll();
        return Result.success(list);
    }

    @RequestMapping( "/insert.action" )
    @ResponseBody
    public Result insert(TbStudent student) {
        int i = studentService.insert(student);
        return Result.success(null);
    }

    @RequestMapping( "/update.action" )
    @ResponseBody
    public Result update(TbStudent student) {
        System.out.println(student);
        int i = studentService.update(student);
        return Result.success(null);
    }

    @RequestMapping( "/delete.action" )
    @ResponseBody
    public Result delete(TbStudent student) {
        int i = studentService.delete(student);
        return Result.success(null);
    }

    @RequestMapping( "/findBySnum.action" )
    @ResponseBody
    public Result findBySnum(String snum) {
        TbStudent student = studentService.findBySnum(snum);
        return Result.success(student);
    }
}
