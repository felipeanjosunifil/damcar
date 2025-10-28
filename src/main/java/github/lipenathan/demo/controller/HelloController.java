package github.lipenathan.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "<h1>Minha primeira aplicação Spring Boot</h1><p>Hello World</p>";
    }
}
