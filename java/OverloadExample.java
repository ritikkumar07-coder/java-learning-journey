// public class OverloadExample {
//     void display(int a){
//         System.out.println("Integer: " + a);
//     }
//     void display(String b){
//         System.out.println("String: " + b);
//     }
//     public static void main(String[] args) {
//         OverloadExample obj = new OverloadExample();
//         obj.display(10);
//         obj.display("Ritik");
//     }
// }

import java.util.Scanner;
public class OverloadExample {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number: ");
        double a = sc.nextDouble();

        System.out.println("Enter second number: ");
        double b = sc.nextDouble();

        System.out.println("Enter operation: - , + , * , / ");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+':
                System.out.println("Addition: " + (a + b));
                break;
            case '-':
                System.out.println("subtraction: " + (a - b));
                break;
            case '*':
                System.out.println("Multiplication: " + (a*b));
                break;
            case '/':
                if (b != 0 ) {
                    System.out.println("Divide: " + (a/b));
                }else{
                    System.out.println("zero cannot be divide ");
                }
                break;
            default:
                System.out.println("Invalid");
        }
    }
}