import java.util.Scanner;

// yaha se method overloading start kiya hai
public class CalculatorApp {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b != 0) {
            throw new ArithmeticException("Error: cannot divide by zero.");
        }
        return (double) a / b;
    }

    private Scanner sc = new Scanner(System.in);

    public void addition() {
        System.out.println("Choose Addition type: ");
        System.out.println("1. Two Integer");
        System.out.println("2. Double Integer");
        System.out.println("3. Three Integer");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter First Integer: ");
                int a = sc.nextInt();
                System.out.print("Enter Second Integer: ");
                int b = sc.nextInt();
                System.out.println("Result: " + add(a, b));
                break;
            case 2:
                System.out.print("Enter First Double: ");
                double x = sc.nextDouble();
                System.out.print("Enter Second Double: ");
                double y = sc.nextDouble();
                System.out.println(" Result: " + add(x, y));
                break;
            case 3:
                System.out.print("Enter First Integer: ");
                int p = sc.nextInt();
                System.out.print("Enter Second Integer: ");
                int q = sc.nextInt();
                System.out.print("Enter Third Integer: ");
                int r = sc.nextInt();
                System.out.println("Result: " + add(p, q, r));
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public void subtraction() {
        System.out.print("Enter First Integer: ");
        int a = sc.nextInt();
        System.out.print("Enter Second Integer: ");
        int b = sc.nextInt();
        System.out.println("Result: " + subtract(a, b));
    }

    public void multiplication() {
        System.out.print("Enter First Double: ");
        double a = sc.nextInt();
        System.out.print("Enter Second Double: ");
        double b = sc.nextInt();
        System.out.println("Result: " + multiply(a, b));
    }

    public void division() {
        System.out.print("Enter Dividend: ");
        int a = sc.nextInt();
        System.out.print("Enter Divisor: ");
        int b = sc.nextInt();
        try {
            System.out.println("Result: " + divide(a, b));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mainmenu() {
        int choice;
        do {
            System.out.println("\nWelcome to Calculator App! ");
            System.out.println("1. Add Numbers");
            System.out.println("2. SUbtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            System.out.println("Enter your Choice: ");
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
                    System.out.println("Exiting! Thank you for using this app.");
                    break;
                default:
                    System.out.println("Invalid choice!");

            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        CalculatorApp app = new CalculatorApp();
        app.mainmenu();
    }
}