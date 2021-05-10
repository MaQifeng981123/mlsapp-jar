package com.rt.generalframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class MlsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MlsApplication.class, args);
    }

}
