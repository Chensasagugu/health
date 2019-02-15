package hdu.cn.hziee.model;

import java.util.Date;

public class DietRecord {
    private Integer drId;

    private Integer userId;

    private Date drDate;

    private Integer drTime;

    public Integer getDrId() {
        return drId;
    }

    public void setDrId(Integer drId) {
        this.drId = drId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDrDate() {
        return drDate;
    }

    public void setDrDate(Date drDate) {
        this.drDate = drDate;
    }

    public Integer getDrTime() {
        return drTime;
    }

    public void setDrTime(Integer drTime) {
        this.drTime = drTime;
    }
}