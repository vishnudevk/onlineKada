package com.onlinekada.dao;
import java.util.List;

import com.onlinekada.model.MasterModel;

public interface GenericDao <Model extends MasterModel> {

	public void persist(Model transientInstance);

	public void attachDirty(Model instance);

	public void attachClean(Model instance);

	public void delete(Model persistentInstance);

	public Model merge(Model detachedInstance);

	public Model findById(Object id);

	public List<Model> findByExample(Model instance);

}