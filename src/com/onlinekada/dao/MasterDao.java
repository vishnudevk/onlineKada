package com.onlinekada.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**This class is used to as the master dao for all the daos in this project
 * @author vishnudev
 *
 */
@Transactional
@Repository 
public class MasterDao {

	
	/**
	 * session factory is getting injected
	 */
	private SessionFactory sessionFactory ;

	/**Used to get the session used in the database related operaions
	 * @return
	 */
	@Transactional
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
