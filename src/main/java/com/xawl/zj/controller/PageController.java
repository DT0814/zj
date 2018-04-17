package com.xawl.zj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
    @RequestMapping( "/toPage.action" )
    public ModelAndView toPage(String pageName) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/admin/" + pageName);
        return mv;
    }
}
