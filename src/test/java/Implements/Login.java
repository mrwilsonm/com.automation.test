package Implements;

import org.openqa.selenium.WebDriver;

import PageFactory.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import helpUtil.BrowserDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;


public class Login {
	
	public static WebDriver driver;
	
	public LoginPage loginPO;
	
	@Given("^Teniendo que soy un cliente$")
	public void teniendo_que_soy_un_cliente() throws Throwable {
		BrowserDriver.getCurrentDriver("chrome");
		driver = BrowserDriver.getCurrentDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		loginPO = new LoginPage(driver);
	}

	@When("^inicio mi sesion en la web$")
	public void inicio_mi_sesion_en_la_web() throws Throwable {
	   loginPO.clickHome(); 
	}

	@When("^ingreso mi usuario \"([^\"]*)\"$")
	public void ingreso_mi_usuario(String strUsuario) throws Throwable {
		loginPO.setUserName(strUsuario);
	}

	@When("^ingreso mi password \"([^\"]*)\"$")
	public void ingreso_mi_password(String strPass) throws Throwable {
		loginPO.setPassword(strPass);
	}
	
	@Then("^doy click en el boton de ingreso$")
	public void doy_click_en_el_boton_de_ingreso() throws Throwable {
	    loginPO.clickLogin();
	    //throw new PendingException();
	}

	
	@Then("^Ingreso a la pagina web$")
	public void ingreso_a_la_pagina_web() throws Throwable {
		//loginPO.getLoginTitle();
		assertThat(loginPO.getLoginTitle(), containsString("Flight Finder to search for the lowest fare on participating airlines. Once you've booked your flight, don't forget to visit the Mercury Tours Hotel Finder to reserve lodging in your destination city"));
	    
	}

}
