package cn.bin.zhang.vo;

import java.io.Serializable;

public class Blog implements Serializable {
    private static final long serialVersionUID = 4171345636332720054L;
    private Integer bid;
    private String btxt;
    private String btitle;
    private Integer uid;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBtxt() {
        return btxt;
    }

    public void setBtxt(String btxt) {
        this.btxt = btxt;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "bid=" + bid +
                ", btxt='" + btxt + '\'' +
                ", btitle='" + btitle + '\'' +
                ", uid=" + uid +
                '}';
    }
}
