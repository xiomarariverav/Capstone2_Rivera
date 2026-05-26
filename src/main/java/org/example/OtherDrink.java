package org.example;

import java.math.BigDecimal;

public class OtherDrink implements OrderItem{

    private String flavor;
    private String size;

    public OtherDrink(String flavor, String size){
        this.flavor = flavor;
        this.size = size;
    }
    @Override
    public BigDecimal getPrice(){

        switch(size.toLowerCase()){

            case "small":
                return new BigDecimal("2.00");

            case "medium":
                return new BigDecimal("2.50");

            case "large":
                return new BigDecimal("3.00");

            default:
                return BigDecimal.ZERO;
        }
    }

    @Override
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
