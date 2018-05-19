package BridgeShow;

import java.io.File;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Theatre extends Show implements Implementor{
	public Theatre(int id,String name,String des, String ac, double r,  int id_admin) {
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
		  s.setType("Theatre");
		  s.setIdShow(this.getIdShow());
		  s.setActor(this.getActors());
		  s.setDesc(this.getDes());
		  s.setImdb(0.0f);
		  s.setImdb_notes(0);
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