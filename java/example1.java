class Task1 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Tasks1 is running: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Task1 interrrupted!");
            }
        }
    }
}

public class example1 {
    public static void main(String[] args) {
        Task1 t1 = new Task1();
        t1.start();
        for (int i = 1; i <= 5; i++) {
            System.out.println("Main Thread: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted!");
            }
        }
    }

}
