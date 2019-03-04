package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University /*extends Student*/ {

    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    private int age;
    public void setAge(int age) {this.age = age;}
    public int getAge() {return age;}

    private List<Student> students = new ArrayList<Student>();
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        /*super(name, age, 0);*/
    }

    //public Student value = null;

    public Student getStudentWithAverageGrade(double averageGrade) {

        Student value = null;

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getAverageGrade() == averageGrade) {
                value = students.get(i);
                return value;
            } else {
                value = null;
            }
        }
        return value;
    }

    public Student getStudentWithMaxAverageGrade() {

        double max = students.get(0).getAverageGrade();
        int index = 0;

        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() > max) {
                max  = students.get(i).getAverageGrade();
                index = i;
            }
        }
        return students.get(index);
    }

    /*public void getStudentWithMinAverageGradeAndExpel() {
        //TODO:
    }*/

    public Student getStudentWithMinAverageGrade() {

        double min = students.get(0).getAverageGrade();
        int index = 0;

        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() < min) {
                min  = students.get(i).getAverageGrade();
                index = i;
            }
        }
        return students.get(index);
    }

    public void expel(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).equals(student)) {
                students.remove(i);
            }
        }
    }

}