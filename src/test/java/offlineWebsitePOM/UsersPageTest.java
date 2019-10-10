package offlineWebsitePOM;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TesstBase;
import Pages.UsersPage;
import Utility.TestUtil;

public class UsersPageTest extends TesstBase {
	LoginPage loginpage;
    HomePage homePage;
    UsersPage usersPage;


	public UsersPageTest() throws Exception {
		super();
	}
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		loginpage=new LoginPage();
		homePage=loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		usersPage=homePage.clickOnUsersLink();
	}
	@Test
	public void verifyUsersLabel()
	{
		boolean flag=usersPage.verifyUsersLabel();
		System.out.println("is users label is displayed?"+flag);
		Assert.assertTrue(flag);
	}
	@DataProvider
	public Object[][] getTestData1()
	{
		Object[][] data=TestUtil.getTestData("Users");
		return data;
	}

	
	@Test(dataProvider="getTestData1")
	public void addingNewUser(String username,String mobile,String email,String password)
	{
		usersPage.verifyAddUserBtn();
		//usersPage.createNewUser("soni", "8484061096", "pawarsoni21@gmailcom", "123456");
		usersPage.createNewUser(username, mobile, email, password);
		Alert alert=driver.switchTo().alert();
		System.out.println("alert msg is"+alert.getText());
		alert.accept();
	}
	

}

