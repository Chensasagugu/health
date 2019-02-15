package hdu.cn.hziee.dao;

import hdu.cn.hziee.model.Consumer;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Consumer record);

    int insertSelective(Consumer record);

    Consumer selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Consumer record);

    int updateByPrimaryKey(Consumer record);
}