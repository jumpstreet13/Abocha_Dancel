package com.abocha.quizapplication;

import java.util.List;

class QuestionsModelJava {

    private String question;
    private List<String> answers;
    private int answer;

    QuestionsModelJava(String question, List<String> answers, int answer) {
        this.question = question;
        this.answers = answers;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
