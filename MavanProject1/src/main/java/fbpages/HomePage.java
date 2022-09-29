package fbpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
 //declartion private web elememnt
	@FindBy(xpath="//input[@placeholder='Search Facebook']")
	private WebElement searchfb;
	
	@FindBy(xpath="//a[@aria-label='Notifications']")
	private WebElement notification;
	
	@FindBy(xpath="//h1[@class='jxuftiz4 jwegzro5 hl4rid49 icdlwmnq']")
	private WebElement notificationtext; 

	@FindBy(xpath="(//div[@aria-label='Messenger'] )[1]")
	private WebElement messenger;
	
	@FindBy(xpath="(//div[@aria-label='Account controls and settings'] //span)[1]")
	private WebElement yourprofile;
	@FindBy(xpath="//span[text()='Log Out']")
	private WebElement logout;

	//initialization constructor
	public HomePage(WebDriver driver)
		{
		PageFactory.initElements(driver, this);
	}
	
	//use action perform
	public void homepagEelement() 
	{
		searchfb.sendKeys("story");
		notification.click();
		messenger.click();
		//logout.click();
	}
	public void clickNotification()
	{
		notification.click();
	}
	public String checkNotificationText()
	{
		return notificationtext.getText();
		
	}
	
	public void clickMessanger()
	{
		messenger.click();

	}
	public void clickAcoountButton()
	{
		yourprofile.click();
	}
	public void clickLogoutButton()
	{
		logout.click();
	}
	
}