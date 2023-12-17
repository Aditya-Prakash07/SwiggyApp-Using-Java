import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Class representing a Restaurant
class Restaurant {
    private String name;
    private Map<String, Double> menu;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new HashMap<>();
    }

    public void addToMenu(String item, double price) {
        menu.put(item, price);
    }

    public void displayMenu() {
        System.out.println("Menu for " + name + ":");
        for (Map.Entry<String, Double> entry : menu.entrySet()) {
            System.out.println("- " + entry.getKey() + " (Rs" + entry.getValue() + ")");
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public double getPrice(String item) {
        return menu.getOrDefault(item, 0.0);
    }
}

// Class representing a Customer
class Customer {
    private String name;
    private ArrayList<Order> orders;
    private double totalAmount;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void placeOrder(Restaurant restaurant, String item) {
        Order order = new Order(restaurant, this, item);
        orders.add(order);
        System.out.println(name + " placed an order for " + item + " from " + restaurant.getName());
    }

    public void viewOrders() {
        System.out.println(name + "'s Orders:");
        for (Order order : orders) {
            order.displayOrder();
        }
        System.out.println("Total Amount: Rs" + totalAmount);
        System.out.println();
    }

    public void makePayment() {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment(this, totalAmount);
    }

    public void updateTotalAmount(double amount) {
        totalAmount += amount;
    }

    public String getName() {
        return name;
    }
}

// Class representing an Order
class Order {
    private Restaurant restaurant;
    private Customer customer;
    private String item;

    public Order(Restaurant restaurant, Customer customer, String item) {
        this.restaurant = restaurant;
        this.customer = customer;
        this.item = item;
        customer.updateTotalAmount(restaurant.getPrice(item));
    }

    public void displayOrder() {
        System.out.println("- " + item + " from " + restaurant.getName() + " (Rs" + restaurant.getPrice(item) + ")");
    }
}

// Class representing a PaymentProcessor
class PaymentProcessor {
    public void processPayment(Customer customer, double amount) {
        System.out.println(customer.getName() + " made a payment of Rs" + amount);
        System.out.println("Payment processed successfully.");
    }
}

// Main application class
public class SwiggyApp {
    public static void main(String[] args) {
        // Create restaurants
        Restaurant restaurant1 = new Restaurant("Restaurant A");
        restaurant1.addToMenu("Burger", 40.0);
        restaurant1.addToMenu("Pizza", 150.0);

        Restaurant restaurant2 = new Restaurant("Restaurant B");
        restaurant2.addToMenu("Pasta", 70.0);
        restaurant2.addToMenu("Salad", 50.0);

        // Display menus
        restaurant1.displayMenu();
        restaurant2.displayMenu();

        // Create a customer
        Customer customer = new Customer("Tushar Sir");

        // Place orders
        customer.placeOrder(restaurant1, "Burger");
        customer.placeOrder(restaurant2, "Pasta");

        // View orders and make payment
        customer.viewOrders();
        customer.makePayment();
    }
}
