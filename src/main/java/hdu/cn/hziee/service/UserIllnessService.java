package hdu.cn.hziee.service;

import hdu.cn.hziee.dao.UserIllnessMapper;
import hdu.cn.hziee.model.UserIllness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserIllnessService {

    @Autowired
    UserIllnessMapper mapper;

    public List SelectByUserid(int userId){ return mapper.selectByUserid(userId); }

    public int insert(UserIllness UI){ return mapper.insert(UI); }

    public int DeleteByUserid(int userId){ return mapper.deleteByUserid(userId); }

    public int DeleteByUserIll(UserIllness UI){ return mapper.deleteByUserIll(UI); }
}
