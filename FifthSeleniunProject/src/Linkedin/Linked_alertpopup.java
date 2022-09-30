package Linkedin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Linked_alertpopup {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver_win32\\\\chromedriver.exe");
	WebDriver d=new ChromeDriver();
	
	d.get("https://www.linkedin.com/login");
	
	Alert alt=d.switchTo().alert();
	alt.accept();
	
}
}
