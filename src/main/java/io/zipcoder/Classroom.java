package io.zipcoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Classroom {
    Student[] students;

    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }
    public Classroom() {
        students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }

    public double getAverageExamScore() {
        double sum = 0;
        for (Student s : students) {
            sum += s.getAverageExamScore();
        }
        return sum / students.length;
    }

    public void addStudent(Student student) {
        // only add to first null value of students array
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
        // If no space for student, create new array
        Student[] newArr = Arrays.copyOf(students, students.length + 1);
        newArr[newArr.length - 1] = student;
        students = newArr;
    }

    public void removeStudent(String firstName, String lastName) {
        int idx = 0;
        while (students[idx] != null) {
            if (students[idx].getFirstName().equals(firstName) && students[idx].getLastName().equals(lastName)) {
                // shift array elements to the left
                for (int i = idx; i < students.length - 1; i++) {
                    students[i] = students[i + 1];
                }
                students[students.length - 1] = null;
                break;
            }
            idx++;
        }
    }

    public Student[] getStudentsByScore() {
       Student[] sorted = Arrays.copyOf(students, students.length);
       Arrays.sort(sorted);

       //reverse for descending order
        int filled = 0;
        for (Student s: students) {
            if (s != null) {
                filled++;
            }
        }
        int upperBound = filled / 2;
        for (int i = 0; i < upperBound; i++) {
            Student tmp = sorted[i];
            sorted[i] = sorted[upperBound - i];
            sorted[upperBound - i] = tmp;
        }
        return sorted;
    }

    public Map<Student, Character> getGradeBook() {
        Map<Student, Character> gradeBook = new HashMap<>();
        Double[] pArr = getPercentileArray();

        for (Student s : students) {
            Double avgScore = s.getAverageExamScore();
            char grade = (avgScore > pArr[0])
                    ? 'A'
                    : (avgScore > pArr[1])
                    ? 'B'
                    : (avgScore > pArr[2])
                    ? 'C'
                    : (avgScore > pArr[3])
                    ? 'D'
                    : 'F';
            gradeBook.put(s, grade);
        }
        return gradeBook;
    }

    // Index 0 -> 89th percentile grade, 1 -> 70th percentile grade, 2 -> 49th, 3 -> 11th
    private Double[] getPercentileArray() {
        Double avgScore = getAverageExamScore();
        double standardSum = 0;
        Double standardDev = 0.0;
        for (Student s : students) {
            standardSum += Math.pow((s.getAverageExamScore() - avgScore), 2);
        }
        standardDev = Math.sqrt(standardSum / students.length);

        Double[] percentileArray = new Double[4];
        percentileArray[0] = (avgScore + (1.227 * standardDev)); // 89th
        percentileArray[1] = (avgScore + (0.524 * standardDev)); // 70th
        percentileArray[2] = (avgScore + (-0.025 * standardDev)); // 49th
        percentileArray[3] = (avgScore + (-1.277 * standardDev)); // 11th

        return percentileArray;
    }

}
