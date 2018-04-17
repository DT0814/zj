package com.xawl.zj.controller;

import com.xawl.zj.pojo.TbDifficulty;
import com.xawl.zj.service.DifficultyService;
import com.xawl.zj.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping( "/difficulty" )
public class DifficultyController {
    @Autowired
    private DifficultyService difficultyService;

    @GetMapping( "/findAll.action" )
    @ResponseBody
    public Result findAll() {
        List<TbDifficulty> list = difficultyService.findAll();
        return Result.success(list);
    }

    @RequestMapping( "/insert.action" )
    @ResponseBody
    public Result insert(TbDifficulty tbDifficulty) {
        int i = difficultyService.insert(tbDifficulty);
        return Result.success(null);
    }

    @RequestMapping( "/update.action" )
    @ResponseBody
    public Result update(TbDifficulty tbDifficulty) {
        int i = difficultyService.update(tbDifficulty);
        return Result.success(null);
    }

    @RequestMapping( "/delete.action" )
    @ResponseBody
    public Result delete(TbDifficulty tbDifficulty) {
        int i = difficultyService.delete(tbDifficulty);
        return Result.success(null);
    }
}
