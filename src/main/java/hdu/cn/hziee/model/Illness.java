package hdu.cn.hziee.model;

public class Illness {
    private Integer illId;

    private String illName;

    public Integer getIllId() {
        return illId;
    }

    public void setIllId(Integer illId) {
        this.illId = illId;
    }

    public String getIllName() {
        return illName;
    }

    public void setIllName(String illName) {
        this.illName = illName == null ? null : illName.trim();
    }
}