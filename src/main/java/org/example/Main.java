package org.example;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<Ingredient> ingredients =
                MenuLoader.loadingIngredient("src/main/resources/cafe_menu_items.csv");

        for(Ingredient ingredient : ingredients){

            System.out.println(ingredient.getName());
        }
    }
}