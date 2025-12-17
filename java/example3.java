class TaskA extends Thread{
    public void run(){
        for(int i = 1; i<= 3; i++){
            System.out.println("TaskA running: "+ i);
        }
    }
}
public class example3{
    public static void main(String[] args) {
        TaskA t1= new TaskA();
        t1.start();
        try{
            t1.join();
        }
        catch(InterruptedException e){
            System.out.println("Main interrupted!");
        }
        System.out.println("TaskA done. Continuing main...");
    }
}