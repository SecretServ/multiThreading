package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Student extends UniversityPerson {
    //private List<Human> children = new ArrayList<>();
    private double averageGrade;
    //private String university;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;
    public String name;
    public int age;



    public Student(String name, int age, double averageGrade) {
        super(name, age);
        //super();
        //super.name = name;
        //super.age = age;
        this.averageGrade = averageGrade;
    }

    /*public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }*/

    public void live() {
        learn();
    }

    public void learn() {
    }


    /**********************************************************/
    /*public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }*/
    /*public void printData() {
        System.out.println(getPosition() + ": " + name);
    }*/

    /*public void incAverageGradeBy01() {
        averageGrade += 0.1;
    }

    public void incAverageGradeBy02() {
        averageGrade += 0.2;
    }*/
    /***********************************************************/
    public void incAverageGrade(double delta) {
        averageGrade += delta;
    }



    public int getCourse() {
        return course;
    }
    public void setCourse(int course) {
        this.course = course;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
    public double getAverageGrade() {
        return averageGrade;
    }

    /***********************************************/
    /*
    public void setValue(String name, double value) {
        if (name.equals("averageGrade")) {
            averageGrade = value;
            return;
        }
        if (name.equals("course")) {
            setCourse ((int) value);
            return;
        }
    }
    */
    /**************************************************/



    public void setBeginningOfSession(Date beginningOfSession) {
        this.beginningOfSession = beginningOfSession;
    }

    public void setEndOfSession(Date endOfSession) {
        this.endOfSession = endOfSession;
    }


    @Override
    public String getPosition() {
        return "Студент";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.getAverageGrade(), getAverageGrade()) == 0 &&
                getCourse() == student.getCourse() &&
                getAge() == student.getAge() &&
                Objects.equals(beginningOfSession, student.beginningOfSession) &&
                Objects.equals(endOfSession, student.endOfSession) &&
                Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAverageGrade(), beginningOfSession, endOfSession, getCourse(), getName(), getAge());
    }
}