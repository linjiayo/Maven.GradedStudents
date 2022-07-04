package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class ClassroomTest {
    Classroom classroom;
    @Before
    public void init() {
        Double[] s1Scores = { 76.0, 90.0};
        Double[] s2Scores = { 99.0, 98.0};


        Student s1 = new Student("Jeff", "One", s1Scores);
        Student s2 = new Student("Peff", "Two", s2Scores);

        Student[] students = { s1, s2};
        classroom = new Classroom(students);
    }

    @Test
    public void testGetStudents() {
        Classroom classroom1 = new Classroom(5);
        Integer expected = 5;

        Integer actual = classroom1.getStudents().length;

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGetAverageExamScore() {
        Double expected = 90.75;

        Double actual = classroom.getAverageExamScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddStudent() {
        Double[] scores = { 20.0, 36.0};
        Student student = new Student("Test", "Three", scores);
        Integer expectedSize = 3;

        classroom.addStudent(student);
        Integer actualSize = classroom.getStudents().length;

        Assert.assertEquals(expectedSize, actualSize);
    }
    @Test
    public void testRemoveStudent() {
        String firstName = "Jeff";
        String lastName = "One";

        classroom.removeStudent(firstName, lastName);

        Assert.assertNull(classroom.getStudents()[1]);
    }

    @Test
    public void testGetStudentsByScoreWithDifferentAverages() {
        Student[] students = classroom.getStudentsByScore();
        String expectedFirst = "Peff";

        String actualFirst = students[0].getFirstName();

        Assert.assertEquals(expectedFirst, actualFirst);
    }

    @Test
    public void testGetStudentsByScoreWithSameAverages() {
        Double[] s1Scores = { 76.0, 90.0};
        Double[] s2Scores = { 76.0, 90.0};
        Student s1 = new Student("Jeff", "One", s1Scores);
        Student s2 = new Student("Abra", "Two", s2Scores);
        Student[] students = { s1, s2 };
        Classroom classroom1 = new Classroom(students);
        String expectedFirst  = "Abra";

        Student[] studentsByAvg = classroom1.getStudentsByScore();
        String actualFirst = studentsByAvg[0].getFirstName();

        Assert.assertEquals(Double.valueOf(studentsByAvg[0].getAverageExamScore()), Double.valueOf(studentsByAvg[1].getAverageExamScore()));
        Assert.assertEquals(expectedFirst, actualFirst);
    }

    @Test
    public void testGetGradeBook() {
        Double[] s3Scores = { 70.0, 50.0 };
        Double[] s4Scores = { 60.0, 50.0};
        Double[] s5Scores = { 20.0 };
        Double[] s6Scores = { 20.0 };
        Student s3 = new Student("Jimbo", "Three", s3Scores);
        Student s4 = new Student("Chris", "Four", s4Scores);
        Student s5 = new Student("Chris", "Five", s5Scores);
        Student s6 = new Student("Chris", "Six", s6Scores);
        classroom.addStudent(s3);
        classroom.addStudent(s4);
        classroom.addStudent(s5);
        classroom.addStudent(s6);

        Map<Student, Character> gradeBook = classroom.getGradeBook();
        Student[] students = classroom.getStudents();

        Assert.assertEquals(Character.valueOf('B'), gradeBook.get(students[0]));
        Assert.assertEquals(Character.valueOf('A'), gradeBook.get(students[1]));
        Assert.assertEquals(Character.valueOf('C'), gradeBook.get(students[2]));
        Assert.assertEquals(Character.valueOf('D'), gradeBook.get(students[3]));
        Assert.assertEquals(Character.valueOf('D'), gradeBook.get(students[4]));
        Assert.assertEquals(Character.valueOf('D'), gradeBook.get(students[5]));
    }
}
