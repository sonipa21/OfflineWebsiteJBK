package offlineWebsitePOM;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TesstBase;

public class LoginPageTest extends TesstBase {
	
	LoginPage loginpage;
    HomePage homePage;
	public LoginPageTest() throws Exception {
		super();
		
	}
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test
	public void  loginPageTitleTest()
	{
	  String title=	loginpage.validateLoginPageTitle();
	  System.out.println("actual tile is"+title);
	  String exceptedTitle="AdminLTE 2 | Log in";
	  Assert.assertEquals(title, exceptedTitle);
	}
	
	@Test
	public void ImageTest()
	{
		boolean flag=loginpage.validateLogo();
		System.out.println("image is displayed"+flag);
		Assert.assertTrue(flag);
	}
	@Test
	public void loginPageUrlTest()
	{
	  String myurl=	loginpage.validatePageURl();
	  System.out.println("actual url is"+myurl);
	  String exceptedURl="file:///C:/Selenium%20Software/Offline%20Website/index.html";
	  Assert.assertEquals(myurl, exceptedURl);
	}
	
	@Test
	public void loginTest() throws Exception
	{
		homePage=loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		
		
	}
	
	
	
	

}
