package testNG;

import org.testng.annotations.*;

/*
 * 1)Login--@BeforeMethod
 * 2)Search--@Test
 * 3)Logout--@AfterMethod
 * 4)Login--
 * 5)Advanced Search--@Test
 * 6)Logout
 */
public class AnnotationDemo1 {
	@BeforeMethod
	void testLogin() {
		System.out.println("Login Successful");
	}
	@Test(priority=1)
	void testSearch() {
		System.out.println("Searching Product");
	}
	@AfterMethod
	void testLogout() {
		System.out.println("Logout SuccessFul");
	}
	@Test(priority=2)
	void testAdvanceSearch() {
		System.out.println("Searching Advance");
	}

}
