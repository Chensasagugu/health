package hdu.cn.hziee.dao;

import hdu.cn.hziee.model.RecipesIllness;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipesIllnessMapper {
    int deleteByPrimaryKey(Integer riId);

    int insert(RecipesIllness record);

    int insertSelective(RecipesIllness record);

    RecipesIllness selectByPrimaryKey(Integer riId);

    int updateByPrimaryKeySelective(RecipesIllness record);

    int updateByPrimaryKey(RecipesIllness record);

    List selectByillId(int illId);
}