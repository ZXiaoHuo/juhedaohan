package com.zqh.juhedaohan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JuhedaohanApplication {

    public static void main(String[] args) {
        SpringApplication.run(JuhedaohanApplication.class, args);
    }

}
