package ca.concordia.processmanagement;

public class PCB {
    int PID;
    boolean processStatus;
    //setters and getters
    public int getPID() {
        return PID;
    }
    public boolean getStatus() {
        return processStatus;
    }
    public void setPID(int pid) {
        PID = pid;
    }
    public void setStatus(boolean status){
        processStatus = status;
    }

}
