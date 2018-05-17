package LogicTier;
 
import java.io.IOException; 
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream; 
import java.net.ServerSocket;
import java.net.Socket;
 

public class ServerUser {
	public int port ; 
	public ServerUser(int port) throws ClassNotFoundException {
		this.port = port;
		connect();
	}

	public void connect() throws ClassNotFoundException {
		System.out.println("port server" + port + " connecting..");
	
 
	try
		(
			ServerSocket client = new ServerSocket(port); 
		Socket s1 = client.accept(); 
		ObjectOutputStream	out = new ObjectOutputStream(s1.getOutputStream());
		ObjectInputStream	in = new ObjectInputStream(s1.getInputStream());
		)
		{Data inputL=new Data();
		Data outputL=new Data();
		System.out.println("Server port " + port + " connected");
		inputL=read(in);
		ClientProtocol pro=new ClientProtocol();
	 while(inputL!=null && s1.isConnected() ) {
			outputL=pro.procesare(inputL);
			System.out.println("Server scrie la client");
			out.writeObject(outputL);
		 	inputL=read(in);
		
			System.out.println("a scrisss");
	 }
		in.close();
		out.close();
		client.close();
		System.out.println("S-a terminat server-ul");
	}catch(IOException ev)
	{
		System.out.println("eroare"+ev);
	}
	}
	
	
	
	 private Data read(ObjectInputStream in)  {
		Data inputL=null;
	 
	
			try {
				inputL=(Data)in.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 
		return inputL;
	}

	public static void main(String[] args) throws ClassNotFoundException {
			
			ServerUser cs = new ServerUser(1220);
	}
}
