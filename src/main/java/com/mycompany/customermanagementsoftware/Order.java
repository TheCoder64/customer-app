/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customermanagementsoftware;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author PC-SUMAN
 */
public class Order {
    private Date date;
    private String status;
    private Customer customer;
    private ArrayList<OrderDetails> orderDetails;
    private ArrayList<Payment> payments;

    public Order(Date date, String status, Customer customer) {
        this.date = date;
        this.status = status;
        this.customer = customer;
        this.orderDetails = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public void addOrderDetail(OrderDetails detail) {
        orderDetails.add(detail);
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public float calcSubTotal() {
        float total = 0;
        for (OrderDetails od : orderDetails) {
            total += od.calcSubTotal();
        }
        return total;
    }

    public float calcTax() {
        float tax = 0;
        for (OrderDetails od : orderDetails) {
            tax += od.calcTax();
        }
        return tax;
    }

    public float calcTotal() {
        return calcSubTotal() + calcTax();
    }

    public float calcTotalWeight() {
        float weight = 0;
        for (OrderDetails od : orderDetails) {
            weight += od.calcWeight();
        }
        return weight;
    }
}
