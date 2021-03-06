
package com.example.backbank;

import com.example.backbank.services.SheduledServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.nio.charset.StandardCharsets;
@EnableScheduling
@SpringBootApplication
public class BackbankApplication {

    public static void main(String[] args) {
        SheduledServiceImpl sheduledService = new SheduledServiceImpl();
        SpringApplication.run(BackbankApplication.class, args);

    }

}
