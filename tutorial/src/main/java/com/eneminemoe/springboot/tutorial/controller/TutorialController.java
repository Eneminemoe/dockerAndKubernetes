package com.eneminemoe.springboot.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@RestController
public class TutorialController {

    private static final Logger logger = Logger.getLogger(TutorialController.class.getName());
    private static final String templateV1 = "Wow, herzlich wilkommen %s!";
    private static final String templateV2 = "Wow, herzlich wilkommen %s! Deine Glückszahl ist heute: %s";
    private static final String uri = "http://calcservice:8080/random";

    private String requestedNumber="0";

    @GetMapping("/v1/welcome")
    public String welcome(@RequestParam(value = "name", defaultValue = "unbekannter Nutzer1") String name) {
        /*
        logger.setLevel(Level.ALL);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);
*/
            logger.log(Level.INFO, "I am welcome V1!");
            return String.format(templateV1, name);
    }

    @GetMapping("/v2/welcome")
    public String welcomeV2(@RequestParam(value = "name", defaultValue = "unbekannter Nutzer2") String name) {
 /*       logger.setLevel(Level.ALL);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);
*/
        logger.log(Level.INFO,"V2 waiting for response of random lucky number...");

            RestTemplate restTemplate = new RestTemplate();
            try {
                requestedNumber = restTemplate.getForObject(uri, String.class);
            } catch (Exception e) {
                requestedNumber= "Error getting the luckynumber: " +e;
            }
            return String.format(templateV2, name, requestedNumber);

    }
}
