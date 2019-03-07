package hdu.cn.hziee.model;

public class Occupation {
    private Integer occupationId;

    private String occupationName;

    private Integer occupationPressure;

    public Integer getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(Integer occupationId) {
        this.occupationId = occupationId;
    }

    public String getOccupationName() {
        return occupationName;
    }

    public void setOccupationName(String occupationName) {
        this.occupationName = occupationName == null ? null : occupationName.trim();
    }

    public Integer getOccupationPressure() {
        return occupationPressure;
    }

    public void setOccupationPressure(Integer occupationPressure) {
        this.occupationPressure = occupationPressure;
    }
}