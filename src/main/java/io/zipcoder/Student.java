package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    String firstName;
    String lastName;
    ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(examScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getExamScores() {
        StringBuilder scores = new StringBuilder();
        scores.append("Exam Scores:%n");
        for (int i = 0; i < examScores.size(); i++) {
            String str = String.format("%tExam %d -> %d%n", i, examScores.get(i) + 1);
            scores.append(str);
        }
        return scores.toString();
    }

    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore) throws IllegalArgumentException {
        if (examNumber > examScores.size() || examNumber < 1) {
            throw new IllegalArgumentException();
        }
        examScores.set(examNumber - 1, newScore);
    }

    public double getAverageExamScore() {
        double sum = 0;
        for (double score : examScores) {
            sum += score;
        }
        return sum / examScores.size();
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
//    @Override
//    public String toString() {
//        StringBuilder res = new StringBuilder();
//        Double avgScore = getAverageExamScore();
//        //String examScores =
//        return;
//    }

}
