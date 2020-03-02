package com.uniovi.tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotaneitorTests {


	private static final String PathFirefox65 ="/usr/bin/firefox";

	private static final String Geckdriver024 = "/usr/bin/geckodriver";

	//En Windows (Debe ser la versión 65.0.1 y desactivar las actualizacioens automáticas)):

	//static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";

	//static String Geckdriver024 = "C:\\Path\\geckodriver024win64.exe";

	//En MACOSX (Debe ser la versión 65.0.1 y desactivar las actualizacioens automáticas):

	//static String PathFirefox65 = "/Applications/Firefox.app/Contents/MacOS/firefox-bin";

	//static String Geckdriver024 = "/Users/delacal/selenium/geckodriver024mac";

	//Común a Windows y a MACOSX

	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
	static String URL = "http://localhost:8090";


	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.gecko.driver", Geckdriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	@Before
	public void setUp() {
		driver.navigate().to(URL);
	}

	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	//Antes de la primera prueba
	@BeforeClass
	static public void begin() {
	}

	//Al finalizar la última prueba
	@AfterClass
	static public void end() {
		//Cerramos el navegador al finalizar las pruebas
		driver.quit();
	}

}
