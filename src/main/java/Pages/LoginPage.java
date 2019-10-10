package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TesstBase{

	public LoginPage() throws Exception  {
		super();
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(linkText="Register a new membership")
	WebElement signUPLink;
	
	@FindBy(xpath="//div[@class='login-logo']")
	WebElement logoImage;
	
	@FindBy(xpath="//div[@id='email_error']")
	WebElement emailError;
	
	@FindBy(id="password_error")
	WebElement passwordError;
	
	@FindBy(xpath="//p[@class='login-box-msg']")
	WebElement logingmsg;
	
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLogo()
	{
		return logoImage.isDisplayed();
	}
	public String validatePageURl()
	{
	  return driver.getCurrentUrl();
	}
	public boolean validateEmailErrorMsg()
	{
		return emailError.isDisplayed();
	}
	public boolean validatePasswordErrorMsg()
	{
		return passwordError.isDisplayed();
	}
	
	public HomePage login(String mail,String pwd) throws Exception
	{
		email.sendKeys(mail);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	
	
	
	
	

}
