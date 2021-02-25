/* Author:  Anand Tripathi - Example program code for CSCI 5105 Spring 2021     */



/* Get started now with  your first Java program */


class HelloWorld { 
	public static void main (String[ ] args) { 
    
        if (args.length == 0) {
           System.out.println("Usage: HelloWorld listOfNames");
           return;
        } 

        for (int i=0; i<args.length; i++) {
            System.out.println ("Hello from " + args[i] ); 
        }
 	} 
}

