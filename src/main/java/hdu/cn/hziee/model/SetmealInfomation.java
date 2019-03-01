package hdu.cn.hziee.model;

public class SetmealInfomation {
    private Integer smId;

    private String smName;

    private Double siFat;

    private Double siEnergy;

    private Double siPortein;

    private Integer siVitaminA;

    private Integer siVitaminB1;

    private Integer siVitaminB2;

    private Integer siVitaminC;

    private Integer siVitaminE;

    private Integer siMg;

    private Integer siCa;

    private Integer siZn;

    private Integer siFe;

    private Integer siCholesterol;

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

    public Integer getSiVitaminB1() {
        return siVitaminB1;
    }

    public void setSiVitaminB1(Integer siVitaminB1) {
        this.siVitaminB1 = siVitaminB1;
    }

    public Integer getSiVitaminB2() {
        return siVitaminB2;
    }

    public void setSiVitaminB2(Integer siVitaminB2) {
        this.siVitaminB2 = siVitaminB2;
    }

    public Integer getSiVitaminC() {
        return siVitaminC;
    }

    public void setSiVitaminC(Integer siVitaminC) {
        this.siVitaminC = siVitaminC;
    }

    public Integer getSiVitaminE() {
        return siVitaminE;
    }

    public void setSiVitaminE(Integer siVitaminE) {
        this.siVitaminE = siVitaminE;
    }

    public Integer getSiMg() {
        return siMg;
    }

    public void setSiMg(Integer siMg) {
        this.siMg = siMg;
    }

    public Integer getSiCa() {
        return siCa;
    }

    public void setSiCa(Integer siCa) {
        this.siCa = siCa;
    }

    public Integer getSiZn() {
        return siZn;
    }

    public void setSiZn(Integer siZn) {
        this.siZn = siZn;
    }

    public Integer getSiFe() {
        return siFe;
    }

    public void setSiFe(Integer siFe) {
        this.siFe = siFe;
    }

    public Integer getSiCholesterol() {
        return siCholesterol;
    }

    public void setSiCholesterol(Integer siCholesterol) {
        this.siCholesterol = siCholesterol;
    }

    public Integer getRightTime() {
        return rightTime;
    }

    public void setRightTime(Integer rightTime) {
        this.rightTime = rightTime;
    }
}