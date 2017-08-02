package Implements;



import PageFactory.DetailFlightBook;
import PageFactory.DetailFlightFinder;
import PageFactory.FlightBookPage;
import PageFactory.FlightConfirmationPage;
import PageFactory.FlightFinderPage;
import PageFactory.FlightSelectPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuyFlight {

	Login login = new Login();
	
	FlightFinderPage flightFinderPage;
	FlightSelectPage selectFlightPage;
	FlightBookPage flightBookPage; 
	FlightConfirmationPage flightConfirmationPage;
	
	@Given("^ingreso a la seccion de compra de vuelos$")
	public void ingreso_a_la_seccion_de_compra_de_vuelos() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		flightFinderPage = new FlightFinderPage(Login.driver);
		flightFinderPage.clickLnkVuelos();
	}


	@When("^busco vuelos disponibles para mi destino$")
	public void busco_vuelos_disponibles_para_mi_destino() throws Throwable {
		DetailFlightFinder detailFlightFinder = new DetailFlightFinder();
		detailFlightFinder.setIntPassengers(1);
		detailFlightFinder.setStrDepartingFrom("Acapulco");
		detailFlightFinder.setStrOnMonth("March");
		detailFlightFinder.setIntOnDay(10);
		detailFlightFinder.setStrArrivingIn("London");
		detailFlightFinder.setStrReturningMonth("June");
		detailFlightFinder.setIntReturnigDay(20);
		detailFlightFinder.setStrServiceClass("First Class");
		detailFlightFinder.setStrAirline("Unified Airlines");
		
		flightFinderPage.inputDetailFlight(detailFlightFinder);
	}

	@When("^selecciono los vuelos que me interesan$")
	public void selecciono_los_vuelos_que_me_interesan() throws Throwable {
		selectFlightPage = new FlightSelectPage(Login.driver);
		selectFlightPage.selectFlights();
	}

	@When("^completo los datos obligatorios para el vuelo$")
	public void completo_los_datos_obligatorios_para_el_vuelo() throws Throwable {
		flightBookPage = new FlightBookPage(Login.driver);
		DetailFlightBook detailFlightBook = new DetailFlightBook();
		detailFlightBook.setStrPassFirst("Juan");
		detailFlightBook.setStrPassLast("David");
		detailFlightBook.setStrPassMeal("Bland");
		detailFlightBook.setStrCreditCard("MasterCard");
		detailFlightBook.setStrCreditNumber("452653562548521");
		detailFlightBook.setStrCreditCardFirstName("Luis");
		detailFlightBook.setStrCreditCardMiddleName("Perez");
		detailFlightBook.setStrExpMonthCreditCard("08");
		detailFlightBook.setStrExpYearCreditCard("2009");
		
		flightBookPage.inputDetailFlightBook(detailFlightBook);
		
	}

	@Then("^confirmo el vuelo$")
	public void confirmo_el_vuelo() throws Throwable {
		flightBookPage.clickConfirmSecurePurchase();
	}

	@Then("^verifico que se haya generado mi vuelo$")
	public void verifico_que_se_haya_generado_mi_vuelo() throws Throwable {
		flightConfirmationPage = new FlightConfirmationPage(Login.driver);
		flightConfirmationPage.assertMessageConfirmation("Your itinerary has been booked!");
	}

	
}
