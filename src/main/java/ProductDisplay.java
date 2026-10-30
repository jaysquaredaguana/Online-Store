
import java.util.ArrayList;
import java.util.Comparator;


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

        while (number != 5) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("  1- Lookup a product by Name");
            System.out.println("  2- Lookup by price");
            System.out.println("  3- Lookup by Department");
            System.out.println("  4- Show all Products");
            System.out.println("  5- Add Product by Sku to your Cart.");
            System.out.println("  6- Go Back to home Page");
            System.out.println("Enter number: ");


            try {
                number = Integer.parseInt(Main.read.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter a number 1-6");
                continue;
            }
            //Calling
        switch(number) {
            case 1 -> Main.searchByProductName();
            case 2 -> Main.searchByPrice();
            case 3 -> Main.searchByDepartment();
            case 4 -> Main.viewAllProducts();
            case 5 -> Main.addToCart();
            case 6 -> {}
            default -> System.out.println(("Invalid Input Enter 1-6."));

        }




        }


    }
}







