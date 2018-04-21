package com.xawl.zj.controller;

import com.xawl.zj.pojo.TbAdmin;
import com.xawl.zj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/admin" )
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping( "/login.action" )
    public ModelAndView login(TbAdmin admin) {
        ModelAndView mv = new ModelAndView();
        TbAdmin tbAdmin = adminService.findByAccount(admin.getAccount());
        if ( tbAdmin == null ) {
            mv.addObject("msg", "账号不存在");
            mv.setViewName("SuperAdminLogin");
        } else if ( !tbAdmin.getPass().equals(admin.getPass()) ) {
            mv.addObject("msg", "密码错误");
            mv.setViewName("SuperAdminLogin");
        } else {
            mv.setViewName("/WEB-INF/superAdmin/index");
        }
        return mv;
    }

    @RequestMapping( "/toPage.action" )
    public ModelAndView toPage(String pageName) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/WEB-INF/superAdmin/" + pageName);
        return mv;
    }
}
