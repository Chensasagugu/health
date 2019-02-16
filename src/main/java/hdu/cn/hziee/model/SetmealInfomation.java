package hdu.cn.hziee.model;

public class SetmealInfomation {
    private Integer smId;

    private String smName;

    private Double siFat;

    private Double siEnergy;

    private Double siPortein;

    private Integer siVitaminA;

    private Double siVitaminB1;

    private Double siVitaminB2;

    private Integer siVitaminC;

    private Integer rightTime;

    public Integer getSmId() {
        return smId;
    }

    public void setSmId(Integer smId) {
        this.smId = smId;
    }

    public String getSmName() {
        return smName;
    }

    public void setSmName(String smName) {
        this.smName = smName == null ? null : smName.trim();
    }

    public Double getSiFat() {
        return siFat;
    }

    public void setSiFat(Double siFat) {
        this.siFat = siFat;
    }

    public Double getSiEnergy() {
        return siEnergy;
    }

    public void setSiEnergy(Double siEnergy) {
        this.siEnergy = siEnergy;
    }

    public Double getSiPortein() {
        return siPortein;
    }

    public void setSiPortein(Double siPortein) {
        this.siPortein = siPortein;
    }

    public Integer getSiVitaminA() {
        return siVitaminA;
    }

    public void setSiVitaminA(Integer siVitaminA) {
        this.siVitaminA = siVitaminA;
    }

    public Double getSiVitaminB1() {
        return siVitaminB1;
    }

    public void setSiVitaminB1(Double siVitaminB1) {
        this.siVitaminB1 = siVitaminB1;
    }

    public Double getSiVitaminB2() {
        return siVitaminB2;
    }

    public void setSiVitaminB2(Double siVitaminB2) {
        this.siVitaminB2 = siVitaminB2;
    }

    public Integer getSiVitaminC() {
        return siVitaminC;
    }

    public void setSiVitaminC(Integer siVitaminC) {
        this.siVitaminC = siVitaminC;
    }

    public Integer getRightTime() {
        return rightTime;
    }

    public void setRightTime(Integer rightTime) {
        this.rightTime = rightTime;
    }
}