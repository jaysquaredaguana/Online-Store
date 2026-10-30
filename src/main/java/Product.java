import java.util.Locale;

public class Product {
    // SKU|Product Name|Price|Department
    private String sku, productName, department;
    private double price;

    public Product(String sku, String productName, double price, String department) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.department = department;
    }

    public String getSku() {
        return sku;
    }

    public String getProductName() {
        return productName;
    }

    public String getDepartment() {
        return department;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%-8s %-32s $%8.2f   %s", sku, productName, price, department);
    }
}
