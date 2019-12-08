package com.bin.zhang.vo;

import java.io.Serializable;

public class JsonP implements Serializable {
    private static final long serialVersionUID = 3717332994326881470L;
    private String deptno;
    private String dname;
    private String desc;

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
