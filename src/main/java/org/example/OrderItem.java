package org.example;

import java.math.BigDecimal;

//OrderItem REQUIREMENTS: must have getPrice() must have getDetails()
public interface OrderItem {
    BigDecimal getPrice();

    String getDetails();
}

