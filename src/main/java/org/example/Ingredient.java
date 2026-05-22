package org.example;

import java.math.BigDecimal;

public class Ingredient {
    private String name;
    private String type;
    private BigDecimal smallPrice;
    private BigDecimal mediumPrice;
    private BigDecimal largePrice;

    public Ingredient(String name, String type, BigDecimal smallPrice, BigDecimal mediumPrice, BigDecimal largePrice) {
        this.name = name;
        this.type = type;
        this.smallPrice = smallPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getSmallPrice() {
        return smallPrice;
    }

    public BigDecimal getPriceBySize(String size) {

        switch (size.toLowerCase()) {

            case "small":
                return smallPrice;

            case "medium":
                return mediumPrice;

            case "large":
                return largePrice;

            default:
                return BigDecimal.ZERO;
        }
    }
}

