package com.onlinekada.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**This class is used to as the master dao for all the daos in this project
 * @author vishnudev
 *
 */
public class MasterDao {

	
	/**
	 * session factory is getting injected
	 */
	private SessionFactory sessionFactory ;

	/**Used to get the session used in the database related operaions
	 * @return
	 */
	protected Session getCurrentSession(){
		 return sessionFactory.getCurrentSession();
	}
	
	/**
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
