package cn.yuyangyang.weixin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.yuyangyang.weixin.dao")
public class WeixinCqmygApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeixinCqmygApplication.class, args);
    }

}
