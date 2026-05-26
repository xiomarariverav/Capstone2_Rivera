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
                    displayOrderScreen();
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

    public void displayOrderScreen() {

        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\nOrder Screen");
            System.out.println("1) Add Coffee");
            System.out.println("2) Add Other Drink");
            System.out.println("3) Add Pastry");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Add coffee coming soon...");
                    break;

                case "2":
                    System.out.println("Add other drink coming soon...");
                    break;

                case "3":
                    System.out.println("Add pastry coming soon...");
                    break;

                case "4":
                    System.out.println("Checkout coming soon...");
                    break;

                case "0":
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}