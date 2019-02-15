package hdu.cn.hziee.dao;

import hdu.cn.hziee.model.Food;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodMapper {
    int deleteByPrimaryKey(Integer foodId);

    int insert(Food record);

    int insertSelective(Food record);

    Food selectByPrimaryKey(Integer foodId);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);
}