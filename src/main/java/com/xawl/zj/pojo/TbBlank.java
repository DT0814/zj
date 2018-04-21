package com.xawl.zj.pojo;

public class TbBlank {
    private Integer bid;

    private String stem;

    private String answer;

    private Integer score;

    private Integer pid;

    private Integer did;

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
        this.stem = stem == null ? null : stem.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
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
        return "TbBlank{" +
                "bid=" + bid +
                ", stem='" + stem + '\'' +
                ", answer='" + answer + '\'' +
                ", score=" + score +
                ", pid=" + pid +
                ", did=" + did +
                '}';
    }
}