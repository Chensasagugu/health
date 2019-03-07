package hdu.cn.hziee.service;

import hdu.cn.hziee.dao.UserIllnessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserIllnessService {

    @Autowired
    UserIllnessMapper mapper;

    public List SelectByUserid(int userId){ return mapper.selectByUserid(userId); }
}
