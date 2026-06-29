import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {
    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].getProductId() == productId) {
                return products[mid];
            }

            if (products[mid].getProductId() < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(104, "Shoes", "Fashion"),
                new Product(101, "Laptop", "Electronics"),
                new Product(103, "Coffee Mug", "Home"),
                new Product(102, "Headphones", "Electronics")
        };

        System.out.println("Linear search for product 103:");
        System.out.println(linearSearch(products, 103));

        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        System.out.println("\nBinary search for product 103 after sorting by productId:");
        System.out.println(binarySearch(products, 103));
    }
}
