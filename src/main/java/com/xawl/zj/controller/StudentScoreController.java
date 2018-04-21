package com.xawl.zj.controller;

import com.xawl.zj.service.StudentScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentScoreController {
    @Autowired
    private StudentScoreService studentScoreService;
}
