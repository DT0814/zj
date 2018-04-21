package com.xawl.zj.controller;

import com.xawl.zj.pojo.*;
import com.xawl.zj.service.*;
import com.xawl.zj.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
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
    @Autowired
    private PointService pointService;
    @Autowired
    private PaperChoiceService paperChoiceService;
    @Autowired
    private PaperBlankService paperBlankService;
    @Autowired
    private PaperSanswerService paperSanswerService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentScoreService studentScoreService;
    @Autowired
    private SanswerPaperStudentService sanswerPaperStudentService;

    @RequestMapping( "/getPaper.action" )
    public ModelAndView getPaper(Integer paid, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("paper");
        TbPaper paper = paperService.selectByPaid(paid);
        List<TbChoice> choices = new ArrayList<>();
        List<TbPaperChoice> paperChoices = paperChoiceService.selectByPaid(paper.getPaid());
        for ( TbPaperChoice paperChoice : paperChoices ) {
            List<TbChoice> list = choiceService.selectByPidAndNum(paperChoice.getPid(), paperChoice.getNum());
            choices.addAll(list);
        }
        session.setAttribute("choices", choices);


        List<TbBlank> blanks = new ArrayList<>();
        List<TbPaperBlank> paperBlanks = paperBlankService.selectByPaid(paper.getPaid());
        for ( TbPaperBlank paperBlank : paperBlanks ) {
            List<TbBlank> list = blankService.selectByPidAndNum(paperBlank.getPid(), paperBlank.getNum());
            blanks.addAll(list);
        }
        session.setAttribute("blanks", blanks);


        List<TbSanswer> sanswers = new ArrayList<>();
        List<TbPaperSanswer> paperSanswers = paperSanswerService.selectByPaid(paper.getPaid());
        for ( TbPaperSanswer paperSanswer : paperSanswers ) {
            List<TbSanswer> list = sAnswerService.selectByPidAndNum(paperSanswer.getPid(), paperSanswer.getNum());
            sanswers.addAll(list);
        }
        session.setAttribute("sanswers", sanswers);
        session.setAttribute("paper", paper);
        return mv;
    }

    @ResponseBody
    @RequestMapping( "/findByTnum.action" )
    public Result findByTnum(String tnum) {
        List<TbPaper> list = paperService.findByTnum(tnum);
        return Result.success(list);
    }

    @ResponseBody
    @RequestMapping( "/delete.action" )
    public Result delete(Integer paid) {
        paperService.delete(paid);
        paperChoiceService.deleteByPaid(paid);
        paperBlankService.deleteByPaid(paid);
        paperSanswerService.deleteByPaid(paid);
        return Result.success(null);
    }

    @ResponseBody
    @RequestMapping( "/add.action" )
    public Result add(Integer[] choice, Integer[] blank, Integer[] sanswer, TbPaper paper) {

        //计算各个题型的总数创建试卷
        Integer snum = 0, bnum = 0, sanum = 0;
        for ( Integer i : choice ) {
            snum += i;
        }
        for ( Integer i : blank ) {
            bnum += i;
        }
        for ( Integer i : sanswer ) {
            sanum += i;
        }
        paper.setBnum(bnum);
        paper.setSanum(sanum);
        paper.setSnum(snum);
        paperService.insert(paper);
        //查询所有知识点创建试卷_题型实体
        List<TbPoint> points = pointService.findAll();
        int i = 0;
        int paid = paper.getPaid();
        for ( TbPoint point : points ) {
            //如果本知识点出题数大于0则向数据库插入一条数据
            if ( choice[i] != 0 ) {
                TbPaperChoice tbPaperChoice = new TbPaperChoice();
                tbPaperChoice.setPid(point.getPid());
                tbPaperChoice.setNum(choice[i]);
                tbPaperChoice.setPaid(paid);
                paperChoiceService.insert(tbPaperChoice);
            }
            if ( blank[i] != 0 ) {
                TbPaperBlank tbPaperBlank = new TbPaperBlank();
                tbPaperBlank.setPid(point.getPid());
                tbPaperBlank.setPaid(paid);
                tbPaperBlank.setNum(blank[i]);
                paperBlankService.insert(tbPaperBlank);
            }
            if ( sanswer[i] != 0 ) {
                TbPaperSanswer tbPaperSanswer = new TbPaperSanswer();
                tbPaperSanswer.setPid(point.getPid());
                tbPaperSanswer.setPaid(paid);
                tbPaperSanswer.setNum(sanswer[i]);
                paperSanswerService.insert(tbPaperSanswer);
            }
            i++;
        }
        return Result.success(null);
    }

    @ResponseBody
    @RequestMapping( "/showMyPaper.action" )
    public Result showMyPaper(String snum) {
        TbStudent bySnum = studentService.findBySnum(snum);
        List<TbPaper> list = paperService.selectByCid(bySnum.getCid());
        for ( TbPaper paper : list ) {
            TbStudentScore score = studentScoreService.selectByPaid(paper.getPaid(), snum);
            if ( score != null ) {
                paper.setScore(score);
            }
        }
        return Result.success(list);
    }

    @ResponseBody
    @RequestMapping( "/submitPaper.action" )
    public Result submitPaper(String snum, Integer paid, String choice, String blank, String sanswer, HttpSession session) throws UnsupportedEncodingException {
        if ( studentScoreService.selectByPaidAndSnum(paid, snum) != null ) {
            return Result.success("你已经打过本试卷");
        }
        String[] choices = choice.split("&");
        List<TbChoice> ListChoices = (List<TbChoice>) session.getAttribute("choices");
        int choiceScore = 0;
        for ( int i = 0; i < choices.length; i++ ) {
            TbChoice tbChoice = ListChoices.get(i);
            if ( choices[i].substring(choices[i].indexOf('=') + 1).equals(tbChoice.getAnswer()) ) {
                choiceScore += 1;
            }
        }
        List<TbBlank> paperBlanks = (List<TbBlank>) session.getAttribute("blanks");
        String[] blanks = blank.split("&");
        int blankScore = 0;
        for ( int i = 0; i < blanks.length; i++ ) {
            TbBlank tbBlank = paperBlanks.get(i);
            String s = blanks[i].substring(blanks[i].indexOf('=') + 1);
            s = URLDecoder.decode(s, "UTF-8");
            if ( s.equals(tbBlank.getAnswer()) ) {
                blankScore += 2;
            }
        }
        String[] sanswers = sanswer.split("&");
        String str = "";
        str += "选择题" + choiceScore + "分,";
        str += "填空题" + blankScore + "分,";

        TbStudentScore tbStudentScore = new TbStudentScore();
        tbStudentScore.setSnum(snum);
        tbStudentScore.setPaid(paid);
        tbStudentScore.setScore(choiceScore + blankScore);
        studentScoreService.insert(tbStudentScore);


        List<TbSanswer> paperSanswer = (List<TbSanswer>) session.getAttribute("sanswers");
        for ( int i = 0; i < sanswers.length; i++ ) {
            TbSanswer tbSanswer = paperSanswer.get(i);
            String s = sanswers[i].substring(sanswers[i].indexOf('=') + 1);
            s = URLDecoder.decode(s, "UTF-8");
            TbSanswerPaperStudent tbSanswerPaperStudent = new TbSanswerPaperStudent();
            tbSanswerPaperStudent.setPaid(paid);
            tbSanswerPaperStudent.setSnum(snum);
            tbSanswerPaperStudent.setAnswer(s);
            tbSanswerPaperStudent.setSaid(tbSanswer.getSaid());
            sanswerPaperStudentService.insert(tbSanswerPaperStudent);
        }
        return Result.success(str);
    }

    @ResponseBody
    @RequestMapping( "/showMsg.action" )
    public Result showMsg(Integer paid) {
        TbPaper paper = paperService.selectByPaid(paid);
        List<TbStudent> list = studentService.findByCid(paper.getCid());
        for ( TbStudent student : list ) {
            TbStudentScore tbStudentScore = studentScoreService.selectByPaidAndSnum(paper.getPaid(), student.getSnum());
            if ( tbStudentScore != null ) {
                student.setScore(tbStudentScore);
            }
        }
        return Result.success(list);
    }
}
