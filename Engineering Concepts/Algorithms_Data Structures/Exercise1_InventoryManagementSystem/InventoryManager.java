import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private final Map<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public Product getProduct(int productId) {
        return products.get(productId);
    }

    public boolean updateProduct(int productId, String productName, int quantity, double price) {
        Product product = products.get(productId);

        if (product == null) {
            return false;
        }

        product.setProductName(productName);
        product.setQuantity(quantity);
        product.setPrice(price);
        return true;
    }

    public boolean deleteProduct(int productId) {
        return products.remove(productId) != null;
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager();

        inventory.addProduct(new Product(101, "Laptop", 15, 55000.0));
        inventory.addProduct(new Product(102, "Keyboard", 40, 900.0));
        inventory.addProduct(new Product(103, "Mouse", 60, 450.0));

        System.out.println("Initial inventory:");
        inventory.displayProducts();

        inventory.updateProduct(102, "Mechanical Keyboard", 30, 2200.0);
        inventory.deleteProduct(103);

        System.out.println("\nAfter update and delete:");
        inventory.displayProducts();

        System.out.println("\nSearch product 101:");
        System.out.println(inventory.getProduct(101));
    }
}
