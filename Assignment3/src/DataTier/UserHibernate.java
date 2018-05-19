package DataTier;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import BridgeShow.Show;

public class UserHibernate {

	public UserHibernate() {

	}
	public void addUser(String id, String name, String password, String type,int id2)
	{
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction(); 
		 User us= new User(Integer.parseInt(id),name, password, type,id2); 
		 session.save(us);
		session.getTransaction().commit();
	    System.out.println("Am inserat noul user!");
		session.close();
	}

	public User getUserId(int id) {
		User shows = new User();
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		Query query = session.createQuery("from User where iduser = :id ");
		query.setParameter("id", id);
		shows = (User) query.getSingleResult();
		session.getTransaction().commit();
		session.close();
		return shows;
	}
	public  List<User> selectusers() {
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		List<User> users = null;

		session.beginTransaction();
		users = session.createQuery("from User").list();
		session.getTransaction().commit();
		session.close();
		return users; 
	}

	public User searchUser(String name) {
		User users ;
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		Query query = session.createQuery("from User where nume = :nume ");
		query.setParameter("nume", name);
		users = (User) query.getSingleResult();
		session.getTransaction().commit();
		session.close();
		return users;
	}

	public void update(int id, String name, String pass, String type,List<String>rec) {
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		User uss= getUserId(id); 
		uss.setName(name);
		uss.setPass(pass);
		uss.setType(type);
		uss.setRec(rec);
		session.beginTransaction();
		session.update(uss);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(int iduser) {
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		User s = (User) session.load(User.class, iduser);
		session.delete(s);
		session.flush();
		session.close();

	} 
	public   User getUser(String nume, String password)
	{
		User a= new User();
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where nume = :x and password = :y");
		query.setParameter("x", nume);
		query.setParameter("y", password);
		Object adm= query.getSingleResult();
		a=(User)adm; 
		session.getTransaction().commit();
		session.close();
		return a;
	} 
}
