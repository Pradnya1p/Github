package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

//import fbpages.JavascriptExcutor;
import fbpages.LoginPage;
import fbpages.MessengerPage;
import fbpages.RoomPage;

public class Testclass {
public static void main(String[] args) throws IOException, InterruptedException {
System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	LoginPage loginpage=new LoginPage(driver);
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,3000)");//scroll down
	
	if(loginpage.checknewaccButtonIsenable()==true)
	{
		System.out.println("create new button is enable");
	}else {
		System.out.println("create new button is not enable");
	}
	loginpage.clicknewaccButton();
	
	loginpage.openmessenger();
	
	MessengerPage messengerpage=new MessengerPage(driver);
	messengerpage.openrooms();
	
	RoomPage roompage=new RoomPage(driver);
	roompage.openhelpcenterButton();
	driver.navigate().back();
	roompage.openreturnmessengerButton();
	Thread.sleep(3000);
	TakesScreenshot take=(TakesScreenshot)driver;
	File src=take.getScreenshotAs(OutputType.FILE );
	File dest =new File("H:\\Screenshort\\Fb1.jpeg");
	FileHandler.copy(src, dest);
	
	
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
}

}
//******************TEST CLASS(no need of webelement required driver)*************************************
//script(code)in Test class
//implicite wait
//alert popup ->driver.switchto().alert()
//child browser page->driver.swithto().window(new address)1.getwindowHandles()method use
//iframe //using index only code in test class
//if else,for loop[java realted concept in psvm()]
