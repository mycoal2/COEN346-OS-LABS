package ca.concordia.processmanagement;

public class main {
    public static void main(String[] args) {
        try {
            System.out.println("\nScenario #1");
            ProcessControl test1 = new ProcessControl();
            int pid = test1.createProcess();
            System.out.println("PID of newly created process is: " + pid);
            test1.terminateProcess(pid);
            System.out.println("Process has been terminated");
        } catch (Exception s) {
            System.out.println("Exception handling");
        }

        try {
            System.out.println("\nScenario #2");
            ProcessControl test2 = new ProcessControl();
            for(int i = 0; i < 200; i++) {;
                test2.createProcess();
            }
            System.out.println("PID of newly created process is: " + test2.createProcess());
            System.out.println("Create max amount of process");
            test2.createProcess();
        } catch (Exception s) {
            System.out.println("CreateProcess() failed. Max PID reached");
        }

        try {
            System.out.println("\nScenario #3");
            ProcessControl test3 = new ProcessControl();
            for(int i = 0; i < 200; i++) {;
                test3.createProcess();
            }
            System.out.println("PID of newly created process is: " + test3.createProcess());
            System.out.println("Max amount of process created");
            test3.terminateProcess(352);
            System.out.println("Terminated pid 352");
            System.out.println("PID of newly created process is: " + test3.createProcess());
            System.out.println("PID of newly created process is: " + test3.createProcess());
        } catch (Exception s) {
            System.out.println("CreateProcess() failed. Max PID reached");

        }
    }
}
