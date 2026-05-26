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
                    displayAddOtherDrinkScreen();
                    break;

                case "3":
                    displayAddPastryScreen();
                    break;

                case "4":
                    displayCheckoutScreen();
                    ordering = false;
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
    public void displayAddOtherDrinkScreen() {

        System.out.println("\nSelect Other Drink Flavor");
        System.out.println("1) Lemonade");
        System.out.println("2) Iced Tea");
        System.out.println("3) Refresher");
        System.out.println("4) Bottled Water");
        System.out.print("Choose a drink: ");

        String flavorChoice = scanner.nextLine();
        String flavor = "";

        switch (flavorChoice) {
            case "1":
                flavor = "Lemonade";
                break;
            case "2":
                flavor = "Iced Tea";
                break;
            case "3":
                flavor = "Refresher";
                break;
            case "4":
                flavor = "Bottled Water";
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }

        System.out.println("\nSelect Size");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        System.out.print("Choose a size: ");

        String sizeChoice = scanner.nextLine();
        String size = "";

        switch (sizeChoice) {
            case "1":
                size = "small";
                break;
            case "2":
                size = "medium";
                break;
            case "3":
                size = "large";
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }

        OtherDrink otherDrink = new OtherDrink(flavor, size);
        currentOrder.addItem(otherDrink);

        System.out.println(size + " " + flavor + " added to order.");
    }
    public void displayCheckoutScreen() {

        System.out.println("\nCheckout");
        System.out.println("----------------------");

        for (OrderItem item : currentOrder.getItems()) {
            System.out.println(item.getDetails());
            System.out.println();
        }

        System.out.println("----------------------");
        System.out.println("Total: $" + currentOrder.getTotal());

        System.out.println("\n1) Confirm");
        System.out.println("0) Cancel");
        System.out.print("Choose an option: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                ReceiptWriter.saveReceipt(currentOrder);
                System.out.println("Order complete.");
                break;

            case "0":
                System.out.println("Checkout canceled.");
                break;

            default:
                System.out.println("Invalid option.");
                break;
        }
    }
}