package Scheduler;

public class Clock extends Thread {
    public int clock = 0;
    public void run() {
        while(true) {
            try{
                sleep(1000);
                clock++;
                System.out.println(clock);
            } catch (Exception e) {
                System.out.println("Exception");
            }
        }
    }
}
