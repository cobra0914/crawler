package com.cobra.entity;

/**
 * Created by cobra on 2016/6/1.
 */
public class Category {
    private int cId;
    private int cPid;
    private String cName;
    private String cUrl;

    public Category() {
    }

    public Category(int cPid, String cName, String cUrl) {
        this.cPid = cPid;
        this.cName = cName;
        this.cUrl = cUrl;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getcPid() {
        return cPid;
    }

    public void setcPid(int cPid) {
        this.cPid = cPid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcUrl() {
        return cUrl;
    }

    public void setcUrl(String cUrl) {
        this.cUrl = cUrl;
    }
}
