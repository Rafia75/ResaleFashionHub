package com.mycompany.resalefashionhub.product;

public class Rating {
    private int stars;  // Rating out of 5
    private String reviewText;

    public Rating(int stars, String reviewText) {
        if (stars < 1) stars = 1;   // Ensure rating is between 1 and 5
        if (stars > 5) stars = 5;
        this.stars = stars;
        this.reviewText = reviewText;
    }

    public int getStars() {
        return stars;
    }

    public String getReviewText() {
        return reviewText;
    }

    @Override
    public String toString() {
        return "Rating: " + stars + " stars - " + reviewText;
    }
}
