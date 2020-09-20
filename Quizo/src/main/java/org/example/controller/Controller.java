package org.example.controller;

import org.example.service.QuestionsManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@RestController
public class Controller {

    private static final Logger log = LoggerFactory.getLogger(Controller.class);
    private static final QuestionsManagerService questionsManagerService = new QuestionsManagerService();

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String getDetails() {
        return "/questions: Provides Questions\n" +
                "/answer/{questionId}/{option}: Evaluate if option for the questionId is correct option";
    }

    @GetMapping("/questions")
    public String getQuestions() {
        return questionsManagerService.generateQuestions();
    }

    // get option from answero api and match here, if it is correct the return success else false
    @GetMapping(value = "/answer/{questionId}/{option}")
    public String checkAnswerForQuestionId(@PathVariable("questionId") Integer questionId, @PathVariable("option") String option) {
        String url = String.format("http://localhost:9090/%s/%s", questionId, option);
        log.info("Answero API url called: {}", url);
        ResponseEntity<String> exchange = ResponseEntity.ok("I am null");
        try {
            exchange = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        } catch (HttpClientErrorException e) {
            log.info("Received following response from Answero API: {} {}", e.getStatusCode(), e.getResponseBodyAsString());
            return "Incorrect Answer";
        } catch (Exception e) {
            log.error("Error in calling Answero API: {}", e.getCause());
            return "Incorrect Answer in API";
        }
        log.info("Received following response from Answero API: {} {}", exchange.getStatusCode(), exchange.getBody());
        return "Correct Answer";
    }


}
