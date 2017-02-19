package ffmeyer;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.MetodosComuns;

public class Desafio2 { //
	WebDriver driver;
	String BASEURL = "http://eliasnogueira.com/arquivos_blog/selenium/desafio/2desafio/";
	
	String LOCATOR_NOME_CSS = "#name_rg_display_section";
	String LOCATOR_EMAIL_CSS = "#email_rg_display_section";
	String LOCATOR_TELEFONE_CSS ="#phone_rg_display_section";
	
	String LOCATOR_NAME_SAVE_CSS = "#name_hv_editing_section > input:nth-child(3)";
	String LOCATOR_EMAIL_SAVE_CSS = "#email_hv_editing_section > input:nth-child(4)";
	String LOCATOR_TELEFONE_SAVE_CSS = "#phone_hv_editing_section > input:nth-child(4)";
	
	String LOCATOR_INPUT_NOME_CSS = "#nome_pessoa";
	String LOCATOR_INPUT_EMAIL_CSS = "#email_value";
	String LOCATOR_INPUT_TELEFONE_CSS ="#phone_value";
	
	
	
	
	String NEW_DATA_NOME = "Felipe Meyer";
	String NEW_DATA_EMAIL= "ffmeyer@gmail.com";
	String NEW_DATA_TELEFONE= "2199469XXXX";
	
	
@Before
public void setUp() {
	
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\ffmeyer\\Downloads\\lib\\geckodriver-v0.14.0-win64\\geckodriver.exe");
	driver = new FirefoxDriver();
	
}

@Test
public void EditaAgenda() {
	
	driver.get(BASEURL);	

	MetodosComuns.clicar(driver, By.cssSelector(LOCATOR_NOME_CSS));
	MetodosComuns.escrever(driver, By.cssSelector(LOCATOR_INPUT_NOME_CSS), NEW_DATA_NOME);
	MetodosComuns.clicar(driver, By.cssSelector(LOCATOR_NAME_SAVE_CSS));
	MetodosComuns.getWhenVisible(driver, By.cssSelector(LOCATOR_NOME_CSS), 30);
	
	MetodosComuns.clicar(driver, By.cssSelector(LOCATOR_EMAIL_CSS));
	MetodosComuns.escrever(driver, By.cssSelector(LOCATOR_INPUT_EMAIL_CSS), NEW_DATA_EMAIL);
	MetodosComuns.clicar(driver, By.cssSelector(LOCATOR_EMAIL_SAVE_CSS));
	MetodosComuns.getWhenVisible(driver, By.cssSelector(LOCATOR_EMAIL_CSS), 30);
		
	MetodosComuns.clicar(driver, By.cssSelector(LOCATOR_TELEFONE_CSS));
	MetodosComuns.escrever(driver, By.cssSelector(LOCATOR_INPUT_TELEFONE_CSS), NEW_DATA_TELEFONE);
	MetodosComuns.clicar(driver, By.cssSelector(LOCATOR_TELEFONE_SAVE_CSS));
	MetodosComuns.getWhenVisible(driver, By.cssSelector(LOCATOR_TELEFONE_CSS), 30);
	
	assertEquals(NEW_DATA_NOME, MetodosComuns.getText(driver, By.cssSelector(LOCATOR_NOME_CSS)));
	//as Strings abaixo ficam no corpo do HTML e nao devem 
	assertEquals("Email: "+ NEW_DATA_EMAIL, MetodosComuns.getText(driver, By.cssSelector(LOCATOR_EMAIL_CSS)));
	assertEquals("Telefone: " + NEW_DATA_TELEFONE, MetodosComuns.getText(driver, By.cssSelector(LOCATOR_TELEFONE_CSS)));			
}

@After
public void shutdown() {
	driver.close();
		driver.quit();	
}

}
