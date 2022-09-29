package fbpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessengerPage {

	//Declaration og variables is private so its encapsulation &abstraction  support i.e webelement
		@FindBy(xpath="//a[text()='Rooms']")
		private WebElement rooms;
		
		@FindBy(xpath="//a[text()='Features']")
		private WebElement features;
		
		//initalizationof webelement 
		public MessengerPage(WebDriver driver)//constructor is public 
		{
			PageFactory.initElements(driver, this);
		}
		//use action perfrom
		public void openrooms()
		{
			rooms.click();
		}
		public  void openfeatures()
		{
			features.click();
		}
	
	
	
	
	
	
	
	
	
}
