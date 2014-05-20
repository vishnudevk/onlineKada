package com.onlinekada.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;

import com.onlinekada.dao.GenericDao;
import com.onlinekada.dao.MasterDao;
import com.onlinekada.model.MasterModel;

public class GenericDaoImpl<model extends MasterModel> extends MasterDao implements GenericDao<model> {

	private Logger logger = Logger.getLogger(GenericDaoImpl.class);

	@Override
	public void persist(model transientInstance) {
		logger.debug("persisting model instance");
		try {
			getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(model instance) {
		logger.debug("attaching dirty model instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(model instance) {
		logger.debug("attaching clean model instance");
		try {
			getCurrentSession().lock(instance, LockMode.NONE);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	public void delete(model persistentInstance) {
		logger.debug("deleting model instance");
		try {
			getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	public model merge(model detachedInstance) {
		logger.debug("merging model instance");
		try {
			model result = (model) getCurrentSession().merge(
					detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	public model findById(Object id) {
		logger.debug("getting model instance with id: " + id);
		try {
			model instance = (model) getCurrentSession().get(
					"model", (Serializable) id);
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

	public List<model> findByExample(model instance) {
		logger.debug("finding model instance by example");
		try {
			List<model> results = getCurrentSession()
					.createCriteria("model").add(Example.create(instance))
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
