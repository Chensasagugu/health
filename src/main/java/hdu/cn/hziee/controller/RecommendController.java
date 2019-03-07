package hdu.cn.hziee.controller;

import hdu.cn.hziee.model.*;
import hdu.cn.hziee.service.*;
import hdu.cn.hziee.util.AliasUtil;
import hdu.cn.hziee.util.GetRemoveSetmeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class RecommendController {
    @Autowired
    StandardIntakeService standardIntakeService;
    @Autowired
    SetmealInfomationService setmealInfomationService;
    @Autowired
    SetMealService setMealService;
    @Autowired
    PushInfomationService pushInfomationService;
    @Autowired
    RecipesService recipesService;

    GetRemoveSetmeal getRemoveSetmeal = new GetRemoveSetmeal();
    //能量需要的上下波动范围
    @Value("${range.energy}")
    private double energyRange;

    //蛋白质需要的上下波动范围
    @Value("${range.protein}")
    private double proteinRange;

    //脂肪需要的上下波动范围
    @Value("${range.fat}")
    private double fatRange;

    /*
    * 描述：推荐给用户一个菜谱
    * */
    @ResponseBody
    @RequestMapping("/recommend")
    public List<Map> recommend(@RequestBody Userinfo consumer)
    {
        Date date = new Date();
        int time=0;
        if(date.getHours()>=0&&date.getHours()<10)
            time = 1;
        else if(date.getHours()>=10&&date.getHours()<16)
            time = 2;
        else
            time = 3;
        StandardIntake intake = standardIntakeService.getStandardIntake(consumer);
        List<SetmealInfomation> setMealList = setmealInfomationService.SelectByTime(time);

        //通过能量需要筛选
        for(int i =0;i< setMealList.size();i++)
        {
            if(setMealList.get(i).getSiEnergy()>(intake.getSiEnergy()+energyRange)
                    ||setMealList.get(i).getSiEnergy()<(intake.getSiEnergy()-energyRange))
            {
                setMealList.remove(i);
            }
        }
        //通过蛋白质需要筛选
        for(int i =0;i< setMealList.size();i++)
        {
            if(setMealList.get(i).getSiPortein()>(intake.getSiPortein()+proteinRange)
                    ||setMealList.get(i).getSiPortein()<(intake.getSiPortein()-proteinRange))
            {
                setMealList.remove(i);
            }
        }
        //通过脂肪需要筛选
        double fatNeed = intake.getSiEnergy()*0.25;
        for(int i =0;i< setMealList.size();i++) {
            if (setMealList.get(i).getSiEnergy() * 0.25 > (fatNeed + fatRange)
                    || setMealList.get(i).getSiEnergy() * 0.25 < (fatNeed - fatRange)) {
                setMealList.remove(i);
            }
        }

        //过滤掉近3天推荐过的套餐
        List<PushInfomation> newestPush = pushInfomationService.selectRecentPush(0);
        for(int i=0;i<setMealList.size();i++)
        {
            for(int j=0;j<newestPush.size();j++)
            {
                if(setMealList.get(i).getSmId()==newestPush.get(j).getSmId())
                    setMealList.remove(i);
            }
        }
        //过滤掉当前用户禁止食用的套餐
        List forbiddenList = getRemoveSetmeal.GetRemoveSetmeal(consumer.getUserId());
        for(int i=0;i<setMealList.size();i++)
        {

            for(int j=0;j<newestPush.size();j++)
            {
                if(setMealList.get(i).getSmId()==forbiddenList.get(i))
                    setMealList.remove(i);
            }
        }
        /*
        * 使用alias算法开始抽奖
        * */
        List<Adward> adwards = new ArrayList<Adward>();
        int totalWeight=0;
        List list=null;
        //设置奖品的名称(套餐id)和权重
        for(int i=0;i<setMealList.size();i++)
        {
            Adward adward = new Adward(setMealList.get(i).getSmId());
            totalWeight+=adward.getWeight();
            adwards.add(adward);
        }
        for(int i =0;i<adwards.size();i++)
        {
            list.add(adwards.get(i).getWeight()/totalWeight);
        }
        AliasUtil method = new AliasUtil(list);
        int index = method.next();
        System.out.println("推荐的套餐id是"+adwards.get(index).getSmId());
        List<SetMeal> setMealContent = setMealService.SelectBySMid(adwards.get(index).getSmId());
        List<Map> mapList = new ArrayList<>();
        for(int i=0;i<setMealContent.size();i++)
        {
            Map map = new HashMap();
            map.put("recipes",setMealContent.get(i));
            map.put("name",recipesService.getName(setMealContent.get(i).getRecipesId()));
            mapList.add(map);
        }
        return mapList;
    }
    /*
    * 描述：测试接口
    * */
    @ResponseBody
    @RequestMapping("/test")
    public List<Map> test()
    {
        /*
         * 使用alias算法开始抽奖
         * */
        List<SetmealInfomation> setMealList = setmealInfomationService.SelectByTime(2);
        List<Adward> adwards = new ArrayList<Adward>();
        int totalWeight=0;
        List list=new ArrayList();
        //设置奖品的名称(套餐id)和权重
        for(int i=0;i<setMealList.size();i++)
        {
            Adward adward = new Adward(setMealList.get(i).getSmId());
            totalWeight+=adward.getWeight();
            adwards.add(adward);
        }
        for(int i =0;i<adwards.size();i++)
        {
            list.add(adwards.get(i).getWeight()/totalWeight);
        }
        AliasUtil method = new AliasUtil(list);
        int index = method.next();
        System.out.println("index="+index);
        System.out.println("smId="+adwards.get(index).getSmId());
        List<SetMeal> setMealContent = setMealService.SelectBySMid(adwards.get(index).getSmId());

        List<Map> mapList = new ArrayList<>();
        for(int i=0;i<setMealContent.size();i++)
        {
            Map map = new HashMap();
            map.put("recipes",setMealContent.get(i));
            map.put("name",recipesService.getName(setMealContent.get(i).getRecipesId()));
            mapList.add(map);
        }
        return mapList;
    }
}
