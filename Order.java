package com.mycompany.resalefashionhub.order;

import com.mycompany.resalefashionhub.product.Product;
import java.util.List;
import java.util.Date;

public class Order {
    private List<Product> products;
    private Date orderDate;
    private double totalCost;

    public Order(List<Product> products) {
        this.products = products;
        this.orderDate = new Date();  // Set the current date as the order date
        this.totalCost = calculateTotal();
    }

    // Method to calculate total cost of the order
    private double calculateTotal() {
        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }

    // Getters
    public List<Product> getProducts() {
        return products;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder("Order Date: " + orderDate + "\nProducts:\n");
        for (Product product : products) {
            orderDetails.append(product.getName()).append(" - $").append(product.getPrice()).append("\n");
        }
        orderDetails.append("Total Cost: $").append(totalCost);
        return orderDetails.toString();
    }
}
