package ca.concordia.processmanagement;
import java.util.LinkedList;
import java.util.Queue;

public interface Operation {
    int createProcess() throws Exception;
    void terminateProcess(int pid) throws Exception;
}