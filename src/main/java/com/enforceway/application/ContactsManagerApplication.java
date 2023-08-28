package com.enforceway.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication()
@MapperScan("com.enforceway.application.mappers")
public class ContactsManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactsManagerApplication.class, args);
    }

}
