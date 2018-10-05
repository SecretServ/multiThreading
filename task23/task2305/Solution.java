package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution[] massive = new Solution[2];

        Solution solOne = new Solution();
        Solution solTwo = new Solution();

        Solution.InnerClass solInOneOne = solOne.new InnerClass();
        Solution.InnerClass solInOneTwo = solOne.new InnerClass();

        Solution.InnerClass solInTwoOne = solOne.new InnerClass();
        Solution.InnerClass solInTwoTwo = solOne.new InnerClass();


        solOne.innerClasses[0] = solInOneOne;
        solOne.innerClasses[1] = solInOneTwo;

        solTwo.innerClasses[0] = solInTwoOne;
        solTwo.innerClasses[1] = solInTwoTwo;

        massive[0] = solOne;
        massive[1] = solTwo;

        return massive;
    }

    public static void main(String[] args) {

    }
}
