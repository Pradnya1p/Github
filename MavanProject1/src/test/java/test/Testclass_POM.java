package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import fbpages.CreatenewAccpage;
import fbpages.SamplePage;

public class Testclass_POM {
public static void main(String[] args)  {
System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
	driver.get("https://www.facebook.com/");
	//driver.manage().window().maximize();

	SamplePage login=new SamplePage(driver);
	login.clickcreateAccButton();
	
	CreatenewAccpage createacc=new CreatenewAccpage(driver);
	//Thread.sleep(2000);
	createacc.dropdown();
	createacc.dragAnddrop();
	createacc.explicitywait();
	
}
}
//implicite wait
//child browser
//iframe by index