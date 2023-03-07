package Scheduler;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Thread.sleep;

public class Priority implements Algorithm {
    List<Task> queue = new ArrayList<Task>();
    List<Task> readyQueue = new ArrayList<Task>();
    int numTasks = 0;
    double avgWait = 0;
    double avgTurn = 0;
    Clock clock1 = new Clock();
    public Priority(List<Task> q) {
        queue=q;
        numTasks = queue.size();
    }

    public void schedule() {
        clock1.start();
        while(queue.size() > 0 || readyQueue.size() > 0) {                  
            Task temp = pickNextTask();
            avgWait += clock1.clock - temp.getArrivalTime();
            System.out.println("This task has started: " + temp);
            try {
                sleep(temp.getBurst() * 1000 + 1);
            } catch (Exception e) {
                System.out.println("error burst");
            }
            avgTurn += clock1.clock - temp.getArrivalTime();
            System.out.println("Task " + temp.getName() + " has finished");
        }
        clock1.stopClock();
        System.out.println("All Tasks are finished");
        System.out.println("Average times: waiting [" + avgWait/numTasks + "] , turnaround: [" + avgTurn/numTasks + "]");
    }

    @Override
    public Task pickNextTask() {
        do {                                                            //add to ready queue if arrival time is lower than clock time
            for(int i = 0; i<queue.size();i++) {                        
                if(queue.get(i).getArrivalTime() <= clock1.clock) {
                    readyQueue.add(queue.remove(i));                    //remove from the full list and add to ready queue
                    i--;
                }
            }
        } while (readyQueue.size() == 0);

        int index = 0;
        int highpriority = -1;

        for(int i = 0; i<readyQueue.size();i++) {                       //check highest priority in the ready queue
            if(readyQueue.get(i).getPriority() > highpriority) {
                highpriority = readyQueue.get(i).getPriority();
                index = i;
            }
        }
        return readyQueue.remove(index);                                //return task with highest priority
    }


}
