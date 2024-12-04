package assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo {
	@Test
	void testTitle() {
		
		String act_title="openshot";
		String exp_title="openshot";
		Assert.assertEquals(act_title, exp_title);
		
	}

}
