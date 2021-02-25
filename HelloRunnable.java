/* Author:  Anand Tripathi - Example program code for CSCI 5105 Spring 2021     */


/**
  * This example shows the use of Runnable interface for
  * concurrent programming. - AT
*/

import java.io.*;

public class HelloRunnable  implements Runnable {
      private  String message;
      public HelloRunnable  ( String message ) {
          this.message = message;
      }

      public void run() {
          System.out.println( Thread.currentThread().getName() + " is saying hello to " + message );
     }
}
