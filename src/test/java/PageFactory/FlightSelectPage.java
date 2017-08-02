package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FlightSelectPage {
	WebDriver driver;
	
	public FlightSelectPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	private void optionDepart() {
		//segundo vuelo
		WebElement rbtDepart = driver.findElement(By.xpath("(//input[@name='outFlight'])[2]"));
		rbtDepart.click();
	}
	
	private void optionReturn() {
		//tercer vuelo
		WebElement rbtReturn = driver.findElement(By.xpath("(//input[@name='inFlight'])[3]"));
		rbtReturn.click();
	}
	
	private void clickContinue() throws InterruptedException{
		WebElement btnContinue = driver.findElement(By.name("reserveFlights"));
		btnContinue.click();
		Thread.sleep(2000);
	}

	public void selectFlights() throws InterruptedException {
		// TODO Auto-generated method stub
		optionDepart();
		optionReturn();
		clickContinue();
	}
	
	
}
