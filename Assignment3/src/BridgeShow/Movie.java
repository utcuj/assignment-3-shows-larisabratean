package BridgeShow;

import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Movie implements Implementor{

	public Movie()
	{
		super();
	}
	@Override
	public void add(Show show) {
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();

		show.setType("Movie");
		session.save(show);
		session.getTransaction().commit();
		 System.out.println("S-a adaugat un movie!");
		session.close();
		
	     
		
	}
 

}
