package com.fiap.mecatronica.api_java_to_flutter.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/hello")
@CrossOrigin(origins = "*")
public class HelloController {
    @GetMapping
    public String sayHello() {
        return "Olá, Spring Boot! API pronta para o Flutter.";
    }
}