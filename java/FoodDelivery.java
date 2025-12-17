class OrderThread extends Thread {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Order received..." + i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}

class CookingThread extends Thread {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Cooking food..." + i);
            try {
                Thread.sleep(500);
            } catch (Exception e) { //exam me Exception e nhi likhna hai uske jagah jo bhi perticular exception hoga usko likhna hai.
            }
        }
    }
}

public class FoodDelivery {
    public static void main(String[] args) throws InterruptedException{
        OrderThread order = new OrderThread();
        CookingThread cook = new CookingThread();

        order.start();
        order.join();
        cook.start();
        cook.join();
        
    }
}
