package LogicTier;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
 
public class ServerAdmin {

private int portNumber;
	
	public ServerAdmin(int portNumber) {
		this.portNumber = 1220;	
		connect();
	}
	
	@SuppressWarnings("unused")
	public void connect() {
		System.out.println("Admin Server port " + portNumber + " try to connect");
		try ( 
			    ServerSocket serverSocket = new ServerSocket(portNumber); 
			    Socket clientSocket = serverSocket.accept();
				ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
		
				) {
			Data inputLine = null, outputLine = null;
		            
		    System.out.println("Admin Server port " + portNumber + " connected");

		    AdminProtocol kkp = new AdminProtocol();  
		  	
		    // get the command and data from the client
		    inputLine = read(in);
		    
		    while (inputLine != null && clientSocket.isConnected() ) {
		    
			    outputLine = kkp.processInput(inputLine);
			    
			     System.out.println("Admin Server: write data to client");
			    out.writeObject(outputLine); 
			     
			 inputLine = read(in);
			    
		    }
		     
		    
		    in.close();
            out.close();
            serverSocket.close();
		        
	        System.out.println("Admin Server closed");
	            
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		 System.out.println("Admin Server port " + portNumber + " closed");
	}
	
	
	 private Data read(ObjectInputStream in) {
		Data inputLine = null;
		 try {
				inputLine = (Data) in.readObject();
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		 return inputLine;
	}
	 
	 public static void main(String[] args) {
			
		 ServerAdmin cs = new ServerAdmin(1220);
	}
}
