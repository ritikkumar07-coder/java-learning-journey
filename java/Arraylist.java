import java.util.*;
public class Arraylist {
    public static void main(String[] args) {
        List<String> friends = new ArrayList<>();

        // CRUD
        // Add elements
        friends.add("Aman");
        friends.add("Riya");
        friends.add("Aman"); // diplicates allowed

        System.out.println("List: " + friends);

        friends.add(1, "Kabir");
        System.out.println("After inserting: " + friends);

        System.out.println("Friend at 2: " + friends.get(2));

        // //updatae element
        // friends.set(0, "Arjun");
        // System.out.println("After update: " + friends);

        // // //Insert at index
        // friends.set(0, "Arjun");
        // System.out.println("After set: " + friends);

        //Remove by value
        friends.remove("Aman");
        friends.remove("Aman");
        friends.remove("Aman");
        System.out.println("After remove:" + friends);

        // Search
        System.out.println("Contains Riya ? " + friends.contains(" RiyA")); //string concept
        System.out.println("After clear: " + friends);

        // clear
        friends.clear();
        System.out.println("After clear: " + friends);

        for(int i =0; i<friends.size(); i++){
            System.out.println(friends.get(i));
        }
    }
}
