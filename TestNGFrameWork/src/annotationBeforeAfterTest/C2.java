package annotationBeforeAfterTest;

import org.testng.annotations.*;

public class C2 {
	@Test
	void xyz() {
		System.out.println("C2 Appilication is working");
	}
	@AfterTest
	void at() {
		System.out.println("After test is working");
	}

}
