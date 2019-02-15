package hdu.cn.hziee.dao;

import hdu.cn.hziee.model.PushInfomation_Sub;
import org.springframework.stereotype.Repository;

@Repository
public interface PushInfomation_SubMapper {
    int deleteByPrimaryKey(Integer pisId);

    int insert(PushInfomation_Sub record);

    int insertSelective(PushInfomation_Sub record);

    PushInfomation_Sub selectByPrimaryKey(Integer pisId);

    int updateByPrimaryKeySelective(PushInfomation_Sub record);

    int updateByPrimaryKey(PushInfomation_Sub record);
}