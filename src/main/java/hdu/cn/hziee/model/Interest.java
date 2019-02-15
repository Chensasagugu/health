package hdu.cn.hziee.model;

public class Interest {
    private Integer interestId;

    private String interestName;

    public Integer getInterestId() {
        return interestId;
    }

    public void setInterestId(Integer interestId) {
        this.interestId = interestId;
    }

    public String getInterestName() {
        return interestName;
    }

    public void setInterestName(String interestName) {
        this.interestName = interestName == null ? null : interestName.trim();
    }
}