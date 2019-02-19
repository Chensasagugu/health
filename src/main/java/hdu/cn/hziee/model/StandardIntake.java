package hdu.cn.hziee.model;

public class StandardIntake {
    private Integer siId;

    private Integer siAge;

    private Integer siEnergy;

    private Integer siPortein;

    private Integer siVitaminA;

    private Double siVitaminB1;

    private Double siVitaminB2;

    private Integer siVitaminC;

    private Integer siPhysical;

    private Integer siSpecial;

    public  StandardIntake() { }
    public StandardIntake(StandardIntake_Male standardIntake_male)
    {
        this.setSiId(standardIntake_male.getSiId());
        this.setSiAge(standardIntake_male.getSiAge());
        this.setSiEnergy(standardIntake_male.getSiEnergy());
        this.setSiPortein(standardIntake_male.getSiPortein());
        this.setSiVitaminA(standardIntake_male.getSiVitaminA());
        this.setSiVitaminB1(standardIntake_male.getSiVitaminB1());
        this.setSiVitaminB2(standardIntake_male.getSiVitaminB2());
        this.setSiVitaminC(standardIntake_male.getSiVitaminC());
        this.setSiPhysical(standardIntake_male.getSiPhysical());
        this.setSiSpecial(0);
    }
    public StandardIntake(StandardIntake_Female standardIntake_female)
    {
        this.setSiId(standardIntake_female.getSiId());
        this.setSiAge(standardIntake_female.getSiAge());
        this.setSiEnergy(standardIntake_female.getSiEnergy());
        this.setSiPortein(standardIntake_female.getSiPortein());
        this.setSiVitaminA(standardIntake_female.getSiVitaminA());
        this.setSiVitaminB1(standardIntake_female.getSiVitaminB1());
        this.setSiVitaminB2(standardIntake_female.getSiVitaminB2());
        this.setSiVitaminC(standardIntake_female.getSiVitaminC());
        this.setSiPhysical(standardIntake_female.getSiPhysical());
        this.setSiSpecial(standardIntake_female.getSiSpecial());
    }
    public Integer getSiId() {
        return siId;
    }

    public void setSiId(Integer siId) {
        this.siId = siId;
    }

    public Integer getSiAge() {
        return siAge;
    }

    public void setSiAge(Integer siAge) {
        this.siAge = siAge;
    }

    public Integer getSiEnergy() {
        return siEnergy;
    }

    public void setSiEnergy(Integer siEnergy) {
        this.siEnergy = siEnergy;
    }

    public Integer getSiPortein() {
        return siPortein;
    }

    public void setSiPortein(Integer siPortein) {
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

    public Integer getSiPhysical() {
        return siPhysical;
    }

    public void setSiPhysical(Integer siPhysical) {
        this.siPhysical = siPhysical;
    }

    public Integer getSiSpecial() {
        return siSpecial;
    }

    public void setSiSpecial(Integer siSpecial) {
        this.siSpecial = siSpecial;
    }
}
