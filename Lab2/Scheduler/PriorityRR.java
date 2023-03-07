package Scheduler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import static java.lang.Thread.sleep;

public class PriorityRR implements Algorithm {
   List<Task> queue = new ArrayList<Task>();

   public PriorityRR() {
   }

   public PriorityRR(List<Task> q) {
       queue=q;
       pickNextTask();
   }

   @Override
   public void schedule() {
       Clock clock1 = new Clock();
       clock1.start();
       while(queue.size() > 0) {
           Task temp = queue.remove(0);

           if(clock1.clock <= temp.getArrivalTime()) {
               try {
                   Thread.sleep((temp.getArrivalTime() - clock1.clock) * 1000);
               } catch (Exception e) {
                   System.out.println("error1");
               }
           }
           System.out.println("This task has started: " + temp);
           try {
               sleep(temp.getBurst() * 1000 );
           } catch (Exception e) {
               System.out.println("error burst");
           }

           System.out.println("Task " + temp.getName() + " has finished");

       }
       clock1.stopClock();
       System.out.println("All Tasks are finished");
   }

   @Override
   public Task pickNextTask() {
       Task[] arr = queue.toArray(new Task[0]);
       
       for (int i = 0; i < arr.length; i++) {
           // Inner nested loop pointing 1 index ahead
           for (int j = i + 1; j < arr.length; j++) {
               // Checking elements
               Task temp = null;
               if (arr[j].getArrivalTime() < arr[i].getArrivalTime() ) {

                   // Swapping
                   temp = arr[i];
                   arr[i] = arr[j];
                   arr[j] = temp;
               }
           }
           // Printing sorted array elements
           //System.out.println(arr[i] + " ");
       }

       queue = new ArrayList<Task>(Arrays.asList(arr));            //put sorted array to queue.

       return null;
   }

}
