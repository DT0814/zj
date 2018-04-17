package com.xawl.zj.pojo;

public class TbSanswer {
    private Integer said;

    private String stem;

    private Integer pid;

    private Integer did;

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
        this.stem = stem == null ? null : stem.trim();
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
        return "TbSanswer{" +
                "said=" + said +
                ", stem='" + stem + '\'' +
                ", pid=" + pid +
                ", did=" + did +
                '}';
    }
}