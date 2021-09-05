package DorD.Game;

public class Timers extends Thread{
    int counter;
    public Timers(int time){
        this.counter = time;
    }

    public int GetTime(){
        return this.counter;
    }
    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter--;
        }
    }

}
