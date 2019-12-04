package cn.bin.zhang.vo;

import java.io.Serializable;

public class Bblog implements Serializable {
    private static final long serialVersionUID = 2035107875546348754L;
    private String bbtitle;
    private String bbintrod;
    private String bbcontent;
    private String bbphoto;
    private Integer bbid;
    private Buser buser;

    public void setBuser(Buser buser) {
        this.buser = buser;
    }

    public Buser getBuser() {
        return buser;
    }

    public String getBbtitle() {
        return bbtitle;
    }

    public void setBbtitle(String bbtitle) {
        this.bbtitle = bbtitle;
    }

    public String getBbintrod() {
        return bbintrod;
    }

    public void setBbintrod(String bbintrod) {
        this.bbintrod = bbintrod;
    }

    public String getBbcontent() {
        return bbcontent;
    }

    public void setBbcontent(String bbcontent) {
        this.bbcontent = bbcontent;
    }

    public String getBbphoto() {
        return bbphoto;
    }

    public void setBbphoto(String bbphoto) {
        this.bbphoto = bbphoto;
    }

    public Integer getBbid() {
        return bbid;
    }

    public void setBbid(Integer bbid) {
        this.bbid = bbid;
    }
}
