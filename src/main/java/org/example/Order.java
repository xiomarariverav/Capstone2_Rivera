package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order {

    private ArrayList<CoffeeDrink> coffees;

    public Order() {
        coffees = new ArrayList<>();
    }

    public void addCoffee(CoffeeDrink coffee) {
        coffees.add(coffee);
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;

        for (CoffeeDrink coffee : coffees) {
            total = total.add(coffee.getPrice());
        }

        return total;
    }

    public ArrayList<CoffeeDrink> getCoffees() {
        return coffees;
    }
}