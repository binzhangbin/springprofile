package cn.bin.zhang.vo;

import java.io.Serializable;
import java.util.Date;

public class File implements Serializable {
    private static final long serialVersionUID = 4474883364234350509L;
    private Integer fid;
    private String fpath;
    private Integer uid;
    private String fname;
    private Date fdate;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFpath() {
        return fpath;
    }

    public void setFpath(String fpath) {
        this.fpath = fpath;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }
}
