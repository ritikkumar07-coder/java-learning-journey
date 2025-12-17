//Sorted automatically(ascending)
//no duplicates
//slower
//Best for: leaderboard , sorted IDs
import java.util.*;
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(50);
        ts.add(10);
        ts.add(30);

        System.out.println(ts);
    }
}
