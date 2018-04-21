package com.xawl.zj.controller;

import com.xawl.zj.pojo.TbBlank;
import com.xawl.zj.pojo.TbChoice;
import com.xawl.zj.pojo.Trying;
import com.xawl.zj.service.BlankService;
import com.xawl.zj.service.ChoiceService;
import com.xawl.zj.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping( "/trying" )
public class TryingController {
    @Autowired
    private ChoiceService choiceService;
    @Autowired
    private BlankService blankService;

    @RequestMapping( "/getTrying" )
    public ModelAndView trying(Trying trying, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        if ( trying.getNum() == null || trying.getNum() == 0 ) {
            trying.setNum(10);
        }
        if ( trying.getCatalog() == 1 ) {
            List<TbChoice> list = choiceService.findChoiceRandom(trying.getNum(), trying.getDid(), trying.getPid());
            session.setAttribute("types", 1);
            session.setAttribute("choiceList", list);
            session.removeAttribute("blankList");
        }
        if ( trying.getCatalog() == 2 ) {
            List<TbBlank> list = blankService.findBlankRandom(trying.getNum(), trying.getDid(), trying.getPid());
            session.setAttribute("types", 2);
            session.setAttribute("blankList", list);
            session.removeAttribute("choiceList");
        }
        mv.setViewName("training");
        System.out.println(trying);
        return mv;
    }

    @RequestMapping( "/submitTrying" )
    @ResponseBody
    public Result submitTrying(String[] choices, String[] blanks, HttpSession session) {
        List<TbChoice> choiceList = (List<TbChoice>) session.getAttribute("choiceList");
        Integer types = (Integer) session.getAttribute("types");
        String str;
        int num = 0;
        if ( types.equals(1) ) {
            for ( int i = 0; i < choiceList.size(); i++ ) {
                if ( choices[i].equals(choiceList.get(i).getAnswer()) ) {
                    num++;
                }
            }
            for ( TbChoice tbChoice : choiceList ) {
                System.out.print("tbChoice:" + tbChoice);
            }
            for ( String choice : choices ) {
                System.out.print("choice:" + choice);
            }
        } else {
            System.out.println();
            List<TbBlank> blankList = (List<TbBlank>) session.getAttribute("blankList");
            for ( int i = 0; i < blankList.size(); i++ ) {
                if ( blanks[i].equals(blankList.get(i).getAnswer()) ) {
                    num++;
                }
            }
            for ( TbBlank tbBlank : blankList ) {
                System.out.print("tbBlank:" + tbBlank);
            }
            System.out.println();
            for ( String blank : blanks ) {
                System.out.print("blank:" + blank);
            }
        }
        str = "您本次答对了" + num + "道题";
        return Result.success(str);
    }

}
