// default package
// Generated 16 May, 2014 1:24:27 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class UserPrivilage.
 * @see .UserPrivilage
 * @author Hibernate Tools
 */
public class UserPrivilageHome {

	private static final Logger log = Logger.getLogger(UserPrivilageHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(UserPrivilage transientInstance) {
		log.debug("persisting UserPrivilage instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(UserPrivilage instance) {
		log.debug("attaching dirty UserPrivilage instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserPrivilage instance) {
		log.debug("attaching clean UserPrivilage instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(UserPrivilage persistentInstance) {
		log.debug("deleting UserPrivilage instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserPrivilage merge(UserPrivilage detachedInstance) {
		log.debug("merging UserPrivilage instance");
		try {
			UserPrivilage result = (UserPrivilage) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserPrivilage findById(int id) {
		log.debug("getting UserPrivilage instance with id: " + id);
		try {
			UserPrivilage instance = (UserPrivilage) sessionFactory
					.getCurrentSession().get("UserPrivilage", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserPrivilage instance) {
		log.debug("finding UserPrivilage instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("UserPrivilage")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
