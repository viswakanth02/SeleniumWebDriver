package testintestng;

import org.testng.annotations.*;

public class AllAnnotations {
	@BeforeSuite
	void bs() {
		System.out.println("This is from @BeforeSuite =======>");
	}

	@AfterSuite
	void as() {
		System.out.println("This is from @AfterSuite =======>");
	}

	@BeforeTest
	void bt() {
		System.out.println("This is from @BeforeTest =======>");
	}

	@AfterTest
	void at() {
		System.out.println("This is from @AfterTest =======>");
	}

	@BeforeClass
	void bc() {
		System.out.println("This is from @BeforeClass =======>");
	}

	@AfterClass
	void ac() {
		System.out.println("This is from @AfterClass =======>");
	}

	@BeforeMethod
	void bm() {
		System.out.println("This is from @BeforeMethod =======>");
	}

	@AfterMethod
	void am() {
		System.out.println("This is from @AfterMethod =======>");
	}

	@Test(priority = 1)
	void tm1() {
		System.out.println("This is from Test Method 1 ========>");
	}

	@Test(priority = 2)
	void tm2() {
		System.out.println("This is from Test Method 2 ========>");
	}
}
