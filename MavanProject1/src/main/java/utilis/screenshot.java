package utilis;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenshot {
	int TestID;
public static void main(String[] args) throws IOException {
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	int TestID=1234;
	Utility.captureScreenshot(driver, TestID);
	driver.close();
	Utility.fetchDataFromExcelSheet(0, 0);
}
}
