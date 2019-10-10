package offlineWebsitePOM;

import org.testng.TestNG;

import Pages.LoginPage;

public class TestRunner {
	static TestNG testNg;
	public static void main(String[] args) {
		testNg=new TestNG();
		testNg.setTestClasses(new Class[] {LoginPageTest.class});
		testNg.run();
		
		
	}

}
