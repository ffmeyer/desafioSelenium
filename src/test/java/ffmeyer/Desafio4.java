package ffmeyer;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.MetodosComuns;

public class Desafio4 {
	WebDriver driver;
	String BASEURL = "http://eliasnogueira.com/arquivos_blog/selenium/desafio/4desafio/";
	
	String LOCATOR_CEP_CSS = "#cep";
	String LOCATOR_LOGRADOURO_CSS = "#rua";
	String LOCATOR_NUMERO_CSS ="#numero";
	String LOCATOR_COMPLEMENTO_CSS ="#complemento";
	String LOCATOR_BAIRRO_CSS ="#bairro";
	String LOCATOR_CIDADE = "#cidade";
	String LOCATOR_ESTADO = "#estado";
	
	String NEW_DATA_CEP = "01310200";
	String NEW_DATA_LOGRADOURO ="Avenida: Paulista";
	String NEW_DATA_NUMERO = "1578";
	String NEW_DATA_COMPLEMENTO = "MASP";
	String NEW_DATA_BAIRRO = "Bela Vista";
	String NEW_DATA_CIDADE = "São Paulo";
	String NEW_DATA_ESTADO = "SP";
		
	static String LOCATOR_BTN_LIMPA_CSS =".btn";
	
	
	
@Before
public void setUp() {
	
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\ffmeyer\\Downloads\\lib\\geckodriver-v0.14.0-win64\\geckodriver.exe");
	driver = new FirefoxDriver();	
}

@Test
public void ValidaEndereco() {
	
	driver.get(BASEURL);	
	getEndereco(driver, LOCATOR_CEP_CSS, NEW_DATA_CEP);
	MetodosComuns.escrever(driver, By.cssSelector(LOCATOR_NUMERO_CSS), NEW_DATA_NUMERO);
	MetodosComuns.escrever(driver, By.cssSelector(LOCATOR_COMPLEMENTO_CSS), NEW_DATA_COMPLEMENTO);	
	assertEquals(NEW_DATA_CEP,MetodosComuns.getValueAttribute(driver,By.cssSelector(LOCATOR_CEP_CSS)));
	assertEquals(NEW_DATA_LOGRADOURO,MetodosComuns.getValueAttribute(driver,By.cssSelector(LOCATOR_LOGRADOURO_CSS)));
	assertEquals(NEW_DATA_NUMERO,MetodosComuns.getValueAttribute(driver,By.cssSelector(LOCATOR_NUMERO_CSS)));
	assertEquals(NEW_DATA_COMPLEMENTO,MetodosComuns.getValueAttribute(driver,By.cssSelector(LOCATOR_COMPLEMENTO_CSS)));
	assertEquals(NEW_DATA_BAIRRO,MetodosComuns.getValueAttribute(driver,By.cssSelector(LOCATOR_BAIRRO_CSS)));
	assertEquals(NEW_DATA_CIDADE,MetodosComuns.getValueAttribute(driver,By.cssSelector(LOCATOR_CIDADE)));
	assertEquals(NEW_DATA_ESTADO,MetodosComuns.getValueAttribute(driver,By.cssSelector(LOCATOR_ESTADO)));
	
	MetodosComuns.clicar(driver, By.cssSelector(LOCATOR_BTN_LIMPA_CSS));
	
	assertEquals("",MetodosComuns.getValueAttribute(driver,By.cssSelector(LOCATOR_CEP_CSS)));
	assertEquals("",MetodosComuns.getValueAttribute(driver,By.cssSelector(LOCATOR_LOGRADOURO_CSS)));
	assertEquals("",MetodosComuns.getValueAttribute(driver,By.cssSelector(LOCATOR_NUMERO_CSS)));
	assertEquals("",MetodosComuns.getValueAttribute(driver,By.cssSelector(LOCATOR_COMPLEMENTO_CSS)));
	assertEquals("",MetodosComuns.getValueAttribute(driver,By.cssSelector(LOCATOR_BAIRRO_CSS)));
	assertEquals("",MetodosComuns.getValueAttribute(driver,By.cssSelector(LOCATOR_CIDADE)));
	assertEquals("",MetodosComuns.getValueAttribute(driver,By.cssSelector(LOCATOR_ESTADO)));
}


public static void getEndereco(WebDriver driver, String locator, String text){
	//http://stackoverflow.com/questions/16488619/actions-through-webdriver-will-not-trigger-the-blur-event
	//jse.executeScript("return arguments[0].focus(); arguments[0].blur(); return true", arguments);
	//jse.executeScript("getEndereco()");
	//jse.executeScript("alert('Test Alerts')"); ok funciona, mas nao eh o que eu preciso
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	driver.findElement(By.cssSelector(locator)).sendKeys(text);
	WebElement arguments = driver.findElement(By.cssSelector(locator));
	//argument nao precisa ser usado aqui mas lancei assim mesmo 
	jse.executeScript("getEndereco()", arguments);

}

@After
public void shutdown() {
	driver.close();
	driver.quit();	
}
}