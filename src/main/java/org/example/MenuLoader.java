package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;

public class MenuLoader {
    public static ArrayList<Ingredient> loadingIngredients(String filePath){

        ArrayList<Ingredient> ingredients = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            reader.readLine();

            String line = reader.readLine();

            while (line != null) {

                // defensive coding
                // skip empty lines in the file
                if (line.trim().isEmpty()) {
                    line = reader.readLine();
                    continue;
                }

                String[] parts = line.split("\\|");

                // defensive coding
                // skip rows with missing or extra columns
                if (parts.length != 5) {
                    System.out.println("Invalid row: " + line);
                    line = reader.readLine();
                    continue;
                }

                //name|type|smallPrice|mediumPrice|largePrice
                Ingredient ingredient = new Ingredient(
                        parts[0],
                        parts[1],
                        new BigDecimal(parts[2]),
                        new BigDecimal(parts[3]),
                        new BigDecimal(parts[4])
                );

                ingredients.add(ingredient);

                line = reader.readLine();
            }
            reader.close();
        }
        catch (Exception e){
            System.out.println("Error loading Menu Items");
        }
        return ingredients;

    }
}
