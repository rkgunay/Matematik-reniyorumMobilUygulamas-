package com.example.matematikogreniyorum2;


import java.util.ArrayList;
import java.util.List;

public class GameDivide {
    private static List<QuestionDivide> questions;
    private int numberCorrect;
    private int numberIncorrect;
    private static int totalQuestion;
    private int score;
    private static QuestionDivide currentQuestion;

    public GameDivide() {
        numberCorrect = 0;
        numberIncorrect = 0;
        totalQuestion = 0;
        score = 0;
        currentQuestion = new QuestionDivide(20);
        questions = new ArrayList<QuestionDivide>();
    }

    public static void makeNewQuestion() {
        currentQuestion = new QuestionDivide(totalQuestion +2);
        totalQuestion++;
        questions.add(currentQuestion);
    }

    public  boolean checkAnswer(int submittedAnswer) {
        boolean isCorrect;
        if (currentQuestion.getAnswer() == submittedAnswer) {
            numberCorrect++;
            isCorrect = true;
        } else {
            numberIncorrect++;
            isCorrect = false;
        }
        score = numberCorrect * 10 - numberIncorrect * 20;
        return isCorrect;
    }


    public List<QuestionDivide> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDivide> questions) {
        this.questions = questions;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public int getNumberIncorrect() {
        return numberIncorrect;
    }

    public void setNumberIncorrect(int numberIncorrect) {
        this.numberIncorrect = numberIncorrect;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static QuestionDivide getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(QuestionDivide currentQuestion) {
        this.currentQuestion = currentQuestion;
    }



}





