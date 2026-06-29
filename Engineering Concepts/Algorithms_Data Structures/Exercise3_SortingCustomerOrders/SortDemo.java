import java.util.Arrays;

public class SortDemo {
    public static void bubbleSort(Order[] orders) {
        for (int i = 0; i < orders.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < orders.length - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(orders, low, high);
            quickSort(orders, low, partitionIndex - 1);
            quickSort(orders, partitionIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int smallerIndex = low - 1;

        for (int current = low; current < high; current++) {
            if (orders[current].getTotalPrice() <= pivot) {
                smallerIndex++;
                swap(orders, smallerIndex, current);
            }
        }

        swap(orders, smallerIndex + 1, high);
        return smallerIndex + 1;
    }

    private static void swap(Order[] orders, int first, int second) {
        Order temp = orders[first];
        orders[first] = orders[second];
        orders[second] = temp;
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {
        Order[] originalOrders = {
                new Order(201, "Ravi", 4500.0),
                new Order(202, "Asha", 1200.0),
                new Order(203, "Neha", 8800.0),
                new Order(204, "Karan", 3100.0)
        };

        Order[] bubbleOrders = Arrays.copyOf(originalOrders, originalOrders.length);
        Order[] quickOrders = Arrays.copyOf(originalOrders, originalOrders.length);

        bubbleSort(bubbleOrders);
        System.out.println("Orders sorted using Bubble Sort:");
        printOrders(bubbleOrders);

        quickSort(quickOrders, 0, quickOrders.length - 1);
        System.out.println("\nOrders sorted using Quick Sort:");
        printOrders(quickOrders);
    }
}
