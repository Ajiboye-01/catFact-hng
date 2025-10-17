package com.example.HNG.controller;

import com.example.HNG.CatFact;
import com.example.HNG.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
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
    private static final Logger log = LoggerFactory.getLogger(CatFileController.class);
    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> fact(){
        String url = "https://catfact.ninja/fact";
        String time = Instant.now().toString();
        Map<String, Object> response = new HashMap<>();
        try {
            CatFact catFact = restTemplate.getForObject(url, CatFact.class);
            if (catFact == null || catFact.getFact() == null) {
                throw new RestClientException("Empty response from Cat Facts API");
            }
            User users = new User("aariyo111@gmail.com", "Ajiboye", "java");

            response.put("status", "success");
            response.put("user",users);
            response.put("timestamp", time);
            response.put("fact", catFact.getFact());

            return ResponseEntity.ok(response);
        } catch (RestClientException e) {
            log.error("Unexpected error calling Cat Facts API: {}", e.getMessage());
            response.put("status", "error");
            response.put("message", "Failed to fetch cat fact. Please try again later.");
            response.put("timestamp", time);
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
        }
    }
}
