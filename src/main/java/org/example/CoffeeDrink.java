package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CoffeeDrink {

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
}