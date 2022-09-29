package utilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

public static void  captureScreenshot(WebDriver driver,int TestID) throws IOException
{
	
	//date & time code
	Date cuurentdate=new Date();
	DateFormat abclass=new SimpleDateFormat("dd-mm-yyyy  hh-mm-ss");
	String date=abclass.format(cuurentdate);
	//Screenshot testscript
	TakesScreenshot take=(TakesScreenshot)driver;
	File src=take.getScreenshotAs(OutputType.FILE);
	
	File dest=new File("H:\\Screenshort\\FB"+TestID+" "+date+".jpeg");
	FileHandler.copy(src, dest);
	
}

	public static String fetchDataFromExcelSheet(int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException
	{
	String path="H:\\excel sheet fetching\\fetch data all.xlsx";
	FileInputStream file=new FileInputStream(path);
	String value=WorkbookFactory.create(file).getSheet("sheet").getRow(rowIndex).getCell(cellIndex).getStringCellValue();
	System.out.println(value);
	return value;
	}
	
}
