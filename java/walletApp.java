import java.time.LocalDateTime;
import java.util.*;

interface Walletservices{
    void changePassword(Scanner sc);
    void changePin(Scanner sc);
}

abstract class MobileWallet implements Walletservices{
    protected long walletId;
    protected String name,password,pin;
    protected double balance = 0;
    protected List<String> txns = new ArrayList<>();
    protected static int count = 0;

    public MobileWallet (String name){
        this.walletId= (long) (Math.random()* 90000000 + 10000000);
        this.name = name;
        count++;
        txns.add("Wallet created on " + LocalDateTime.now());
    }

    public abstract void addMoney(double amt);
    public abstract void recharge(double amt);

    public void showBalance(){
        System.out.println("Balance: Rs" + balance);
    }

    public void showTxns(){
        if(txns.isEmpty())
            System.out.println("No Transactions!");
        else
            txns.forEach(System.out::println);
    }

    @Override
    public void changePassword(Scanner sc){
        System.out.print("New Password");
        password = sc.next();
        txns.add("Password changed on: " + LocalDateTime.now());
    }

    @Override
    public void changePin(Scanner sc){
        while (true) {
            System.out.println("New 4-digit Pin");
            String p = sc.next();
            if (p.matches("\\d{4}")) {
                pin = p;
                txns.add("Pin changed on: " + LocalDateTime.now());
                break;
            }else{
                System.out.println("Pin must be exactly 4 digit!");
            }
        }
    }
}

//prepaid wallet
class PrepaidWallet extends MobileWallet{
    public PrepaidWallet(String name){
        super(name);
    }

    @Override
    public void addMoney(double amt){
        if(amt <= 0)
            return;
        balance += amt;
        txns.add("Money added: " + amt);
    }

    @Override
    public void recharge(double amt){
        if(amt > balance){
            System.out.println("Insufficient balance!");
        return;
        }
        balance-= amt;
        txns.add("Recharge: " + amt);
    }
}

 //Postpaid wallet
class PostpaidWallet extends MobileWallet {
    private final double LIMIT = 1000;

    public PostpaidWallet(String name){
        super(name);

    }

    @Override
    public void addMoney(double amt){
        balance+= amt;
        txns.add("Bill paid: " + amt);
    }

    @Override
    public void recharge(double amt){
        if(balance - amt < -LIMIT){
            System.out.println("Credit limit exceeds!");
            return;
        } 
        balance-= amt;
        txns.add("Recharge: " + amt);
    }
}
// Main class

public class walletApp{
    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        List<MobileWallet> list = new ArrayList<>();

        System.out.print("Loading");
        for(int i = 0; i < 3; i++){
            Thread.sleep(400);
            System.out.print(".");
            
        }
        
        System.out.println("\n\n======================================");
        System.out.println(" WELCOME TO DIGITAL WALLET SYSTEM ");
        System.out.println("======================================");
        System.out.println("Date & Time: " + LocalDateTime.now());
        System.out.println("Safe . Fast . Secure Transaction");
        System.out.println("======================================");

        while (true) {
            System.out.println("\n-------- MAIN MENU --------");
            System.out.println("1.Creat Wallet");
            System.out.println("2.Login to Wallet");
            System.out.println("3.Show Total Users");
            System.out.println("4.Exit");
            System.out.print("Enter your choice: ");

            int ch = sc.nextInt();

            if(ch == 1){
                System.out.print("Enter Name: ");
                String name = sc.next();

                System.out.print("Select Type (1.Prepaid  2.Postpaid)");
                int type = sc.nextInt();

                MobileWallet w = (type == 1)
                        ? new PrepaidWallet(name)
                        : new PostpaidWallet(name);


                System.out.print("Set Password: ");
                w.password = sc.next();

                while (true) {
                    System.out.print("Set 4-digit PIN: ");
                    String p = sc.next();
                    if(p.matches("\\d{4}")){
                        w.pin = p;
                        break;
                    }else{
                        System.out.println("PIN must be exactly 4 digit!");
                    }
                }
                list.add(w);
                System.out.println("\n Wallet created successfully!");
                System.out.println("Your Wallet ID: " + w.walletId);
            }
            else if(ch == 2){
                System.out.print("Enter Wallet ID: ");
                long id = sc.nextLong();

                MobileWallet user = null;
                for(MobileWallet w : list)
                    if(w.walletId == id)
                        user = w;
                if(user == null){
                    System.out.println("Wallet not found!");
                    continue;
                }
                int attempts = 3;
                boolean success = false;

                while (attempts > 0) {
                    System.out.print("Enter Password: ");
                    String pass = sc.next();

                    System.out.println("Enter Pin: ");
                    String pin = sc.next();

                    if(pass.equals(user.password) && pin.equals(user.pin)){
                        success = true;
                        break;
                    }else{
                        attempts--;
                        System.out.println("Wrong login! Attempts left: " + attempts);
                    }
                }
                if(!success){
                    System.out.println("Account Locked after 3 Failed Attmepts!");
                    continue;
                }

                while (true) {
                    System.out.println("\n------USER MENU------");
                    System.out.println("1.Add Money");
                    System.out.println("2.Recharge");
                    System.out.println("3.Cheak Balance");
                    System.out.println("4.View transactions");
                    System.out.println("5.Change Password");
                    System.out.println("6.Change Pin");
                    System.out.println("7.Logout");
                    System.out.print("Choose Option: ");

                    int op = sc.nextInt();

                    if (op == 1 ){
                        System.out.println("Enter Amount: ");
                        user.addMoney(sc.nextDouble());
                    }
                    else if (op == 2){
                        System.out.println("Enter Recharge Amount: ");
                        user.recharge(sc.nextDouble());
                    }
                    else if (op == 3){
                        user.showBalance();
                    }
                    else if (op == 4){
                        user.showTxns();
                    }
                    else if (op == 5){
                        user.changePassword(sc);
                    }
                    else if (op == 6){
                        user.changePin(sc);
                    }else{
                        System.out.println("Logged out successfully!");
                        break;
                    }
                }
            }
            else if (ch == 3){
                System.out.println("Total Users: " + MobileWallet.count);
            }
            else{
                System.out.println("Thank you for using Digital Wallet! ");
                return;
            }
        }
    }
}