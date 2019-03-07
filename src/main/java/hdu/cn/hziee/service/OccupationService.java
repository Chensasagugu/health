package hdu.cn.hziee.service;

import hdu.cn.hziee.dao.OccupationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OccupationService {
    @Autowired
    OccupationMapper occupationMapper;
    public int getPressure(String occupation){return occupationMapper.getPressure(occupation);}
}
