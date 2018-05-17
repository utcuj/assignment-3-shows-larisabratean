package DataTier;

import java.io.File;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import BridgeShow.Show;
 
public class OperationsHibernate {

	@SuppressWarnings("unchecked")
	public List<Show> getHistoryShows(int id) { 
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
	 
		session.beginTransaction();
		 
        @SuppressWarnings("deprecation")
		Criteria c = session.createCriteria(Show.class)
            .addOrder(Order.asc("idshow"))
            .createCriteria("users", Criteria.LEFT_JOIN)
            .addOrder(Order.asc("iduser"))
            .add(Restrictions.eq("iduser", id))
            .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return c.list();
  
	 
	}

	public void addShowUser(int idu, int ids) {
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("C:\\Users\\larisa\\workspace\\Assignment3\\hibernate.cfg.xml"))
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		  User use = (User)session.get(User.class, idu); 
		  System.out.println(use.getName());
		  
          Show sh = (Show)session.get(Show.class, ids);
          System.out.println(sh.getName());
          use.getSh().add(sh);
          session.save(use);
		session.getTransaction().commit();
		session.close();
	}

 
}
