package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {
    Student student;
    @Before
    public void init() {
        Double[] scores = new Double[] {80.0, 95.5};
        student = new Student("John", "Doe", scores);
    }

    @Test
    public void testGetFirstName() {
        String exp = "John";

        String actual = student.getFirstName();

        Assert.assertEquals(exp, actual);
    }

    @Test
    public void testGetLastName() {
        String exp = "Doe";

        String actual = student.getLastName();

        Assert.assertEquals(exp, actual);
    }

    @Test
    public void testGetExamScores() {
        double expScore1 = 80.0;
        double expScore2 = 95.5;
        String expStr = String.format("Exam Scores:\n\tExam 1 -> %.0f\n\tExam 2 -> %.0f\n",
                expScore1, expScore2);

        String actual = student.getExamScores();

        Assert.assertEquals(expStr, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetExamScoreOutOfRange() {
        student.getExamScore(50);
    }

    @Test
    public void testAddExamScore() {
        Double expScore = 50.0;
        student.setExamScore(2, 50.0);

        Double actual = student.getExamScore(2);

        Assert.assertEquals(expScore, actual);
    }


    @Test
    public void testSetExamScore() {
        Double expScore = 60.0;
        student.setExamScore(3, expScore);

        Double actual = student.getExamScore(3);

        Assert.assertEquals(expScore, actual);
    }

    @Test
    public void testGetAverageExamScore() {
        Double expAvg = 87.75;

        Double actual = student.getAverageExamScore();

        Assert.assertEquals(expAvg, actual);
    }

    @Test
    public void testSetFirstName() {
        String exp = "Jimmy";
        student.setFirstName(exp);

        String actual = student.getFirstName();

        Assert.assertEquals(exp, actual);
    }

    @Test
    public void testSetLastName() {
        String exp = "Smith";
        student.setLastName(exp);

        String actual = student.getLastName();

        Assert.assertEquals(exp, actual);
    }

    @Test
    public void testToString() {
        Double avgScore = student.getAverageExamScore();
        String examScores = student.getExamScores();
        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        String expected = String.format("Student Name: %s %s\n\t Average Score: %.0f\n" +
                "%s", firstName, lastName, avgScore, examScores);

        String actual = student.toString();

        Assert.assertEquals(expected, actual);
    }
}