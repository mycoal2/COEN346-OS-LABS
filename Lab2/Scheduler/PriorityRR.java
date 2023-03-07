package Scheduler;
import java.util.*;
import static java.lang.Thread.sleep;

public class PriorityRR implements Algorithm {
   List<Task> queue = new ArrayList<Task>();
   int Quantum_time = 6; //seconds;
   int numGroups = 1;
   int numTask;
   Clock clock1 = new Clock();
   public PriorityRR() {
   }

   public PriorityRR(List<Task> q) {
       queue=q;
       pickNextTask();
   }

   @Override
   public void schedule() {
      clock1.start();
      int i = 0;
      while(queue.size() > 0) {                  
         Task temp = queue.get(i);
         numTask = 0;
         Set<String> set = new HashSet<String>();
         for(int j = 0; j<queue.size() ;j++) {
            if(queue.get(j).getGroup() == temp.getGroup()) {
               numTask++;
            }
            set.add(queue.get(j).getGroup());
         }
         numGroups = set.size();
         System.out.println(set);
         System.out.println("This task has started: " + temp);
         try {
             sleep((Quantum_time/numGroups)/numTask * 1000 + 1);
             if((Quantum_time/numGroups)/numTask > temp.getBurst()) {
               System.out.println("Task " + temp.getName() + " has finished");
               queue.remove(temp);
               i--;
             } else {
             temp.setBurst(temp.getBurst()-((Quantum_time/numGroups)/numTask));
             }
         } catch (Exception e) {
             System.out.println("error burst");
         }
         if(queue.size() == 0) {
            break;
         }
         i++;
         if(i % queue.size() == 0) {
            i = 0;
         }
     }
     clock1.stopClock();
     System.out.println("All Tasks are finished");
   }

   @Override
   public Task pickNextTask() {
      return null;
   }

}
