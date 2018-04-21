package com.xawl.zj.pojo;

public class TbSanswerPaperStudent {
    private Integer sapaid;

    private Integer said;
    //简答题信息
    private TbSanswer sanswer;

    private String answer;

    private Integer paid;

    private String snum;

    public Integer getSapaid() {
        return sapaid;
    }

    public TbSanswer getSanswer() {
        return sanswer;
    }

    public void setSanswer(TbSanswer sanswer) {
        this.sanswer = sanswer;
    }

    public void setSapaid(Integer sapaid) {
        this.sapaid = sapaid;
    }

    public Integer getSaid() {
        return said;
    }

    public void setSaid(Integer said) {
        this.said = said;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getPaid() {
        return paid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum == null ? null : snum.trim();
    }
}