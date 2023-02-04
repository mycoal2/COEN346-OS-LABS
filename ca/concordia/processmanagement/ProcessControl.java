package ca.concordia.processmanagement;
import java.util.LinkedList;
import java.util.Queue;

public class ProcessControl implements Operation {
    Queue<PCB> queue = new LinkedList<>();
    PIDManager Manager = new PIDManager();
    ProcessControl() {
        try {
            Manager.allocateMap();
        }
        catch (Exception i) {
            System.out.println("allocate map error");
        }
    }
    public int createProcess() throws Exception {
        int temp_PID = Manager.allocatePID();
        PCB pcb = new PCB();
        pcb.setPID(temp_PID);
        queue.add(pcb);
        return pcb.getPID();
    }

    public void terminateProcess(int pid) throws Exception {
        PCB temp = new PCB();
        Manager.releasePID(pid);
        for(int i = 0; i < queue.size(); i++) {
            temp = queue.remove();
            if (temp.getPID() == pid)
                return;
            queue.add(temp);
        }
    }
}
