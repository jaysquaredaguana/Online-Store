import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static ArrayList<Product> inventory = new ArrayList<>();
    public static HashMap<Product, Integer> cart = new HashMap<>();
    public static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        loadInventory();
//        inventory.remove(0); // removes the format line
        // Scanner read = new Scanner(System.in);

        int command = StoreHomeScreen.displayHomeMenu();

        while (command != 3) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1- List all products");
            System.out.println("2- View Cart");
            System.out.println("3- Exit");

//            command = read.nextInt();
            read.nextLine();

            switch (command) {
                case 1 -> viewAllProducts(); // Customers should be able to view all products
                case 2 -> CartDisplay.displayCart(cart); // shows the existing items in the cart.
                case 3 -> System.out.println("Thank you for using Search Inventory!");
                default -> System.out.println("Invalid command. Please enter a number from 1 to 3.");
            }
        }
        read.close();
    }

    // method requirements

    public static void loadInventory() {
        try {
            // create a FileReader object
            FileReader filereader = new FileReader("products.csv");

            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(filereader);

            String input;
            String[] productInfo;

            // SKU|Product Name|Price|Department
            String sku, productName, department;
            double price;

            bufReader.readLine();

            // read until there is no more data
            while ((input = bufReader.readLine()) != null) {
                productInfo = input.split("\\|");
                sku = productInfo[0];
                productName = productInfo[1];
                price = Double.parseDouble(productInfo[2]);
                department = productInfo[3];
                inventory.add(new Product(sku, productName, price, department));
            }
        }
        catch (IOException e) {
            System.out.println("ERROR: An unexpected error occurred");
        }
    }
    public static void viewAllProducts() {
        System.out.println("\nWe carry the following inventory:");
        // inventory.sort(Comparator.comparing(Product::getProductName));
        inventory.forEach(System.out::println);
    }
    public static void searchByProductName() {
        System.out.print("Enter product name: ");
        String productName = read.nextLine().trim();

        boolean found = false;

        for (Product product : inventory) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                System.out.println(product);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }
    public static void searchByPrice() {
        System.out.print("Enter minimum price: ");
        double minPrice = read.nextDouble();

        System.out.print("Enter maximum price: ");
        double maxPrice = read.nextDouble();
        read.nextLine();

        for (Product product : inventory) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                System.out.println(product);
            }
        }
    }
    public static void searchByDepartment() {
        System.out.print("Enter department: ");
        String department = read.nextLine();

        for (Product product : inventory) {
            if (product.getDepartment().equalsIgnoreCase(department)) {
                System.out.println(product);
            }
        }
    }
    public static void addToCart() {
        System.out.print("Enter product SKU: ");
        String sku = read.nextLine();

        boolean found = false;

        for (Product product : inventory) {
            if (product.getSku().equalsIgnoreCase(sku)) {
                cart.compute(product, (key, value) -> value == null ? 1 : value + 1);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        } else {
            System.out.println("Successfully added to cart!");
        }
    }
    public static void removeFromCart() {
        System.out.print("Enter product SKU: ");
        String sku = read.nextLine();

        boolean found = false;

        for (Product product : inventory) {
            if (product.getSku().equalsIgnoreCase(sku)) {
                cart.remove(product);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        } else {
            System.out.println("Successfully removed item from cart!");
        }
    }
    public static void addToInventory() {
        StringBuilder skuBuilder = new StringBuilder();

        System.out.print("Enter product name: ");
        String name = read.nextLine();

        System.out.print("Enter product price: ");
        double price = read.nextDouble();
        read.nextLine();

        System.out.print("Enter product SKU: ");
        String department = read.nextLine();

        // departments: AV, CP, GM, PW
        switch (department) {
            case "Audio Video" -> skuBuilder.append("AV");
            case "Computers" -> skuBuilder.append("CP");
            case "Games" -> skuBuilder.append("GM");
            case "Electronics" -> skuBuilder.append("PW");
            default -> skuBuilder.append("__");
        }
        // random four digit SKU
        int randomSku = (int)(Math.random() * 10000);
        skuBuilder.append(String.format("%04d", randomSku));
        String sku = skuBuilder.toString();

        Product newProduct = new Product(sku, name, price, department);
        inventory.add(newProduct);

        System.out.println("Product successfully added to inventory!");
    }

    // screens
    public static void storeHomeScreen() {
        // Display Products
        // Display Cart
        // Exit - closes out of the application
        System.out.println("\nWhat do you want to do?");
        System.out.println("1- List all products");
        System.out.println("2- Display cart");
        System.out.println("3- Quit the application");
        System.out.print("Enter command: ");
    }
}
