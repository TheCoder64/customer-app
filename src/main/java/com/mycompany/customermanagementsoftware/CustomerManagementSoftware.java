/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.customermanagementsoftware;

import java.util.Date;
public class CustomerManagementSoftware {

    public static void main(String[] args) {
        Customer customer = new Customer("Ravi", "Vellore");

        Item item1 = new Item("Laptop", 2.5f, 50000);
        Item item2 = new Item("Mouse", 0.2f, 500);

        OrderDetails od1 = new OrderDetails(1, "Taxable", item1);
        OrderDetails od2 = new OrderDetails(2, "Taxable", item2);

        Order order = new Order(new Date(), "Pending", customer);
        order.addOrderDetail(od1);
        order.addOrderDetail(od2);

        Payment payment = new Cash(order.calcTotal(), 60000);
        order.addPayment(payment);

        System.out.println("Subtotal: " + order.calcSubTotal());
        System.out.println("Tax: " + order.calcTax());
        System.out.println("Total: " + order.calcTotal());
        System.out.println("Weight: " + order.calcTotalWeight());
    }
}
