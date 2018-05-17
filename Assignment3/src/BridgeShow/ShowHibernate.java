package BridgeShow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ShowHibernate {

	public ShowHibernate() {

	}
	public void add(Show show, ShowAfterAbstraction sb) { // without id
		sb.add(show);
	}
	public   List<Show> selectShows() {
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		List<Show> shows = null;

		session.beginTransaction();
		shows = session.createQuery("from Show").list();
		session.getTransaction().commit();
		session.close();
		return shows;
		 
	}

	public List<Show> searchShow(String name) {
		List<Show> shows = new ArrayList<Show>();
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		Query query = session.createQuery("from Show where name = :name ");
		query.setParameter("name", name);
		shows = query.getResultList();
		session.getTransaction().commit();
		session.close();
		return shows;
	}
	public Show getShow(int id) {
		Show shows = new Show();
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		Query query = session.createQuery("from Show where idshow = :id ");
		query.setParameter("id", id);
		shows = (Show) query.getSingleResult();
		session.getTransaction().commit();
		session.close();
		return shows;
	}
	public void update(Show show) {
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.update(show);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(int id) {
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		Show s = (Show) session.load(Show.class, id);
		session.delete(s);
		session.flush();
		session.close();

	} 
	
}