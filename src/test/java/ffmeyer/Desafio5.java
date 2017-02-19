package ffmeyer;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.MetodosComuns;

public class Desafio5 {
	
	WebDriver driver;
	String BASEURL = "http://eliasnogueira.com/arquivos_blog/selenium/desafio/5desafio/";
	
	String LOCATOR_USERNAME_XPATH = "//label[text() = 'Username']//following-sibling::div/input";
	String LOCATOR_USERNAME_REP_XPATH = "//label[text() = 'Username (repetir)']//following-sibling::div/input";
	String LOCATOR_PASSWORD_XPATH ="//label[text() = 'Password']//following-sibling::div/input";
	String LOCATOR_PASSWORD_REP_XPATH ="//label[text() = 'Password (repetir)']//following-sibling::div/input";
	String LOCATOR_BTN_ENVIA_XPATH ="//input[@id='submitBtn2']";
	String LOCATOR_DIV_ERROR ="//input[@id='errorDiv2']";
	String MSG_ERROR ="Os campos não tem o mesmo valor!";
	
	String NEW_DATA_USERNAME = "ffmeyer_UN";
	String NEW_DATA_INV_USERNAME = "ffmeyer_INV";
	String NEW_DATA_PASSWORD = "ffmeyer_PW";	
	
@Before
public void setUp() {
	
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\ffmeyer\\Downloads\\lib\\geckodriver-v0.14.0-win64\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.get(BASEURL);	
}

@Test
public void CadastroEnderecoCorreto() {
	
	MetodosComuns.escrever(driver, By.xpath(LOCATOR_USERNAME_XPATH), NEW_DATA_USERNAME);
	MetodosComuns.escrever(driver, By.xpath(LOCATOR_USERNAME_REP_XPATH), NEW_DATA_USERNAME);
	MetodosComuns.escrever(driver, By.xpath(LOCATOR_PASSWORD_XPATH), NEW_DATA_PASSWORD);
	MetodosComuns.escrever(driver, By.xpath(LOCATOR_PASSWORD_REP_XPATH), NEW_DATA_PASSWORD);
	MetodosComuns.clicar(driver, By.xpath(LOCATOR_BTN_ENVIA_XPATH));
	
}

public void CadastroEnderecoIncorreto() {
	
	MetodosComuns.escrever(driver, By.xpath(LOCATOR_USERNAME_XPATH), NEW_DATA_USERNAME);
	MetodosComuns.escrever(driver, By.xpath(LOCATOR_USERNAME_REP_XPATH), NEW_DATA_INV_USERNAME);
	MetodosComuns.escrever(driver, By.xpath(LOCATOR_PASSWORD_XPATH), NEW_DATA_PASSWORD);
	MetodosComuns.escrever(driver, By.xpath(LOCATOR_PASSWORD_REP_XPATH), NEW_DATA_PASSWORD);
	MetodosComuns.clicar(driver, By.xpath(LOCATOR_BTN_ENVIA_XPATH));
	MetodosComuns.getWhenVisible(driver, By.xpath(LOCATOR_DIV_ERROR), 30);
	assertEquals(MSG_ERROR,MetodosComuns.getValueAttribute(driver,By.xpath(LOCATOR_DIV_ERROR)));
	
}

@After
public void shutdown() {
	driver.close();
	driver.quit();	
}

}
