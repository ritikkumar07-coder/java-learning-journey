import java.util.*;
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        set.add("java");
        set.add("Python");
        set.add("java");//ignored duplicate
        set.add("C++");
        System.out.println(set); //order not guarenteed

        System.out.println("Contains java?" + set.contains("java"));

        set.remove("snake");
        System.out.println("After remove: " + set);

    }
    
}
