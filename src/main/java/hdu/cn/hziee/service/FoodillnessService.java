package hdu.cn.hziee.service;

import hdu.cn.hziee.dao.FoodIllnessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodillnessService {

    @Autowired
    FoodIllnessMapper mapper;

    public List SelectByillId(int ill_id){ return mapper.selectByillId(ill_id); }
}
