package fbpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Declaration og variables is private so its encapsulation &abstraction  support i.e webelement
	@FindBy(xpath="//input[@ id='email']")
	private WebElement username;
	
	@FindBy(xpath="//input[@ id='pass']")
	private WebElement pass;
	
	@FindBy(xpath="//button[@name='login'] ")
	private WebElement loginbutton;
	
	@FindBy(xpath="//a[text()='Messenger']")
	private WebElement messenger;
	
	@FindBy(xpath="//a[text()='Create New Account'] ")
	private WebElement newaccButton;

	//initalizationof webelement 
	public LoginPage(WebDriver driver)//constructor is public 
	{
		PageFactory.initElements(driver, this);
	}
	
	//use //methods in webelement action perform functions
	public void sendUsername(String user)//public AS
	{
		//username.sendKeys("truptipatil9495@gmail.com");
		username.sendKeys(user);
	}
	public void sendPassword(String password)
	{
		//password.sendKeys("omkar1234");
		pass.sendKeys(password);
	}
	
	public void clicknewaccButton()
	{
		newaccButton.click();
		
	}
	/*public void clickonLoginButton()
	{
		loginbutton.click();
	}*/
	public void openmessenger()
	{
		messenger.click();
	}
	
	//isenable test case 1.create webelement2.create method
	public boolean checknewaccButtonIsenable()
	{
		return newaccButton.isEnabled();
	}
	//orS
	
	 public void loginPagefb(String user,String password)
	 {
		 
	username.sendKeys(user);
     pass.sendKeys(password); 
	 //username.sendKeys("truptipatil9495@gmail.com");
	// password.sendKeys("omkar1234");
	 loginbutton.click();
	 }	
	
	}
//***************POM CLASS (need web element)*************************************************
//script(code)in POM class
//mouse action (need web element)
//explicite wait
//select class(drop down/list box)
//isEnable(),IsDisplay(),Isselected() ->create boolean (RT)method&return webelement
//getattribute(),getex()t-> 
