package offlineWebsitePOM;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TesstBase;
import Pages.UsersPage;

public class HomePageTest extends TesstBase {
	LoginPage loginpage;
    HomePage homePage;
    UsersPage usersPage;

	public HomePageTest() throws Exception {
		super();
		
	}
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homePage=loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyHomePageTitleTest()
	{
		String mytitle=homePage.verifyHomePageTitle();
		System.out.println("title is"+mytitle);
		String exceptedTitle="AdminLTE 2 | Dashboard";
		Assert.assertEquals(mytitle, exceptedTitle);
	}
	
	@Test
	public void verifyUserLabelTest()
	{
		boolean flag=homePage.verifyCorrectUserLabel();
		System.out.println("is correct username is displaed?"+flag);
		Assert.assertTrue(flag);
	}
	@Test
	public void verifyUsersLinkTest() throws Exception
	{
		usersPage=homePage.clickOnUsersLink();
	}
	
	
	
	

}
