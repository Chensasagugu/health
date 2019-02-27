package hdu.cn.hziee.service;

import hdu.cn.hziee.dao.ConsumerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    ConsumerMapper mapper;

}
