package com.uniovi.tests.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uniovi.tests.utils.SeleniumUtils;

public class PO_PrivateView extends PO_NavView {
	static public void fillFormAddMark(WebDriver driver, int userOrder, String descriptionp, String scorep) {
		// Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
		SeleniumUtils.esperarSegundos(driver, 5);
		// Seleccionamos el alumnos userOrder
		new Select(driver.findElement(By.id("user"))).selectByIndex(userOrder);

		// Rellenemos el campo de descripción
		WebElement description = driver.findElement(By.name("description"));
		description.clear();
		description.sendKeys(descriptionp);
		WebElement score = driver.findElement(By.name("score"));
		score.click();
		score.clear();
		score.sendKeys(scorep);
		By boton = By.className("btn");
		driver.findElement(boton).click();

	}
	
	public static void manejarLista(WebDriver driver, String consulta, int opcion) {
		List<WebElement> elementos = new ArrayList<WebElement>();
		elementos = PO_View.checkElement(driver, "free",
				consulta);
		elementos.get(opcion).click();
	}
	
	public static void goToLoginFillAndTest(WebDriver driver, String user, String password,String texto) {
		// Vamos al formulario de logueo.
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");

		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, user, password); 

		// COmprobamos que entramos en la pagina de login
		PO_View.checkElement(driver, "text", texto);
	}
static public void fillFormAddTeacher(WebDriver driver, int userOrder, String namet, String surname, String dnit, String categoria) {
		// Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
		SeleniumUtils.esperarSegundos(driver, 5);

		WebElement name = driver.findElement(By.name("name"));
		name.clear();
		name.sendKeys(namet);
		WebElement lastName= driver.findElement(By.name("lastName"));
		lastName.click();
		lastName.clear();
		lastName.sendKeys(surname);
		WebElement dni= driver.findElement(By.name("dni"));
		dni.click();
		dni.clear();
		dni.sendKeys(dnit);
		WebElement cat = driver.findElement(By.name("category"));
		cat.click();
		cat.clear();
		cat.sendKeys(categoria);
		By boton = By.className("btn");
		driver.findElement(boton).click();

	}
}
