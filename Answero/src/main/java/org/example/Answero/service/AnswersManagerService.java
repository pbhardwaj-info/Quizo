package org.example.Answero.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Answero.modal.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class AnswersManagerService {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger log = LoggerFactory.getLogger(AnswersManagerService.class);
    private static Map<Integer, Answer> answersMap;

    @PostConstruct
    private void initMap() {
        answersMap = new HashMap<>();
        answersMap.put(1, Answer.builder()//.questionId(1)
                .answer("d").build());
        answersMap.put(2, Answer.builder()//.questionId(2)
                .answer("a").build());
        answersMap.put(3, Answer.builder()//.questionId(3)
                .answer("b").build());
    }

    public String fetchAnswerForId(int questionId) {
        String answer = null;
        if (answersMap != null && answersMap.containsKey(questionId)) {
            answer = answersMap.get(questionId)
                    .getAnswer();// objectMapper.writeValueAsString(answersMap.get(questionId).getAnswer());
            log.info("Answer for question id {} found: {}", questionId, answer);
        } else {
            log.info("Answer for question id {} Not Found!", questionId);
        }
        return answer;
    }
}
