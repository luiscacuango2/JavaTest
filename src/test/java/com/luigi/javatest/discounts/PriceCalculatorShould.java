package com.luigi.javatest.discounts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceCalculatorShould {

    @Test
    public void total_zero_when_there_are_prices() {
        PriceCalculator calculator = new PriceCalculator();
        assertEquals(0.0, calculator.getTotal(), 0.001);
    }

    @Test
    public void total_is_the_sum_of_prices() {
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(10.2);
        calculator.addPrice(15.5);
        // Usamos delta 0.001 para manejar precisión de decimales
        assertEquals(25.7, calculator.getTotal(), 0.001);
    }

    @Test
    public void apply_discount_to_prices() {
        PriceCalculator calculator = new PriceCalculator();
        calculator.addPrice(100);
        calculator.addPrice(50);
        calculator.addPrice(50);
        calculator.setDiscount(25.0); // 25% de descuento

        // Total (200) - 25% (50) = 150
        assertEquals(150.0, calculator.getTotal(), 0.001);
    }

}