package com.mycompany.resalefashionhub.admin;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.resalefashionhub.product.Product;

public class Admin {
    private List<Product> products;

    public Admin() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void displayProducts() {
        System.out.println("\nAvailable Products:");
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            // Print the table header
            System.out.println("+-----+----------------------+------------------------------------------+---------+");
            System.out.printf("| %-3s | %-20s | %-40s | %-8s|\n", "No", "Name", "Description", "Price");
            System.out.println("+-----+----------------------+------------------------------------------+---------+");

            // Print each product in the table
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                System.out.printf(
                    "| %-3d | %-20s | %-40s | $%-6.2f |\n",
                    i + 1,
                    product.getName(),
                    product.getDescription(),
                    product.getPrice()
                );
            }

            // Print the table footer
            System.out.println("+-----+-----------------------+-----------------------------------------+---------+");
        }
    }
}
