package Scheduler;

public class Clock extends Thread {
    public int clock = 0;
    boolean exit = true;
    public void run() {
        while(exit) {
            try{
                sleep(1000);
                clock++;
                System.out.println(clock);
            } catch (Exception e) {
                System.out.println("Exception123");
                return;
            }
        }
        System.out.println("Clock has stopped");
    }

    public void stopClock() {
        exit = false;
    }
}
