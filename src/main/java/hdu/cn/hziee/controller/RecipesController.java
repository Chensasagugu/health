package hdu.cn.hziee.controller;

import hdu.cn.hziee.model.Food;
import hdu.cn.hziee.model.FoodFormula;
import hdu.cn.hziee.model.Recipes;
import hdu.cn.hziee.service.FoodFormulaService;
import hdu.cn.hziee.service.FoodService;
import hdu.cn.hziee.service.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("recipes")
public class RecipesController {

    @Autowired
    RecipesService recipesService;

    @Autowired
    FoodFormulaService foodFormulaService;

    @Autowired
    FoodService foodService;


    @RequestMapping("update")
    public void updateRecipesData(){
        List<Recipes> RecipesList = recipesService.Findall();
        for (int i = 0;i<RecipesList.size();i++){
            int Recipes_id = RecipesList.get(i).getRecipesId();

            //营养含量值
            double Food_fat = 0;
            double Food_protein = 0;
            double Food_energy = 0;
            double Food_vitamin_A = 0;
            double Food_vitamin_B_1 = 0;
            double Food_vitamin_B_2 = 0;
            double Food_vitamin_C = 0;
            double Food_vitamin_E = 0;
            double Food_Ca = 0;
            double Food_Mg = 0;
            double Food_Fe = 0;
            double Food_Zn = 0;
            double Food_cholesterol = 0;

            List<FoodFormula> foodFormulaList = foodFormulaService.SelectByRecipesId(Recipes_id);
            for (int n = 0;n<foodFormulaList.size();n++){
                int Foodid = foodFormulaList.get(n).getFoodId();
                double Foodnumber = foodFormulaList.get(n).getFoodNumber();
                Food food = foodService.selectByPrimaryKey(Foodid);

                //计算套餐营养含量
                Food_fat += food.getFoodFat()*9*Foodnumber;
                Food_protein += food.getFoodProtein()*Foodnumber;
                Food_energy += food.getFoodEnergy()*Foodnumber;
                Food_vitamin_A += food.getFoodVitaminA()*Foodnumber;
                Food_vitamin_B_1 += food.getFoodVitaminB1()*Foodnumber;
                Food_vitamin_B_2 += food.getFoodVitaminB2()*Foodnumber;
                Food_vitamin_C += food.getFoodVitaminC()*Foodnumber;
                Food_vitamin_E += food.getFoodVitaminE()*Foodnumber;
                Food_Ca += food.getFoodCa()*Foodnumber;
                Food_Mg += food.getFoodMg()*Foodnumber;
                Food_Fe += food.getFoodFe()*Foodnumber;
                Food_Zn += food.getFoodZn()*Foodnumber;
                Food_cholesterol += food.getFoodCholesterol()*Foodnumber;
            }

            Recipes recipes = new Recipes();
            recipes.setRecipesId(Recipes_id);
            recipes.setRecipesFat(Food_fat/3);
            recipes.setRecipesProtein(Food_protein/3);
            recipes.setRecipesEnergy(Food_energy/3);
            recipes.setRecipesVitaminA(Food_vitamin_A/3);
            recipes.setRecipesVitaminB1(Food_vitamin_B_1/3);
            recipes.setRecipesVitaminB2(Food_vitamin_B_2/3);
            recipes.setRecipesVitaminC(Food_vitamin_C/3);
            recipes.setRecipesVitaminE(Food_vitamin_E/3);
            recipes.setRecipesCa(Food_Ca/3);
            recipes.setRecipesMg(Food_Mg/3);
            recipes.setRecipesFe(Food_Fe/3);
            recipes.setRecipesZn(Food_Zn/3);
            recipes.setRecipesCholesterol(Food_cholesterol/3);
            recipesService.UpdateByPrimaryKeySelective(recipes);
        }
    }
}
