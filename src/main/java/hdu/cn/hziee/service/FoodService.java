package hdu.cn.hziee.service;

import hdu.cn.hziee.dao.FoodMapper;
import hdu.cn.hziee.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    FoodMapper mapper;

    public Food selectByPrimaryKey(int Food_id){ return mapper.selectByPrimaryKey(Food_id); }
}
