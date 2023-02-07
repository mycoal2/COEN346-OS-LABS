package ca.concordia.processmanagement;
import java.util.LinkedList;
import java.util.Queue;

public class ProcessControl implements Operation {
    Queue<PCB> queue = new LinkedList<>();
    PIDManager Manager = new PIDManager();
    ProcessControl() {                          //constructor
        try {
            Manager.allocateMap();              //Initialize the array for all free PIDs.
        }
        catch (Exception i) {
            System.out.println("allocate map error");
        }
    }
    public int createProcess() throws Exception {
        int temp_PID = Manager.allocatePID();           //search for a free PID
        PCB pcb = new PCB();                            //create the process control block
        pcb.setPID(temp_PID);                           //store the pid in the PCB
        queue.add(pcb);                                 //add it to the ready queue
        return pcb.getPID();
    }

    public void terminateProcess(int pid) throws Exception {
        PCB temp = new PCB();
        Manager.releasePID(pid);                        //free the pid
        for(int i = 0; i < queue.size(); i++) {         //this for loop search for the process with the coressponding pid
            temp = queue.remove();                      //since its a queue, you can only look at the first one.
            if (temp.getPID() == pid)
                return;
            queue.add(temp);                            //if its not the correct pid, re-add the pid to the queue.
        }
    }
}
