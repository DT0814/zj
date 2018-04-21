package com.xawl.zj.pojo;

public class TbStudent {
    private String snum;

    private String sname;

    private Integer cid;

    private String spass;

    private String token;

    private String tokenpass;
    //学生的某一次的分数,用于教师查询试卷完成情况使用
    private TbStudentScore score;
    //所在班级名称
    private String cname;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public TbStudentScore getScore() {
        return score;
    }

    public void setScore(TbStudentScore score) {
        this.score = score;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum == null ? null : snum.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getSpass() {
        return spass;
    }

    public void setSpass(String spass) {
        this.spass = spass == null ? null : spass.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getTokenpass() {
        return tokenpass;
    }

    public void setTokenpass(String tokenpass) {
        this.tokenpass = tokenpass == null ? null : tokenpass.trim();
    }
}