package fbpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
	//declaration of variable i.webelement private
	@FindBy(xpath="//a[text()='Create New Account']")
	private WebElement createNewAcc;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@value='1']")
	private WebElement fegender;
	
	//initaliazation of webelement  public by constructor &PageFactory class&initElements()method
	
	public SignupPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//use method use public i.e weelement action perform
	public void singupElement()
	{
		firstname.sendKeys("Trupti");
		lastname.sendKeys("Patil");
		fegender.click();

	}
	
}

