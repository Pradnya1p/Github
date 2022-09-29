package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import fbpages.LoginPage;
import fbpages.MessengerPage;
import fbpages.RoomPage;

import setup.BaseForRoomPage;
import utilis.Utility;

public class VerifyRoomPageButton extends BaseForRoomPage  {
	//global obict declartion all & its private
	private WebDriver driver;
	private LoginPage loginpage;
	private MessengerPage messengerpage;
	private RoomPage roompage;
	private int TestID;
//**Asseration //SoftAssert //non static method create object & import
	private SoftAssert soft;//declared globally
	
	@Parameters("browser")
	@BeforeTest//lunch browse code
	public void openBrowser(String browserName)
	{
		System.out.println("Before Test");
		if(browserName.equals("Chrome"))
		{
//			System.out.println("Chrome Browser Open");
//			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//			WebDriver driver=new ChromeDriver();
			driver=openChromeBrowser();
		}
		
		if(browserName.equals("Firefox"))
		{
			driver=openFirefoxBrowser();
		}
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@BeforeClass  //create objects of POM classes all 
	public void  createPOMObjects()
	{
		System.out.println("Before class objects of POM");
		loginpage=new LoginPage(driver);
		messengerpage=new MessengerPage(driver);
		roompage=new RoomPage(driver);
		soft=new SoftAssert();//softAssert object created
	}
	
	@BeforeMethod  //url & POM class all methods which we create in mavan src/main/java
	public void openurl_openroompage()
	{
		System.out.println("Before Method");
		driver.get("https://www.facebook.com/");
		//driver.manage().window().maximize();
		loginpage.openmessenger();
		messengerpage.openrooms();	
		

	}
	
	@Test  //test case which we validate 
	public void verifyVisitHelpCenterButton()
	{
		TestID=001;
		System.out.println("Test case 1 ");
		roompage.openhelpcenterButton();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		System.out.println(url);
		System.out.println(title);
						//actual //expected in us  faluire message
		soft.assertEquals(url, "https://www.messenger.com/help","messangerhelp page not found");
		soft.assertEquals(title, "Messenger Help Centre");
		soft.assertAll();//alwayse use all()then then it run
		
		/*System.out.println("***************************");
		if(url.equals("https://www.messenger.com/help") && title.equals("Messenger Help Centre"))
		{
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}*/
	}
	@Test
	public void verifyReturnToMessangerButton ()
	{
		TestID=002;
		System.out.println("Test Case 2");
		roompage.openreturnmessengerButton();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		System.out.println(url);
		System.out.println(title);
		
		soft.assertEquals(title, "Messenger","messenger page not found");
		/*System.out.println("***************************");
		if(url.equals("https://www.messenger.com/")&& title.equals("Messenger"))
		{
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}*/
	}
		
	@AfterMethod  //if after the @Test case any code is remaining like logout
	//Always in@After Method write**Screenshot when Test Case Fail**////each Test Case  with id,date &time//////		
	public void aftermethod(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
		Utility.captureScreenshot(driver, TestID);
		}
			System.out.println("After method");
	}
	
	
	@AfterClass //closing broweser code
	public void clearObjects()
	{
		System.out.println("After class");
		loginpage=null;
		messengerpage=null;
		roompage=null;	
	}
	
	@AfterTest//close the browser
	public void closeBrowser()
	{
		System.out.println("After Test");
		driver.quit();
		driver=null;
		System.gc();//garbage collector
	}
	
	
}
