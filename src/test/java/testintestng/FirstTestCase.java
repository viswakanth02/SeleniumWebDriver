package testintestng;

import org.testng.annotations.Test;

public class FirstTestCase {

	@Test(priority=1)
	void login() {
		System.out.println("Login  the application========>");
	}

	@Test(priority=2)
	void openapp() {
		System.out.println("Opening in the application======>");
	}

	@Test(priority=3)
	void logout() {
		System.out.println("Logout the application========>");
	}

}
