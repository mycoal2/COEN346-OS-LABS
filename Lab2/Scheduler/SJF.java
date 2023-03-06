package Scheduler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.*;
import static java.lang.Thread.sleep;

public class SJF implements Algorithm {

    List<Task> queue = new ArrayList<Task>();
    Queue<Task> readyQueue = new LinkedList<Task>();
    Clock clock1 = new Clock();

    public SJF(List<Task> q) {
        queue = q;
    }

    @Override
    public void schedule() {
        clock1.start();

        while (queue.size() > 0 || readyQueue.size() > 0) {
            Task temp = pickNextTask();
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
        //sort the queue with arrival time
        Task[] new_arr = queue.toArray(new Task[0]);

        for (int i = 0; i < new_arr.length; i++) {
            // Inner nested loop pointing 1 index ahead
            for (int j = i + 1; j < new_arr.length; j++) {
                // Checking elements
                Task temp = null;
                if (new_arr[j].getBurst() < new_arr[i].getBurst()) {

                    // Swapping
                    temp = new_arr[i];
                    new_arr[i] = new_arr[j];
                    new_arr[j] = temp;
                }
            }
        }
        queue = new ArrayList<Task>(Arrays.asList(new_arr));

        while(queue.size()>0)
        {
            return queue.remove(0);
        }

        return null;

    }



}
