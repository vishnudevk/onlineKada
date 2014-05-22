onlineKada
==========
TBD

annotations
@Repository("myCommodityDao")
public class CommodityDaoImpl extends GenericHibernateDao<Commodity> implements
		TableMaintenanceDao<Commodity> {
		
		
		
		
@Service("commodityBo")
@Transactional(readOnly = true)
public class CommodityBoImpl implements TableMaintenanceBo<CommodityDto> {
