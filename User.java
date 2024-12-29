package com.mycompany.resalefashionhub.user;

import com.mycompany.resalefashionhub.product.Product;
import com.mycompany.resalefashionhub.order.Order;
import com.mycompany.resalefashionhub.bill.Bill;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Product> cart;
    private List<Order> orderHistory;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.cart = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
    }

    // Method to add a product to the cart
    public void addToCart(Product product) {
        if (product != null) {
            cart.add(product);
            System.out.println(product.getName() + " has been added to your cart.");
        } else {
            System.out.println("Invalid product.");
        }
    }

    // Method to view the cart
    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("\nYour Cart:");
            for (int i = 0; i < cart.size(); i++) {
                Product product = cart.get(i);
                System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice());
            }
        }
    }

    // Method to checkout and generate the bill
    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Add products before checking out.");
        } else {
            // Generate and display the bill
            Bill bill = new Bill(cart);
            bill.displayBill();

            // Create an order and add to the history
            Order order = new Order(cart);
            orderHistory.add(order);

            cart.clear(); // Clear the cart after checkout
            System.out.println("Thank you for your purchase!");
            System.out.println("Your order has been placed and added to the order history.");
        }
    }
    // Inside User.java class
public void rateProduct(Product product, double userRating) {
    if (product != null && userRating >= 1 && userRating <= 5) {
        product.rateProduct(userRating);  // Call the rateProduct method of Product class
        System.out.println("Thank you for rating " + product.getName());
    } else {
        System.out.println("Invalid rating. Please provide a rating between 1 and 5.");
    }
}


    // Method to view order history
    public void viewOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("You have no past orders.");
        } else {
            System.out.println("\nOrder History:");
            for (Order order : orderHistory) {
                System.out.println(order.toString());
            }
        }
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User: " + username;
    }
}
