package hdu.cn.hziee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"hdu.cn.hziee.dao"})
public class HzieeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HzieeApplication.class, args);
    }

}

