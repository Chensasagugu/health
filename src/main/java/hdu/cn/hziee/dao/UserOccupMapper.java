package hdu.cn.hziee.dao;

import hdu.cn.hziee.model.UserOccup;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOccupMapper {
    int deleteByPrimaryKey(Integer uoId);

    int insert(UserOccup record);

    int insertSelective(UserOccup record);

    UserOccup selectByPrimaryKey(Integer uoId);

    int updateByPrimaryKeySelective(UserOccup record);

    int updateByPrimaryKey(UserOccup record);
}