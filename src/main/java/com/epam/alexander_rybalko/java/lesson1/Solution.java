package com.epam.alexander_rybalko.java.lesson1;

import com.epam.alexander_rybalko.java.lesson1.task1.Task1;
import com.epam.alexander_rybalko.java.lesson1.task2.Task2;
import com.epam.alexander_rybalko.java.lesson1.task3.Task3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Acer on 17.02.2018.
 */
public class Solution {
    private static StringTokenizer st;
    private static BufferedReader in;

    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        new Solution().run();
        in.close();
    }

    private void run() throws IOException {

        System.out.println("Enter the operation:\n1 - Task1\n2 - Task2\n3 - Task3");
        String op = in.readLine();
        switch (op) {
            case "1": {
                Task1 task1 = new Task1();
                System.out.println("Massive is generated:");
                task1.generateMassive();
                task1.writeMassive(task1.massive);

                System.out.println("Replace maxMin and minMax");
                task1.replaceMaxMinAndMinMax();

                System.out.println("Calculate sum of even index elements");
                task1.sumEvenElements();

                System.out.println("Replace negative elements by zero");
                task1.replaceNegativeByZero();

                System.out.println("Multiply positive elements before negative");
                task1.multPositiveElements();

                System.out.println("Find subtract between average sum and min element");
                task1.findSubtract();

                System.out.println("Find elements which count more than one and indexes are negative");
                task1.findElementMoreThanOne();
                break;
            }
            case "2": {
                System.out.println("Enter the number of strings");
                int n = nextInt();
                System.out.println("Enter n strings");
                String[] args = new String[n];
                for (int i = 0; i < n; i++){
                    args[i] = in.readLine();
                }
                Task2 task2 = new Task2(args);
                System.out.println("Min and Max string");
                task2.findMaxAndMinStrings();

                System.out.println("String with length more than average");
                task2.findStringWithLengthMoreAverage();

                System.out.println("String with length less than average");
                task2.findStringWithLengthLessAverage();

                System.out.println("String this less different symbol");
                task2.findStringWithLessDifferentSymbol();

                System.out.println("String this all different symbol");
                task2.findStringWithEqualDifferentSymbol();

                System.out.println("Second string which contains only digits");
                task2.findNumber();
                break;
            }

            case "3": {
                System.out.println("Enter first element, second element");
                int a = nextInt();
                int b = nextInt();
                System.out.println("Enter the operation (+, -, *, /)");
                String operToCalculate = in.readLine();

                Task3 task3 = new Task3();
                try {
                    double result = task3.calculate(a, b, operToCalculate);
                    System.out.println(result);
                } catch (ArithmeticException e){
                    System.out.println(e.getMessage());
                }
                break;
            }
        }


    }

    public String next() throws IOException {
        if (st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
    private int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

}
