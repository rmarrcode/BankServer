/* Author:  Anand Tripathi - Example prgoram code for CSCI 5105 Spring 2021    */
/* Example of sending a serialized object over a network connection.          */
/* This example illustrates how a serialized object is sent over the network. */
/* See GetObject.jave program which shows how an object is  received.         */ 

import java.net.*;
import java.io.*;
import java.util.*;

public class SendObject {

  protected String host, file;
  protected int port;
  protected DataInputStream in;
  protected DataOutputStream out;


  public static void main (String args[]) throws IOException {
    InetAddress  server  = null;
    Socket      sock = null;

    if ( args.length != 2 ) {
       System.out.println("Usage: SendObject hostname portnumber");
       throw new RuntimeException( "hostname and port number as arguments" );
    }

    String host = args[0];
    int  port = Integer.parseInt( args[1] );

    System.out.println ("Connecting to " + host + ":" + port + "..");

    Socket socket = new Socket (host, port);
    System.out.println ("Connected.");

    OutputStream out = socket.getOutputStream ();
    ObjectOutputStream os = new ObjectOutputStream( out );

    os.writeObject( "Anand  Tripathi");
    os.writeObject( new Date() );
    socket.close();

  }
}
