package org.example.AsyncTaskAcceptor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
    This class will act as a medium to make independent task to be executed on
    different threads and once the task is completed log the status of the task as
    PASS / FAIL with its respective TaskId
*/
public class TaskAcceptor {

    private static final String[] statusArray = {"PASS" , "FAIL"};
    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);
    private static TaskAcceptor taskAcceptorInstance = new TaskAcceptor();

    /* Object creation following singleton design */
    public static TaskAcceptor getInstance(){

        if(taskAcceptorInstance == null){
            taskAcceptorInstance = new TaskAcceptor();
        }
        return taskAcceptorInstance;
    }

    /* Method to accept tasks to be handled async / background */

    public void executeTask(Runnable runnableTask){

        try{
            if(runnableTask == null){
                throw new NullPointerException("Invalid task submitted!");
            }
            final Future<?> submit = executorService.submit(runnableTask);
            System.out.println("*********** Task Submitted ******** ");
            taskExecutionStatus(0);
        }
        catch(Exception e){
            taskExecutionStatus(1);
        }
    }

    private void taskExecutionStatus(int i){
        System.out.println("Task execution status : " + statusArray[i]);
    }

}
