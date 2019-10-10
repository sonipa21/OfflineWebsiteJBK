package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesstBase {
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TesstBase() throws Exception
	{
		prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\JBK Eclipse Configured 32-bit\\offlineWebsitePOM\\src\\main\\java\\config\\config.properties");
		prop.load(ip);
	}
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32 new\\chromedriver.exe"); 
		    driver=new ChromeDriver(); 
			
		}
		else if(browserName=="Firefox")
		{
			driver=new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
