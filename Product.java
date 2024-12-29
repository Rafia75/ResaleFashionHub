package com.mycompany.resalefashionhub.product;

public class Product {
    private String name;
    private String description;
    private double price;
    private double rating;  // Average rating of the product
    private int numberOfRatings;  // To track how many users have rated this product

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = 0.0;
        this.numberOfRatings = 0;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }
// Inside Product.java class
public void rateProduct(double userRating) {
    // Update the product rating based on the user's input
    this.rating = (this.rating * numberOfRatings + userRating) / (++numberOfRatings);
}

    @Override
    public String toString() {
        return "Name: " + name + ", Description: " + description + ", Price: " + price + ", Rating: " + rating;
    }
}
