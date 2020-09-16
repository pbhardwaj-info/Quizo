package org.example.service;

import org.example.modal.Bank;

public final class QuestionsManagerService {

    private final Bank bank = new Bank();

    public String generateQuestions() {
        return bank.getQuestions();
    }

    public String evaluateQuestions() {
        return ";";
    }

}
