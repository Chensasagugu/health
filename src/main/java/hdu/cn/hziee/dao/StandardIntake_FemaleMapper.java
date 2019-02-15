package hdu.cn.hziee.dao;

import hdu.cn.hziee.model.StandardIntake_Female;

public interface StandardIntake_FemaleMapper {
    int deleteByPrimaryKey(Integer siId);

    int insert(StandardIntake_Female record);

    int insertSelective(StandardIntake_Female record);

    StandardIntake_Female selectByPrimaryKey(Integer siId);

    int updateByPrimaryKeySelective(StandardIntake_Female record);

    int updateByPrimaryKey(StandardIntake_Female record);
}