package cxt.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cxt.cn.dao")
public class JhcApplication {

    public static void main(String[] args) {
        SpringApplication.run(JhcApplication.class, args);
    }

}
