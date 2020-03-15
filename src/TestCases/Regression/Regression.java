package TestCases.Regression;

import org.testng.annotations.Test;

import Keyword.Keyword;

public class Regression {
	@Test
	public void tc_01() {
		Keyword.openBrowser("Chrome");
		Keyword.openURL("https://www.facebook.com/");
		Keyword.enterText("XPATH", "//input[@name='email']", "acg@gmail.com");
		Keyword.enterText("XPATH", "//input[@name='pass']", "acg@123");
		//Keyword.clickOnElement("XPATH", "//input[@type='submit']");
		Keyword.selectValue("XPATH", "//select[@name='birthday_day']", "23");
		Keyword.selectValue("XPATH", "//select[@name='birthday_month']", "Sept");
		Keyword.selectValue("XPATH", "//select[@name='birthday_year']", "1994");
		
}
}
