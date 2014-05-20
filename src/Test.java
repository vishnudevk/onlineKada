import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Test.class);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		logger.debug(factory.isClosed());
	}

}
