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
        scores.append("Exam Scores:\n");
        for (int i = 0; i < examScores.size(); i++) {
            String str = String.format("\tExam %d -> %.0f\n", i + 1,  examScores.get(i));
            scores.append(str);
        }
        return scores.toString();
    }

    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    public double getExamScore(int examNumber) throws IllegalArgumentException {
        if (examNumber > examScores.size() || examNumber < 1) {
            throw new IllegalArgumentException();
        }
        return examScores.get(examNumber - 1);
    }

    public void setExamScore(int examNumber, double newScore) throws IllegalArgumentException {
        if (examNumber - 1 > examScores.size() || examNumber < 1) {
            throw new IllegalArgumentException();
        }
        if (examNumber - 1 == examScores.size()) {
            addExamScore(newScore);
        } else {
            examScores.set(examNumber - 1, newScore);
        }

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
    @Override
    public String toString() {
        //StringBuilder res = new StringBuilder();
        Double avgScore = getAverageExamScore();
        String examScores = getExamScores();
        String firstName = getFirstName();
        String lastName = getLastName();
        String out = String.format("Student Name: %s %s\n\t Average Score: %.0f\n" +
                "%s", firstName, lastName, avgScore, examScores);

        return out;
    }

}
