import java.util.*;
public class studentmarksmanager {
    public static void main(String[] args) {
        List<Integer> Marks = new ArrayList<>();

        Marks.add(46);
        Marks.add(34);
        Marks.add(20);
        Marks.add(40);
        Marks.add(15);

        System.out.println("Marks: " + Marks);

        // update
        Marks.set(2, 37);
        System.out.println("After update: " + Marks);

        // remove
        Marks.remove(4);
        System.out.println("After removing the lowest marks: " + Marks);

        // final list
        System.out.println("Final list: " + Marks);
    }
}
