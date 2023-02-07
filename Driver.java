import ca.concordia.processmanagement.*;

public class Driver {
    public static void main(String[] args) {
        try {
            System.out.println("\nScenario #1");
            ProcessControl test1 = new ProcessControl();                    //This creates the ProcessControl which has the operation.
            int pid = test1.createProcess();                                //This creates a process and it returns its PID.
            System.out.println("PID of newly created process is: " + pid);
            test1.terminateProcess(pid);                                    //This will terminate the process with the specific PID.
            System.out.println("Process has been terminated");
        } catch (Exception s) {
            System.out.println("Exception handling");
        }

        try {
            System.out.println("\nScenario #2");
            ProcessControl test2 = new ProcessControl();
            for(int i = 0; i < 200; i++) {
                test2.createProcess();                      //This will create 200 process with different PIDs. so 300 to 499
            }
            System.out.println("PID of newly created process is: " + test2.createProcess());   //This create the process with pid 500
            System.out.println("Create max amount of process");
            test2.createProcess();                                                             //This tries to create another process, but all pids are already taken so it throws an exception.
        } catch (Exception s) {
            System.out.println("CreateProcess() failed. Max PID reached");
        }

        try {
            System.out.println("\nScenario #3");
            ProcessControl test3 = new ProcessControl();
            for(int i = 0; i < 200; i++) {
                test3.createProcess();
            }
            System.out.println("PID of newly created process is: " + test3.createProcess());    //This create the process with pid 500
            System.out.println("Max amount of process created");
            test3.terminateProcess(352);                                                    //This terminate the process with pid 352
            System.out.println("Terminated pid 352");
            System.out.println("PID of newly created process is: " + test3.createProcess());    //This will create a new process with pid 352 because it is the only one that is free.
            System.out.println("PID of newly created process is: " + test3.createProcess());    //This tries to create another process, but all pids are already taken so it throws an exception.
        } catch (Exception s) {
            System.out.println("CreateProcess() failed. Max PID reached");

        }
    }
}
