package hdu.cn.hziee.controller;

import hdu.cn.hziee.model.*;
import hdu.cn.hziee.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("illness")
public class IllnessController {

    @Autowired
    UserIllnessService userIllnessService;

    @Autowired
    FoodillnessService foodillnessService;

    @Autowired
    RecipesIllnessService recipesIllnessService;

    @Autowired
    FoodFormulaService foodFormulaService;

    @Autowired
    SetMealService setMealService;

    @RequestMapping("GetRemoveSetmeal")
    public ArrayList GetRemoveSetmeal(@RequestParam("userid") int user_id){
        List<UserIllness> UINlist = userIllnessService.SelectByUserid(user_id);
        if (UINlist.size() != 0){
            ArrayList<Integer> RecipesIdlist = new ArrayList<>();
            for (int i = 0;i<UINlist.size();i++){
                int ill_id = UINlist.get(i).getIllId();
                List<RecipesIllness> RIlist = recipesIllnessService.SelectByillId(ill_id);
                if (RIlist.size() != 0){
                    for (int n = 0;n<RIlist.size();n++){
                        int Recipes_id = RIlist.get(n).getRecipesId();
                        RecipesIdlist.add(Recipes_id);
                    }
                }

                List<FoodIllness> FIlist = foodillnessService.SelectByillId(ill_id);
                if (FIlist.size() != 0){
                    for (int m = 0;m< FIlist.size();m++){
                        int food_id = FIlist.get(m).getFoodId();
                        List<FoodFormula> FFlist = foodFormulaService.SelectByFoodid(food_id);
                        if (FFlist.size() != 0){
                            for (int p = 0;p<FFlist.size();p++){
                                int Recipes_id = FFlist.get(p).getRecipesId();
                                RecipesIdlist.add(Recipes_id);
                            }
                        }
                    }
                }
            }

            if (RecipesIdlist.size() != 0){
                ArrayList<Integer> SetmealIdlist = new ArrayList<>();
                for (int i = 0;i<RecipesIdlist.size();i++){
                    SetMeal SM = setMealService.SelectByRecipesid(RecipesIdlist.get(i));
                    SetmealIdlist.add(SM.getSmId());
                }
                return SetmealIdlist;
            }else{
                return null;
            }
        }else{
            return null;
        }


    }
}
