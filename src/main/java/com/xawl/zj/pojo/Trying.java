package com.xawl.zj.pojo;

public class Trying {
    private Integer num;
    private Integer catalog;
    private Integer pid;
    private Integer did;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getCatalog() {
        return catalog;
    }

    public void setCatalog(Integer catalog) {
        this.catalog = catalog;
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
        return "Trying{" +
                "num=" + num +
                ", catalog=" + catalog +
                ", pid=" + pid +
                ", did=" + did +
                '}';
    }
}
