package com.k8s.internalapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class InternalAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternalAppApplication.class, args);
    }

}

@RestController
class InternalController {
    @GetMapping("/hello")
    public String hello() {
        return "hello from internal app";
    }
}
