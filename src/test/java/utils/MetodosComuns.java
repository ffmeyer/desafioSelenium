package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MetodosComuns {
	
	public static WebElement getWhenVisible(WebDriver driver, By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		return element;
	}

	public static String getClassAtribute(WebDriver driver, By locator){
		return driver.findElement(locator).getAttribute("class");		
	}
	
	public static String getValueAttribute(WebDriver driver, By locator){
		return driver.findElement(locator).getAttribute("value");		
	}
	
	public static String getText(WebDriver driver, By locator){
		return driver.findElement(locator).getText();		
	}
	
	public static void escrever(WebDriver driver, By locator, String text){
		driver.findElement(locator).clear();	
		driver.findElement(locator).sendKeys(text);
	}
	
	public static void clicar(WebDriver driver, By locator){
		driver.findElement(locator).click();		
	}
	
	
}
