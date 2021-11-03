package com.midterm.hblx.Model;

import java.util.ArrayList;

public class Question {
    private String id;
    private ArrayList<String> answer;
    private ArrayList<String> result;
    private String pathImage;
    private ArrayList<String> userResult;

    public Question() {
    }

    public Question(ArrayList<String> answer, ArrayList<String> result, String pathImage, ArrayList<String> userResult) {
        this.answer = answer;
        this.result = result;
        this.pathImage = pathImage;
        this.userResult = userResult;
    }

    public ArrayList<String> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<String> answer) {
        this.answer = answer;
    }

    public ArrayList<String> getResult() {
        return result;
    }

    public void setResult(ArrayList<String> result) {
        this.result = result;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public ArrayList<String> getUserResult() {
        return userResult;
    }

    public void setUserResult(ArrayList<String> userResult) {
        this.userResult = userResult;
    }
}
