package cn.bin.zhang.vo;

import java.io.Serializable;
import java.util.Date;

public class User  implements Serializable {
    private static final long serialVersionUID = 9171311636732720454L;
    private Integer uid;
    private Integer uage;
    private Date ubirthday;
    private String uname;
    private String upasswd;
    private String uphoto;
    private String uinfo;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUage() {
        return uage;
    }

    public void setUage(Integer uage) {
        this.uage = uage;
    }

    public Date getUbirthday() {
        return ubirthday;
    }

    public void setUbirthday(Date ubirthday) {
        this.ubirthday = ubirthday;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpasswd() {
        return upasswd;
    }

    public void setUpasswd(String upasswd) {
        this.upasswd = upasswd;
    }

    public String getUphoto() {
        return uphoto;
    }

    public void setUphoto(String uphoto) {
        this.uphoto = uphoto;
    }

    public String getUinfo() {
        return uinfo;
    }

    public void setUinfo(String uinfo) {
        this.uinfo = uinfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uage=" + uage +
                ", ubirthday=" + ubirthday +
                ", uname='" + uname + '\'' +
                ", upasswd='" + upasswd + '\'' +
                ", uphoto='" + uphoto + '\'' +
                ", uinfo='" + uinfo + '\'' +
                '}';
    }
}
