class TaskX extends Thread{
    public void run()
    {
        System.out.println(getName() + " running with priority " + getPriority());
    }
}
public class example4{
    public static void main(String[] args) {
        TaskX t1 = new TaskX();
        TaskX t2 =new TaskX();

        t1.setPriority(Thread.MIN_PRIORITY); // jab bhi hum aise capital me likh rhe honge  to ye function nhi hai ye class variable hai...
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
}

// class TaskX extends Thread{
//     public static void main(String[] args){
//         try {
//             int result = 10/0;
//         } catch (ArithmeticException e) {
//             System.out.println("Cannot divide by zero!");
//         }finally{
//             System.out.println("Always executes");
//         }
//     }
// }