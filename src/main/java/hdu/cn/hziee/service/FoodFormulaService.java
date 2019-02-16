package hdu.cn.hziee.service;

import hdu.cn.hziee.dao.FoodFormulaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodFormulaService {

    @Autowired
    FoodFormulaMapper mapper;

    public List SelectByRecipesId(int recipesId){ return mapper.selectByrecipesId(recipesId); }
}
