package Scheduler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import static java.lang.Thread.sleep;

public class Priority implements Algorithm {
    List<Task> queue = new ArrayList<Task>();
    List<Task> Readyqueue = new ArrayList<Task>();

    public Priority(List<Task> q) {
        queue=q;
    }

    public void schedule() {
        Clock clock1 = new Clock();
        clock1.start();
        while(queue.size() > 0) {
            Task temp = queue.remove(0);

            if(clock1.clock <= temp.getPriority()) {
                try {
                    Thread.sleep((temp.getPriority() - clock1.clock) * 1000);
                } catch (Exception e) {
                    System.out.println("error1");
                }
            }
            System.out.println(temp.getName() + " has started");
            try {
                sleep(temp.getBurst() * 1000 + 1);
            } catch (Exception e) {
                System.out.println("error burst");
            }
            System.out.println(temp.getName() + " has finished");
        }
        System.out.println("All Tasks are finished");
        clock1.stopClock();
    }

    @Override
    public Task pickNextTask() {
        return null;
    }


}
