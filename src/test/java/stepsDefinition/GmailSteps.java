package stepsDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import PageFactory.GmailPage;

public class GmailSteps {

	WebDriver driver;
	
	GmailPage gmailPage;
	
	
	public GmailSteps(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void abrirPagina(String strUrl){
		gmailPage.abrirPagina(strUrl);
		gmailPage = new GmailPage(driver);
	}
	
	public void accesoCuentaGmail(String strCuentaCorreo, String strPass) throws InterruptedException {
		// TODO Auto-generated method stub
		gmailPage.loguearGmail(strCuentaCorreo, strPass);
	}


	public void clickRedactarCorreo() throws InterruptedException {
		// TODO Auto-generated method stub
		gmailPage.clickRedactarCorreo();
	}


	public void ingresarCorreoDestinatario(String strCorreoDestinatario) {
		// TODO Auto-generated method stub
		gmailPage.ingresarCorreoDestinatario(strCorreoDestinatario);
	}


	public void ingresarAsuntoYCuerpoEmail(String strAsunto, String strContenidoEmail) {
		// TODO Auto-generated method stub
		gmailPage.ingresarAsuntoYCuerpoEmail(strAsunto, strContenidoEmail);
	}


	public void clickEnviarCorreo() throws InterruptedException {
		// TODO Auto-generated method stub
		gmailPage.clickEnviarCorreo();
	}


	public void verificarEmailBandejaEntrada(String strAsunto) {
		// TODO Auto-generated method stub
		gmailPage.verificarEmailBandejaEntrada(strAsunto);
	}


	public void eliminarEmailClickDerecho() throws InterruptedException {
		// TODO Auto-generated method stub
		gmailPage.eliminarEmailClickDerecho();
	}


	public void moverEmailElimnadoABandejaEntrada() throws InterruptedException {
		// TODO Auto-generated method stub
		gmailPage.moverEmailElimnadoABandejaEntrada();
	}





	
	
	
	
	
}
