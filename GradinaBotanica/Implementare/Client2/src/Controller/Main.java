package Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import Model.Admin;
import Model.Angajat;
import Model.Planta;

public class Main {
	 public static void main(String args[]) {
	       
		
		// Main client=new  Main();
		 startClient();
	 }
	 
	 public static void startClient() {
		    try {
		        // Create the socket
		        Socket clientSocket = new Socket("127.0.0.1", 5001);
		        // Create the input & output streams to the server
		        ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
		        ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());

		        String line ="";
		        while(!line.equals("terminare"))
		        {
		        	try {
		        		line=inFromServer.readLine();
		        		outToServer.writeUTF(line);
		        		
		        	}catch(IOException i) {
		        		System.out.println("");
		        	}
		        }

		        clientSocket.close();
		        inFromServer.close();

		    } catch (Exception e) {
		        System.err.println("Client Error: " + e.getMessage());
		        System.err.println("Localized: " + e.getLocalizedMessage());
		        System.err.println("Stack Trace: " + e.getStackTrace());
		        System.err.println("To String: " + e.toString());
		    }
		}	 
}

