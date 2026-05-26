package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void saveReceipt(Order order){

        try{

            //creates receipt folder if it doesnt exist
            File folder = new File("receipts");

            if(!folder.exists()){
                folder.mkdir();
            }

            //creates timestamp for filename
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

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
