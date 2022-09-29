package fbpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatenewAccpage {
	//********global declaration***********
	//global variable
	private WebDriver driver;
	//Select class global declation
	private Select s;//drop down need wbelement so in POM
	//Explicite wait  
	private WebDriverWait wait;
	//mouse action Actions class
	private Actions act;
	
	
	//declation of variable
@FindBy(xpath="//select[@id='month']")
private WebElement selectmonthButton;

@FindBy(xpath="//input[@name='reg_email__']")
private WebElement emailattribute;

@FindBy(xpath="//input[@name='reg_passwd__']")
private WebElement passwordattribute;

@FindBy(xpath="//a[text()='Learn more']")
private WebElement learnlink;


//initilization of webelement create constructor
public CreatenewAccpage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	this.driver=driver;//
	s=new Select(selectmonthButton);//initilazation of select class
	wait=new WebDriverWait(driver,20);//20 is always in sec
	act=new Actions(driver);
}
public void dropdown()
{
	s.selectByVisibleText("May");
}
public void dragAnddrop()
{
	act.dragAndDrop(learnlink,passwordattribute );
}
public void explicitywait()
{
	wait.until(ExpectedConditions.visibilityOf(emailattribute));
	emailattribute.sendKeys("framework@gmail.com");
}

}
//BY DECLARING GLOBALLY*************************
//drop down
//mouse action drag & drop
//exlicite wait
