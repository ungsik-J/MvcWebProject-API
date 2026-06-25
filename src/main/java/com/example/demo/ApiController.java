package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 이 클래스가 REST API를 처리하는 컨트롤러임을 선언
public class ApiController {

    // 1. 단순 텍스트 반환 API (http://localhost:8080/hello)
    @GetMapping("/api")
    public String sayHello() {
        return "Hello, Spring Boot API!";
    }

    // 2. JSON 데이터를 반환하는 API (http://localhost:8080/user?name=홍길동)
    @GetMapping("/user")
    public Map<String, Object> getUser(@RequestParam(defaultValue = "Guest") String name) {
        Map<String, Object> response = new HashMap<>();
        response.put("name", name);
        response.put("age", 25);
        response.put("status", "success");
        
        return response; // 자바의 Map이나 객체를 리턴하면 자동으로 JSON으로 변환됩니다.
    }
}