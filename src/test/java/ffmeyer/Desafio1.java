package ffmeyer;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.MetodosComuns;

public class Desafio1 {
	WebDriver driver;
	String BASEURL = "http://eliasnogueira.com/arquivos_blog/selenium/desafio/1desafio/";
	
	String LOCATOR_VALOR_1= "#number1";
	String LOCATOR_VALOR_2= "#number2";
	String LOCATOR_RESULT = ".form-group > input:nth-child(3)";	
	String LOCATOR_ENVIAR_CSS = ".form-group > input:nth-child(4)";
	
@Before
public void setUp() {
	
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\ffmeyer\\Downloads\\lib\\geckodriver-v0.14.0-win64\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.get(BASEURL);
}

@Test
public void SomaNumeros() {
	
		int valor1 = Integer.parseInt(MetodosComuns.getText(driver, By.cssSelector(LOCATOR_VALOR_1)));
		int valor2 = Integer.parseInt(MetodosComuns.getText(driver, By.cssSelector(LOCATOR_VALOR_2)));
		MetodosComuns.escrever(driver, By.cssSelector(LOCATOR_RESULT), Integer.toString(valor1+valor2));		
		MetodosComuns.clicar(driver, By.cssSelector(LOCATOR_ENVIAR_CSS));		
		MetodosComuns.getWhenVisible(driver, By.cssSelector("#resultado"), 30);
		assertEquals("CORRETO",driver.findElement(By.cssSelector("#resultado")).getText());			
}

@After
public void shutdown() {
	driver.close();
	driver.quit();	
}
}
