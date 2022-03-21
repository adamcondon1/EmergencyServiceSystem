/*
@author adamc x18392911 Emergency Service
 */
//imports
package udpechoclient;
import java.io.*;
import java.net.*;

public class UDPClient {

    //packets and sockets vars
    private static InetAddress host;
    private static final int PORT = 1998;
    private static DatagramSocket DatagramSocket;
    private static DatagramPacket inPacket, outPacket;
    private static byte[] buffer;

    public static void main(String[] args) {
        //getting localhost address throw exception if an unknown exception occurs   
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.out.println("Host ID not found!"); //Message thrown if Host ID is not detected
            System.exit(1);
        }
        run();
    }

    private static void run() {
        try {
            DatagramSocket = new DatagramSocket();
            //Initating stream for keyboard input
            BufferedReader userEntry = new BufferedReader(
            new InputStreamReader(System.in));
            //message = client response = server 
            String message = null;
            String response = null;
            do {
                //format the user must enter
                System.out.print("Make Sure the Exact Same Format is Followed:\n");
                System.out.print("Choose which Service you need from the following(hospital, police, rescue)\n");
                System.out.print("Enter a service and the system will provide 24 hour locations for these servcies: ");
                message = userEntry.readLine();
                if (message.equals("DATE")) {
                    System.out.print("");
                }
                if (message.equals("date")) {
                    System.out.print("");  
                }
                //if statement which recieves in put and sends repsonse
                if (!message.equals("***CLOSE***")) {
                    outPacket = new DatagramPacket(message.getBytes(), message.length(), host, PORT);    
                    DatagramSocket.send(outPacket);	

                    buffer = new byte[256];     
                    inPacket = new DatagramPacket(buffer, buffer.length); 	
                    DatagramSocket.receive(inPacket);	
                    response = new String(inPacket.getData(), 0, inPacket.getLength());	
                    System.out.println("\nSERVER " + response);
                }
            } while (!message.equals("***CLOSE***"));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("\n Closing connection... ");
            DatagramSocket.close();	
        }
    }
}
