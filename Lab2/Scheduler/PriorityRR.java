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
     
   }

   @Override
   public Task pickNextTask() {
      return null;
   }

}
