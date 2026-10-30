public class StoreHomeScreen {
    //Displays the main home screen menu
    public static void displayMenu() {
        System.out.println("\n=== Store Home Menu ===");
        System.out.println("1 - Display Products");
        System.out.println("2 - Display Cart");
        System.out.println("3 - Exit");
        System.out.print("Choose an option: ");
        Main.read.nextInt();
    }

}
