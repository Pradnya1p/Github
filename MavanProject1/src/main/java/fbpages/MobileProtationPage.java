package fbpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileProtationPage {

	@FindBy(xpath="//input[@class='uiLinkButtonInput']")
	private WebElement notnowlink;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement homeicon;

	public MobileProtationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


public void fbMobileProtection()
{
	 homeicon.click();
}
public void clickOnNotNowLink()
{
	notnowlink.click();
	}

}