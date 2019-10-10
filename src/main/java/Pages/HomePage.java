package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TesstBase {

	public HomePage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//p[contains(text(),'Kiran')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Users')]")
	WebElement usersLink;
	
	@FindBy(xpath="//span[contains(text(),'Operators')]")
	WebElement operatorsLink;
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	WebElement logoutLink;
	
	@FindBy(xpath="//i[@class='fa fa-circle text-success']")
	WebElement statusOfUser;
	
	public boolean verifyCorrectUserLabel()
	{
		return usernameLabel.isDisplayed();
	}
	
	public String verifyHomePageTitle()
	{
	  return driver.getTitle();
	}
	public UsersPage clickOnUsersLink() throws Exception
	{
		usersLink.click();
		return new UsersPage();
	}
	public OperatorsPage clickOnOperatorsLink() throws Exception
	{
		operatorsLink.click();
		return new OperatorsPage();
	}
	public void verifyUserStatus()
	{
		statusOfUser.isDisplayed();
		
	}

}
