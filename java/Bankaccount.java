import java.util.*;


class Greeting {
    Scanner sc = new Scanner(System.in);
    String customerType;

    void greetuser() {
        System.out.println("Welcome to our bank!");
        System.out.println("Are you a new customer or regular customer?");
        customerType = sc.nextLine();

        if (customerType.equalsIgnoreCase("regular")) {
            System.out.println("Welcome back! We are happy to help you again.");
        } else if (customerType.equalsIgnoreCase("new")) {
            System.out.println("Welcome! You are a new customer, let me help you to open a new account.");
        } else {
            System.out.println("Invalid! Please choose 'Regular' or 'New'.");
        }
    }
}

class PersonalDetails extends Greeting {
    String dob;
    int age;

    void details() {
        System.out.println("What is your name? ");
        String name = sc.nextLine();

        System.out.println("What is your Gender? ");
        String gender = sc.nextLine();
        if (gender.equalsIgnoreCase("Male")) {
            System.out.println("Hello Sir, Glad to have you here!");
        } else if (gender.equalsIgnoreCase("Female")) {
            System.out.println("Hello Ma'am, Glad to have you here!");
        } else {
            System.out.println("Hello, glad to have you here!");
        }

        System.out.println("Enter your Date of Birth (ddmmyyyy): ");
        dob = sc.nextLine();

        System.out.println("What is your Age?: ");
        age = sc.nextInt();
        sc.nextLine();

        if (age < 13) {
            System.out.println("You are a child.");
        } else if (age <= 18) {
            System.out.println("You are a teenager.");
        } else if (age <= 30) {
            System.out.println("You are an adult. You can open your account for your personal work.");
        } else if (age <= 50) {
            System.out.println("You are a middle-aged adult. You can open your bank account for savings.");
        } else {
            System.out.println("You are a senior citizen.");
        }
    }
}

class AccountType extends PersonalDetails {
    void type() {
        System.out.println("Which type of Account do you want to open?");
        System.out.println("1 - Saving Account \n2 - Current Account");
        String type = sc.nextLine();

        if (type.equalsIgnoreCase("Saving Account")) {
            System.out.println("You have selected Saving Account. It helps you save money and earn interest.");
        } else if (type.equalsIgnoreCase("Current Account")) {
            System.out.println("You have chosen Current Account. It is mainly used for daily business transactions.");
        } else {
            System.out.println("Invalid choice! Please select Saving or Current Account.");
        }
    }
}

class Password extends AccountType {
    void createPinAndPassword() {
        System.out.println("Create a 4-digit PIN: ");
        String pin = sc.nextLine();

        if (pin.length() == 4 && pin.matches("[0-9]+")) {
            if (dob.contains(pin)) {
                System.out.println("You cannot use your DOB as your PIN!");
                String dob = sc.nextLine();
                if(pin.equals(dob)){
                    System.out.println("Please Re-enter your password:");
                }
                return;
            }
            System.out.println("PIN created successfully!");
        } else {
            System.out.println("Invalid PIN! Must contain exactly 4 digits.");
            return;
        }

        System.out.println("Create a strong password: ");
        String password = sc.nextLine();

        if (dob.contains(password)) {
            System.out.println(" You cannot use your DOB as your password!");
        }else{
            boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

            for(char ch : password.toCharArray()){
                if(Character.isUpperCase(ch)) hasUpper = true;
                else if(Character.isLowerCase(ch)) hasLower = true;
                else if(Character.isDigit(ch)) hasDigit = true;
                else hasSpecial = true;
            }
            if (password.length() >8 && hasUpper && hasLower && hasDigit && hasSpecial){
                System.out.println("Password created successfully!");
            }else{
                System.out.println("Weak password! \nPassword must contain: ");
                System.out.println("Minimum 8 characters.");
                System.out.println("At least 1 uppercase letter!");
                System.out.println("At least 1 lowercase letter!");
                System.out.println("At least one number!");
                System.out.println("At least one special character!");
            }
        }

    }
}

class AccountCreated extends Password{
    void confirm(){
        System.out.println("Congratulation your account has been created successfully .");
        System.out.println("You can now use it for your transactions.");
    }
}

class RegularCustomer extends Greeting {
    void choice(){
        System.out.println("What would like to do? ");
        System.out.println("1 - Check Balance\n2 - Withdraw Money ");
        String choice = sc.nextLine();

        if(choice.equals("1")){
            System.out.println("Your current balance is : 10000");

        }else if(choice.equals("2")){
            System.out.println("Enter amount to withdraw; ");
            Double amount =sc.nextDouble();
            sc.nextLine();
            System.out.println("Rs." + amount + "withdrawn successfully."); 
        }else{
            System.out.println("Invalid choice!");
        }
    }
}

public class Bankaccount {
    public static void main(String[]args){
        Greeting g = new Greeting();
        g.greetuser();

        if(g.customerType.equalsIgnoreCase("new")){
            AccountCreated newCustomer = new AccountCreated();
            newCustomer.details();
            newCustomer.type();
            newCustomer.createPinAndPassword();
            newCustomer.confirm();
        }else if(g.customerType.equalsIgnoreCase("regular")){
            RegularCustomer rc = new RegularCustomer();
            rc.choice();
        }
    }
}