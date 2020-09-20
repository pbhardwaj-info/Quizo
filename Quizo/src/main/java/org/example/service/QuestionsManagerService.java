package org.example.service;

import com.google.gson.Gson;
import org.example.modal.Question;

import java.util.LinkedList;
import java.util.List;

public class QuestionsManagerService {
    public String generateQuestions() {
        return generateQuestionsJson();
    }

    private String generateQuestionsJson() {
        List<Question> questionList = new LinkedList<>();

        questionList.add(Question.builder().questionId("1")
                .question("Which is the tallest mountain on earth?")
                .optionA("Mt Everest")
                .optionB("Mt Kilimanjaro")
                .optionC("Mt K2")
                .optionD("Mt Mauna Kea")    //ans
                .build()
        );

        questionList.add(Question.builder().questionId("2")
                .question("The Tapti River is flowing from which of the following region?")
                .optionA("Satpura range")      //ans
                .optionB("Vindhyachal range")
                .optionC("Western Ghats")
                .optionD("Eastern Ghats")
                .build()
        );

        questionList.add(Question.builder().questionId("3")
                .question("Which of the following river system created  the Jog waterfalls?")
                .optionA("Tunga bhadra")
                .optionB("Sharavathi") // ans
                .optionC("Koyna")
                .optionD("None of the above")
                .build());

        Gson gson = new Gson();
        return gson.toJson(questionList);
    }

}
