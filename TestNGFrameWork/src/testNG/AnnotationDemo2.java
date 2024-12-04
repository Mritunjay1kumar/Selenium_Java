package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

public class AnnotationDemo2 {
	
	@BeforeClass
	void testLogin() {
		System.out.println("Login Successful");
	}
	@Test(priority=1)
	void testSearch() {
		System.out.println("Searching Product");
	}
	@AfterClass
	void testLogout() {
		System.out.println("Logout SuccessFul");
	}
	@Test(priority=2)
	void testAdvanceSearch() {
		System.out.println("Searching Advance");
	}

}
