package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UsersPage  extends TesstBase{

	public UsersPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//h1[contains(text(),'Users')]")
	WebElement usersLabel;
	
	
	@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-sm pull-right']")
	WebElement addUserBtn;
	@FindBy(id="username")
	WebElement userName;
	@FindBy(id="mobile")
	WebElement mobileNo;
	@FindBy(id="email")
	WebElement email;
	@FindBy(id="Female")
	WebElement gender;
	@FindBy(id="password")
	WebElement password;
	@FindBy(xpath="//button[@class='btn btn-info pull-right']")
	WebElement submitBtn;
	
	
	public boolean verifyUsersLabel()
	{
		return usersLabel.isDisplayed();
	}
	
	public void verifyAddUserBtn()
	{
		addUserBtn.click();
	}
	public void createNewUser(String usName,String mobNo,String mail,String pwd)
	{
		userName.sendKeys(usName);
		mobileNo.sendKeys(mobNo);
		email.sendKeys(mail);
		gender.click();
		Select select=new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		select.selectByVisibleText("Delhi");
		password.sendKeys(pwd);
		submitBtn.click();
		
		
		
		
	}
	
	

}
