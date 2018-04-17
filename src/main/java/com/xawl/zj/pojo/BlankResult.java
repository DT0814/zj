package com.xawl.zj.pojo;

public class BlankResult {
    private String dname;

    private String name;

    private Integer bid;

    private String stem;

    private String answer;

    private Integer score;

    private Integer pid;

    private Integer did;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "BlankResult{" +
                "dname='" + dname + '\'' +
                ", name='" + name + '\'' +
                ", bid=" + bid +
                ", stem='" + stem + '\'' +
                ", answer='" + answer + '\'' +
                ", score=" + score +
                ", pid=" + pid +
                ", did=" + did +
                '}';
    }
}
