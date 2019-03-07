package hdu.cn.hziee.dao;

import hdu.cn.hziee.model.Occupation;
import org.springframework.stereotype.Repository;

@Repository
public interface OccupationMapper {
    int deleteByPrimaryKey(Integer occupationId);

    int insert(Occupation record);

    int insertSelective(Occupation record);

    Occupation selectByPrimaryKey(Integer occupationId);

    int updateByPrimaryKeySelective(Occupation record);

    int updateByPrimaryKey(Occupation record);
}