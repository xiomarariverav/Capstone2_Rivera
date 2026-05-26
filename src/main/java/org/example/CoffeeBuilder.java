package org.example;

public class CoffeeBuilder {

    private CoffeeDrink coffeeDrink;

    public CoffeeBuilder(String drinkType, String size, String temperature) {
        coffeeDrink = new CoffeeDrink(drinkType, size, temperature);
    }

    public CoffeeBuilder addIngredient(Ingredient ingredient) {
        // send the ingredient to the CoffeeDrink object
        coffeeDrink.addIngredient(ingredient);
        return this;
    }

    public CoffeeDrink build() {
        return coffeeDrink;
    }
}