import java.util.List;

import com.onlinekada.model.MasterModel;
import com.onlinekada.model.KadaUser;

public interface MasterDao <Model extends MasterModel> {

	public void persist(Model transientInstance);

	public void attachDirty(Model instance);

	public void attachClean(Model instance);

	public void delete(Model persistentInstance);

	public Model merge(Model detachedInstance);

	public Model findById(java.lang.String id);

	public List findByExample(Model instance);

}