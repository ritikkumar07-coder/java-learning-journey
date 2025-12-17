// 1
// public class helloworld {
//     public static void main(String[] args){
//         System.out.println("Hello world");
//         System.out.println("Welcome to java program");
        
//     }
    
// }

// 2
// public class helloworld{
//     public static void main(String []args){
//         System.out.printf("%s %s", "Welcome", "User\n");
//         String name = "Ritik";
//         String address = "Sohna";
//         String friend = "Ashish";
//         System.out.printf("Name: %s\nAddress: %s\nFriend name: %s", name,address,friend );
//     }
// }

// 3
// public class helloworld{
//     public static void main(String[] args) {
//         System.out.println("Name: Ritik\n Address: Sohna\n Friend name: Ashish\n");
//     }
// }

// 4
// public class helloworld{
//     public static void main(String[] args){
//         int number = 07;
//         System.out.printf("The number is: %s" ,number);
//     }
// }


// 5
// public class helloworld {
//     public static void main(String[] args) {
//         float realnumber = 45.7f;
//         System.out.printf("the real number is : %s" , realnumber);
//     }
// }

// 6
// public class helloworld{
//     public static void main(String[]args){
//         int num1 = 54;
//         int num2 = 45;
//         System.out.printf("The Number 1 is : %s\n", num1);
//         System.out.printf("The Number 2 is : %s",num2);
//     }
// }

// 7
// import java.util.*;

// public class printinteger{
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.printf("Enter a number: ");
//         int num = sc.nextInt();

//         System.out.printf("The number is: %s",num);
//     }
// }

// 8
import java.util.*;

public class printrealnumber{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
         System.out.println("Enter a real number: ");
        float realnumber = sc.nextFloat();
        System.out.printf("The real number is : %s",realnumber);
        
    }
}