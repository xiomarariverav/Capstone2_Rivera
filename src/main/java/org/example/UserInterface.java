package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private ArrayList<Ingredient> ingredients;
    private Order currentOrder;

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
                    currentOrder = new Order();
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
                    displayAddPastryScreen();
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
    public void displayAddPastryScreen() {

        System.out.println("\nSelect Pastry");
        System.out.println("1) Muffin");
        System.out.println("2) Croissant");
        System.out.println("3) Bagel");
        System.out.println("4) Cookie");
        System.out.println("5) Brownie");

        System.out.print("Choose a pastry: ");

        String choice = scanner.nextLine();

        String pastryType = "";

        switch (choice) {

            case "1":
                pastryType = "Muffin";
                break;

            case "2":
                pastryType = "Croissant";
                break;

            case "3":
                pastryType = "Bagel";
                break;

            case "4":
                pastryType = "Cookie";
                break;

            case "5":
                pastryType = "Brownie";
                break;

            default:
                System.out.println("Invalid option.");
                return;
        }

        Pastry pastry = new Pastry(pastryType);

        currentOrder.addItem(pastry);

        System.out.println(pastryType + " added to order.");
    }
}