package com.xawl.zj.controller;

import com.xawl.zj.pojo.TbTeacher;
import com.xawl.zj.service.TeacherService;
import com.xawl.zj.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping( "/teacher" )
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

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
