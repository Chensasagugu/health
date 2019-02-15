package hdu.cn.hziee.dao;

import hdu.cn.hziee.model.DietRecord_Sub;
import org.springframework.stereotype.Repository;

@Repository
public interface DietRecord_SubMapper {
    int deleteByPrimaryKey(Integer drsId);

    int insert(DietRecord_Sub record);

    int insertSelective(DietRecord_Sub record);

    DietRecord_Sub selectByPrimaryKey(Integer drsId);

    int updateByPrimaryKeySelective(DietRecord_Sub record);

    int updateByPrimaryKey(DietRecord_Sub record);
}