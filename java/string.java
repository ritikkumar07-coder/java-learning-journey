// import java.util.Scanner;

// public class practice {
//     public static void main(String[] args) {
//         System.out.println("Taking the user input");
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter number 1");
//         int a = sc.nextInt();
//         System.out.println("Enter number 2");
//         int b = sc.nextInt();
//         int sum = a + b;
//         System.out.println("The sum of these numbers is : " + sum);
//     }

// }

// import java.util.Scanner;

// public class practice {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter maths marks: ");
//         float maths = sc.nextFloat();
//         System.out.println("Enter physics marks: ");
//         float physics = sc.nextFloat();
//         System.out.println("Enter chemistry marks: ");
//         float chemistry = sc.nextFloat();
//         System.out.println("Enter english marks: ");
//         float english = sc.nextFloat();
//         System.out.println("Enter hindi marks: ");
//         float hindi = sc.nextFloat();

//         float percentage = ((maths + physics + chemistry + english + hindi )/ 500.0f) * 100;

//         System.out.println("Percentage: ");
//         System.out.println(percentage);
//     }
// }

// public class practice{
//     public static void main(String[] args){
//         // int a = 45;
//         // int b = 34;
//         // int c = 75;
//         // int sum = (a + b + c);
//         // System.out.println("the total sum of numbers are: "+ sum);

//          int subject1 = 87;
//          int subject2 = 97;
//          int subject3 = 86;
//          float cgpa = (subject1 + subject2 + subject3)/30.0f;
//          System.out.println(cgpa);
//     }
// }

// import java.util.Scanner;

// public class practice{
//     public static void main(String [] args){
//         System.out.println("Enter your name: ");
//         Scanner sc = new Scanner(System.in);
//         String name = sc.next();
//         System.out.println("Hello " + name + " Have a good day");
//     }
// }

// public class practice{
//     public static void main(String [] args){
//         String name = "Ritik";
//         String address = "sohna";
//         String friendname = "Ashish";

//         System.out.printf("Name : %s\nAddress : %s\nFriend's Name : %s",name,address,friendname);
//     }
// }

// import java.util.*;

// class Greeting{
//     void greetuser(){
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Welcome to our bank!");
//         System.out.println("are you a new customer or regular customer?");
//         String customerType = sc.nextLine();
//         System.out.println("are you interested or not ? yes/ no" );
//         String interestType = sc.nextLine();
//         System.out.println("thank you for your response ");
//         System.out.println("customer type is : " + customerType);
//         System.out.println("interest type is : " +interestType)
//     }
// }

import java.util.Scanner;


public class string{
    public static void main(String[] args) {
        // int a = 5;
        // float b = 8.98f;
         
        // System.out.printf("The value of a is %s and value of b is %f", a,b);

        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        System.out.println(st);
    }
}