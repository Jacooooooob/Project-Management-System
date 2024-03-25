package com.tg;

import com.tg.config.WebMvcConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Slf4j
@MapperScan("com.tg.mapper")
@ComponentScan(basePackages = {"com.tg"})
@Import({WebMvcConfiguration.class})
@SpringBootApplication
public class InitiateProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(InitiateProjectApplication.class, args);
        log.info("项目启动成功...");
    }

}
