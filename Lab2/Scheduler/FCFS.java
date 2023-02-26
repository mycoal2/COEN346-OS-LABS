package Scheduler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import static java.lang.Thread.sleep;

public class FCFS implements Algorithm {
    List<Task> queue = new ArrayList<Task>();
    public FCFS() {
    }

    public FCFS(List<Task> q) {
        queue=q;
        pickNextTask();
    }

    @Override
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
        Task[] arr = queue.toArray(new Task[0]);
        
        for (int i = 0; i < arr.length; i++) {
            // Inner nested loop pointing 1 index ahead
            for (int j = i + 1; j < arr.length; j++) {
                // Checking elements
                Task temp = null;
                if (arr[j].getPriority() < arr[i].getPriority() ) {
 
                    // Swapping
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // Printing sorted array elements
            System.out.println(arr[i] + " ");
        }

        queue = new ArrayList<Task>(Arrays.asList(arr));            //put sorted array to queue.

        return null;
    }


}
