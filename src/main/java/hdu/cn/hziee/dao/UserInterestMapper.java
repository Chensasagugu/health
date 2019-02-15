package hdu.cn.hziee.dao;

import hdu.cn.hziee.model.UserInterest;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInterestMapper {
    int deleteByPrimaryKey(Integer uiId);

    int insert(UserInterest record);

    int insertSelective(UserInterest record);

    UserInterest selectByPrimaryKey(Integer uiId);

    int updateByPrimaryKeySelective(UserInterest record);

    int updateByPrimaryKey(UserInterest record);
}