package hdu.cn.hziee.dao;

import hdu.cn.hziee.model.FoodIllness;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodIllnessMapper {
    int deleteByPrimaryKey(Integer fiId);

    int insert(FoodIllness record);

    int insertSelective(FoodIllness record);

    FoodIllness selectByPrimaryKey(Integer fiId);

    int updateByPrimaryKeySelective(FoodIllness record);

    int updateByPrimaryKey(FoodIllness record);

    List selectByillId(int illId);
}