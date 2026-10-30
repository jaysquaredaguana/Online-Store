import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductDisplay {
    public static void display(){

        ArrayList<Product> inventory = Main.inventory;
        inventory.sort(Comparator.comparing(Product::getProductName));

        //Looking at Inventory
        System.out.println("Inventory In Stock");
        for (Product product : inventory)
            System.out.println(product);
    }
    //Listing All Store Products Using While Loop
    public static void showProducts() {
        int number = 0;

        while (number != 4) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("  1- Lookup a product by its SKU");
            System.out.println("  2- Show all Products");
            System.out.println("  3- Add Product by Sku to your Cart.");
            System.out.println("  4- Go Back to home Page");
            System.out.println("Enter number: ");


            try {
                number = Main.read.nextInt();

            } catch (NumberFormatException e) {
                System.out.println("Enter a number 1-4");
                continue;
            }
            //Calling
        switch(number) {
            case 1 -> Main.viewAllProducts();
            case 2 -> Main.searchByProductName();
            case 3 -> Main.addToCart();
            case 4 -> StoreHomeScreen.displayHomeMenu();
            default -> System.out.println(("Invalid Input Enter 1-4."));

        }




        }


    }
}







