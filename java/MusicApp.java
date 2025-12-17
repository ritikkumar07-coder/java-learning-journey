class AudioThread extends Thread{
    public void run(){
        for(int i = 0; i <= 5; i++){

            System.out.println("Playing audio chunk" + i);
            try{
                Thread.sleep(300);
            }catch(Exception e){}
        }
    }
}

class LyricsThread extends Thread{
    public void run(){
        for(int i = 0; i <= 5; i++){

            System.out.println("Showing Lyrics line" + i);
            try{
                Thread.sleep(300);
            }catch(Exception e){}
        }
    }
}
public class MusicApp {
    public static void main(String[] args) throws InterruptedException{
        
        AudioThread at = new AudioThread();
        LyricsThread lt = new LyricsThread();
    
        at.start();
        lt.start();
        at.join();
        at.join();
        
    }
    
}

// capstone**'


// synchronization...
// deadlock..imp