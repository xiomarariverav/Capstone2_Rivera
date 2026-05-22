package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Ingredient> ingredients =
                MenuLoader.loadingIngredients("src/main/resources/cafe_menu_items.csv");

        CoffeeDrink coffee = new CoffeeDrink("Latte", "medium", "iced");

        coffee.addIngredient(ingredients.get(1));  // Latte
        coffee.addIngredient(ingredients.get(7));  // Espresso Shot
        coffee.addIngredient(ingredients.get(15)); // Vanilla Syrup

        System.out.println(coffee.getSize() + " "
                + coffee.getTemperature() + " "
                + coffee.getDrinkType());

        System.out.println("Total: $" + coffee.getPrice());
    }
}