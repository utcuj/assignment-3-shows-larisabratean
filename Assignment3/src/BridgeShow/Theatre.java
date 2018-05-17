package BridgeShow;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Theatre implements Implementor {

	public Theatre()
	{
		super();
	}
	public void add(Show show) {
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		show.setType("Theatre");
		session.save(show);
		
		session.getTransaction().commit();
		 System.out.println("S-a adaugat un teatru!");
		session.close();
	}
}