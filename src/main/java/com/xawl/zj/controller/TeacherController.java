package com.xawl.zj.controller;

import com.github.pagehelper.PageInfo;
import com.xawl.zj.pojo.TbTeacher;
import com.xawl.zj.service.TeacherService;
import com.xawl.zj.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping( "/teacher" )
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping( "/findAll.action" )
    @ResponseBody
    public Result findAll(Integer page, Integer num) {
        if ( num == null || num == 0 ) {
            num = 10;
        }
        PageInfo<TbTeacher> pageInfo = teacherService.findAll(page, num);
        return Result.success(pageInfo);
    }

    @ResponseBody
    @RequestMapping( "/insert.action" )
    public Result insert(TbTeacher teacher) {
        TbTeacher tb = teacherService.selectByTnum(teacher.getTnum());
        if ( tb != null ) {
            return Result.err(300, "工号存在");
        } else {
            teacher.setTpass("123456");
            teacherService.insert(teacher);
        }
        return Result.success(tb);
    }

    @RequestMapping( "/resetPass.action" )
    @ResponseBody
    public Result resetPass(String tnum) {
        TbTeacher teacher = new TbTeacher();
        teacher.setTnum(tnum);
        teacher.setTpass("123456");
        teacherService.update(teacher);
        return Result.success(null);
    }

    @RequestMapping( "/delete.action" )
    @ResponseBody
    public Result delete(String tnum) {
        teacherService.delete(tnum);
        return Result.success(null);
    }

    @ResponseBody
    @RequestMapping( "/login.action" )
    public Result login(TbTeacher teacher) {
        TbTeacher tb = teacherService.selectByTnum(teacher.getTnum());
        if ( tb == null ) {
            return Result.err(300, "账号不存在");
        } else if ( !tb.getTpass().equals(teacher.getTpass()) ) {
            return Result.err(300, "密码错误");
        }
        return Result.success(tb);
    }

    @ResponseBody
    @RequestMapping( "/findByTnum.action" )
    public Result findByTnum(String tnum) {
        TbTeacher tb = teacherService.selectByTnum(tnum);
        return Result.success(tb);
    }

    @ResponseBody
    @RequestMapping( "/update.action" )
    public Result update(TbTeacher teacher) {
        TbTeacher tb = teacherService.update(teacher);
        return Result.success(tb);
    }

    @ResponseBody
    @RequestMapping( "/updatePass.action" )
    public Result updatePass(TbTeacher teacher, String newPass) {
        TbTeacher tbTeacher = teacherService.selectByTnum(teacher.getTnum());
        if ( !tbTeacher.getTpass().equals(teacher.getTpass()) ) {
            return Result.err(300, "原始密码输入错误");
        } else {
            teacher.setTpass(newPass);
            teacherService.update(teacher);
        }

        return Result.success("密码修改成功");
    }

}
