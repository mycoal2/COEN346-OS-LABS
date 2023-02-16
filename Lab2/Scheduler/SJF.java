package Scheduler;

public class SJF implements Algorithm {
    Queue<Task> queue = new LinkedList<>();
    Queue<Task> waiting_queue=new LinkedList<>();   

    public void schedule() {
      int time=0;
      Clock timer=new Clock();
      timer.start();

      while(queue.size()>0)
      {
         Task temp=queue.remove();

         if(timer.clock<=temp.getPriority())
         {
            try{
               Thread.sleep((temp.getPriority()-timer.clock)*1000))
            }catch (Exception e) {
                    System.out.println("error1");
                }
         }
         System.out.println(temp.getName() + " has started");
         
         Task check=queue.peek();
         if(check.getPriority()==timer.clock)
         {
            check=queue.remove();
            manage_queue(check);
         }

         try{
             sleep(temp.getBurst() * 1000);
            } catch (Exception e) {
               System.out.println("error");
            }
            System.out.println("This task has finished");

      }
         
      }

      public void manage_queue(Task another_task)
      {
         if(waiting_queue.size()<=0)
         {
            waiting_queue.add(another_task);
         }

         else
         {
            Task temp=waiting_queue.remove();
            if(another_task.getBurst()<temp.getBurst())
            {
               waiting_queue.add(another_task);
               waiting_queue.add(temp);
            }
         }

      }

        
    }
     
     public Task pickNextTask() {
        Task a = new Task("name",5,2);
        return a;
     }
}
