package hdu.cn.hziee.model;

import java.util.Date;

public class PushInfomation {
    private Integer piId;

    private Integer userId;

    private Integer smId;

    private String underlyingdisease;

    private String journaltips;

    private Date piDate;

    private Integer piTime;

    public Integer getPiId() {
        return piId;
    }

    public void setPiId(Integer piId) {
        this.piId = piId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSmId() {
        return smId;
    }

    public void setSmId(Integer smId) {
        this.smId = smId;
    }

    public String getUnderlyingdisease() {
        return underlyingdisease;
    }

    public void setUnderlyingdisease(String underlyingdisease) {
        this.underlyingdisease = underlyingdisease == null ? null : underlyingdisease.trim();
    }

    public String getJournaltips() {
        return journaltips;
    }

    public void setJournaltips(String journaltips) {
        this.journaltips = journaltips == null ? null : journaltips.trim();
    }

    public Date getPiDate() {
        return piDate;
    }

    public void setPiDate(Date piDate) {
        this.piDate = piDate;
    }

    public Integer getPiTime() {
        return piTime;
    }

    public void setPiTime(Integer piTime) {
        this.piTime = piTime;
    }
}