package com.enforceway.application;

import org.h2.tools.Server;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication()
@MapperScan("com.enforceway.application.mappers")
public class ContactsManagerApplication {

    public static void main(String[] args) throws SQLException {
        Server.createTcpServer(args).start();
        SpringApplication.run(ContactsManagerApplication.class, args);
    }

}
