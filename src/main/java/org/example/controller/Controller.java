package org.example.controller;

import org.example.service.QuestionsManagerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final QuestionsManagerService questionsManagerService = new QuestionsManagerService();

    @GetMapping("/details")
    public String getDetails() {
        return "This is a quizzer app \n GET Req on /questions will give you 5 questions \n" +
                "POST on /answers will take your answers and return results";
    }

    @GetMapping("/questions")
    public String getQuestions() {
        return questionsManagerService.generateQuestions();
    }


//    public static void main(String[] args) {
//        System.out.println(questionsManagerService.generateQuestions());
//    }

//    @PostMapping("/answers")
//    public String checkAnswers() {
//        return questionsManagerService.evaluateQuestions();
//    }

}
