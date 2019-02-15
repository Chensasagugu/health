package hdu.cn.hziee.dao;

import hdu.cn.hziee.model.SetMealInfomation;
import org.springframework.stereotype.Repository;

@Repository
public interface SetMealInfomationMapper {
    int deleteByPrimaryKey(Integer smId);

    int insert(SetMealInfomation record);

    int insertSelective(SetMealInfomation record);

    SetMealInfomation selectByPrimaryKey(Integer smId);

    int updateByPrimaryKeySelective(SetMealInfomation record);

    int updateByPrimaryKey(SetMealInfomation record);
}