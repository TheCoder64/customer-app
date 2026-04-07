/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customermanagementsoftware;

/**
 *
 * @author PC-SUMAN
 */
public class OrderDetails {
    private int quantity;
    private String taxStatus;
    private Item item;

    public OrderDetails(int quantity, String taxStatus, Item item) {
        this.quantity = quantity;
        this.taxStatus = taxStatus;
        this.item = item;
    }

    public float calcSubTotal() {
        return item.getPriceForQuantity(quantity);
    }

    public float calcWeight() {
        return item.getShippingWeight() * quantity;
    }

    public float calcTax() {
        return item.getTax() * quantity;
    }
}
