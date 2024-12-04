package annotationBeforeAfterTest;

import org.testng.annotations.*;

public class C1 {
	
	@Test
	void abc() {
		System.out.println("Logining in Application");
	}
	@BeforeTest
	void bt() {
		System.out.println("Before test is working");
	}

}
