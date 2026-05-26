package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private ArrayList<Ingredient> ingredients;

    public UserInterface() {
        scanner = new Scanner(System.in);
        ingredients = MenuLoader.loadingIngredients("src/main/resources/cafe_menu_items.csv");
    }

    public void displayHomeScreen() {

        boolean running = true;

        while (running) {
            System.out.println("\nHome Screen");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Starting new order...");
                    break;

                case "0":
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}