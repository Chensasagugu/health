package hdu.cn.hziee.model;

public class Adward {
    int smId;
    double weight;
    public Adward(int smId,int weight)
    {
        this.smId=smId;
        this.weight=weight;
    }
    public Adward(int smId)
    {
        this.smId=smId;
        this.weight=1;
    }
    public int getSmId() {
        return smId;
    }

    public void setSmId(int smId) {
        this.smId = smId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
