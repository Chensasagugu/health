package hdu.cn.hziee.service;

import hdu.cn.hziee.dao.SetMealMapper;
import hdu.cn.hziee.model.SetMeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetMealService {

    @Autowired
    SetMealMapper mapper;

    public int Insert(SetMeal SM){ return mapper.insert(SM); }

    public List SelectBySMid(int SM_id){ return mapper.selectBySMid(SM_id); }

    public int DeleteByRecipesId(SetMeal SM){ return mapper.deleteByRecipesId(SM); }
}
