//Week1
//Data Structures and Algorithms
//Exercise-2 Ecommerce Platform Search Function
import java.util.*;

public class ProductSearchTool {

    static class Item {
        int id;
        String name;
        String type;

        Item(int id, String name, String type) {
            this.id = id;
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Product ID: " + id + " | Name: " + name + " | Category: " + type;
        }
    }

    
    public static Item searchByNameLinear(Item[] items, String searchKey) {
        for (Item item : items) {
            if (item.name.equalsIgnoreCase(searchKey)) {
                return item;
            }
        }
        return null;
    }

  
    public static Item searchByNameBinary(Item[] items, String searchKey) {
        int start = 0, end = items.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int comparison = items[mid].name.compareToIgnoreCase(searchKey);

            if (comparison == 0) return items[mid];
            else if (comparison < 0) start = mid + 1;
            else end = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int count = scanner.nextInt();
        scanner.nextLine(); 

        List<Item> inventory = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for product #" + (i + 1));
            System.out.print("Product ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Product Name: ");
            String name = scanner.nextLine();

            System.out.print("Category: ");
            String category = scanner.nextLine();

            inventory.add(new Item(id, name, category));
        }

    
        Item[] productArray = inventory.toArray(new Item[0]);
        Arrays.sort(productArray, Comparator.comparing(p -> p.name.toLowerCase()));

        System.out.print("\nEnter product name to search: ");
        String query = scanner.nextLine();


        Item linearResult = searchByNameLinear(productArray, query);
        System.out.println("Linear Search Result: " + (linearResult != null ? linearResult : "No match found"));

        Item binaryResult = searchByNameBinary(productArray, query);
        System.out.println("Binary Search Result: " + (binaryResult != null ? binaryResult : "No match found"));

        System.out.println("\nTime Complexity Analysis:");
        System.out.println("- Linear Search: O(n)");
        System.out.println("- Binary Search: O(log n) [on sorted data]");

        scanner.close();
    }
}


