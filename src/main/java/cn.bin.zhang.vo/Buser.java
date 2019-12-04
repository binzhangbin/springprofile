package cn.bin.zhang.vo;

import com.sun.tools.javac.util.List;

import java.io.Serializable;
import java.util.Date;

public class Buser implements Serializable {
    private static final long serialVersionUID = -5990038185984973323L;
    private Integer buid;
    private Integer buage;
    private Date bubirthday;
    private Date bulastloginday;
    private String bueducation;
    private String buname;
    private String bunickname;
    private String buphoto;
    private List<Bblog> bblog;

    public void setBblog(List<Bblog> bblog) {
        this.bblog = bblog;
    }

    public List<Bblog> getBblog() {
        return bblog;
    }

    public Integer getBuid() {
        return buid;
    }

    public void setBuid(Integer buid) {
        this.buid = buid;
    }

    public Integer getBuage() {
        return buage;
    }

    public void setBuage(Integer buage) {
        this.buage = buage;
    }

    public Date getBubirthday() {
        return bubirthday;
    }

    public void setBubirthday(Date bubirthday) {
        this.bubirthday = bubirthday;
    }

    public Date getBulastloginday() {
        return bulastloginday;
    }

    public void setBulastloginday(Date bulastloginday) {
        this.bulastloginday = bulastloginday;
    }

    public String getBueducation() {
        return bueducation;
    }

    public void setBueducation(String bueducation) {
        this.bueducation = bueducation;
    }

    public String getBuname() {
        return buname;
    }

    public void setBuname(String buname) {
        this.buname = buname;
    }

    public String getBunickname() {
        return bunickname;
    }

    public void setBunickname(String bunickname) {
        this.bunickname = bunickname;
    }

    public String getBuphoto() {
        return buphoto;
    }

    public void setBuphoto(String buphoto) {
        this.buphoto = buphoto;
    }
}
