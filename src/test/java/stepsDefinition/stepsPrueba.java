package stepsDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepsPrueba {

	WebDriver driver = new ChromeDriver();
	
	
	@Given("^Tengo acceso como Juan$")
	public void tengo_acceso_como_Juan() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		
		
	    //throw new PendingException();
	}

	@Given("^Me encuento en la pantalla de compra$")
	public void me_encuento_en_la_pantalla_de_compra() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	    throw new PendingException();
	}

	@When("^Realizo la compra de vuelo \"([^\"]*)\" \"([^\"]*)\" en cualquier \"([^\"]*)\"$")
	public void realizo_la_compra_de_vuelo_en_cualquier(String arg1, String arg2, String arg3) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^selecciono \"([^\"]*)\"$")
	public void selecciono(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^continuo la compra$")
	public void continuo_la_compra() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Selecciono el \"([^\"]*)\" de la primera lista$")
	public void selecciono_el_de_la_primera_lista(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Selecciono el \"([^\"]*)\" de la segunda lista$")
	public void selecciono_el_de_la_segunda_lista(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^completo los datos obligatorios de compra$")
	public void completo_los_datos_obligatorios_de_compra() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^continuo con pago seguro$")
	public void continuo_con_pago_seguro() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Verificar el mensaje \"([^\"]*)\" en pantalla$")
	public void verificar_el_mensaje_en_pantalla(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^cierro la sesi?n de compra$")
	public void cierro_la_sesi_n_de_compra() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	
}
