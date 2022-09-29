package setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseForRoomPage {

	public WebDriver openChromeBrowser()
	{
		System.out.println("Chrome Browser Open");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
		
	}
		
	public WebDriver openFirefoxBrowser()
		{
			System.out.println("Firefox Browser open");
			System.setProperty("webdriver.gecko","D:\\geckodriver.exe");
			WebDriver driver=new FirefoxDriver();
			return driver;
		}
	}
	

