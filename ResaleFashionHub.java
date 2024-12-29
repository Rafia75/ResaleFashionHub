package com.mycompany.resalefashionhub;
import java.util.HashMap;
import java.util.Scanner;
import com.mycompany.resalefashionhub.admin.Admin;
import com.mycompany.resalefashionhub.product.Product;
import com.mycompany.resalefashionhub.user.User;

public class ResaleFashionHub {

    private static HashMap<String, String> registeredUsers = new HashMap<>();

    public static void main(String[] args) {
        Admin admin = new Admin();
        Scanner scanner = new Scanner(System.in);
        
        admin.addProduct(new Product("Vintage Jacket", "Classic style, lightly used", 49.99));
        admin.addProduct(new Product("Designer Handbag", "Genuine leather, barely used", 120.00));
        admin.addProduct(new Product("Sneakers", "Trendy and comfortable", 35.00));
        admin.addProduct(new Product("Leather Boots", "Stylish and durable, lightly worn", 60.00));
        admin.addProduct(new Product("Wool Sweater", "Soft and cozy, perfect for winter", 25.50));
        admin.addProduct(new Product("Sunglasses", "Trendy, UV protection", 30.00));
        admin.addProduct(new Product("Formal Blazer", "Perfect for work or formal events", 50.00));
        admin.addProduct(new Product("Denim Jeans", "Comfortable and casual, lightly worn", 40.00));
        admin.addProduct(new Product("Silk Scarf", "Elegant and smooth, great accessory", 20.00));
        admin.addProduct(new Product("Sports Watch", "Digital, water-resistant", 35.00));
        admin.addProduct(new Product("Backpack", "Durable and spacious, lightly used", 45.00));
        admin.addProduct(new Product("Casual T-Shirt", "Cotton, trendy design", 15.99));
        admin.addProduct(new Product("Running Shoes", "Lightweight and comfortable", 50.00));
        admin.addProduct(new Product("Designer Belt", "Premium leather, classic style", 25.00));
        admin.addProduct(new Product("Evening Gown", "Elegant and beautiful, barely worn", 80.00));
        admin.addProduct(new Product("Winter Coat", "Warm & stylish,perfect for cold weather", 70.00));
        admin.addProduct(new Product("Laptop Bag", "Professional and durable, good condition", 55.00));
        admin.addProduct(new Product("Trendy Earrings", "Silver-plated, fashionable", 10.50));
        admin.addProduct(new Product("Casual Sneakers", "Comfortable, great for daily wear", 45.00));
        admin.addProduct(new Product("Leather Wallet", "Compact and stylish, excellent condition", 25.00));
        admin.addProduct(new Product("Graphic Hoodie", "Trendy and cozy, good condition", 30.00));


        System.out.println("Welcome to the Resale Fashion Hub!");

        while (true) {
            System.out.println("\nAre you an Admin or a User?");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int roleChoice = scanner.nextInt();
            scanner.nextLine();

            switch (roleChoice) {
                case 1:
                    adminLogin(scanner, admin);
                    break;
                case 2:
                    userLogin(scanner, admin);
                    break;
                case 3:
                    System.out.println("Thank you for visiting Resale Fashion Hub!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void adminLogin(Scanner scanner, Admin admin) {
        System.out.print("\nEnter Admin username: ");
        String adminUsername = scanner.nextLine();
        System.out.print("Enter Admin password: ");
        String adminPassword = scanner.nextLine();
        
        if (adminUsername.equals("Sayem") && adminPassword.equals("sumaiya")) {
            System.out.println("Admin login successful!");
            adminMenu(scanner, admin);
        }
        else if (adminUsername.equals("Mim") && adminPassword.equals("rishat")) {
            System.out.println("Admin login successful!");
            adminMenu(scanner, admin);
        }
        else if (adminUsername.equals("Risha") && adminPassword.equals("shakib")) {
            System.out.println("Admin login successful!");
            adminMenu(scanner, admin);
        }
        else {
            System.out.println("Invalid admin credentials.");
        }

    }

    private static void adminMenu(Scanner scanner, Admin admin) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Log Out");
            System.out.print("Choose an option: ");
            int adminChoice = scanner.nextInt();
            scanner.nextLine();

            switch (adminChoice) {
                case 1:
                    addProduct(scanner, admin);
                    break;
                case 2:
                    admin.displayProducts();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addProduct(Scanner scanner, Admin admin) {
        System.out.print("\nEnter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product description: ");
        String description = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Product product = new Product(name, description, price);
        admin.addProduct(product);
        System.out.println("Product added successfully!");
    }

    private static void userLogin(Scanner scanner, Admin admin) {
        System.out.println("\n1. Log In");
        System.out.println("2. Register");
        System.out.print("Choose an option: ");
        int loginChoice = scanner.nextInt();
        scanner.nextLine(); 

        switch (loginChoice) {
            case 1:
                loginExistingUser(scanner, admin);
                break;
            case 2:
                registerNewUser(scanner);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void loginExistingUser(Scanner scanner, Admin admin) {
        System.out.print("\nEnter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (registeredUsers.containsKey(username) && registeredUsers.get(username).equals(password)) {
            System.out.println("User login successful!");
            User user = new User(username, password);
            userMenu(scanner, user, admin);
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void registerNewUser(Scanner scanner) {
        System.out.print("\nEnter a username: ");
        String username = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        if (registeredUsers.containsKey(username)) {
            System.out.println("Username already exists. Please try a different one.");
        } else {
            registeredUsers.put(username, password);
            System.out.println("Registration successful! You can now log in.");
        }
    }

    private static void userMenu(Scanner scanner, User user, Admin admin) {
        while (true) {
            System.out.println("\nUser Menu:");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. View Past Orders");
            System.out.println("6. Rate a Product");
            System.out.println("7. Log Out");
            System.out.print("Choose an option: ");
            int userChoice = scanner.nextInt();
            scanner.nextLine(); 

            switch (userChoice) {
                case 1:
                    admin.displayProducts();
                    break;
                case 2:
                    admin.displayProducts();
                    System.out.print("Enter the product number to add to cart: ");
                    int productChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (productChoice > 0 && productChoice <= admin.getProducts().size()) {
                        user.addToCart(admin.getProducts().get(productChoice - 1));
                        System.out.println("Product added to cart!");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 3:
                    user.viewCart();
                    break;
                case 4:
                    user.checkout();
                    break;
                case 5:
                    user.viewOrderHistory();
                    break;
                case 6:
                    System.out.print("Enter product number to rate: ");
                    int ratingProductChoice = scanner.nextInt();
                    System.out.print("Enter your rating (1-5): ");
                    double rating = scanner.nextDouble();
                    scanner.nextLine(); 

                    if (ratingProductChoice > 0 && ratingProductChoice <= admin.getProducts().size()) {
                        if (rating >= 1 && rating <= 5) {
                            user.rateProduct(admin.getProducts().get(ratingProductChoice - 1), rating);
                        } else {
                            System.out.println("Invalid rating. Please provide a rating between 1 and 5.");
                        }
                    } else {
                        System.out.println("Invalid product choice. Please select a valid product number.");
                    }
                    break;

                case 7:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
