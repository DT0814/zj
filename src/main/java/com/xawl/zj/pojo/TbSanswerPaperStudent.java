package com.xawl.zj.pojo;

public class TbSanswerPaperStudent {
    private Integer sapaid;

    private Integer said;

    private String answer;

    private Integer paid;

    public Integer getSapaid() {
        return sapaid;
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
}