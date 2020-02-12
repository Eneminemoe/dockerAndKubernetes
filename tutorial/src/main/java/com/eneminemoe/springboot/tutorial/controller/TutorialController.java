package com.eneminemoe.springboot.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TutorialController {

    private static final String template = "Wow, herzlich wilkommen %s! Deine Glückszahl ist heute: %s";
    private final String uri = "http://calculator:8080/random";

    @GetMapping("/welcome")
    public String welcome(@RequestParam(value = "name", defaultValue = "unbekannter Nutzer") String name) {
        String tmpNumber = "0";

        RestTemplate restTemplate = new RestTemplate();
        try {
            tmpNumber = restTemplate.getForObject(uri, String.class);
        } catch (Exception e) {
            return "This seems to be step one, if not check the error: " + String.format(template, name, tmpNumber);
        }
        return String.format(template, name, tmpNumber);
    }


}
