package hdu.cn.hziee.model;

public class Recipes {
    private Integer recipesId;

    private String recipesName;

    private String recipesType;

    public Integer getRecipesId() {
        return recipesId;
    }

    public void setRecipesId(Integer recipesId) {
        this.recipesId = recipesId;
    }

    public String getRecipesName() {
        return recipesName;
    }

    public void setRecipesName(String recipesName) {
        this.recipesName = recipesName == null ? null : recipesName.trim();
    }

    public String getRecipesType() {
        return recipesType;
    }

    public void setRecipesType(String recipesType) {
        this.recipesType = recipesType == null ? null : recipesType.trim();
    }
}