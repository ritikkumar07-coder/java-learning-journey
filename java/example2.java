class Task2 implements Runnable{
    public void run(){
        for(int i=1; i<=3; i++){
            System.out.println("Runnable Thread: " + i);
            try{
                Thread.sleep(700);
            }
            catch(InterruptedException e ){
                System.out.println("Runnable Thread interrupted!");
            }
        }
    }
}
public class example2 {
    public static void main(String[] args) {
        Thread t = new Thread(new Task2()); //inner class (have to study) -->class ke andar uske variable ke sath khud ka class add kr skte hai .
        t.start();
        for(int i = 1; i<=3; i++){
            System.out.println("Main Thread Working: " + i);
        }
    }
}
