package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

import fbpages.HomePage;
import fbpages.LoginPage;
import setup.BaseForHomePage;
import utilis.Utility;

public class VerifyHomePage extends BaseForHomePage {
	//global obict declartion all & its private
		private WebDriver driver;
		private LoginPage loginpage;
		private HomePage homepage;
		private int TestID;
		
		@Parameters("browser")
		@BeforeTest  //lunch browse code
		public void openBrowser(String browserName)
		{
			System.out.println("Before Test");
			//System.out.println("Chrome");
	//******Cross Browser Testing*****//
			//**Chrome Browser***//
			if(browserName.equals("Chrome"))
			{
				driver=openChromeBrowser();
			}
			if(browserName.equals("Firefox"))
			{
				driver=openFirefoxBrowser();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		
		@BeforeClass  
		public void createPOMObjects()
		{
			 loginpage=new LoginPage(driver);
			 homepage=new HomePage(driver);
		}
		
		@BeforeMethod  
		public void openurl_openhomepage() throws EncryptedDocumentException, IOException
		{
			System.out.println("before method");
			driver.get("https://www.facebook.com/");
			
	/////	/////**fetch data from excel**/////////	
			//String user="truptipatil9495@gmail.com";
			//String pass="omkar1234";
			// loginpage.loginPagefb(user,pass);
			 String user1=Utility.fetchDataFromExcelSheet(6,0);
			 String pass1=Utility.fetchDataFromExcelSheet(6,1);
			 loginpage.loginPagefb(user1,pass1);
			 
			 //loginpage.loginPagefb(data);
			 //homepage.clickMessanger();	 
			// homepage.clickNotification();
		}
		
	@Test
		public void verifyMessangerButton() throws InterruptedException
		{
			TestID=1234;
			System.out.println("Test case 1");
			homepage.clickMessanger();
			String url=driver.getCurrentUrl();
			//System.out.println(url);
			String title=driver.getTitle();
			//System.out.println(title);
								//1actual Result  2 expected given by user story  3failure Message 			
			Assert.assertEquals(url, "https://www.facebook.com/","url is incorrect");
			Assert.assertEquals(title, "Facebook","title is incorrect");
			Thread.sleep(3000);
			//homepage.clickNotification();
		}
		
//**Asseration using Hard Assert/Assert//method is static so call by classname & import**//
//use 3 arg if 1 st asseration fail other assertion not excute in that perticular test case	
		@Test
		public void verifyNotificationButton() throws InterruptedException
		{
			TestID=1235;
			System.out.println("Test Case 2");
			homepage.clickNotification();
			homepage.checkNotificationText();
			String text=homepage.checkNotificationText();
			//System.out.println(text);
			Assert.assertEquals(text, "Notifications","notification text is incoorect");
			Thread.sleep(3000);
			String title=driver.getTitle();
			// System.out.println(title);
			Assert.assertEquals(title, "Facebook","test case 2 title is incorrect");
			
			/*if(text.equals("Notifications"))
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}*/
			
		}
		
		@AfterMethod  //if after the @Test case any code is remaining like logout
		public void logOutFromApplication(ITestResult result) throws InterruptedException, IOException
		{
//Always in@After Method write**Screenshot when Test Case Fail**////each Test Case  with id,date &time//////		
			if(ITestResult.FAILURE==result.getStatus())
			{
			Utility.captureScreenshot(driver, TestID);
			}
				System.out.println("After method for Log Out");
				//Thread.sleep(3000);
				homepage.clickAcoountButton();
				homepage.clickLogoutButton();

		}
		
		@AfterClass //closing broweser code
		public void clearObject()
		{
			
			System.out.println("after class");
			loginpage=null;
			homepage=null;	
		}
		
		@AfterTest
		public void closeBrowser()
		{
			System.out.println("after test");
			driver.quit();
			driver=null;
			System.gc();//garbage collecter in System class inbuild method RT=void	
		}

		
}
