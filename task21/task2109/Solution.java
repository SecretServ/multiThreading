package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public A clone() throws CloneNotSupportedException {

            return (A) super.clone();
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            A a = (A) o;

            if (i != a.i) return false;
            return j == a.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;

            B b = (B) o;

            return name != null ? name.equals(b.name) : b.name == null;

        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public B clone() throws CloneNotSupportedException  {

            if(this.getClass().getSimpleName().equals("B")) {
                throw new CloneNotSupportedException();
            } else {
                //System.out.println(this.getClass().getSimpleName());
                return (B) super.clone();
            }

        }

    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }


        public  C clone() throws CloneNotSupportedException {
            return (C) super.clone();
        }


    }

    public static void main(String[] args) {

        A a = new A(11, 12);
        B b = new B(21, 22, "bbb");
        C c = new C(31, 32, "ccc");
        A aClone = null;
        B bClone = null;
        C cClone = null;
        try {
            aClone = a.clone();
            cClone = c.clone();
            bClone = b.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(aClone);
        System.out.println(bClone);
        System.out.println(cClone);

    }
}
