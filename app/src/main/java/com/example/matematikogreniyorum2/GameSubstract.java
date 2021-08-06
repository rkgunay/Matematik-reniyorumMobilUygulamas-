package com.example.matematikogreniyorum2;


import java.util.ArrayList;
import java.util.List;

public class GameSubstract {
    private static List<QuestionSubstract> questions;
    private int numberCorrect;
    private int numberIncorrect;
    private static int totalQuestion;
    private int score;
    private static QuestionSubstract currentQuestion;

    public GameSubstract() {
        numberCorrect = 0;
        numberIncorrect = 0;
        totalQuestion = 0;
        score = 0;
        currentQuestion = new QuestionSubstract(10);
        questions = new ArrayList<QuestionSubstract>();
    }

    public static void makeNewQuestion() {
        currentQuestion = new QuestionSubstract(totalQuestion * 2 + 5);
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


    public List<QuestionSubstract> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionSubstract> questions) {
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

    public static QuestionSubstract getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(QuestionSubstract currentQuestion) {
        this.currentQuestion = currentQuestion;
    }



}





