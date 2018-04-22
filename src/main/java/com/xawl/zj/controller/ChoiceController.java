package com.xawl.zj.controller;

import com.github.pagehelper.PageInfo;
import com.xawl.zj.pojo.TbChoice;
import com.xawl.zj.service.ChoiceService;
import com.xawl.zj.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping( "/choice" )
public class ChoiceController {
    @Autowired
    private ChoiceService choiceService;


    @GetMapping( "/findAll.action" )
    @ResponseBody
    public Result findAll(Integer num, Integer page) {
        if ( num == null || num == 0 ) {
            num = 5;
        }
        if ( page == null || page == 0 ) {
            page = 1;
        }
        PageInfo pageInfo = choiceService.findAll(num, page);
        System.out.println(pageInfo);
        return Result.success(pageInfo);
    }

    @RequestMapping( "/insert.action" )
    @ResponseBody
    public Result insert(TbChoice choice) {
        choice.setScore(1);
        int i = choiceService.insert(choice);
        return Result.success(null);
    }

    @RequestMapping( "/update.action" )
    @ResponseBody
    public Result update(TbChoice choice) {
        int i = choiceService.update(choice);
        return Result.success(null);
    }

    @RequestMapping( "/delete.action" )
    @ResponseBody
    public Result delete(TbChoice choice) {
        int i = choiceService.delete(choice);
        return Result.success(null);
    }

    @RequestMapping( "/getOne.action" )
    @ResponseBody
    public Result getOne() {
        TbChoice choice = choiceService.getOne();
        return Result.success(choice);
    }
}
