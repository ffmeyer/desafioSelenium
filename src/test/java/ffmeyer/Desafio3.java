package ffmeyer;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Desafio3 {
	WebDriver driver;
	String BASEURL = "http://eliasnogueira.com/arquivos_blog/selenium/desafio/3desafio/drag_and_drop/demo.php";

	String LOCATOR_IPHONE_XPATH="//img[contains(@src,'products/iPhone.png')]"; 
	String LOCATOR_IPOD_XPATH= "//img[contains(@src,'products/iPod.png')]";
	String LOCATOR_APPLETV_XPATH= "//img[contains(@src,'products/Apple-TV.png')]";
	//String LOCATOR_CARRINHO_CSS= "//div[@class='content drop-here ui-droppable']";
	String LOCATOR_CARRINHO_CSS= ".content.drop-here.ui-droppable";
	
	
@Before
public void setUp() {
	
	System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\geckodriver-v0.14.0-win64.exe");
	driver = new FirefoxDriver();
	driver.get(BASEURL);
}

@Test
public void ComprarProdutos() {
	/*Actions action = new Actions(driver);*/
		WebElement iPhone = driver.findElement(By.xpath(LOCATOR_IPHONE_XPATH));
	WebElement iPodShuffle = driver.findElement(By.xpath(LOCATOR_IPOD_XPATH));
	WebElement appleTV = driver.findElement(By.xpath(LOCATOR_APPLETV_XPATH ));
	
	
	WebElement carrinho = driver.findElement(By.cssSelector(LOCATOR_CARRINHO_CSS));	
	/*action.dragAndDrop(iphone,carrinho).build().perform();
	action.dragAndDrop(ipod,carrinho).build().perform();
	action.dragAndDrop(appleTv,carrinho).build().perform();
	*/
	
	Actions drag = new Actions(driver);
    drag.clickAndHold(iPhone).build().perform();    
    drag.clickAndHold().moveToElement(carrinho).release(carrinho).build().perform();    
		
	//assertEquals("CORRETO",driver.findElement(By.cssSelector("#resultado")).getText());			
}

@After
public void shutdown() {
	driver.close();
	driver.quit();	
}
	

}

