import java.util.*;
public class GroceryList {
    public static void main(String[] args) {
        List<String> grocery = new ArrayList<>();

        grocery.add("Milk");
        grocery.add("Sugar");
        grocery.add("Rice");
        grocery.add("Vegitables");
        grocery.add("Eggs");
        grocery.add("cooking oil");
        grocery.add("Eggs");

        System.out.println("Grocery items: " + grocery);

        // search
        System.out.println("Contains Milk ? " + grocery.contains("Milk"));

        // count total items
        System.out.println("Total items: " + grocery.size());

        // Remove the duplicate item
        grocery.remove("Eggs");
        System.out.println("After remove: " + grocery);

        // print the sorted list
        Collections.sort(grocery);
        System.out.println("Sorted list: " + grocery);
        
    }
}
