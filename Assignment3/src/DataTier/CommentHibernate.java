package DataTier;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import BridgeShow.Comment; 
 

public class CommentHibernate {

	public void addCommentDAO(BridgeShow.Comment c,String nume){
		 SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		    session.save(c);
		    System.out.println("Added comment: "+c.getComment()+" by "+nume);
		    session.getTransaction().commit();
			session.close();
	}

	public void deleteCommentDAO(Comment s){ 
		SessionFactory sessionFactory = new Configuration()
					.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			  session.delete(s);
			  
			    session.getTransaction().commit();
				session.close();
		  
	}
}
