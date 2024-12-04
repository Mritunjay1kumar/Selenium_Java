package annotationBeforeAfterTest;

import org.testng.annotations.*;

public class C3 {
	
	@Test
	void pqr() {
		System.out.println("C3 is launching");
	}
	@BeforeSuite
	void bs() {
		System.out.println("Before suite is running");
	}
	@AfterSuite
	void as() {
		System.out.println("After suite is running");
	}

}
