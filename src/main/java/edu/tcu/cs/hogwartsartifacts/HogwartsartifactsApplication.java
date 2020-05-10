package edu.tcu.cs.hogwartsartifacts;

import edu.tcu.cs.hogwartsartifacts.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HogwartsartifactsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HogwartsartifactsApplication.class, args);
    }
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }
}
