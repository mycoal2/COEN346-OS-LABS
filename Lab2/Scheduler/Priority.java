package Scheduler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import static java.lang.Thread.sleep;

public class Priority implements Algorithm {
    List<Task> queue = new ArrayList<Task>();
    List<Task> readyQueue = new ArrayList<Task>();
    Clock clock1 = new Clock();
    public Priority(List<Task> q) {
        queue=q;
    }

    public void schedule() {
        clock1.start();
        while(queue.size() > 0 || readyQueue.size() > 0) {
            Task temp = pickNextTask();
            try {
                Thread.sleep((temp.getPriority() - clock1.clock) * 1000);
            } catch (Exception e) {
                System.out.println("error1");
            }
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

    public void addtoReadyQueue() {
        
    }

    @Override
    public Task pickNextTask() {
        for(int i = 0; i<queue.size();i++) {
            if(queue.get(i).getPriority() <= clock1.clock) {
                readyQueue.add(queue.remove(i));
            }
        }

        int index = 0;
        int highpriority = -1;
        for(int i = 0; i<readyQueue.size();i++) {
            if(readyQueue.get(i).getPriority() > highpriority) {
                index = i;
            }
        }

        return readyQueue.remove(index);
    }


}
