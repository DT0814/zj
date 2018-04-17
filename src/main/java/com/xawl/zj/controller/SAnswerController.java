package com.xawl.zj.controller;

import com.github.pagehelper.PageInfo;
import com.xawl.zj.pojo.TbSanswer;
import com.xawl.zj.service.SAnswerService;
import com.xawl.zj.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping( "/sanswer" )
public class SAnswerController {
    @Autowired
    private SAnswerService sAnswerService;

    @GetMapping( "/findAll.action" )
    @ResponseBody
    public Result findAll(Integer num, Integer page) {
        if ( num == null || num == 0 ) {
            num = 5;
        }
        if ( page == null || page == 0 ) {
            page = 1;
        }
        PageInfo pageInfo = sAnswerService.findAll(num, page);
        System.out.println(pageInfo);
        return Result.success(pageInfo);
    }


    @RequestMapping( "/insert.action" )
    @ResponseBody
    public Result insert(TbSanswer sanswer) {
        int i = sAnswerService.insert(sanswer);
        return Result.success(null);
    }

    @RequestMapping( "/update.action" )
    @ResponseBody
    public Result update(TbSanswer sanswer) {
        int i = sAnswerService.update(sanswer);
        return Result.success(null);
    }

    @RequestMapping( "/delete.action" )
    @ResponseBody
    public Result delete(TbSanswer sanswer) {
        int i = sAnswerService.delete(sanswer);
        return Result.success(null);
    }
}
