package com.xawl.zj.controller;

import com.github.pagehelper.PageInfo;
import com.xawl.zj.pojo.TbClass;
import com.xawl.zj.pojo.TbStudent;
import com.xawl.zj.service.ClassService;
import com.xawl.zj.service.StudentService;
import com.xawl.zj.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping( "/student" )
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;

    @GetMapping( "/findAll.action" )
    @ResponseBody
    public Result findAll(Integer page, Integer num) {
        if ( num == null || num == 0 ) {
            num = 10;
        }
        PageInfo<TbStudent> pageInfo = studentService.findAll(page, num);
        for ( TbStudent student : pageInfo.getList() ) {
            TbClass c = classService.findByCid(student.getCid());
            student.setCname(c.getName());
        }

        return Result.success(pageInfo);
    }

    @RequestMapping( "/register.action" )
    @ResponseBody
    public Result register(TbStudent student) {
        TbStudent bySnum = studentService.findBySnum(student.getSnum());
        if ( bySnum != null ) {
            return Result.success(300, "学号已注册");
        } else {
            int i = studentService.insert(student);
        }
        return Result.success(student);
    }

    @RequestMapping( "/login.action" )
    @ResponseBody
    public Result login(TbStudent student) {
        TbStudent bySnum = studentService.findBySnum(student.getSnum());
        if ( bySnum == null ) {
            return Result.success(300, "账号不存在");
        } else if ( !bySnum.getSpass().equals(student.getSpass()) ) {
            return Result.success(300, "密码错误");
        }
        return Result.success(bySnum);
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

    @RequestMapping( "/resetPass.action" )
    @ResponseBody
    public Result resetPass(String snum) {
        TbStudent student = new TbStudent();
        student.setSnum(snum);
        student.setSpass("123456");
        studentService.update(student);
        return Result.success(null);
    }

    @RequestMapping( "/insert.action" )
    @ResponseBody
    public Result insert(TbStudent student) {
        TbStudent bySnum = studentService.findBySnum(student.getSnum());
        if ( bySnum != null ) {
            return Result.success(300, "学号已注册");
        }
        student.setSpass("123456");
        student.setToken("123456");
        student.setTokenpass("123456");
        studentService.insert(student);
        return Result.success(null);
    }
}
