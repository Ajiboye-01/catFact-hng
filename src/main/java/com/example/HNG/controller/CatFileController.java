package com.example.HNG.controller;

import com.example.HNG.CatFact;
import com.example.HNG.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("")
@CrossOrigin
@RequiredArgsConstructor
public class CatFileController {
    private final RestTemplate restTemplate;

    @GetMapping("/me")
    public Map<String, String> fact(){
        String url = "https://catfact.ninja/#/Facts/getRandomFact";
        CatFact catFact = restTemplate.getForObject(url, CatFact.class);
        User users = new User("aariyo111@gmail.com", "Ajiboye", "java");
        String time = Instant.now().toString();
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("user",users.toString());
        response.put("timestamp", time);
        response.put("fact", catFact.getFact());

        return response;
    }
}
