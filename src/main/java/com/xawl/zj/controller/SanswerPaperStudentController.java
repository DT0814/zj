package com.xawl.zj.controller;

import com.xawl.zj.pojo.TbSanswer;
import com.xawl.zj.pojo.TbSanswerPaperStudent;
import com.xawl.zj.service.SAnswerService;
import com.xawl.zj.service.SanswerPaperStudentService;
import com.xawl.zj.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping( "/sAnswerPaperStudent" )
public class SanswerPaperStudentController {
    @Autowired
    private SanswerPaperStudentService sanswerPaperStudentService;
    @Autowired
    private SAnswerService sAnswerService;

    @ResponseBody
    @RequestMapping( "/findBySnumAndPaid.action" )
    public Result findBySnumAndPaid(Integer paid, String snum) {
        List<TbSanswerPaperStudent> tbSanswerPaperStudent = sanswerPaperStudentService.findBySnumAndPaid(paid, snum);
        for ( TbSanswerPaperStudent sanswerPaperStudent : tbSanswerPaperStudent ) {
            TbSanswer sanswer = sAnswerService.findBySaid(sanswerPaperStudent.getSaid());
            if ( sanswer != null ) {
                sanswerPaperStudent.setSanswer(sanswer);
            }
        }
        return Result.success(tbSanswerPaperStudent);
    }

}
