package ca.concordia.processmanagement;

public class PIDManager {

    static final int MIN_PID = 300;
    static final int MAX_PID = 500;

    int[] arr = new int[MAX_PID-MIN_PID+1]; //array with size 201 for each PIDs availlable

    public void allocateMap() throws Exception{     //initialize all pid to be free. 0 is free. 1 is taken.
        for(int i = 0; i < 201; i++) {
            arr[i] = 0;                             
        }
    }

    public int allocatePID() throws Exception {
        int i=0;
        while(arr[i] == 1) {            //check if the PID is taken. If it is, check the next one.
            i++;
        }
        arr[i] = 1;                     //once found a free PID, you set it to taken.
        return i + MIN_PID;             //index + MIN_PID to have the actual PID
    }

    public void releasePID(int pid) {
        if(arr[pid-MIN_PID] != 0) {
            arr[pid-MIN_PID] = 0;
        }
    }

}
