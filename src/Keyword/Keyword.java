package Keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Keyword {
	
	public static WebElement getWebElement(String locaterType,String LocatorValue) {
		WebElement element=null;
		
		switch(locaterType)
		{
		case"XPATH":
			
			element=Constant.driver.findElement(By.xpath(LocatorValue));
			break;
		case"CSS":
			element=Constant.driver.findElement(By.cssSelector(LocatorValue));
			break;
		case"ID":
			element=Constant.driver.findElement(By.cssSelector(LocatorValue));
			break;
		case"LINKTEXT":
			element=Constant.driver.findElement(By.linkText(LocatorValue));
			break;
		case"PARTIAL_LINKTEXT":
			element=Constant.driver.findElement(By.partialLinkText(LocatorValue));
			break;
		default:
			System.out.println("Invalid LOcatorType: "+locaterType+". Expected XPATH,CSS,ID,LINKTEXT,PARTIAL_LINKTEXT");
		}
		return element;
	}

	public static void openBrowser(String browserName) {
		
		switch(browserName)
		{
		case"Chrome":
			WebDriverManager.chromedriver().setup();
			Constant.driver = new ChromeDriver(); 
			break;
		case"Firefox":
			WebDriverManager.firefoxdriver().setup();
			Constant.driver=new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browserName: "+browserName);
		}
	}
	public static  void openURL(String url)
	{
		Constant.driver.get(url);
	}
	public static void enterText(String locaterType,String LocatorValue,String textToEnter) {
		
		getWebElement(locaterType, LocatorValue).sendKeys(textToEnter);
  
	}
	public static void clickOnElement(String locaterType,String LocatorValue) {
getWebElement(locaterType, LocatorValue).click();

	}
	public static void selectValue(String locaterType,String LocatorValue,String textToselect) {
		WebElement element=getWebElement(locaterType, LocatorValue);

		Select select=new Select (element);
		select.selectByVisibleText(textToselect);

	}
}
