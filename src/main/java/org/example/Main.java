package org.example;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Ingredient> ingredients =
                MenuLoader.loadingIngredients("src/main/resources/cafe_menu_items.csv");

        Order order = new Order();

        CoffeeDrink coffee = new CoffeeBuilder("Latte", "medium", "iced")
                .addIngredient(ingredients.get(1))
                .addIngredient(ingredients.get(7))
                .addIngredient(ingredients.get(15))
                .build();

        order.addItem(coffee);

        System.out.println(coffee.getSize() + " "
                + coffee.getTemperature() + " "
                + coffee.getDrinkType());

        System.out.println("Coffee Total: $" + coffee.getPrice());

        System.out.println("Order Total: $" + order.getTotal());

        System.out.println(coffee.getDetails());
        Pastry pastry = new Pastry("Croissant");
        order.addItem(pastry);

        System.out.println(pastry.getDetails());
        System.out.println("Order Total: $" + order.getTotal());

        OtherDrink drink = new OtherDrink("Lemonade", "large");
        order.addItem(drink);

        System.out.println(drink.getDetails());
        System.out.println("Order Total: $" + order.getTotal());
    }
}