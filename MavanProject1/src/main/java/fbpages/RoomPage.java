package fbpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomPage {
	//Declaration og variables is private so its encapsulation &abstraction  support i.e webelement
			 
			@FindBy(xpath="//a[text()= ' Visit our help center ']  ")
			private WebElement helpcenterButton ;
			
			@FindBy(xpath="//a[text()=' Return to messenger.com ']")
			private WebElement returnmessengerButton  ;
			
			//initalizationof webelement 
			public RoomPage(WebDriver driver)//constructor is public 
			{
				PageFactory.initElements(driver, this);
			}

			//use action perfrom
			
			public  void openhelpcenterButton()
			{
				helpcenterButton.click();
			}
			public void openreturnmessengerButton()
			{
				returnmessengerButton.click();
			}
			
			
			
			
			
}



