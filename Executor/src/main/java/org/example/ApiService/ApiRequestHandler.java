package org.example.ApiService;

/*
This class behaves as a service layer and will be called from external api calls made to the
application controller.

In The service layer where the business logic of application is handled we will make sure to
make the independent tasks to be accepted by the TaskAcceptor and complete the given task on different
thread without blocking the main thread.

*/

import org.example.AsyncTaskAcceptor.TaskAcceptor;

public class ApiRequestHandler {

     /*
        This is a handler method which will be handling the business logic
        Now the developer has to decide based on the requirement what tasks are there which
        can be handled in async manner or whose result does not comprise in the output of the request

        Example :
           1. Some complex calculations which can be done independently
           2. Some n/w call such as database call to push / pull certain data.
           3. File creations

     */
     public void handler(){

         /*
          *   Api Business logic
          */

         /*
            Let us consider we found out two background task which we now want to
            be managed by our TaskAcceptor
         */
         final TaskAcceptor taskAcceptor = TaskAcceptor.getInstance();
         /* Submiting task1 in TaskAcceptor */
         taskAcceptor.executeTask(this::computationTask);

         /* Submiting task2 in TaskAcceptor */
         taskAcceptor.executeTask(this::computationTask);

     }

    /* Below method will work as some high computation task which will be executed in TaskAcceptor */
    private void computationTask() {

        try {
            /*Thread sleeps for 10 seconds as in it is some I/O operation*/
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
