package ffmeyer;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.MetodosComuns;

public class Desafio6 {
	
	WebDriver driver;
	String BASEURL = "http://eliasnogueira.com/arquivos_blog/selenium/desafio/6desafio/";
	String UMA_LETRA_XPATH = "//div[@id='pswd_info']//li[@id='letra']";
	String UMA_MAIUSCULA_PATH= "//div[@id='pswd_info']//li[@id='maiuscula']";
	String UM_NUMERO_XPATH= "//div[@id='pswd_info']//li[@id='numero']";
	String OITO_DIGITOS_XPATH = "//div[@id='pswd_info']//li[@id='tamanho']";
	
	String LOCATOR_PASSWORD_XPATH ="//input[@id='senha']";	
		
@Before
public void setUp() {
	
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\ffmeyer\\Downloads\\lib\\geckodriver-v0.14.0-win64\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.get(BASEURL);	
}

@Test
public void Valida1Letra() {
	String NEW_DATA_USERNAME = "a";
	MetodosComuns.escrever(driver, By.xpath(LOCATOR_PASSWORD_XPATH), NEW_DATA_USERNAME);
	assertEquals("valid",MetodosComuns.getClassAtribute(driver,By.xpath(UMA_LETRA_XPATH)));
	assertEquals("invalid",MetodosComuns.getClassAtribute(driver,By.xpath(UMA_MAIUSCULA_PATH)));
	assertEquals("invalid",MetodosComuns.getClassAtribute(driver,By.xpath(UM_NUMERO_XPATH)));
	assertEquals("invalid",MetodosComuns.getClassAtribute(driver,By.xpath(OITO_DIGITOS_XPATH)));	
}

@Test
public void Valida1LetraMaiscula() {
	String NEW_DATA_USERNAME = "A";
	MetodosComuns.escrever(driver, By.xpath(LOCATOR_PASSWORD_XPATH), NEW_DATA_USERNAME);
	assertEquals("valid",MetodosComuns.getClassAtribute(driver,By.xpath(UMA_LETRA_XPATH)));
	assertEquals("valid",MetodosComuns.getClassAtribute(driver,By.xpath(UMA_MAIUSCULA_PATH)));
	assertEquals("invalid",MetodosComuns.getClassAtribute(driver,By.xpath(UM_NUMERO_XPATH)));
	assertEquals("invalid",MetodosComuns.getClassAtribute(driver,By.xpath(OITO_DIGITOS_XPATH)));	
}

@Test
public void Valida1Numero() {
	String NEW_DATA_USERNAME = "1";
	MetodosComuns.escrever(driver, By.xpath(LOCATOR_PASSWORD_XPATH), NEW_DATA_USERNAME);
	assertEquals("invalid",MetodosComuns.getClassAtribute(driver,By.xpath(UMA_LETRA_XPATH)));
	assertEquals("invalid",MetodosComuns.getClassAtribute(driver,By.xpath(UMA_MAIUSCULA_PATH)));
	assertEquals("valid",MetodosComuns.getClassAtribute(driver,By.xpath(UM_NUMERO_XPATH)));
	assertEquals("invalid",MetodosComuns.getClassAtribute(driver,By.xpath(OITO_DIGITOS_XPATH)));	
}

@Test
public void Valida8caracteres() {
	String NEW_DATA_USERNAME = "********";
	MetodosComuns.escrever(driver, By.xpath(LOCATOR_PASSWORD_XPATH), NEW_DATA_USERNAME);
	assertEquals("invalid",MetodosComuns.getClassAtribute(driver,By.xpath(UMA_LETRA_XPATH)));
	assertEquals("invalid",MetodosComuns.getClassAtribute(driver,By.xpath(UMA_MAIUSCULA_PATH)));
	assertEquals("invalid",MetodosComuns.getClassAtribute(driver,By.xpath(UM_NUMERO_XPATH)));
	assertEquals("valid",MetodosComuns.getClassAtribute(driver,By.xpath(OITO_DIGITOS_XPATH)));	
}


@Test
public void ValidaTudo() {
	String NEW_DATA_USERNAME = "A1234567";
	MetodosComuns.escrever(driver, By.xpath(LOCATOR_PASSWORD_XPATH), NEW_DATA_USERNAME);
	assertEquals("valid",MetodosComuns.getClassAtribute(driver,By.xpath(UMA_LETRA_XPATH)));
	assertEquals("valid",MetodosComuns.getClassAtribute(driver,By.xpath(UMA_MAIUSCULA_PATH)));
	assertEquals("valid",MetodosComuns.getClassAtribute(driver,By.xpath(UM_NUMERO_XPATH)));
	assertEquals("valid",MetodosComuns.getClassAtribute(driver,By.xpath(OITO_DIGITOS_XPATH)));	
}

@After
public void shutdown() {
	driver.close();
	driver.quit();	
}

}
