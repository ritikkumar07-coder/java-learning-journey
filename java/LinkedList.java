// queue stack--> stack means "ek ke upar ek"  lifo (last in first out)
//                queue--> jo phle aya hai phle bahar bhi wahi niklega


// for dequeue--> jab koi queue bahar niklta hai (The first person in the billing line pays and leaves.)
// for enqueue--> You walk to the billing counter.There is a line of people.You go and stand at the 'back of the line'.



// LinkedList --> every value is connected to the next one 
// (matlab agar ek linkedlist hai jisem 5 values hai to 1 ke pass 2 ka address hoga or 2 ke pass 3 ka aise chlta rhega..)


// import java.util.*;

// public class LinkedList {
//     public static void main(String[] args) {
//         List<Integer> numbers = new LinkedList<>();

//         numbers.add(10);
//         numbers.add(20);
//         numbers.add(30);
//         System.out.println("List: " + numbers);

//         LinkedList<Integer> ll = (LinkedList<Integer>) numbers;
//         ll.addFirst(5);
//         ll.addLast(40);

//         System.out.println("After operatons: " + ll);

//         ll.removeFirst();
//         System.out.println("After removeFirst: " + ll);

//     }
// }  ----> this code is also right..

import java.util.*;

public class LinkedList {
    public static void main(String[] args) {
        java.util.LinkedList<Integer> numbers = new java.util.LinkedList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        System.out.println("List: " + numbers);

        numbers.addFirst(5);
        numbers.addLast(40);

        System.out.println("After operations: " + numbers);

        numbers.removeFirst();
        System.out.println("After removeFirst: " + numbers);

        for(int i = 0; i < numbers.size(); i++){
            System.out.println(numbers.get(i));
        }
    }
}
