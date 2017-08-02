package PageFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderPage {

	WebDriver driver;
	
	public FlightFinderPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
  	public void clickLnkVuelos() throws InterruptedException {
	    WebElement lnkPaginaVuelo = driver.findElement(By.linkText("Flights"));
		lnkPaginaVuelo.click();
		Thread.sleep(2000);
	}

	private void selectPassengers(int intPassengers) {
		WebElement cmdPassengers = driver.findElement(By.name("passCount"));
		new Select(cmdPassengers).selectByVisibleText(String.valueOf(intPassengers));
	}
	
	private void selectDeportingFrom(String strDeportingFrom) {
		WebElement cmbDeportingFrom = driver.findElement(By.name("fromPort"));
		new Select(cmbDeportingFrom).selectByVisibleText(strDeportingFrom);	
	}

	private void selectOnMonth(String strOnMonth) {
		WebElement cmbOnMonth = driver.findElement(By.name("fromMonth"));
		new Select(cmbOnMonth).selectByVisibleText(strOnMonth);
		
	}
	
	private void selectOnDay(int strOnDay) {
		WebElement cmbOnDay = driver.findElement(By.name("fromDay"));
		new Select(cmbOnDay).selectByVisibleText(String.valueOf(strOnDay));
		
	}
    
	private void selectArrivingIn(String strArrivingIn) {
		WebElement cmbArrivingIn = driver.findElement(By.name("toPort"));
		new Select(cmbArrivingIn).selectByVisibleText(strArrivingIn);
	}
	private void selectReturningMonth(String strReturningMonth) {
		WebElement cmbReturningMonth = driver.findElement(By.name("toMonth"));
		new Select(cmbReturningMonth).selectByVisibleText(strReturningMonth);
	}
	private void selectReturningDay(int strReturningDay) {
		WebElement cmbReturningDay = driver.findElement(By.name("toDay"));
		new Select(cmbReturningDay).selectByVisibleText(String.valueOf(strReturningDay));
	}
	private void optionServiceClass(String strServiceClass) {
		WebElement cmbServiceClass = driver.findElement(By.name("servClass"));
		cmbServiceClass.click();
	}
	
	private void selectAirline(String strAirline) {
		WebElement cmbAirline = driver.findElement(By.name("airline"));
		new Select(cmbAirline).selectByVisibleText(strAirline);
	}
	
	private void clickFindFlight() throws InterruptedException {
		WebElement btnFindFlight = driver.findElement(By.name("findFlights"));
		btnFindFlight.click();
		Thread.sleep(2000);
	}
	
	public void inputDetailFlight(DetailFlightFinder detailFlight) throws InterruptedException{
		selectPassengers(detailFlight.getIntPassengers());
		selectDeportingFrom(detailFlight.getStrDepartingFrom());
		selectOnMonth(detailFlight.getStrOnMonth());
		selectOnDay(detailFlight.getIntOnDay());
		selectArrivingIn(detailFlight.getStrArrivingIn());
		selectReturningMonth(detailFlight.getStrReturningMonth());
		selectReturningDay(detailFlight.getIntReturnigDay());
		optionServiceClass(detailFlight.getStrServiceClass());
		selectAirline(detailFlight.getStrAirline());
		clickFindFlight();
	}

	


    
}
