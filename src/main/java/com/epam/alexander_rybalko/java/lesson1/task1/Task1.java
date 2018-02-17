package com.epam.alexander_rybalko.java.lesson1.task1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Acer on 17.02.2018.
 */
public class Task1 {
    public int[] massive = new int[20];

    public void generateMassive() {
        for (int i = 0; i < massive.length; i++) {
            massive[i] = (int) (Math.random() * 21) - 10;
        }
    }

    public void replaceMaxMinAndMinMax() {
        int[] massive = Arrays.copyOf(this.massive, this.massive.length);
        int maxMin = -11;
        int idMaxMin = -1;
        int minMax = 11;
        int idMinMax = -1;
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] < 0 && massive[i] > maxMin) {
                maxMin = massive[i];
                idMaxMin = i;
            }
            if (massive[i] > 0 && massive[i] < minMax) {
                minMax = massive[i];
                idMinMax = i;
            }
        }
        if (idMaxMin != -1 && idMinMax != -1) {
            massive[idMaxMin] = minMax;
            massive[idMinMax] = maxMin;
        }
        writeMassive(massive);
    }

    public void sumEvenElements() {
        int[] massive = Arrays.copyOf(this.massive, this.massive.length);
        int sum = 0;
        for (int i = 0; i < massive.length; i += 2) {
            sum += massive[i];
        }
        System.out.println(sum);
    }

    public void replaceNegativeByZero() {
        int[] massive = Arrays.copyOf(this.massive, this.massive.length);
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] < 0) {
                massive[i] = 0;
            }
        }
        writeMassive(massive);
    }

    public void multPositiveElements() {
        int[] massive = Arrays.copyOf(this.massive, this.massive.length);
        for (int i = 0; i < massive.length - 1; i++) {
            if (massive[i] > 0 && massive[i + 1] < 0) {
                massive[i] *= 3;
            }
        }
        writeMassive(massive);
    }

    public void findSubtract() {
        int[] massive = Arrays.copyOf(this.massive, this.massive.length);
        int minElement = 11;
        int sum = 0;
        for (int i = 0; i < massive.length; i++) {
            minElement = Math.min(minElement, massive[i]);
            sum += massive[i];
        }
        double average = sum / massive.length;
        System.out.println(average - minElement);
    }

    public void findElementMoreThanOne(){
        int[] massive = Arrays.copyOf(this.massive, this.massive.length);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < massive.length; i+=2){
            int cnt = 0;
            for (int j = 0; j < massive.length; j++){
                if (massive[j] == massive[i]){
                    cnt++;
                }
            }
            if (cnt > 1){
                list.add(massive[i]);
            }
        }
        for (int i : list){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void writeMassive(int[] massive) {
        for (int i = 0; i < massive.length; i++) {
            System.out.print(massive[i] + " ");
        }
        System.out.println();
    }
}
