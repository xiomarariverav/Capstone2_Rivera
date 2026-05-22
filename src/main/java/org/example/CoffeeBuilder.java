package org.example;

public class CoffeeBuilder {

    private CoffeeDrink coffeeDrink;

    public CoffeeBuilder(String drinkType, String size, String temperature) {
        coffeeDrink = new CoffeeDrink(drinkType, size, temperature);
    }

    public CoffeeBuilder addIngredient(Ingredient ingredient) {
        coffeeDrink.addIngredient(ingredient);
        return this;
    }

    public CoffeeDrink build() {
        return coffeeDrink;
    }
}