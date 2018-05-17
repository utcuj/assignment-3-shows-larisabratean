package LogicTier;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import DataTier.Admin;
import PresentationTier.AdminUser;
import PresentationTier.PremiumFrame; 
public class AdminController {
	private final String host = "0.0.0.0";
	private final int portNr = 1220;
private Admin ur;
private Socket kkSocket = null;
private ObjectOutputStream out = null;
private ObjectInputStream in = null;
private AdminUser pf;
	public AdminController(AdminUser pf, Admin ur) {
		System.out.println("admin");
		this.pf = pf;
		this.ur = ur;
	}
	public AdminController()
	{
		
	}

	public void connect() {	
		System.out.println("Admin: try to connect");

		// connect to the server
		try {
			kkSocket = new Socket(host, portNr);
			out = new ObjectOutputStream(kkSocket.getOutputStream());
			in = new ObjectInputStream(kkSocket.getInputStream());
			System.out.println("Client: connected");
		} catch (UnknownHostException e) {
            System.err.println("Don't know about host " + host);
            System.exit(1);
        } catch (IOException e) {
		 System.err.println("Client (connect): Couldn't get I/O for the connection to " + host);
         System.exit(1);
        } 	
		
	}
	 
	
	public void btnUpdateClicked() {
		Object[] data = pf.getData();
		
		if (out == null) {
			connect();
		}
		
        try {
            Data fromServer = null;
            Data fromUser = new Data();
 
            // send the command with data to server
            fromUser.operatie = "updateShow";  
            fromUser.data.add(data);
            
            System.out.println("Admin: write to server");
            out.writeObject(fromUser);
            
            // get data from server
            try {
				fromServer = (Data) in.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
            
        } catch (IOException e) {
            System.err.println("Admin (btnAddClicked): Couldn't get I/O for the connection to " + host);
            System.exit(1);
        } finally {
        }
	}
	
	public void btnAddClicked() {
		Object[] data = pf.getData();
		
		if (out == null) {
			connect();
		}
		
            Data fromServer = null;
            Data fromUser = new Data();
 
            // send the command with data to server
            fromUser.operatie = "addShow";  
            fromUser.data.add(data);
            
            System.out.println("Admin: write to server");
            try {
				out.writeObject(fromUser);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
             
            
       
	}
	
	public void btnAddUserClicked() {
		Object[] data = pf.getUserData();
		
		if (out == null) {
			connect();
		}
		
        try {
            Data fromServer = null;
            Data fromUser = new Data();
 
            // send the command with data to server
            fromUser.operatie = "addUser";  
            fromUser.data.add(data);
            
            System.out.println("Admin: write to server");
            out.writeObject(fromUser);
            
            // get data from server
            try {
				fromServer = (Data) in.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
            
        } catch (IOException e) {
            System.err.println("Admin (btnAddUserClicked): Couldn't get I/O for the connection to " + host);
            System.exit(1);
        } finally {
        }
	}
	
	public void btnDisplayAllClicked() {
		displayAll();
		displayAllUsers();
	}
	
	public void displayAll() {
		if (out == null) {
			connect();
		}
		
        try {
            Data fromServer = null;
            Data fromUser = new Data();
 
            // send the command with data to server
            fromUser.operatie = "retriveAll"; System.out.println("Admin: write to server");
            out.writeObject(fromUser);
            
            // get data from server
            try {
				fromServer = (Data) in.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
            
            // {s.getId_show(), s.getName(), s.getType(), s.getDescription(), s.getRelease_date(), s.getImdb_no(), s.getImdb_s()}
            // tell and send to gui what to display from the data received from the server
            System.out.println("Admin: send data to gui");        
	        pf.displayShows(fromServer.data);

			//closeServer();

        } catch (IOException e) {
            System.err.println("Client (retrieveAll): Couldn't get I/O for the connection to " + host);
            System.exit(1);
        } finally {
        	// tell the server to close
        	//closeServer();
        }
	}
	
	public void displayAllUsers() {
		if (out == null) {
			connect();
		}
		
        try {
            Data fromServer = null;
            Data fromUser = new Data();
 
            // send the command with data to server
            fromUser.operatie = "retrieveAllUsers"; System.out.println("Admin: write to server");
            out.writeObject(fromUser); 
            
            // get data from server
            try {
				fromServer = (Data) in.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
            
            // {s.getId_show(), s.getName(), s.getType(), s.getDescription(), s.getRelease_date(), s.getImdb_no(), s.getImdb_s()}
            // tell and send to gui what to display from the data received from the server
            System.out.println("Admin: send data to gui");        
	        pf.displayUsers(fromServer.data);

			//closeServer();

        } catch (IOException e) {
            System.err.println("Client (retrieveAll): Couldn't get I/O for the connection to " + host);
            System.exit(1);
        } finally {
        	// tell the server to close
        	//closeServer();
        }
	}

	public void btnDeleteClicked() {
		Object[] data = pf.getData(); 

		if (out == null) {
			connect();
		}
		
        try {
            Data fromServer = null;
            Data fromUser = new Data();
 
            // send the command with data to server
            fromUser.operatie = "deleteShow";  
            fromUser.data.add(data);
            
            System.out.println("Admin: write to server");
            out.writeObject(fromUser);
            
            // get data from server
            try {
				fromServer = (Data) in.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
            
        } catch (IOException e) {
            System.err.println("Admin (btnDeleteClicked): Couldn't get I/O for the connection to " + host);
            System.exit(1);
        } finally {
        }
	}
	
public List<Object[]> search(String name) {
		
		List<Object[]> data = new  ArrayList<Object[]>();
		
		if (out == null) {
			connect();
		}
		
        try {
            Data fromServer = null;
            Data fromUser = new Data();
 
            // send the command with data to server
            fromUser.operatie = "search"; 
            Object[] o = {name};
            fromUser.data.add(o); 
            
            out.writeObject(fromUser);
            
            // get data from server
            try {
				fromServer = (Data) in.readObject();
				
				data = fromServer.data;
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

        } catch (IOException e) {
            System.err.println("Admin (search): Couldn't get I/O for the connection to " + host);
            System.exit(1);
        } finally {
        }
        
        return data;
	}
	
	public void btnDeleteUserClicked() {
		Object[] data = pf.getUserData();
		
		if (out == null) {
			connect();
		}
		
        try {
            Data fromServer = null;
            Data fromUser = new Data();
 
            // send the command with data to server
            fromUser.operatie = "deleteUser";  
            fromUser.data.add(data);
            
            System.out.println("Admin: write to server");
            out.writeObject(fromUser);
            
            // get data from server
            try {
				fromServer = (Data) in.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
            
        } catch (IOException e) {
            System.err.println("Admin (btnDeleteUserClicked): Couldn't get I/O for the connection to " + host);
            System.exit(1);
        } finally {
        }
	}
		
	public void btnUpdateUserClicked() {
		Object[] data = pf.getUserData();
		
		if (out == null) {
			connect();
		}
		
        try {
            Data fromServer = null;
            Data fromUser = new Data();
 
            // send the command with data to server
            fromUser.operatie = "updateUser";  
            fromUser.data.add(data);
            
            System.out.println("Admin: write to server");
            out.writeObject(fromUser);
            
            // get data from server
            try {
				fromServer = (Data) in.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
            
        } catch (IOException e) {
            System.err.println("Admin (updateUser): Couldn't get I/O for the connection to " + host);
            System.exit(1);
        } finally {
        }
	}
	 

	public void closeServer() {
		System.out.println("Admin: tell server to close");
		 try {
				out.writeObject(null);
				in.close();
		        out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
         System.out.println("Admin: closed");    
	}
	
	
	

	public static void main(String[] args) {
		AdminController c= new AdminController();
	 
		AdminUser av = new AdminUser();
		av.setFrame(); 
		
	}
	
}
