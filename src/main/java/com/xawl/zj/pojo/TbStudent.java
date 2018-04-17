package com.xawl.zj.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class TbStudent {
    private String snum;

    private String sname;

    private Integer cid;

    private String spass;

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

    @Override
    public String toString() {
        return "TbStudent{" +
                "snum='" + snum + '\'' +
                ", sname='" + sname + '\'' +
                ", cid=" + cid +
                ", spass='" + spass + '\'' +
                '}';
    }
}