package LogicTier; 
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import DataTier.User;
import PresentationTier.PremiumFrame; 
public class ClientController {
	private PremiumFrame pf; 
	private final String host = "0.0.0.0";
	private final int portNr = 1220;
	private Socket clientSocket = null;
	private ObjectOutputStream out = null;
	private ObjectInputStream in = null;
	private String nameUser="Bianca";
	private int iduser=1;
	private User us;
	private ServerUser cs;
public ClientController()
{
	
}
	public ClientController(PremiumFrame pf,User us) {
		System.out.println("user");
		this.pf = pf;
	 this.us = us;
	}

	public void connect()   {
		System.out.println("Client: se conecteaza");

		try {
			clientSocket = new Socket(host, portNr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Eroare"+e);
		}
		try {
			out = new ObjectOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Eroare1"+e);
		}
		try {
			in = new ObjectInputStream(clientSocket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Eroare3"+e);		}
		System.out.println("Client: conectat");

	}
	public void getData() throws UnknownHostException, IOException
	{
		if (out==null)
		{
			connect();
		}
		Data ser=null;
		Data cl=new Data();
		cl.operatie="getData";
		System.out.println("Client: scriere server");
		out.writeObject(cl);
		//ia date de la server
		try {
			ser=(Data)in.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Server scrie la client"+e);
		}
		System.out.println("Client: trimite date la interfata");
		List<Object[]> dt= new ArrayList<Object[]>();
		System.out.println("data ce vreau "+dt.get(0));
		for (Object[] obiect:ser.data)
		{
			dt.add(new Object[] {obiect[1],obiect[2]});
			 System.out.println(obiect[1] + " " + obiect[2]);
			
		}
	pf.afisareShows(dt);
	}
	public List<Object[]> searchShow(String name)throws UnknownHostException, IOException 
	{
		List<Object[]> data= new ArrayList<Object[]>();
		if (out==null)
		{
			connect();
		}
		Data ser=null;
		Data cl= new Data();
		cl.operatie="search";
		Object[] o= {name};
		cl.data.add(o);
		System.out.println("Client: scriere server");
		out.writeObject(cl);
		try {
			ser=(Data)in.readObject();
			data=ser.data;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return data;
	}
	public void btnSearch() throws UnknownHostException, IOException
	{
		String numeShow= pf.textSearchShow.getText();
		List<Object []>data=searchShow(numeShow);
		System.out.println("Clientul trimite date la interfata");
 
		pf.afisareShows(data);
	
	}
	public void btnAddInterest() throws UnknownHostException, IOException, ClassNotFoundException
	{
		String name= pf.textSearchShow.getText();
		List<Object[]>data= searchShow(name);
		System.out.println("dat."+data.size());
		int id_show=(int)data.get(0)[5];
		addHistory(id_show);
		
	}
	public void addHistory(int id_show) throws UnknownHostException, IOException, ClassNotFoundException
	{
		if (out==null)
		{
			connect();
		}
			Data ser=null;
			Data cl=new Data();
			cl.operatie="addShowUser";
			Object[] o= {us.getIdUser()};
			cl.data.add(o);
			cl.data.add(new Object[] {id_show});
		
            System.out.println("Client: scriere la server");
            out.writeObject(cl);
            ser=(Data)in.readObject();
           
		
	}
	public void viewHistory() throws UnknownHostException, IOException, ClassNotFoundException
	{
	 
		if (out==null)
		{
			connect();
			System.out.println("s-a facut conectare");
		}
			Data ser=null;
			Data cl=new Data();
			cl.operatie="getShows";
			Object[] o= {us.getIdUser()};
			cl.data.add(o);
			  
            System.out.println("Client: scriere la server");
            out.writeObject(cl);
         
            ser=(Data)in.readObject();
            System.out.println("Clientul trimite date la interfata");
            List<Object[]> data = new ArrayList<Object[]>();
            for(Object[] ob : ser.data) {
           	 data.add(new Object[]{ob[1],ob[2]}); // the name of the show
           }
           pf.afisareShows(data);
	}
	public void medieRate() throws UnknownHostException, IOException, ClassNotFoundException
	{
		String name=pf.textSearchShow.getText();
		String rate= pf.textRate.getText();

		
		List<Object[]> data = searchShow(name);  

		String imdb_no = Double.toString(((double) data.get(0)[3] + Double.parseDouble(rate))/2); 
		
		//float average = imdb_s/imdb_no;
		data.get(0)[3] = imdb_no; 
		 
		update(data);
		btnSearch();
	}

	public void update(List<Object[]> data) throws UnknownHostException, IOException, ClassNotFoundException {
		if (out == null) {
			connect();
		}
		Data ser=null;
		Data cl=new Data();
		cl.operatie="updateShow";
		cl.data=data;

        System.out.println("Client: scriere la server");
        out.writeObject(cl);
 			ser=(Data)in.readObject();
 	 
	}
	public static void main(String[] args) {
		ClientController c= new ClientController();
		PremiumFrame cv = new PremiumFrame();
		cv.setFrame();
	}
}
