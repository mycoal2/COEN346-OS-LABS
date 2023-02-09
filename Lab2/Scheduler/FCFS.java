package Scheduler;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Thread.sleep;

public class FCFS implements Algorithm {
    Queue<Task> queue = new LinkedList<>();
    public FCFS() {
        Task a = new Task("T1", 0, 2);
        Task b = new Task("T2", 5, 3);
        Task c = new Task("T3", 6, 4);
        Task d = new Task("T4", 10, 7);
        queue.add(a);
        queue.add(b);
        queue.add(c);
        queue.add(d);
    }
    @Override
    public void schedule() {
        int time = 0;
        Clock clock1 = new Clock();
        clock1.start();
        //System.out.println(queue.size());
        while(queue.size() > 0) {
            Task temp = queue.remove();

            if(clock1.clock <= temp.getPriority()) {
                try {
                    Thread.sleep((temp.getPriority() - clock1.clock) * 1000);
                } catch (Exception e) {
                    System.out.println("error1");
                }
            }
            System.out.println(temp.getName() + " has started");
            try {
                sleep(temp.getBurst() * 1000);
            } catch (Exception e) {
                System.out.println("error");
            }
            System.out.println("This task has finished");

        }

    }

    @Override
    public Task pickNextTask() {
        return null;
    }


}
