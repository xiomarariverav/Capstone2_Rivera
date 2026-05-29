package org.example;

public class CoffeeBuilder {
    //This class builds custom coffee drinks, adds ingredients gradually, and returns the finished drink

    private CoffeeDrink coffeeDrink;

    public CoffeeBuilder(String drinkType, String size, String temperature) {
        //Creates CoffeeDrink Object
        coffeeDrink = new CoffeeDrink(drinkType, size, temperature);
    }

    public CoffeeBuilder addIngredient(Ingredient ingredient) {
        // send the ingredient to the CoffeeDrink object
        coffeeDrink.addIngredient(ingredient);
        return this;
    }

    public CoffeeDrink build() {
        //returns the finished drink.
        return coffeeDrink;
    }
}