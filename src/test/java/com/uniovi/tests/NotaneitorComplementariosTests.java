package com.uniovi.tests;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.tests.pageobjects.PO_PrivateView;
import com.uniovi.tests.pageobjects.PO_View;
import com.uniovi.tests.utils.SeleniumUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotaneitorComplementariosTests {

	static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";

	static String Geckdriver024 = "C:\\Users\\UO258654\\Downloads\\PL-SDI-Sesio╠ün5-material\\geckodriver024win64.exe";
	
	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
	static String URL = "http://localhost:8090";

	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.gecko.driver", Geckdriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	@Test
	public void prueba1() {
		PO_PrivateView.goToLoginFillAndTest(driver, "99999988F","123456", "Gestión de usuarios");

		// Pinchamos en la opción de menu de Notas: //li[contains(@id, 'marks-menu')]/a
		PO_PrivateView.manejarLista(driver, "//li[contains(@id, 'teachers-menu')]/a", 0);

		// Esperamos a aparezca la opción de añadir nota: //a[contains(@href,
		// 'mark/add')]
		PO_PrivateView.manejarLista(driver, "//a[contains(@href, 'teacher/add')]", 0);

		// Ahora vamos a rellenar la nota. //option[contains(@value, '4')]
		PO_PrivateView.fillFormAddTeacher(driver, 0, "Daniel", "Gayo", "53513950B", "doctorando");

		// Comprobamos que aparece la nota en la pagina
		List<WebElement> elementos = PO_View.checkElement(driver, "text", "53513950B");

		// Ahora nos desconectamos
		PO_PrivateView.clickOption(driver, "logout", "text", "Identifícate");
	}
	
	@Test
	public void prueba2() {
		PO_PrivateView.goToLoginFillAndTest(driver, "99999988F","123456", "Gestión de usuarios");

		// Pinchamos en la opción de menu de Notas: //li[contains(@id, 'marks-menu')]/a
		PO_PrivateView.manejarLista(driver, "//li[contains(@id, 'teachers-menu')]/a", 0);

		// Esperamos a aparezca la opción de añadir nota: //a[contains(@href,
		// 'mark/add')]
		PO_PrivateView.manejarLista(driver, "//a[contains(@href, 'teacher/add')]", 0);

		// Ahora vamos a rellenar la nota. //option[contains(@value, '4')]
		PO_PrivateView.fillFormAddTeacher(driver, 0, "    ", "Sancho", "53613950B", "   ");

		// Comprobamos que aparece la nota en la pagina
		List<WebElement> elementos = PO_View.checkElement(driver, "text", "Este campo no puede ser vacío");

		// Ahora nos desconectamos
		PO_PrivateView.clickOption(driver, "logout", "text", "Identifícate");
	}
@Test
	public void prueba3() {
		PO_PrivateView.goToLoginFillAndTest(driver, "99999990A","123456", "Gestión de notas");

		// Pinchamos en la opción de menu de Notas: //li[contains(@id, 'marks-menu')]/a
		PO_PrivateView.manejarLista(driver, "//li[contains(@id, 'teachers-menu')]/a", 0);

		// Y esperamos a que NO aparezca la ultima "Nueva Nota 1"
		SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "Agregar profesores", PO_View.getTimeout());

		// Ahora nos desconectamos
		PO_PrivateView.clickOption(driver, "logout", "text", "Identifícate");
	}
	@Before
	public void setUp() {
		driver.navigate().to(URL);
	}

	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

// Al finalizar la última prueba
	@AfterClass
	static public void end() {
		// Cerramos el navegador al finalizar las pruebas
		driver.quit();
	}

}
