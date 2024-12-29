package com.mycompany.resalefashionhub.bill;

import com.mycompany.resalefashionhub.product.Product;
import java.util.List;

public class Bill {

    private List<Product> products;
    private double total;

    public Bill(List<Product> products) {
        this.products = products;
        this.total = calculateTotal();
    }

    // Method to calculate the total price of the products
    private double calculateTotal() {
        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }

    // Method to display the bill with two decimal places
    public void displayBill() {
        System.out.println("\n--- Final Bill ---");
        for (Product product : products) {
            // Displaying price with 2 decimal places
            System.out.printf("%s - $%.2f\n", product.getName(), product.getPrice());
        }
        // Displaying total price with 2 decimal places
        System.out.printf("\nTotal: $%.2f\n", total);
    }
}
