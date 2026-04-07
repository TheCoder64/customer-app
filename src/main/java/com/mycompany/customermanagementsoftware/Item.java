/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customermanagementsoftware;

/**
 *
 * @author PC-SUMAN
 */
public class Item {
    private float shippingWeight;
    private String description;
    private float price;

    public Item(String description, float shippingWeight, float price) {
        this.description = description;
        this.shippingWeight = shippingWeight;
        this.price = price;
    }

    public float getPriceForQuantity(int quantity) {
        return price * quantity;
    }

    public float getTax() {
        return price * 0.1f; // 10% tax example
    }

    public boolean inStock() {
        return true; // Assume always in stock
    }

    public float getShippingWeight() {
        return shippingWeight;
    }
}