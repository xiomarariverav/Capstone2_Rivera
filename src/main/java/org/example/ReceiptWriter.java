package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    //This class is responsible for creating and saving receipts to a text file

    //takes an order, creates a receipt file, saves the order details into it
    public static void saveReceipt(Order order){

        try{

            //creates receipt folder
            File folder = new File("receipts");

            //check if Folder Exists
            if(!folder.exists()){
                //If it DOESN’T exist, creates it automatically
                folder.mkdir();
            }

            //creates timestamp for filename
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            //turns the current time into a string
            String timestamp =
                    LocalDateTime.now().format(formatter);

            String fileName ="receipts/" + timestamp +".txt";

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(fileName));
            writer.write("Latte Lane Receipt\n");
            writer.write("------------------\n\n");

            // loop through every order item
            for (OrderItem item : order.getItems()) {

                writer.write(item.getDetails());
                writer.write("\n\n");
            }
            writer.write("----------------------\n");
            writer.write("TOTAL: $" + order.getTotal());

            writer.close();

            System.out.println("Receipt saved: " + fileName);

        }
        catch (Exception e) {

            System.out.println("Error saving receipt");
        }
    }
}
