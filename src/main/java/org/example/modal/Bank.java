package org.example.modal;

import com.google.gson.Gson;
import org.example.interfaces.DataBank;

import java.util.LinkedList;
import java.util.List;

public class Bank implements DataBank {

    List<Question> questionList;

    public String getQuestions() {
//        try {
        return generateQuestionsJson();
//        } catch (JsonProcessingException j) {
//            return "Some parsing error occurred";
//        } catch (IOException i) {
//            return "some error occurred";
//        }
    }

    private String generateQuestionsJson() {
        questionList = new LinkedList<>();

        questionList.add(Question.builder().questionId("1")
                .question("Which is the tallest mountain on earth")
                .optionA("Mt Everest")
                .optionB("Mt Kilimanjaro")
                .optionC("Mt K2")
                .optionD("Mt Mauna Kea")    //ans
                .build()
        );

        questionList.add(Question.builder().questionId("2")
                .question("Which is the highest mountain on earth")
                .optionA("Mt Everest")      //ans
                .optionB("Mt Kilimanjaro")
                .optionC("Mt K2")
                .optionD("Mt Mauna Kea")
                .build()
        );

        Gson gson = new Gson();
        return gson.toJson(questionList);
    }

}
