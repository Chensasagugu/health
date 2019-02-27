package hdu.cn.hziee.util;

import hdu.cn.hziee.model.*;
import hdu.cn.hziee.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GetRemoveSetmeal {

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

    /*
    * 传进参数：User_id
    * 返回参数：ArrayList SetmealIdlist
    *
    * 功能：获取用户不能食用的套餐集合
    * */

    public ArrayList GetRemoveSetmeal(int user_id){
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
