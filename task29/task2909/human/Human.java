package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private static int nextId = 0;
    private int id;
    protected int age;
    public String name;
    //private int course;

    //protected int[] size;
    protected Size size;

    //protected boolean isSoldier;

    /*public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;*/
    private BloodGroup bloodGroup;

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    /*public void setBloodGroup(int code) {
        switch (code) {
            case 1 : bloodGroup.first();
            break;
            case 2 : bloodGroup.second();
            break;
            case 3 : bloodGroup.third();
            break;
            case 4 : bloodGroup.fourth();
            break;
            default : break;
        }
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }*/

    /*********************************************************************************/
    private List<Human> children = new ArrayList<>();
    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }
    /*public void setChildren(List<Human> children) {
        this.children = children;
    }*/
    public void addChild(Human human) {
        children.add(human);
    }

    public void removeChild(Human human) {
        children.remove(human);
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        //this.id = id;
    }

    public Human() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public int getCourse() {
        return course;
    }*/

/*
    public void setCourse(int course) {
        this.course = course;
    }
*/

    /*public void live() {
        if (isSoldier)
            fight();
    }*/

    /*public void fight() {
    }*/

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    @Override
    public void live() {

    }

    public String getPosition() {
        return "Человек";
    }

    public void printData() {
        System.out.println(this.getPosition() + ": " + name);
    }

    public class Size {
        public int height;
        public int weight;

        public Size(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }
}