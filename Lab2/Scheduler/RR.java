package Scheduler;

public class RR implements Algorithm {
    int Quantum_time = 10; //seconds   
    public void schedule() {

    }
 
     
     public Task pickNextTask() {
        Task a = new Task("name", 4, 2);
        return a;
     }
}
