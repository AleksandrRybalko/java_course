package com.epam.alexander_rybalko.java.lesson1.task2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Acer on 17.02.2018.
 */
public class Task2 {

    String[] args;

    public Task2(String[] args){
        this.args = args;
    }
    public void findMaxAndMinStrings(){
        String maxString = "";
        String minString = "";
        for (String s : args){
            if (s.length() > maxString.length()){
                maxString = s;
            }
            if (Objects.equals(minString, "") || s.length() < minString.length()){
                minString = s;
            }
        }
        System.out.println(minString + " " + minString.length());
        System.out.println(maxString + " " + maxString.length());
    }

    public void findStringWithLengthMoreAverage(){
        double average = 0;
        for (String s : args){
            average+=s.length();
        }
        average /=args.length;
        for (String s : args){
            if (s.length() > average){
                System.out.println(s + " " + s.length());
            }
        }
    }

    public void findStringWithLengthLessAverage(){
        double average = 0;
        for (String s : args){
            average+=s.length();
        }
        average /=args.length;
        for (String s : args){
            if (s.length() < average){
                System.out.println(s + " " + s.length());
            }
        }
    }

    public void findStringWithLessDifferentSymbol(){
        int count = Integer.MAX_VALUE;
        String result = "";
        for (String s : args){
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()){
                set.add(c);
            }
            if (set.size() < count){
                count = set.size();
                result = s;
            }
        }
        System.out.println(result);
    }

    public void findStringWithEqualDifferentSymbol(){
        String result = "";
        for (String s : args){
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()){
                set.add(c);
            }
            if (set.size() == s.length() && result.equals("")){
                result = s;
            }
        }
        System.out.println(result);
    }

    public void findNumber(){
        int count = 0;
        String result = "";
        for (String s : args){
            boolean isNumber = true;
            for (char c : s.toCharArray()){
                if (!Character.isDigit(c)){
                    isNumber = false;
                    break;
                }
            }
            if (isNumber){
                count++;
                if (count <= 2){
                    result = s;
                }
            }
        }
        System.out.println(result);
    }


}
