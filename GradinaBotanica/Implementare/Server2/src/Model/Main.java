package Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startServer();
	}
	public static void startServer() {

	    try {
	        ServerSocket welcomeSocket = new ServerSocket(5001);

	        while (true) {    
	            // Create the Client Socket
	            Socket clientSocket = welcomeSocket.accept();
	            System.out.println("Socket Extablished...");
	            System.out.println("Connection with Client");
	            // Create input and output streams to client
	            ObjectOutputStream outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
	            ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());

	            // Read modify
	            // TODO here

	            /* Create Message object and retrive information */
	            String line ="";
		        while(!line.equals("terminare"))
		        {
		        	try {
		        		line=inFromClient.readLine();
		        		outToClient.writeUTF(line);
		        		
		        	}catch(IOException i) {
		        		System.out.println("");
		        	}
		        }

		        clientSocket.close();
		        inFromClient.close();
	            /* Modify the message object */
	           
	            /* Send the modified Message object back */
	                 

	        }

	    } catch (Exception e) {
	        System.err.println("Server Error: " + e.getMessage());
	        System.err.println("Localized: " + e.getLocalizedMessage());
	        System.err.println("Stack Trace: " + e.getStackTrace());
	        System.err.println("To String: " + e.toString());
	    }
	}

}
