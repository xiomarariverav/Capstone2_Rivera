package org.example;

import java.math.BigDecimal;

public class OtherDrink implements OrderItem{
    //MUST include: getPrice() and getDetails()

    private String flavor;
    private String size;

    public OtherDrink(String flavor, String size){
        this.flavor = flavor;
        this.size = size;
    }
    @Override
    //calculates the drink price based on size.
    public BigDecimal getPrice(){

        switch(size.toLowerCase()){

            case "small":
                return new BigDecimal("2.00");

            case "medium":
                return new BigDecimal("2.50");

            case "large":
                return new BigDecimal("3.00");

            //defensive coding
            default:
                return BigDecimal.ZERO;
        }
    }

    @Override
    //Returns a formatted description of the drink
    public String getDetails() {
        return size + " " + flavor + " Price: $" + getPrice();
    }

    public String getFlavor(){
        return flavor;
    }

    public String getSize(){
        return size;
    }
}
