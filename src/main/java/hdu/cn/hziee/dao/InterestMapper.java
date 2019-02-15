package hdu.cn.hziee.dao;

import hdu.cn.hziee.model.Interest;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestMapper {
    int deleteByPrimaryKey(Integer interestId);

    int insert(Interest record);

    int insertSelective(Interest record);

    Interest selectByPrimaryKey(Integer interestId);

    int updateByPrimaryKeySelective(Interest record);

    int updateByPrimaryKey(Interest record);
}