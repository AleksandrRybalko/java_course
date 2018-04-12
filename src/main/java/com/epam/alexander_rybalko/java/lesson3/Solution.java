package com.epam.alexander_rybalko.java.lesson3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        new Solution().run(args);
    }

    public void run(String[] args) {
        int param = 0;
        if (args.length > 0 && !args[0].equals("0")) {
            param = 1;
        }
        List<Student> students = generateInformationAboutStudents();
        for (Student student : students) {
            if (param == 0) {
                System.out.println(student.getNotFullReport(new Date()));
            } else {
                System.out.println(student.getFullReport(new Date()));
            }
            System.out.println("___________________________________");
        }
    }

    private List<Student> generateInformationAboutStudents() {
        List<Student> students = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {

            Student student = new Student("Ivanov Ivan", "J2EE Developer", simpleDateFormat.parse("2018-03-30 19:00"));
            student.addCourse(new Course("Technology of Java Servlets", 16));
            student.addCourse(new Course("Struts Framework", 24));
            students.add(student);

            student = new Student("Petrov Petr", "Java Developer", simpleDateFormat.parse("2018-02-27 11:30"));
            student.addCourse(new Course("java technology overview", 8));
            student.addCourse(new Course("Library JFC/Swing", 16));
            student.addCourse(new Course("Technology of JDBC", 16));
            students.add(student);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return students;
    }
}
