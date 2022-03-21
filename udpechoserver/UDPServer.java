/*
@author adamc x18392911 Emergency Service 
 */

package udpechoserver;

//imports
import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import static java.util.Collections.list;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.function.Predicate;


public class UDPServer {

    //packets and sockets vars
    private static final int PORT = 1998;
    private static DatagramSocket DatagramSocket;
    private static DatagramPacket inPacket, outPacket;
    private static byte[] buffer;

    public static void main(String[] args) {  
        //formats for user input declared
        DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("dd/mm/yy");  //format for which to display date
        LocalDateTime now = LocalDateTime.now();
        String date = (currentDate.format(now));
        DateTimeFormatter currentTime = DateTimeFormatter.ofPattern("HH:mm:ss");   //format for which to display time
        System.out.println(currentTime.format(now));
        String time = (currentTime.format(now));
        System.out.println("Opening port...\n");
        try {
            //opening port
            DatagramSocket = new DatagramSocket(PORT); 
        } catch (SocketException e) {
            // catch stating unable to connect
            System.out.println("Unable to attach to port!"); 
            System.exit(1);
        }
        run(date, time);
    }

    private static void run(String date, String time) {
        try {
            //message in = from client message out = from server and number of messages entered
            String messageIn, messageOut;
            int numMessages = 0;

            do {
                buffer = new byte[256]; 		
                inPacket = new DatagramPacket(buffer, buffer.length); 
                DatagramSocket.receive(inPacket);	

                InetAddress clientAddress = inPacket.getAddress();	
                int clientPort = inPacket.getPort();		

                messageIn = new String(inPacket.getData(), 0, inPacket.getLength());	
        
        ArrayList<String> myList = new ArrayList<String>();
        //adds the event typed in the console to the list once typed in the format provided once off
        myList.add(messageIn);

        
ArrayList<String> mList = new ArrayList<String>();
        //adds the event typed in the console to the list once typed in the format provided once off
            if(messageIn.contains("police")){
        mList.add(messageIn);
        }
        mList.add("Parnell Street Station");
        mList.add("Kevin Street Station");
        mList.add("Naas Station");
        
        //Array List storing events         
        ArrayList<String> dList = new ArrayList<String>();
        //adds the event typed in the console to the list once typed in the format provided once off
        if(messageIn.contains("hospital")){
        dList.add(messageIn);
        }
        dList.add("St James Hospital");
        dList.add("The Coombe");
        dList.add("The Rotunda");             
        dList.add("Naas Hospital");

        
        ArrayList<String> aList = new ArrayList<String>();
        //adds the event typed in the console to the list once typed in the format provided once off
        if(messageIn.contains("rescue")){
        aList.add(messageIn);
        }
        aList.add("Howth Rescue");
        aList.add("Clonee Rescue");
        aList.add("Galway Bay Rescue");
        
        
        
        String example = "11th, May, Anniversary; 9am; true";
        
        //Tokensiser to split input
        StringTokenizer stk = new StringTokenizer(example, ",; ");
        
        String string1 = stk.toString();
        String string2 = stk.nextToken();
        String string3 = stk.nextToken();
        String string4 = stk.nextToken();

        //If Valid It will be split
        boolean validity = Boolean.parseBoolean(stk.nextToken(messageIn));
        
        if (validity){    
            System.out.println(string1);
            System.out.println(string2);
            System.out.println(string3);
            System.out.println(string4);
        } 
        
        //Confirmation the message was recived and stored
        System.out.println("Message stored");
                System.out.println("Message received.");
                if (messageIn.equals("DATE")){
                    messageOut = date;
                } else if (messageIn.equals("date")) {
                    messageOut = date;            

                } else if (messageIn.equals("TIME")) {
                    messageOut = time;
                    
                } else if (messageIn.equals("time")) {
                    messageOut = time;        
                    } 
            
                else{
                    messageOut = ("Message" + ": " + messageIn);
                    System.out.println("All Events Entered and stored : " + myList.toString());
                    }
                
                        if (string3.equals("police")){
                   messageOut = ("Events Taking Part in the Same Month:" +mList); 
                   }
                        if (messageIn.contains("hospital")){
                    messageOut =("Events Taking Part in the Same Month:" +dList); 
                   }
                        if (messageIn.contains("rescue")){
                    messageOut =("Events Taking Part in the Same Month:" +aList); 
                   }  
              
                outPacket = new DatagramPacket(messageOut.getBytes(),
                    messageOut.length(),
                    clientAddress,
                    clientPort);		
                DatagramSocket.send(outPacket);	
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {		//If exception thrown, close connection.
            System.out.println("\n Closing connection... ");
            DatagramSocket.close();				
        }
       }
      }
