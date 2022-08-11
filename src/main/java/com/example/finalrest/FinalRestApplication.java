package com.example.finalrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FinalRestApplication {

    public static void main(String[] args) {

        SpringApplication.run(FinalRestApplication.class, args);

        User userJames = new User(3L,"James","Brown",(byte)29);
        User userThomas = new User(3L,"Thomas","Shelby",(byte)29);
        Connection connection = new Connection(getRestTemplate(), getHttpHeaders());
        connection.listUser();
        connection.addUser(userJames);
        connection.changeUser(userThomas);
        connection.deleteUser(3);
    }

    @Bean
    public static RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public static HttpHeaders getHttpHeaders(){
        return new HttpHeaders();
    }

}
