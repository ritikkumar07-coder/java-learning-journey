// import java.util.*;
// public class calculator {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the first number: ");
//         double num1 = sc.nextDouble();
//         System.out.println("Enter the second number: ");
//         double num2 = sc.nextDouble();
//         System.out.println("Enter the operators: '-' , '+' , '*' , '/' ");
//         char op = sc.next().charAt(0);

//         double result;
//         switch (op) {
//             case '+':
//                 result = num1 + num2;
//                 break;
//             case '-': 
//                 result = num1 - num2;
//                 break;
//             case '*':
//                 result = num1 * num2;
//                 break;
//             case '/':
//                 if(num2 !=0){
                    
//                     result = num1 / num2;
//                 }else{
//                     System.out.println("Error: division by zero.  ");
//                     return;
//                 }
//                 break;
            
//             default:
//             System.out.println("Invalid operator");
//                 return;
//             }
//             System.out.println("Result: " + result);
//             sc.close();
//     }

//     public String add(double x, double y, int r) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'add'");
//     }
// }

import java.util.Scanner;

public class CalculatorApp2{
    public int add(int a , int b){
        return a + b;
    }
    public double add(double a ,double b){
        return a + b;
    }
    public int add(int a , int b , int c){
        return a + b + c;
    }
    public int subtract(int a , int b){
        return a - b;
    }
    public double multiply(double a , double b){
        return a * b;
    }
    public double divide(double a , double b){
        if(b != 0){
            throw new ArithmeticException("Error! cannot divide 0.");
        }
        return (double) a / b;
    }

    private Scanner sc = new Scanner(System.in);

    public void addition(){
        System.out.println("Choose addition type: ");
        System.out.println("1. two integer");
        System.out.println("2. two double");
        System.out.println("3. three integer");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter first int: ");
                int a = sc.nextInt();
                System.out.print("ENter second int: ");
                int b = sc.nextInt();
                System.out.println("result: " + add(a,b));
                break;

            case 2:
                System.out.print("Enter first double: ");
                double x = sc.nextInt();
                System.out.print("ENter second double: ");
                double y = sc.nextInt();
                System.out.println("result: " + add(x,y));
                break;
            case 3:
                System.out.print("Enter first int: ");
                int p = sc.nextInt();
                System.out.print("ENter second int: ");
                int q = sc.nextInt();
                System.out.print("ENter third int: ");
                int r = sc.nextInt();
                System.out.println("result: " + add(p,q,r));
                break;        
            default:
                System.out.println("Invalid choice");
        }
    }

    public void subtraction(){
        System.out.print("Enter first int: ");
        int a = sc.nextInt();
        System.out.print("ENter second int: ");
        int b = sc.nextInt();
        System.out.println("result: " + subtract(a,b));
    }
    public void multiplication(){
        System.out.print("Enter first double: ");
        double a = sc.nextInt();
        System.out.print("ENter second double: ");
        double b = sc.nextInt();
        System.out.println("result: " + multiply(a,b));
    }
    public void division(){
        System.out.print("Enter first int: ");
        int a = sc.nextInt();
        System.out.print("ENter second int: ");
        int b = sc.nextInt();
         try {
            System.out.println("Result: " + divide(a, b));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mainmenu(){
        int choice ;
        do{
            System.out.println("welcome to calculator application");
            System.out.println("1. add numbers");
            System.out.println("2. subtract numbers");
            System.out.println("3. multiply numbers");
            System.out.println("4. divide numbers");
            System.out.println("5. exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addition(); 
                    break;
                case 2:
                    subtraction();
                    break;
                case 3:
                    multiplication();
                    break;
                case 4:
                    division();
                    break;
                case 5:
                    System.out.println("Exiting....thank you for using");
                    break;

            
                default:
                    System.out.println("invalid choice");
            }
        }while(choice!=5);
    }
    public static void main(String[] args) {
        CalculatorApp app = new CalculatorApp();
        app.mainmenu();;
    }


}