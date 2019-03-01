package hdu.cn.hziee.dao;

import hdu.cn.hziee.model.PushInfomation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PushInfomationMapper {
    int deleteByPrimaryKey(Integer piId);

    int insert(PushInfomation record);

    int insertSelective(PushInfomation record);

    PushInfomation selectByPrimaryKey(Integer piId);

    List<PushInfomation> selectRecentPush(int day);

    int updateByPrimaryKeySelective(PushInfomation record);

    int updateByPrimaryKey(PushInfomation record);
}