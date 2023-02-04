package ca.concordia.processmanagement;

public class PIDManager {

    static final int MIN_PID = 300;
    static final int MAX_PID = 500;

    int[] arr = new int[MAX_PID-MIN_PID+1];

    public void allocateMap() throws Exception{     //initialize all pid to be free
        for(int i = 0; i < 201; i++) {
            arr[i] = 0;
        }
    }

    public int allocatePID() throws Exception {
//        for(int i = 0; i < 200; i++) {
//            if(arr[i] == 0) {
//                arr[i] = 1;
//                return i + MIN_PID;
//            }
//        }
        int i=0;
        while(arr[i] == 1) {
            i++;
        }
        arr[i] = 1;
        return i + MIN_PID;
    }

    public void releasePID(int pid) {
        if(arr[pid-MIN_PID] != 0) {
            arr[pid-MIN_PID] = 0;
        }
    }

}
