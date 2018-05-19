package BridgeShow;

import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Movie extends Show implements Implementor{
	public Movie(int id,String name,String des, String ac, double r,  int id_admin) {
		super(id,name,des,ac, r,1);
 
	}
	@Override
	public void add() {
		final ServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
		        .build();
		try {
		    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		    Session session = sessionFactory.openSession();
		    session.beginTransaction();
		  Show s= new Show();
		  s.setType("Movie");
		  s.setIdShow(this.getIdShow());
		  s.setActor(this.getActors());
		  s.setDesc(this.getDes());
		  s.setImdb(0.0f);
		  s.setImdb_notes(0);
		  s.setIdA(1);
		  s.setName(this.getName()); 
		    session.save(s);
		    session.getTransaction().commit();
		    session.close();
		
		    sessionFactory.close();
		
		
		} catch (Exception ex) {
			System.out.println("eroare"+ex);
			ex.printStackTrace();
		    StandardServiceRegistryBuilder.destroy(registry);
		}// TODO Auto-generated method stub
}
}