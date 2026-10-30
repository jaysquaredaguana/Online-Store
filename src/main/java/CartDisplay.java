import java.util.HashMap;
import java.util.Map;

public class CartDisplay {

    public static void displayCart(HashMap<Product, Integer>cart) {
        System.out.println("\n Your Shopping Cart: ");

        double total = 0; // leaving this blank so that it can be added to in the for loop

//        Within the cart we are pulling the key(product) and the amount of each product(value)
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            double subtotal = product.getPrice() * quantity; // calculating the price for each product / quantity.

            total += subtotal; // adding all the items together with each iteration.

            System.out.printf("%s - Quantity: %d = $%.2f", product.getProductName(), quantity, subtotal);

            }

            while (true) {
                System.out.println("1. Checkout");
                System.out.println("2. Remove Product");
                System.out.println("3. Go Back Home");

                System.out.println("What would you like to do?");
                int choice = Main.read.nextInt();

                switch (choice) {
                    case 1:
                        if (cart.isEmpty()) { // evaluating if there are any items
                            System.out.println("It feels a little empty in here..");
                            break;
                        }

                        System.out.println("Thank you for your purchase!");
                        cart.clear(); // This will clear out the cart since the customer "purchased" the items.
                        return;

                    case 2:
                        System.out.println("Removing the selected product");
                        Main.removeFromCart(); // This will remove an item from the cart
                        break;

                    case 3:
                        System.out.println("Returning to the menu...");
                        return;

                    default:
                        System.out.println("Please select a valid choice");
                        break;
                }


            }
        }


    }