package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CoffeeDrink implements OrderItem {

    private String drinkType;
    private String size;
    private String temperature;
    private ArrayList<Ingredient> addIns;

    public CoffeeDrink(String drinkType, String size, String temperature) {
        this.drinkType = drinkType;
        this.size = size;
        this.temperature = temperature;
        this.addIns = new ArrayList<>();
    }

    public void addIngredient(Ingredient ingredient) {
        addIns.add(ingredient);
    }

    public BigDecimal getPrice() {
        BigDecimal total = BigDecimal.ZERO;

        for (Ingredient ingredient : addIns) {
            // get the ingredient price based on drink size
            // then add it to the total
            total = total.add(ingredient.getPriceBySize(size));
        }

        return total;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public String getSize() {
        return size;
    }

    public String getTemperature() {
        return temperature;
    }

    public ArrayList<Ingredient> getAddIns() {
        return addIns;
    }
    @Override
    public String getDetails() {
        String details = size + " " + temperature + " " + drinkType + "\n";

        for (Ingredient ingredient : addIns) {
            //add each ingredient name onto a new line
            details += "- " + ingredient.getName() + "\n";
        }
        // add the final drink price to the bottom
        details += "Price: $" + getPrice();

        return details;
    }
}