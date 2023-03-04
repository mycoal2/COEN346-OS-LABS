import java.util.*;
import java.io.*;

import Scheduler.*;

public class Driver {

    int Min_prio = 1;
    int Max_prio = 10;
    public static void main(String[] args) throws IOException {
        // Clock obj = new Clock();
        // obj.start();
        if (args.length != 2) {
            System.err.println("Usage: java Driver <algorithm> <schedule>");
            System.exit(0);
        }

        BufferedReader inFile = new BufferedReader(new FileReader(args[1]));

        String schedule;

        // create the queue of tasks
        List<Task> queue = new ArrayList<Task>();

        // read in the tasks and populate the ready queue   
        String choice = args[0].toUpperCase();     
        while ( (schedule = inFile.readLine()) != null) {
            String[] params = schedule.split(",\\s*");
            switch(choice) {
                case "FCFS":
                    queue.add(new Task(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2])));
                    break;
                case "SJF":
                    break;
                case "PRI":
                    queue.add(new Task(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3])));
                    break;
                case "RR":
                    
                    break;
                case "PRI-RR":
                    
                    break;
                default:
                    System.err.println("Invalid algorithm");
                    System.exit(0);
            }
        }
        

        inFile.close();
        
        Algorithm scheduler = null;
        //String choice = args[0].toUpperCase();

        switch(choice) {
            case "FCFS":
                scheduler = new FCFS(queue);

                break;
            case "SJF":
                // scheduler = new SJF(queue);
                break;
            case "PRI":
                scheduler = new Priority(queue);
                break;
            case "RR":
                // scheduler = new RR(queue);
                break;
            case "PRI-RR":
                // scheduler = new PriorityRR(queue);
                break;
            default:
                System.err.println("Invalid algorithm");
                System.exit(0);
        }

        // start the scheduler
        scheduler.schedule();



        // FCFS obj1 = new FCFS();
        // obj1.schedule();


    }
    
}