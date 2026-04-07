package com.mycompany.customermanagementsoftware;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC-SUMAN
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class OrderTest {

    //Test 1: Item price calculation
    @Test
    void testItemPriceForQuantity() {
        Item item = new Item("Laptop", 2.5f, 50000.0f);
        assertEquals(50000.0f, item.getPriceForQuantity(1));
    }

    //Test 2: OrderDetails subtotal
    @Test
    void testOrderDetailsSubTotal() {
        Item item = new Item("Mouse", 0.2f, 500.0f);
        OrderDetails od = new OrderDetails(2, "Taxable", item);

        assertEquals(1000.0f, od.calcSubTotal());
    }

    //Test 3: Tax calculation
    @Test
    void testTaxCalculation() {
        Item item = new Item("Keyboard", 1.0f, 1000.0f);
        OrderDetails od = new OrderDetails(2, "Taxable", item);
        assertEquals(200.0f, od.calcTax());
    }

    //Test 4: Order total calculation
    @Test
    void testOrderTotal() {
        Item item = new Item("Keyboard", 1.0f, 1000.0f);
        OrderDetails od = new OrderDetails(2, "Taxable", item);

        Order order = new Order(new Date(), "Pending", null);
        order.addOrderDetail(od);
        assertEquals(2200.0f, order.calcTotal());
    }

    //Test 5: Total weight calculation
    @Test
    void testTotalWeight() {
        Item item = new Item("Laptop", 2.5f, 50000.0f);
        OrderDetails od = new OrderDetails(2, "Taxable", item);
        Order order = new Order(new Date(), "Pending", null);
        order.addOrderDetail(od);
        assertEquals(5.0f, order.calcTotalWeight());
    }
}

// test trigger