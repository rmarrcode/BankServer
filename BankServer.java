import java.net.*;
import java.io.*;
import java.util.*;

public class BankServer extends Thread {
  protected Socket s;
  ArrayList records = new ArrayList();
  BankServer (Socket s) {
    System.out.println ("New client.");
    this.s = s;
  }

  public void run () {
    while(true) {
        try {
            InputStream in = s.getInputStream();
            ObjectInputStream oin = new ObjectInputStream( in );
            Date d = (Date) oin.readObject();
            records.add(d);
            System.out.println("all records");
            for (int i = 0; i < records.size(); i++) {
                System.out.println(records.get(i) + " ");
            }
        }
        catch (IOException e) {
        }
        catch (ClassNotFoundException e) {
        }
    }
  }

  public static void main (String args[]) throws IOException {

    if (args.length != 1)
         throw new RuntimeException ("Syntax: EchoServer port-number");

    System.out.println ("Starting on port " + args[0]);
    ServerSocket server = new ServerSocket (Integer.parseInt (args[0]));

    while (true) {
      System.out.println ("Waiting for a client request");
      Socket client = server.accept ();
      System.out.println( "Received request from " + client.getInetAddress ());
      System.out.println( "Starting worker thread..." );
      BankServer c = new BankServer (client);
      c.start ();
    }
  }
}
