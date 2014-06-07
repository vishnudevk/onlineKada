package com.onlinekada.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Expression;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlinekada.dao.MasterDao;
import com.onlinekada.model.KadaUser;


@Repository("userDaoImpl")
public class UserDaoImpl extends MasterDao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(GenericDaoImpl.class);

	public void persist(KadaUser transientInstance) {
		logger.debug("persisting User instance");
		try {
			getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(KadaUser instance) {
		logger.debug("attaching dirty User instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(KadaUser instance) {
		logger.debug("attaching clean User instance");
		try {
			getCurrentSession().lock(instance, LockMode.NONE);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void delete(KadaUser persistentInstance) {
		logger.debug("deleting User instance");
		try {
			getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	public KadaUser merge(KadaUser detachedInstance) {
		logger.debug("merging User instance");
		try {
			KadaUser result = (KadaUser) getCurrentSession().merge(
					detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	public KadaUser findById(Object id) {
		logger.debug("getting User instance with id: " + id);
		try {
			KadaUser instance = (KadaUser) getCurrentSession().get(
					(KadaUser.class), (Serializable) id);
			if (instance == null) {
				logger.debug("get successful, no instance found");
			} else {
				logger.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}
	
	@Transactional
	public List<KadaUser> findByExample(KadaUser instance) {
		logger.debug("finding User instance by example");
		try {
			List<KadaUser> results = getCurrentSession()
					.createCriteria(KadaUser.class).add(Example.create(instance).excludeZeroes()).add(Expression.eq("userName", instance.getUserName()))
					.list();
			logger.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			logger.error("find by example failed", re);
			throw re;
		}
	}
}
