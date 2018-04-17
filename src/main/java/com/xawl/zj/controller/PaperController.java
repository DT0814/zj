package com.xawl.zj.controller;

import com.xawl.zj.pojo.TbBlank;
import com.xawl.zj.pojo.TbChoice;
import com.xawl.zj.pojo.TbPaper;
import com.xawl.zj.pojo.TbSanswer;
import com.xawl.zj.service.BlankService;
import com.xawl.zj.service.ChoiceService;
import com.xawl.zj.service.PaperService;
import com.xawl.zj.service.SAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping( "/paper" )
public class PaperController {
    @Autowired
    private PaperService paperService;
    @Autowired
    private ChoiceService choiceService;
    @Autowired
    private BlankService blankService;
    @Autowired
    private SAnswerService sAnswerService;

    @RequestMapping( "/getPaper.action" )
    public ModelAndView getPaper(Integer paid) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("paper");
        TbPaper paper = paperService.selectBypid(paid);
        List<TbChoice> choices = choiceService.selectByCount(paper.getSnum());
        List<TbBlank> blanks = blankService.selectByCount(paper.getBnum());
        List<TbSanswer> sansers = sAnswerService.selectByCount(paper.getSanum());
        mv.addObject("choices", choices);
        mv.addObject("blanks", blanks);
        mv.addObject("sansers", sansers);
        mv.addObject("paper", paper);
        return mv;
    }

}
