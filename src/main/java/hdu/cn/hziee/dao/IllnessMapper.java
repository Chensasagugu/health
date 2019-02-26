package hdu.cn.hziee.dao;

import hdu.cn.hziee.model.Illness;
import org.springframework.stereotype.Repository;

@Repository
public interface IllnessMapper {
    int deleteByPrimaryKey(Integer illId);

    int insert(Illness record);

    int insertSelective(Illness record);

    Illness selectByPrimaryKey(Integer illId);

    int updateByPrimaryKeySelective(Illness record);

    int updateByPrimaryKey(Illness record);
}