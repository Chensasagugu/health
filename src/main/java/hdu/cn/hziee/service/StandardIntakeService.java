package hdu.cn.hziee.service;

import hdu.cn.hziee.dao.StandardIntake_FemaleMapper;
import hdu.cn.hziee.dao.StandardIntake_MaleMapper;
import hdu.cn.hziee.model.StandardIntake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandardIntakeService {
    @Autowired
    StandardIntake_FemaleMapper standardIntake_femaleMapper;
    @Autowired
    StandardIntake_MaleMapper standardIntake_maleMapper;


    /*
    * 输入：consumer类
    * 输出：营养素列表
    * 描述：获得用户在膳食营养素表中需要的每一个营养素含量。
    * */
    public StandardIntake getStandardIntake(Userinfo user) {
        int age = user.getUserAge();
        int pressure = user.getUserWorkpressure();
        if (user.getUserSex().equals("1")) {
            if (age <= 10) {
                StandardIntake intake = new StandardIntake(standardIntake_maleMapper.selectByPrimaryKey(age + 1));
                return intake;
            } else if (age >= 11 && age < 14) {
                StandardIntake intake = new StandardIntake(standardIntake_maleMapper.selectByPrimaryKey(12));
                return intake;
            } else if (age >= 14 && age < 18) {
                StandardIntake intake = new StandardIntake(standardIntake_maleMapper.selectByPrimaryKey(13));
                return intake;
            } else if (age >= 18 && age < 50 && pressure == 1) {
                StandardIntake intake = new StandardIntake(standardIntake_maleMapper.selectByPrimaryKey(14));
                return intake;
            } else if (age >= 18 && age < 50 && pressure == 2) {
                StandardIntake intake = new StandardIntake(standardIntake_maleMapper.selectByPrimaryKey(15));
                return intake;
            } else if (age >= 18 && age < 50 && pressure == 3) {
                StandardIntake intake = new StandardIntake(standardIntake_maleMapper.selectByPrimaryKey(16));
                return intake;
            } else if (age >= 50 && pressure == 1) {
                StandardIntake intake = new StandardIntake(standardIntake_maleMapper.selectByPrimaryKey(17));
                return intake;
            } else if (age >= 50 && pressure == 2) {
                StandardIntake intake = new StandardIntake(standardIntake_maleMapper.selectByPrimaryKey(18));
                return intake;
            } else if (age >= 50 && pressure == 3) {
                StandardIntake intake = new StandardIntake(standardIntake_maleMapper.selectByPrimaryKey(19));
                return intake;
            } else {
                return new StandardIntake();
            }
        } else {
            if (age <= 10) {
                StandardIntake intake = new StandardIntake(standardIntake_femaleMapper.selectByPrimaryKey(age + 1));
                return intake;
            } else if (age >= 11 && age < 14) {
                StandardIntake intake = new StandardIntake(standardIntake_femaleMapper.selectByPrimaryKey(12));
                return intake;
            } else if (age >= 14 && age < 18) {
                StandardIntake intake = new StandardIntake(standardIntake_femaleMapper.selectByPrimaryKey(13));
                return intake;
            } else if (age >= 18 && age < 50 && pressure == 1) {
                StandardIntake intake = new StandardIntake(standardIntake_femaleMapper.selectByPrimaryKey(14));
                return intake;
            } else if (age >= 18 && age < 50 && pressure == 2) {
                StandardIntake intake = new StandardIntake(standardIntake_femaleMapper.selectByPrimaryKey(15));
                return intake;
            } else if (age >= 18 && age < 50 && pressure == 3) {
                StandardIntake intake = new StandardIntake(standardIntake_femaleMapper.selectByPrimaryKey(16));
                return intake;
            } else if (age >= 50 && pressure == 1) {
                StandardIntake intake = new StandardIntake(standardIntake_femaleMapper.selectByPrimaryKey(17));
                return intake;
            } else if (age >= 50 && pressure == 2) {
                StandardIntake intake = new StandardIntake(standardIntake_femaleMapper.selectByPrimaryKey(18));
                return intake;
            } else if (age >= 50 && pressure == 3) {
                StandardIntake intake = new StandardIntake(standardIntake_femaleMapper.selectByPrimaryKey(19));
                return intake;
            } else {
                return new StandardIntake();
            }
        }
    }
}
