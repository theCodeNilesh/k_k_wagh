package com.kkwagh.kkw_poly;

public class QuizLibrary {
    private String mQuestions[] = {
            "She/He wants to become ----- engineer",
            "Natasha is afraid_____ spiders.",
            "----- Oranges are grown in Nagpur",
            "What are doing ____ coming Sunday ?",
            "This is __________ best Mexican restaurant in the country."
    };

    private String mChoices[][] = {
            {"a", "an", "the", "no article"},
            {"from", "in", "about", "of"},
            {"a", "an", "the", "no article"},
            {"from", "to", "on", "in"},
            {"a", "an", "the", "no article"}
    };


    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;
    }
}
