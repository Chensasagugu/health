package hdu.cn.hziee.service;

import hdu.cn.hziee.dao.SetmealInfomationMapper;
import hdu.cn.hziee.model.SetmealInfomation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetmealInfomationService {

    @Autowired
    SetmealInfomationMapper mapper;

    public int insert(SetmealInfomation SmI){ return mapper.insert(SmI);}

    public SetmealInfomation SelectByPrimaryKey(int SM_id){ return mapper.selectByPrimaryKey(SM_id); }

    public int UpdateByPrimaryKeySelective(SetmealInfomation SmI){ return mapper.updateByPrimaryKeySelective(SmI); }
}
