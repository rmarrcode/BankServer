/* Author:  Anand Tripathi - Example prgoram code for CSCI 5105 Spring 2021     */
/* Example of receiving a serialized object over a network connection.         */
/* This example illustrates how a serialized object is  received over network. */
/* See SendObject.jave program which shows how an object is  received.          */


import java.net.*;
import java.io.*;
import java.util.*;

public class GetObject {

  public static void main (String args[]) throws IOException {

    if (args.length != 1) {
		System.out.println("Usage: GetObject  portnumber");
        throw new RuntimeException ("Syntax: GetObject port-number");
    }

    System.out.println ("Starting on port " + args[0]);
    ServerSocket server = new ServerSocket (Integer.parseInt (args[0]));

    while (true) {
      System.out.println ("\n ******************* \nWaiting for a client request...");
      Socket client = server.accept ();
	  
      System.out.println( "\nConnection opened with client...receiving objects... "  );
	  InputStream in  = client.getInputStream();
      ObjectInputStream oin = new ObjectInputStream( in );
      Date date = null;
      String name = null;
      try {
         name = (String) oin.readObject();
         date = (Date) oin.readObject();
      }
      catch ( ClassNotFoundException e) {
         e.printStackTrace();
      }

      System.out.println( "Received two objects::"  );
      System.out.println( "String Object: "+  name  +  "\nDate Object: "+ date );

    }
  }
}
