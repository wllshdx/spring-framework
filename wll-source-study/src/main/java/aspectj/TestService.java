package aspectj;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestService {
	protected final Log logger = LogFactory.getLog(getClass());

	public void eatCarrot() {
		logger.info("eatCarrot start ! ");
		System.out.println("吃萝卜");
		logger.info("eatCarrot end ! ");
	}

	public void eatMushroom() {
		logger.info("eatMushroom start ! ");
		System.out.println("吃蘑菇");
		logger.info("eatMushroom start ! ");
	}

	public void eatCabbage() {
		logger.info("eatCabbage start ! ");
		System.out.println("吃白菜");
		logger.info("eatCabbage start ! ");
	}
}