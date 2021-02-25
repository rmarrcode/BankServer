import java.net.*;
import java.io.*;
import java.util.*;

public class BankClient   {

  protected String host, file;
  protected int port;

  public static void main (String args[]) throws IOException {
    InetAddress  server  = null;
    Socket      sock = null;

    if ( args.length != 2 ) {
       throw new RuntimeException( "hostname and port number as arguments" );
    }

    String host = args[0];
    int  port = Integer.parseInt( args[1] );

    System.out.println ("Connecting to " + host + ":" + port + "..");

    Socket socket = new Socket (host, port);
    System.out.println ("Connected.");

    InputStream rawIn = socket.getInputStream ();
    BufferedReader  buffreader = new BufferedReader( new InputStreamReader(rawIn) );
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ( ( line = keyboard.readLine() ) != null ) {
            System.out.println(line);
            OutputStream out = socket.getOutputStream();
            ObjectOutputStream os = new ObjectOutputStream( out );
            os.writeObject( new Date() );
    }

    socket.close();
  }
}
