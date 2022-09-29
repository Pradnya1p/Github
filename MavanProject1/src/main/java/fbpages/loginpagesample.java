package fbpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpagesample {
	@FindBy(xpath="//a[text()='Create New Account']")
	private WebElement createnewacc;
	public loginpagesample(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickcreateAccButton()
	{
		createnewacc.click();
		
	}

}
