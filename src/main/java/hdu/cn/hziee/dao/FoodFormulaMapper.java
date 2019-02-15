package hdu.cn.hziee.dao;

import hdu.cn.hziee.model.FoodFormula;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodFormulaMapper {
    int deleteByPrimaryKey(Integer ffId);

    int insert(FoodFormula record);

    int insertSelective(FoodFormula record);

    FoodFormula selectByPrimaryKey(Integer ffId);

    int updateByPrimaryKeySelective(FoodFormula record);

    int updateByPrimaryKey(FoodFormula record);
}