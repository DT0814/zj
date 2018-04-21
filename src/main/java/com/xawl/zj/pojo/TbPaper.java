package com.xawl.zj.pojo;

public class TbPaper {
    private Integer paid;

    private Integer snum;

    private Integer bnum;

    private Integer sanum;

    private String tnum;

    private String name;

    private Integer time;

    private Integer cid;

    private TbStudentScore score;

    public TbStudentScore getScore() {
        return score;
    }

    public void setScore(TbStudentScore score) {
        this.score = score;
    }

    public Integer getPaid() {
        return paid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public Integer getBnum() {
        return bnum;
    }

    public void setBnum(Integer bnum) {
        this.bnum = bnum;
    }

    public Integer getSanum() {
        return sanum;
    }

    public void setSanum(Integer sanum) {
        this.sanum = sanum;
    }

    public String getTnum() {
        return tnum;
    }

    public void setTnum(String tnum) {
        this.tnum = tnum == null ? null : tnum.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "TbPaper{" +
                "paid=" + paid +
                ", snum=" + snum +
                ", bnum=" + bnum +
                ", sanum=" + sanum +
                ", tnum='" + tnum + '\'' +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", cid=" + cid +
                '}';
    }
}