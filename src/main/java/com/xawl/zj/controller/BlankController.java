package com.xawl.zj.controller;

import com.github.pagehelper.PageInfo;
import com.xawl.zj.pojo.TbBlank;
import com.xawl.zj.service.BlankService;
import com.xawl.zj.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping( "/blank" )
public class BlankController {
    @Autowired
    private BlankService blankService;

    @GetMapping( "/findAll.action" )
    @ResponseBody
    public Result findAll(Integer num, Integer page) {
        if ( num == null || num == 0 ) {
            num = 5;
        }
        if ( page == null || page == 0 ) {
            page = 1;
        }
        PageInfo pageInfo = blankService.findAll(num, page);
        System.out.println(pageInfo);
        return Result.success(pageInfo);
    }


    @RequestMapping( "/insert.action" )
    @ResponseBody
    public Result insert(TbBlank blank) {
        blank.setScore(2);
        int i = blankService.insert(blank);
        return Result.success(null);
    }

    @RequestMapping( "/update.action" )
    @ResponseBody
    public Result update(TbBlank blank) {
        int i = blankService.update(blank);
        return Result.success(null);
    }

    @RequestMapping( "/delete.action" )
    @ResponseBody
    public Result delete(TbBlank blank) {
        int i = blankService.delete(blank);
        return Result.success(null);
    }

    @RequestMapping( "/getOne.action" )
    @ResponseBody
    public Result getOne() {
        TbBlank blank = blankService.getOne();
        return Result.success(blank);
    }
}
