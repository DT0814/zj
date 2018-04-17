package com.xawl.zj.pojo;

public class SAnswerResult {
    private String dname;

    private String name;

    private Integer said;

    private String stem;

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

    public Integer getSaid() {
        return said;
    }

    public void setSaid(Integer said) {
        this.said = said;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
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
        return "SAnswerResult{" +
                "dname='" + dname + '\'' +
                ", name='" + name + '\'' +
                ", said=" + said +
                ", stem='" + stem + '\'' +
                ", pid=" + pid +
                ", did=" + did +
                '}';
    }
}
