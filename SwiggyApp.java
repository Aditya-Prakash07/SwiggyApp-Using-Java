import java.util.ArrayList;

// Class representing a Restaurant
class Restaurant {
    private String name;
    private ArrayList<String> menu;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public void addToMenu(String item) {
        menu.add(item);
    }

    public void displayMenu() {
        System.out.println("Menu for " + name + ":");
        for (String item : menu) {
            System.out.println("- " + item);
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}

// Class representing a Customer
class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void placeOrder(Restaurant restaurant, String item) {
        System.out.println(name + " placed an order for " + item + " from " + restaurant.getName());
    }

    public String getName() {
        return null;
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
    }

    public void displayOrder() {
        System.out.println("Order details:");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Restaurant: " + restaurant.getName());
        System.out.println("Item: " + item);
        System.out.println();
    }
}

// Main application class
public class SwiggyApp {
    public static void main(String[] args) {
        // Create restaurants
        Restaurant restaurant1 = new Restaurant("Restaurant A");
        restaurant1.addToMenu("Burger");
        restaurant1.addToMenu("Pizza");

        Restaurant restaurant2 = new Restaurant("Restaurant B");
        restaurant2.addToMenu("Pasta");
        restaurant2.addToMenu("Salad");

        // Display menus
        restaurant1.displayMenu();
        restaurant2.displayMenu();

        // Create a customer 
        Customer customer = new Customer("Tushar Sir");

        // Place orders
        customer.placeOrder(restaurant1, "Burger");
        customer.placeOrder(restaurant2, "Pasta");

        // Create orders
        Order order1 = new Order(restaurant1, customer, "Burger");
        Order order2 = new Order(restaurant2, customer, "Pasta");

        // Display orders
        order1.displayOrder();
        order2.displayOrder();
    }
}
