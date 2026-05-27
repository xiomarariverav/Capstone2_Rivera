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
            System.out.println("5) View Current Order");
            System.out.println("6) Add Signature Drink");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    displayAddCoffeeScreen();
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

                case "5":
                    displayCurrentOrder();
                    break;

                case "6":
                    displayAddSignatureDrinkScreen();
                    break;

                case "0":
                    System.out.println("Order canceled.");
                    currentOrder = null;
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

        if (currentOrder.getItems().isEmpty()) {
            System.out.println("You cannot checkout with an empty order.");
            return;
        }

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
                currentOrder = null;
                break;

            case "0":
                System.out.println("Checkout canceled.");
                currentOrder = null;
                break;

            default:
                System.out.println("Invalid option.");
                break;
        }
    }
    public String selectCoffeeType() {

        System.out.println("\nSelect Coffee Type");
        System.out.println("1) Coffee");
        System.out.println("2) Latte");
        System.out.println("3) Cappuccino");
        System.out.println("4) Cold Brew");
        System.out.println("5) Matcha");
        System.out.println("6) Chai");
        System.out.println("7) Mocha");
        System.out.print("Choose a drink type: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                return "Coffee";
            case "2":
                return "Latte";
            case "3":
                return "Cappuccino";
            case "4":
                return "Cold Brew";
            case "5":
                return "Matcha";
            case "6":
                return "Chai";
            case "7":
                return "Mocha";
            default:
                System.out.println("Invalid option.");
                return "";
        }
    }
    public String selectSize() {

        System.out.println("\nSelect Size");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        System.out.print("Choose a size: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                return "small";
            case "2":
                return "medium";
            case "3":
                return "large";
            default:
                System.out.println("Invalid option.");
                return "";
        }
    }
    public String selectTemperature() {

        System.out.println("\nSelect Temperature");
        System.out.println("1) Hot");
        System.out.println("2) Iced");
        System.out.print("Choose temperature: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                return "hot";
            case "2":
                return "iced";
            default:
                System.out.println("Invalid option.");
                return "";
        }
    }
    public void displayAddCoffeeScreen() {

        String drinkType = selectCoffeeType();

        if (drinkType.equals("")) {
            return;
        }

        String size = selectSize();

        if (size.equals("")) {
            return;
        }

        String temperature = selectTemperature();

        if (temperature.equals("")) {
            return;
        }

        CoffeeBuilder builder = new CoffeeBuilder(drinkType, size, temperature);

        // add the drink base ingredient
        for (Ingredient ingredient : ingredients) {

            if (ingredient.getName().equalsIgnoreCase(drinkType)) {
                builder.addIngredient(ingredient);
            }
        }

        // add premium ingredients
        addPremiumAddIns(builder);
        // add free ingredients
        addRegularAddIns(builder);

        CoffeeDrink coffee = builder.build();

        currentOrder.addItem(coffee);

        System.out.println(size + " " + temperature + " " + drinkType + " added to order.");
    }
    public void addPremiumAddIns(CoffeeBuilder builder) {

        boolean adding = true;

        while (adding) {

            System.out.println("\nPremium Add-Ins");
            System.out.println("1) Espresso Shot");
            System.out.println("2) Oat Milk");
            System.out.println("3) Almond Milk");
            System.out.println("4) Soy Milk");
            System.out.println("5) Coconut Milk");
            System.out.println("6) Extra Espresso Shot");
            System.out.println("0) Done");

            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            String ingredientName = "";

            switch (choice) {

                case "1":
                    ingredientName = "Espresso Shot";
                    break;

                case "2":
                    ingredientName = "Oat Milk";
                    break;

                case "3":
                    ingredientName = "Almond Milk";
                    break;

                case "4":
                    ingredientName = "Soy Milk";
                    break;

                case "5":
                    ingredientName = "Coconut Milk";
                    break;

                case "6":
                    ingredientName = "Extra Espresso Shot";
                    break;

                case "0":
                    adding = false;
                    continue;

                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            for (Ingredient ingredient : ingredients) {

                if (ingredient.getName().equalsIgnoreCase(ingredientName)) {

                    builder.addIngredient(ingredient);

                    System.out.println(ingredientName + " added.");
                }
            }
        }
    }
    public void addRegularAddIns(CoffeeBuilder builder) {

        boolean adding = true;

        while (adding) {
            System.out.println("\nRegular Add-Ins / Syrups / Toppings");
            System.out.println("1) Sugar");
            System.out.println("2) Cinnamon");
            System.out.println("3) Sweetener");
            System.out.println("4) Ice");
            System.out.println("5) Vanilla Powder");
            System.out.println("6) Vanilla Syrup");
            System.out.println("7) Caramel Syrup");
            System.out.println("8) Mocha Syrup");
            System.out.println("9) Hazelnut Syrup");
            System.out.println("10) Brown Sugar Syrup");
            System.out.println("11) Lavender Syrup");
            System.out.println("12) Whipped Cream");
            System.out.println("13) Caramel Drizzle");
            System.out.println("14) Chocolate Drizzle");
            System.out.println("15) Cold Foam");
            System.out.println("0) Done");

            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            String ingredientName = "";

            switch (choice) {
                case "1":
                    ingredientName = "Sugar";
                    break;
                case "2":
                    ingredientName = "Cinnamon";
                    break;
                case "3":
                    ingredientName = "Sweetener";
                    break;
                case "4":
                    ingredientName = "Ice";
                    break;
                case "5":
                    ingredientName = "Vanilla Powder";
                    break;
                case "6":
                    ingredientName = "Vanilla Syrup";
                    break;
                case "7":
                    ingredientName = "Caramel Syrup";
                    break;
                case "8":
                    ingredientName = "Mocha Syrup";
                    break;
                case "9":
                    ingredientName = "Hazelnut Syrup";
                    break;
                case "10":
                    ingredientName = "Brown Sugar Syrup";
                    break;
                case "11":
                    ingredientName = "Lavender Syrup";
                    break;
                case "12":
                    ingredientName = "Whipped Cream";
                    break;
                case "13":
                    ingredientName = "Caramel Drizzle";
                    break;
                case "14":
                    ingredientName = "Chocolate Drizzle";
                    break;
                case "15":
                    ingredientName = "Cold Foam";
                    break;
                case "0":
                    adding = false;
                    continue;
                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            for (Ingredient ingredient : ingredients) {
                if (ingredient.getName().equalsIgnoreCase(ingredientName)) {
                    builder.addIngredient(ingredient);
                    System.out.println(ingredientName + " added.");
                }
            }
        }
    }
    public void displayCurrentOrder() {

        if (currentOrder.getItems().isEmpty()) {
            System.out.println("Your order is currently empty.");
            return;
        }

        System.out.println("\nCurrent Order");
        System.out.println("----------------------");

        for (OrderItem item : currentOrder.getItems()) {
            System.out.println(item.getDetails());
            System.out.println();
        }

        System.out.println("----------------------");
        System.out.println("Total: $" + currentOrder.getTotal());
    }
    public Ingredient findIngredientByName(String name) {

        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equalsIgnoreCase(name)) {
                return ingredient;
            }
        }

        return null;
    }
    public CoffeeDrink createCloudMatcha(String size, String temperature) {

        CloudMatcha drink = new CloudMatcha(size, temperature);

        drink.addIngredient(findIngredientByName("Matcha"));
        drink.addIngredient(findIngredientByName("Oat Milk"));
        drink.addIngredient(findIngredientByName("Vanilla Syrup"));
        drink.addIngredient(findIngredientByName("Cold Foam"));

        return drink;
    }
    public CoffeeDrink createMochaDream(String size, String temperature) {

        MochaDream drink = new MochaDream(size, temperature);

        drink.addIngredient(findIngredientByName("Mocha"));
        drink.addIngredient(findIngredientByName("Espresso Shot"));
        drink.addIngredient(findIngredientByName("Mocha Syrup"));
        drink.addIngredient(findIngredientByName("Chocolate Drizzle"));
        drink.addIngredient(findIngredientByName("Whipped Cream"));

        return drink;
    }
    public void displayAddSignatureDrinkScreen() {

        System.out.println("\nSignature Drinks");
        System.out.println("1) Cloud Matcha");
        System.out.println("2) Mocha Dream");
        System.out.print("Choose a signature drink: ");

        String choice = scanner.nextLine();

        String size = selectSize();

        if (size.equals("")) {
            return;
        }

        String temperature = selectTemperature();

        if (temperature.equals("")) {
            return;
        }

        CoffeeDrink drink;

        switch (choice) {

            case "1":
                drink = createCloudMatcha(size, temperature);
                break;

            case "2":
                drink = createMochaDream(size, temperature);
                break;

            default:
                System.out.println("Invalid option.");
                return;
        }

        System.out.println("\nWould you like to customize this drink?");
        System.out.println("1) Yes");
        System.out.println("0) No");
        System.out.print("Choose an option: ");

        String customizeChoice = scanner.nextLine();

        if (customizeChoice.equals("1")) {

            CoffeeBuilder builder =
                    new CoffeeBuilder(drink.getDrinkType(), size, temperature);

            // copy existing ingredients into builder
            for (Ingredient ingredient : drink.getAddIns()) {
                builder.addIngredient(ingredient);
            }

            // allow additional customization
            addPremiumAddIns(builder);
            addRegularAddIns(builder);

            drink = builder.build();
        }

        currentOrder.addItem(drink);

        System.out.println(drink.getDrinkType() + " added to order.");
    }
}