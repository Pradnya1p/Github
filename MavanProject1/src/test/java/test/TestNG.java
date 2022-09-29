package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//******testNg tool& libarary add ********
//annotation is use for the pgm sequence
//avoid code repeation no of line decrease
//Thrir are 10 annotation below is 5 & the sequence is same
public class TestNG {
	
	@BeforeClass   //lunch browse code
	public void beforeclass()
	{
		System.out.println("Before class");
	}
	
	@BeforeMethod  //url & class object which we create in mavan src/main/java
	public void beforeMethod()
	{
		System.out.println("Before Method");
	}
	
	@Test  //test case which we validate 
	public void test()
	{
		System.out.println("Test");
	}
	@Test //2 test cases then create 2ns @Test annation
	public void test1()
	{
		System.out.println("test1");
	}
	
	@AfterMethod  //if after the @Test case any code is remaining like logout
	public void aftermethod()
	{
			System.out.println("After method");
	}
	@AfterClass //closing broweser code
	public void afterclass()
	{
		System.out.println("after class");
	}
	
	
}
