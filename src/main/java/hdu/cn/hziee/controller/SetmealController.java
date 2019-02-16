package hdu.cn.hziee.controller;

import hdu.cn.hziee.model.Food;
import hdu.cn.hziee.model.FoodFormula;
import hdu.cn.hziee.service.FoodFormulaService;
import hdu.cn.hziee.service.FoodService;
import hdu.cn.hziee.service.RecipesService;
import hdu.cn.hziee.service.SetmealInfomationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/setmeal")
public class SetmealController {

    @Autowired
    SetmealInfomationService setmealInfomationService;

    @Autowired
    RecipesService recipesService;

    @Autowired
    FoodFormulaService foodFormulaService;

    @Autowired
    FoodService foodService;

    @Test
    public void shiyan(){
        long time = System.currentTimeMillis();
        String t = String.valueOf(time/1000);
        System.out.println(t);
    }

    //增加套餐
    public void insertSM(int[] RecipesArray){
        //营养含量值
        double Food_fat = 0;
        double Food_protein = 0;
        double Food_energy = 0;
        double Food_vitamin_A = 0;
        double Food_vitamin_B_1 = 0;
        double Food_vitamin_B_2 = 0;
        int Food_vitamin_C = 0;

        for (int i = 0;i<RecipesArray.length;i++){
            int Recipes_id = RecipesArray[i];
            List<FoodFormula> RecipesList = foodFormulaService.SelectByRecipesId(Recipes_id);
            for (int j = 0;j<RecipesList.size();j++){
                int Food_id = RecipesList.get(j).getFoodId();
                Food food = foodService.selectByPrimaryKey(Food_id);

            }
        }
    }

    //给套餐配置菜品


}
