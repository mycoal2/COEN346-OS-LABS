import Scheduler.*;

public class Driver {

    int Min_prio = 1;
    int Max_prio = 10;
    public static void main(String[] args) {
       // Clock obj = new Clock();
     //   obj.start();

        FCFS obj1 = new FCFS();
        obj1.schedule();


    }
    
}