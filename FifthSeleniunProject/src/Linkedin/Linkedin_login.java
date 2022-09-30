package Linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;//3.impot JavascriptExecutor
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Linkedin_login {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		
		d.get("https://www.linkedin.com/login");
		d.manage().window().maximize();
		
		WebElement username=d.findElement(By.xpath("//input[@ id='username']"));
		username.sendKeys("truptipatil9495@gmail.com");
		
		WebElement signin=d.findElement(By.xpath("//button[text()='Sign in']"));
		signin.click();
		Thread.sleep(1000);
		
		//Scroll down 1.find the element to get visible so xpath
		WebElement joinNow=d.findElement(By.xpath("//a[@id='join_now']"));
		
		//2.use JavascriptExecutor is  interface used to execute JavaScript with Selenium 
		JavascriptExecutor js=(JavascriptExecutor)d;
		
		//4JavascriptExecutor method executorScript(arguments,script)
		
		//Script – This is the JavaScript that needs to execute.
		//Arguments – It is the arguments to the script. It’s optional.
		js.executeScript("arguments[0].scrollIntoView(true);",joinNow);
		joinNow.click();
		
		WebElement email=d.findElement(By.xpath("//input[@id='email-or-phone']"));
		email.sendKeys("truptipatil9495@gmail.com");
		
		
		WebElement password=d.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("sunita1234");
		
		
		WebElement agreeAndjoin=d.findElement(By.xpath("//button[@id='join-form-submit']"));
		agreeAndjoin.click();
		d.navigate().back();

		
		
		
		//d.close();
		
	}
}
