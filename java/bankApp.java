import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

interface BankServices {
    void changePassword(Scanner sc);

    void changePin(Scanner sc);
}

abstract class Bankaccount implements BankServices {
    private long AccountNumber;
    private String fullName;
    private String firstName;
    private String dob;
    private int age;
    private String guardianName;
    private String guardianRelation;
    private double balance;
    private String password;
    private String pin;
    private List<String> transactions = new ArrayList<>();
    protected static int accountCount = 0;

    // constructors
    public Bankaccount() {
        this.AccountNumber = generateAccountNumber();
        accountCount++;
    }

    public Bankaccount(String fullName, String dob) {
        this(); // call default constructor
        this.fullName = fullName.trim();
        this.firstName = extractFirstName(fullName);
        this.dob = dob;
        this.age = calculateAgeFromDOB(dob);
        if (this.age < 18) {
            // guardian will be set by caller
        }
        this.balance = 0.0;
    }

    protected long generateAccountNumber() {
        // generate 8- digit random account number
        return ThreadLocalRandom.current().nextLong(10000000L, 100000000L);
    }

    private String extractFirstName(String fullName) {
        String[] parts = fullName.trim().split("\\s+");
        return parts.length > 0 ? parts[0] : fullName;
    }

    private int calculateAgeFromDOB(String dob) {
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birth = LocalDate.parse(dob, fmt);
            LocalDate now = LocalDate.now();
            return (int) ChronoUnit.YEARS.between(birth, now);
        } catch (Exception ex) {
            return 0; // invalid format caller should ensure valid DOB
        }
    }

    protected void addTransaction(String txn) {
        transactions.add(txn);
    }

    // Abstract methods
    public abstract void deposite(double amount);

    public abstract void withdraw(double amount);

    public abstract void checkBalance();

    // overloaded deposite with purpose
    public void deposite(double amount, String description) {
        deposite(amount);
        addTransaction("Deposit: " + amount + " | " + description + " | Date: " + LocalDateTime.now());
    }

    public void withdraw(double amount, String purpose) {
        withdraw(amount);
        addTransaction("Withdraw: " + amount + " | " + purpose + " | Date: " + LocalDateTime.now());
    }

    // Encapsulation: getters and setters with validations
    public long getAccountNumber() {
        return AccountNumber;
    }

    public String getFullname() {
        return fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDob() {
        return dob;
    }

    public int getAge() {
        return age;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public String getGuardianRelation() {
        return guardianRelation;
    }

    public double getBalance() {
        return balance;

    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPin() {
        return pin;
    }

    protected void setPin(String pin) {
        this.pin = pin;
    }

    public List<String> getTransaction() {
        return transactions;
    }

    public static int getAccountCount() {
        return accountCount;
    }

    public void setGuardian(String name, String relation) {
        
        this.guardianName = name;
        this.guardianRelation = relation;
    }

    public void displayAccountDetails() {
        System.out.println("=== Account Details ===");
        System.out.println("Account Number: " + getAccountNumber());
         System.out.println("Name (Displayed): " + getFirstName()); // only first name visible
         System.out.println("DOB: " + getDob());
         System.out.println("Age: " + getAge());
         if (getAge() < 18) {
             System.out.println("Guardian: " + getGuardianName() + "(" + getGuardianRelation() + ")");
         }
         System.out.println("Balance: INR" + String.format("%.2f", getBalance()));
     }

    public void showLastNTransactions(int n) {
        System.out.println("=== Last " + n + " Transactions ===");
        int size = transactions.size();
        if (size == 0) {
            System.out.println("No transaction yet.");
            return;
        }
        int start = Math.max(0, size - n);
        for (int i = start; i < size; i++) {
            System.out.println(transactions.get(i));
        }
    }

    // interface implementations
    @Override
    public void changePassword(Scanner sc) {
        System.out.println("Change Password:");
        while (true) {
            System.out.println("Enter a new password: ");
            String newPass = sc.nextLine();
            if (bankApp.isValidPassword(newPass)) {
                setPassword(newPass);
                System.out.println("Password updated successfully.");
                addTransaction("Password changed on " + LocalDateTime.now());
                break;
            } else {
                System.out.println("Password does not meet complexity requirments . Try again.");
            }
        }
    }

    @Override
    public void changePin(Scanner sc) {
        System.out.println("Change PIN:");
        while (true) {
            System.out.println("Enter new 4-digit PIN: ");
            String newPin = sc.nextLine().trim();
            if (bankApp.isValidPin(newPin, this.getDob())) {
                setPin(newPin);
                System.out.println("PIN updated successfully.");
                addTransaction("PIN changed on " + LocalDateTime.now());
                break;
            } else {
                System.out.println("Invalid PIN. it must be 4 digits and not match");
            }
        }
    }
}

// finally keyword (after mid term) , throw and throws keyword
// Savings Account with minimum balance & interest
class SavingsAccount extends Bankaccount {
    private static final double MIN_BALANCE = 500.0;
    private double interestRate = 4.0;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(String fullName, String dob) {
        super(fullName, dob);
    }

    @Override
    public void deposite(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        setBalance(getBalance() + amount);
        addTransaction("Deposit: " + amount + "| Date: " + LocalDateTime.now());
        System.out.println("INR" + amount + "deposited. New balance: INR" + String.format("%.2f", getBalance()));
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return;
        }
        if (getBalance() - amount < MIN_BALANCE) {
            System.out.println("Withdrawal denied. Savings account must maintain minimun balance of INR" + MIN_BALANCE);
            return;
        }
        if (getBalance() - amount < MIN_BALANCE) {
            System.out.println("Withdrawl denied. Savingd account must maintain minimum balance of INR" + MIN_BALANCE);
            return;
        }
        setBalance(getBalance() - amount);
        addTransaction("Withdraw: INR" + amount + "Date: " + LocalDateTime.now());
        System.out.println("INR" + amount + "Withdrawn. New balance: INR" + String.format("%.2f", getBalance()));

    }

    @Override
    public void checkBalance() {
        System.out.println("Current Savings Balance: INR" + String.format("%.2f", getBalance()));
        addTransaction("Balance inquiry on " + LocalDateTime.now());
    }

    @Override
    public String toString() {
        return " SavingAccount";
    }

    public void applySimpleIterest(int years) {
        if (years <= 0)
            return;
        double principal = getBalance();
        double interest = (principal * interestRate * years) / 100.0;
        setBalance(getBalance() + interest);
        addTransaction("Interest applied: INR" + interest + " for " + " years " + years);
        System.out.println("Interest INR" + String.format("%.2f", interest) + " added. New balance: INR"
                + String.format("%2f", getBalance()));
    }

}

// Current account with overdraft
class CurrentAccount extends Bankaccount {
    private static final double OVERDRAFT_LIMIT = 5000.0;

    public CurrentAccount() {
        super();
    }

    public CurrentAccount(String fullName, String dob) {
        super(fullName, dob);
    }

    @Override
    public void deposite(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        setBalance(getBalance() + amount);
        addTransaction("Deposit: INR" + amount + " | Date: " + LocalDateTime.now());
        System.out.println("INR" + amount + " deposited. New balance: INR" + String.format("%2f", getBalance()));

    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
            return;
        }
        if (getBalance() - amount < -OVERDRAFT_LIMIT) {
            System.out.println("Withdrawal denied. Ecceeds iverdraft limit of INR" + OVERDRAFT_LIMIT);
            return;
        }
        setBalance(getBalance() - amount);
        addTransaction("withdraw: INR" + amount + "| Date: " + LocalDateTime.now());
        System.out.println("INR" + amount + "withdrawn. New Balance: INR" + String.format("%2f", getBalance()));

    }

    @Override
    public void checkBalance() {
        System.out.println("Current Account Balance: INR" + String.format("%.2f", getBalance()));
        addTransaction("Balance inquiry on " + LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "CurrentAccount";
    }
}

public class bankApp {
    private static Scanner SC = new Scanner(System.in);

    // Password validation: min 8 chars, 1 uppercase, 1 lowercase, 1 digit, 1
    // special char
    public static boolean isValidPassword(String pwd) {
        if (pwd == null || pwd.length() < 8)
            return false;
        boolean upper = false, lower = false, digit = false, special = false;
        for (char C : pwd.toCharArray()) {
            if (Character.isUpperCase(C))
                upper = true;
            else if (Character.isLowerCase(C))
                lower = true;
            else if (Character.isDigit(C))
                digit = true;
            else
                special = true;
        }
        return upper && lower && digit && special;
    }

    // PIN validation: 4 digits, not DDMM, not MMDD, not YYYY form DOB
    public static boolean isValidPin(String pin, String dob) {
        if (pin == null || !pin.matches("\\d{4}"))
            return false;
        // if DOB is not provided or not in expected dd/MM/yyyy form, only digit-check is used
        if (dob == null || !dob.matches("\\d{2}/\\d{2}/\\d{4}"))
            return true;

        String dd = dob.substring(0, 2);
        String mm = dob.substring(3, 5);
        String yyyy = dob.substring(6, 10);

        String ddmm = dd + mm;
        String mmdd = mm + dd;
        String yy = yyyy; // 4-digit year

        if (pin.equals(ddmm) || pin.equals(mmdd) || pin.equals(yy)) {
            return false;
        }
        return true;
    }

    // Helper to read non-empty line
    private static String readNonEmptyLine(String propmt) {
        String line;
        do {
            System.out.println(propmt);
            line = SC.nextLine().trim();
        } while (line.isEmpty());
        return line;
    }

    // DOB validation
    private static boolean isValidDOB(String dob) {
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate birth = LocalDate.parse(dob, fmt);
            // reasonable DOB check: not in future and year > 1980
            return !birth.isAfter(LocalDate.now()) && birth.getYear() > 1900;
        } catch (Exception ex) {
            return false;
        }
    }

    // Create account flow
    private static Bankaccount createAccount() {
        System.out.println("=== Create New Account ===");
        String fullName = readNonEmptyLine("Enter full name: ");
        String dob;
        while (true) {
            dob = readNonEmptyLine("Enter Date of Birth (dd/MM/yyyy): ");
            if (isValidDOB(dob))
                break;
            System.out.println("Invalid DOB format or unrealistic date. Please enter again.");
        }

        // Calculate age
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birth = LocalDate.parse(dob, fmt);
        int age = (int) ChronoUnit.YEARS.between(birth, LocalDate.now());

        String accType;
        while (true) {
            System.out.println("Choose account type (1 - Savings, 2 - Current): ");
            String choice = SC.nextLine().trim();
            if (choice.equals("1")) {
                accType = "Savings";
                break;
            } else if (choice.equals("2")) {
                accType = "Current";
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        Bankaccount account;
        if (accType.equals("Savings")) {
            account = new SavingsAccount(fullName, dob);
        } else {
            account = new CurrentAccount(fullName, dob);
        }

        if (age < 18) {
            System.out.println("Applicant is a minor (age " + age + "). Guardian details required.");
            String gname = readNonEmptyLine("Enter guardian/adult Name: ");
            String gRelation = readNonEmptyLine("Enter relation with guardian/adult: ");
            account.setGuardian(gname, gRelation);
        }

        // Password setyp loop
        while (true) {
            System.out.println("Set a password (min 8 chars, 1 uppercase, 1 lowercase, 1 digit, 1 special): ");
            String pwd = SC.nextLine();
            if (isValidPassword(pwd)) {
                account.setPassword(pwd);
                break;
            } else {
                System.out.println("Password doesn't meet comlexity requirements. Try again.");

            }
        }

        // PIN setup loop
        while (true) {
            System.out.println("Set a 4-digit PIN (must not equal DDMM, MMDd, or YYYY of DOB): ");
            String pin = SC.nextLine().trim();
            if (isValidPin(pin, dob)) {
                account.setPin(pin);
                break;
            } else {
                System.out.println("Invalid PIN - cannot be DOB patterns. Try again.");
            }
        }

        System.out.println("Account Successfully created!");
        account.addTransaction("Account created on " + LocalDateTime.now());
        account.displayAccountDetails();
        return account;
    }

    // Authentication: allow 3 attempts for (password + pin)
    private static boolean authenticate(Bankaccount account) {
        if (account == null)
            return false;
        int attempts = 0;
        while (attempts < 3) {
            System.out.println("Enter password: ");
            String pwd = SC.nextLine();
            System.out.println("Enter 4-digit PIN: ");
            String pin = SC.nextLine().trim();
            if (pwd.equals(account.getPassword()) && pin.equals(account.getPin())) {
                account.addTransaction("Successful login on " + LocalDateTime.now());
                return true;
            } else {
                attempts++;
                System.out.println("Invalid credentials. Attmepts left: " + (3 - attempts));
                account.addTransaction("Failed login attempt on " + LocalDateTime.now());
            }
        }
        System.out.println("Account locked due to 3 failed attempts.");
        account.addTransaction("Account locked after 3 failed attempts on " + LocalDateTime.now());
        return false;
    }

    private static void showMenu(Bankaccount account) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Transaction Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Change Password");
            System.out.println("5. Change PIN");
            System.out.println("6. View Account Details (first name shown)");
            System.out.println("7. Show last 5 transactions");
            System.out.println("8. Apply interest (Savings only)");
            System.out.println("9. Exit");
            System.out.println("Choose option: ");
            String opt = SC.nextLine().trim();
            switch (opt) {
                case "1":
                    System.out.println("Enter amount to deposit: ");
                    try {
                        double amt = Double.parseDouble(SC.nextLine());
                        System.out.println("optional description (press enter to skip): ");
                        String desc = SC.nextLine();
                        if (desc.trim().isEmpty())
                            account.deposite(amt);
                        else
                            account.deposite(amt, desc);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Incvalid amount.");
                    }
                    break;
                case "2":
                    System.out.println("Enter amount to withdraw; ");
                    try {
                        double wamt = Double.parseDouble(SC.nextLine());
                        System.out.println("Optional purpose (press enter to skip): ");
                        String purp = SC.nextLine();
                        if (purp.trim().isEmpty())
                            account.withdraw(wamt);
                        else
                            account.withdraw(wamt, purp);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case "3":
                    account.checkBalance();
                    break;
                case "4":
                    account.changePassword(SC);
                    break;
                case "5":
                    account.changePin(SC);
                    break;
                case "6":
                    account.displayAccountDetails();
                    break;
                case "7":
                    account.showLastNTransactions(5);
                    break;
                case "8":
                    if (account instanceof SavingsAccount) {
                        System.out.println("Enter number of years to apply simple interest: ");
                        try {
                            int yrs = Integer.parseInt(SC.nextLine());
                            ((SavingsAccount) account).applySimpleIterest(yrs);
                        } catch (NumberFormatException nfe) {
                            System.out.println("Invalid number.");
                        }

                    } else {
                        System.out.println("interest application is only for Savings Account.");
                    }
                    break;
                case "9":
                    System.out.println("Exiting. Thank you!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid menu option.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Bank Account Management System (Demo)\n");
        List<Bankaccount> accounts = new ArrayList<>();
        while (true) {
            System.out.println("\nMain Menu: ");
            System.out.println("1. Create Account");
            System.out.println("2. Login to Account");
            System.out.println("3. Show total accounts created");
            System.out.println("4. Exit");
            System.out.println("Choose option: ");
            String choice = SC.nextLine().trim();
            switch (choice) {
                case "1":
                    Bankaccount acc = createAccount();
                    accounts.add(acc);
                    break;
                case "2":
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts found. Please create an account first.");
                        break;
                    }
                    System.out.print("Enter account number to login: ");
                    String accNumStr = SC.nextLine().trim();
                    try {
                        long accNum = Long.parseLong(accNumStr);
                        Bankaccount found = null;
                        for (Bankaccount a : accounts) {
                            if (a.getAccountNumber() == accNum) {
                                found = a;
                                break;
                            }
                        }
                        if (found == null) {
                            System.out.println("Account not found.");
                            break;
                        }
                        if (authenticate(found)) {
                            // After successful auth -> show menu
                            showMenu(found);
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("Invalid account number foramt.");
                    }
                    break;
                case "3":
                    System.out.println("Total accounts created: " + Bankaccount.getAccountCount());
                    break;
                case "4":
                    System.out.println("Application terminating. Goodbye.");
                    SC.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
