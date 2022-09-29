package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import fbpages.HomePage;
import fbpages.LoginPage;
import fbpages.MobileProtationPage;
import utilis.Utility;

public class Testclass1 {
public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	//driver.manage().window().maximize();
	
	LoginPage login=new LoginPage(driver);
//////////////////////////////////////////////////
	
	//Fetch data from excel sheet username&password
	//String user="truptipatil9495@gmail.com";
	//String pass="omkar1234";
	
	String user=Utility.fetchDataFromExcelSheet(6, 0);
	System.out.println(user);
	login.sendUsername(user);
	Thread.sleep(3000);
	String password=Utility.fetchDataFromExcelSheet(0, 1);
	System.out.println(password);
	login.sendUsername(password);
	
	//Thread.sleep(4000);
	//MobileProtationPage mobilepage=new MobileProtationPage(driver);
	
//	mobilepage.clickOnNotNowLink();
	Thread.sleep(3000);
	//login.sendUsername();
	//login.sendPassword();
	//login.clickonLoginButton();
	
	HomePage homepage=new HomePage(driver);
	Thread.sleep(3000);
	homepage.clickMessanger();
	Thread.sleep(3000);
	homepage.clickNotification();
	Thread.sleep(3000);
	homepage.clickAcoountButton();
	Thread.sleep(3000);
	homepage.clickLogoutButton();

	
}
}
