package org.example.Answero.controller;

import org.example.Answero.service.AnswersManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
public class AnsweroController {
    private static final Logger log = LoggerFactory.getLogger(AnsweroController.class);
    private static final AnswersManagerService answerManagerService = new AnswersManagerService();

    @GetMapping("/")
    public String getDetails() {
        return "Answer service is up";
    }

    @GetMapping("/{questionId}/{option}")
    public ResponseEntity getAnswerForId(@PathVariable(name ="questionId") Integer questionId,
                                         @PathVariable(name = "option") String option) {
        String answerForId = answerManagerService.fetchAnswerForId(questionId);
        log.info("Option: {}",option);
        log.info("Answer for selected questionId {} is {}", questionId, answerForId);
        return answerForId != null && answerForId.equalsIgnoreCase(option) ? ResponseEntity.status(200).body(answerForId) : ResponseEntity.status(400).body("Incorrect Answer");
    }

}
