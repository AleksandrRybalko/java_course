package com.epam.alexander_rybalko.java.lesson6.task3;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Scanner;

import com.epam.alexander_rybalko.java.lesson6.task3.dish.Salad;
import com.epam.alexander_rybalko.java.lesson6.task3.ioConnector.IOConnector;
import com.epam.alexander_rybalko.java.lesson6.task3.vegetable.Vegetable;

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
        System.out.print("The Chef have the following vegetables:\n1. Beet\n2. Cabbage\n3. Carrot\n"
                + "4. Cucumber\n5. Potato\n6. Squash\n7. Tomato\n");
    }

    public void getOptions() {
        File saladFile = new File("src/main/resources/com/epam/alexander_rybalko/java/lesson6/task3/salad.txt");
        try {
            if (!saladFile.exists()) {
                saladFile.createNewFile();
                IOConnector.writeObject(saladFile, this.salad);
            } else {
                this.salad = (Salad) IOConnector.readObject(saladFile);
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

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
                    choice = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Bad option!");
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
                        IOConnector.writeObject(saladFile, this.salad);
                        break;
                    }
                    case 4: {
                        Vegetable vegetable = null;
                        double weightOfVegetable = -1;
                        try {
                            System.out.println("Enter name of vegetable:");
                            String nameOfVegetable = scan.nextLine();
                            nameOfVegetable = "com.epam.alexander_rybalko.java.lesson6.task3.vegetable." + nameOfVegetable;
                            try {
                                Class<?> vegetableClass = Class.forName(nameOfVegetable);
                                Constructor<?> constructor = vegetableClass.getDeclaredConstructor();
                                vegetable = (Vegetable) constructor.newInstance();

                            } catch (ClassNotFoundException e) {
                                System.out.println("Bad name of vegetable! Check list of available vegetables!");
                            } catch (Exception e) {
                            }

                            System.out.println("Enter weight:");
                            weightOfVegetable = Double.parseDouble(scan.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Bad weight of vegetable!");
                        }
                        if (vegetable != null && weightOfVegetable > 0) {
                            this.salad.addIngredient(vegetable, weightOfVegetable);
                            IOConnector.writeObject(saladFile, this.salad);
                        }
                        break;
                    }
                    case 5: {
                        this.salad.sortByWeight();
                        IOConnector.writeObject(saladFile, this.salad);
                        this.salad.showIngredients();
                        break;
                    }
                    case 6: {
                        this.salad.sortByKcals();
                        IOConnector.writeObject(saladFile, this.salad);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
