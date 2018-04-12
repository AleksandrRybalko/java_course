package com.epam.alexander_rybalko.java.lesson4.task3;

import com.epam.alexander_rybalko.java.lesson4.task3.dish.Salad;
import com.epam.alexander_rybalko.java.lesson4.task3.exception.BadChoiceException;
import com.epam.alexander_rybalko.java.lesson4.task3.exception.BadNameOfVegetableException;
import com.epam.alexander_rybalko.java.lesson4.task3.exception.BadWeightOfVegetableException;
import com.epam.alexander_rybalko.java.lesson4.task3.vegetable.Vegetable;

import java.lang.reflect.Constructor;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chef {
    private String name;
    private Salad salad;

    public Chef(String name) {
        this.name = name;
        salad = new Salad();
    }

    public String getName() {
        return this.name;
    }

    public void setSaladName(String name) {
        this.salad.setName(name);
    }

    public void addIngredient(Vegetable vegetable, double weight) {
        this.salad.addIngredient(vegetable, weight);
    }

    public void showAllVegetables() {
        int i = 1;
        for (Vegetables vegetable : Vegetables.values()) {
            System.out.println(i + ". " + vegetable.getName());
            i++;
        }
    }

    public void getOptions() {
        try (Scanner scan = new Scanner(System.in)) {
            int choice = -1;
            while (choice != 0) {
                System.out.println("\nChoose one of the options:");
                System.out.println("1. Get list of available vegetables");
                System.out.println("2. Get name of salad");
                System.out.println("3. Rename salad");
                System.out.println("4. Add ingredient");
                System.out.println("5. Sort ingredients by weight");
                System.out.println("6. Sort ingredients by total calories");
                System.out.println("7. Show recipe");
                System.out.println("8. Get total calories of salad");
                System.out.println("0. Exit");
                try {
                    choice = parseChoice(scan.nextLine());
                } catch (BadChoiceException e) {
                    System.err.println(e.getMessage());
                    choice = -1;
                }
                switch (choice) {
                    case 1: {
                        this.showAllVegetables();
                        break;
                    }
                    case 2: {
                        System.out.println("Name of salad: " + this.salad.getName());
                        break;
                    }
                    case 3: {
                        System.out.println("Enter name of salad:");
                        salad.setName(scan.nextLine());
                        break;
                    }
                    case 4: {
                        Vegetable vegetable = null;
                        double weightOfVegetable = -1;
                        try {
                            System.out.println("Enter name of vegetable:");
                            String nameOfVegetable = scan.nextLine();

                            checkerForNameVegetable(nameOfVegetable);
                            nameOfVegetable = "com.epam.alexander_rybalko.java.lesson4.task3.vegetable." + nameOfVegetable;
                            Class<?> vegetableClass = Class.forName(nameOfVegetable);
                            Constructor<?> constructor = vegetableClass.getDeclaredConstructor();
                            vegetable = (Vegetable) constructor.newInstance();

                            System.out.println("Enter weight:");
                            weightOfVegetable = parseWeightVegetable(scan.nextLine());
                        } catch (BadNameOfVegetableException | BadWeightOfVegetableException e) {
                            System.err.println(e.getMessage());
                        } catch (Exception e) {
                            // this catch need for reflection
                        }
                        if (vegetable != null && weightOfVegetable > 0) {
                            this.salad.addIngredient(vegetable, weightOfVegetable);
                        }
                        break;
                    }
                    case 5: {
                        this.salad.sortByWeight();
                        this.salad.showIngredients();
                        break;
                    }
                    case 6: {
                        this.salad.sortByKcals();
                        this.salad.showIngredients();
                        break;
                    }
                    case 7: {
                        this.salad.showIngredients();
                        break;
                    }
                    case 8: {
                        System.out.println("Total calories of salad: " + this.salad.getTotalCalories());
                        break;
                    }
                    case 0: {
                        break;
                    }
                    default: {
                        break;
                    }
                }

            }
        }

    }

    private int parseChoice(String choice) throws BadChoiceException {
        Pattern patternForChoice = Pattern.compile("[0-9]+");
        Matcher matcherForChoice = patternForChoice.matcher(choice);
        if (!matcherForChoice.matches()) {
            throw new BadChoiceException();
        }
        return Integer.parseInt(choice);
    }

    private double parseWeightVegetable(String weight) throws BadWeightOfVegetableException {
        Pattern patternForDouble = Pattern.compile("[0-9]*\\.?[0-9]*");
        Matcher matcherForDouble = patternForDouble.matcher(weight);
        if (!matcherForDouble.matches()) {
            throw new BadWeightOfVegetableException();
        }
        return Double.parseDouble(weight);
    }

    private void checkerForNameVegetable(String name) throws BadNameOfVegetableException {
        boolean result = false;
        for (Vegetables vegetable : Vegetables.values()) {
            if (name.equals(vegetable.getName())) {
                result = true;
            }
        }
        if (!result) {
            throw new BadNameOfVegetableException();
        }
    }

    private enum Vegetables {
        BEET("Beet"), CABBAGE("Cabbage"), CARROT("Carrot"), CUCUMBER("Cucumber"), POTATO("Potato"), SQUASH(
                "Squash"), TOMATO("Tomato");

        private String name;

        private Vegetables(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}
