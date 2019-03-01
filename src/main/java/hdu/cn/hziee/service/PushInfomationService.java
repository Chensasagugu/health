package hdu.cn.hziee.service;

import hdu.cn.hziee.dao.PushInfomationMapper;
import hdu.cn.hziee.model.PushInfomation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PushInfomationService {
    @Autowired
    PushInfomationMapper mapper;

    public List<PushInfomation> selectRecentPush(int day){return mapper.selectRecentPush(day);}
}
