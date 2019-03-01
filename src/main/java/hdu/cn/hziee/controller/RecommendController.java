package hdu.cn.hziee.controller;

import hdu.cn.hziee.model.Consumer;
import hdu.cn.hziee.model.PushInfomation;
import hdu.cn.hziee.model.SetmealInfomation;
import hdu.cn.hziee.model.StandardIntake;
import hdu.cn.hziee.service.PushInfomationService;
import hdu.cn.hziee.service.SetmealInfomationService;
import hdu.cn.hziee.service.StandardIntakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class RecommendController {
    @Autowired
    StandardIntakeService standardIntakeService;
    @Autowired
    SetmealInfomationService setmealInfomationService;
    @Autowired
    PushInfomationService pushInfomationService;
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
    public List recommend(@RequestBody Consumer consumer)
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
                {
                    setMealList.remove(i);
                }
            }
        }
        return setMealList;
    }
    /*
    * 描述：测试接口
    * */
    @ResponseBody
    @RequestMapping("/test")
    public List test()
    {
        return pushInfomationService.selectRecentPush(0);
    }
}
