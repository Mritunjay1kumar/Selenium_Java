package testNG;

import org.testng.annotations.Test;

/*
 *open app
 *login
 *logout
 */

public class FirstTestCase {
	
	@Test(priority=0)
	void openApp() {
		System.out.println("Opening Application");
	}
	
	@Test(priority=1)
	void login() {
		
		System.out.println("Login Application");
	}
	@Test(priority=2)
	void logout() {
		
		System.out.println("Logging out Application");
	}

}
