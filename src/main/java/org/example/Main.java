package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Ingredient> ingredients =
                MenuLoader.loadingIngredients("src/main/resources/cafe_menu_items.csv");

        CoffeeDrink coffee = new CoffeeBuilder("Latte", "medium", "iced")
                .addIngredient(ingredients.get(1))
                .addIngredient(ingredients.get(7))
                .addIngredient(ingredients.get(15))
                .build();

        System.out.println(coffee.getSize() + " "
                + coffee.getTemperature() + " "
                + coffee.getDrinkType());

        System.out.println("Total: $" + coffee.getPrice());
    }
}