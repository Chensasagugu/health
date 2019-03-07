package hdu.cn.hziee.service;

import hdu.cn.hziee.dao.UserOccupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseroccupService {

    @Autowired
    UserOccupMapper mapper;
}
