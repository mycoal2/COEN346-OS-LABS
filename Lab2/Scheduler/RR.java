package Scheduler;

import java.util.Queue;
import java.util.LinkedList;


public class RR implements Algorithm {
    int Quantum_time = 10; //seconds;
    int elapsedTime; // time spent executing
    Queue<Task> readyQueue;


    public RR(int Quantum_time){
        readyQueue = new LinkedList<>();
        this.Quantum_time = Quantum_time;
        elapsedTime = 0; // default value
    }

    public Task pickNextTask() { // this function will return the head of the queue
        Task nextTask = readyQueue.poll(); // returns the first element, returns null if queue is empty
        if(nextTask != null){
            readyQueue.add(nextTask);
        }
        return nextTask; // returns the next element at the head of the list
    }

    public void schedule() {
        while(!readyQueue.isEmpty()){
            Task currentTask = pickNextTask(); // loads next task using pickNextTask function
        // this could end up causing an infinite loop trying to pick the next task, so we can break if there's no tasks
            if(currentTask == null){
                break;
            }

            int timeRemaining = currentTask.getBurst() - elapsedTime; // calculates remaining time
            int timeExecuted = Math.min(Quantum_time, timeRemaining); // this will output the lower of the two numbers
            System.out.println("tid: " + currentTask.getTid() + "executed for" + timeExecuted + "seconds");
            elapsedTime = elapsedTime + timeExecuted;
            currentTask.setBurst(timeRemaining - timeExecuted); // updates burst time with the remaining time

            // if the burst wasn't completed, we have to add it back to the queue
            if(timeRemaining > 0){
                readyQueue.add(currentTask);
            }

            // if the queue is empty (i.e. no tasks to perform, we can return and reset the elapsedTime
            if(readyQueue.isEmpty()){
                System.out.println("No Tasks in the Queue");
                elapsedTime = 0;
                return;
            }

        }
    }
}


