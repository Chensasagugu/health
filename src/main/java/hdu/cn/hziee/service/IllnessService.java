package hdu.cn.hziee.service;

import hdu.cn.hziee.dao.IllnessMapper;
import hdu.cn.hziee.model.Illness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IllnessService {

    @Autowired
    IllnessMapper mapper;

    public Illness SelectByIllname(String name){ return mapper.selectByIllname(name); }

    public Illness SelectByPrimaryKey(int id){ return mapper.selectByPrimaryKey(id); }

    public List SelectAll(){ return mapper.selectAll(); }
}
