package Implements;

import org.openqa.selenium.WebDriver;

import PageFactory.GmailPage;

//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class Gmail {

	public static WebDriver driver;
	
	GmailPage gmailPage;
	
	
	@Given("^Tengo acceso a una cuenta gmail \"([^\"]*)\" con pass \"([^\"]*)\"$")
	public void tengo_acceso_a_una_cuenta_gmail_con_pass(String strCuentaCorreo, String strPass) throws Throwable {
		
		gmailPage = new GmailPage(driver);
		gmailPage.abrirPagina("https://accounts.google.com/signin/v2/sl/pwd?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession&cid=0&navigationDirection=forward");
		gmailPage.accesoCuentaGmail(strCuentaCorreo, strPass);
	}

	@Given("^redacto un nuevo correo$")
	public void redacto_un_nuevo_correo() throws Throwable {
		gmailPage.clickRedactarCorreo();
	}

	@When("^Ingreso el destinatario \"([^\"]*)\"$")
	public void ingreso_el_destinatario(String strCorreoDestinatario) throws Throwable {
		gmailPage.ingresarCorreoDestinatario(strCorreoDestinatario);
	}

	@When("^ingresar asunto \"([^\"]*)\" y cuerpo email \"([^\"]*)\"$")
	public void ingresar_asunto_y_cuerpo_email(String strAsunto, String strCuerpoCorreo) throws Throwable {
		gmailPage.ingresarAsuntoYCuerpoEmail(strAsunto, strCuerpoCorreo);
	}
	
	@When("^enviar correo$")
	public void enviar_correo() throws Throwable {
		gmailPage.clickEnviarCorreo();
	}

	@Then("^verificar email en bandeja de entrada \"([^\"]*)\"$")
	public void verificar_email_en_bandeja_de_entrada(String strAsunto) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		gmailPage.verificarEmailBandejaEntrada(strAsunto);
	}

	
	@Then("^eliminar email con click derecho$")
	public void eliminar_email_con_click_derecho() throws Throwable {
		gmailPage.eliminarEmailClickDerecho();
	}


	@Then("^Mover el email nuevamente a la bandeja de entrada$")
	public void mover_el_email_nuevamente_a_la_bandeja_de_entrada() throws Throwable {
		gmailPage.moverEmailElimnadoABandejaEntrada();
	}
	
	
	
}
