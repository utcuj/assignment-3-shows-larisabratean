package DataTier;

import java.io.File; 
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class AdminHibernate {

	public AdminHibernate() {

	}

	public List<Admin> selectAdmins() {
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		List<Admin> admins = null;

		session.beginTransaction();
		admins = session.createQuery("from admin").list();
		session.getTransaction().commit();
		session.close();
		return admins;  
	}
	public Admin getAdmin(String nume, String password)
	{
		Admin a= new Admin();
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Admin where nume = :x and password = :y");
		query.setParameter("x", nume);
		query.setParameter("y", password);
		Object adm= query.getSingleResult();
		a=(Admin)adm; 
		session.getTransaction().commit();
		session.close();
		return a;
	} 
}
