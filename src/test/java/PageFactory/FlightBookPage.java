package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightBookPage {
	
	WebDriver driver;
	
	public FlightBookPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	private void inputPassFirst(String strPassFirst){
		WebElement txtPassFirst = driver.findElement(By.name("passFirst0"));
		txtPassFirst.sendKeys(strPassFirst);
	}
	
	private void inputPassLast(String strPassLast){
		WebElement txtPassLast = driver.findElement(By.name("passLast0"));
		txtPassLast.sendKeys(strPassLast);
	}
	
	private void selectPassMeal(String strPassMeal){
		WebElement cmbPassMeal = driver.findElement(By.name("pass.0.meal"));
		new Select(cmbPassMeal).selectByVisibleText(strPassMeal);
	}
	
	private void selectCreditCard(String strCreditCard){
		WebElement cmbCreditCard = driver.findElement(By.name("creditCard"));
		new Select(cmbCreditCard).selectByVisibleText(strCreditCard);
	}
	
	private void inputCreditNumber(String strCreditNumber){
		WebElement txtCreditNumber = driver.findElement(By.name("creditnumber"));
		txtCreditNumber.sendKeys(strCreditNumber);
	}
	
	private void selectExpMonthCreditCard(String strExpMonthCreditCard){
		WebElement txtExpMonthCreditCard = driver.findElement(By.name("cc_exp_dt_mn"));
		new Select(txtExpMonthCreditCard).selectByVisibleText(strExpMonthCreditCard);
	}
	
	private void selectExpYearCreditCard(String strExpYearCreditCard){
		WebElement txtExpYearCreditCard = driver.findElement(By.name("cc_exp_dt_yr"));
		new Select(txtExpYearCreditCard).selectByVisibleText(strExpYearCreditCard);
	}
	
	private void inputCreditCardFirstName(String strCreditCardFirstName){
		WebElement txtCreditCardFirstName = driver.findElement(By.name("cc_frst_name"));
		txtCreditCardFirstName.sendKeys(strCreditCardFirstName);
	}
	
	private void inputCreditCardMiddleName(String strCreditCardMiddleName){
		WebElement txtCreditCardMiddleName = driver.findElement(By.name("cc_mid_name"));
		txtCreditCardMiddleName.sendKeys(strCreditCardMiddleName);
	}
	
	private void clickSecurePurchase() throws InterruptedException{
		WebElement lnkSecurePurchase = driver.findElement(By.name("buyFlights"));
		lnkSecurePurchase.click();
		Thread.sleep(2000);
	}

	public void inputDetailFlightBook(DetailFlightBook detailFlightBook) {
		// TODO Auto-generated method stub
		inputPassFirst(detailFlightBook.getStrPassFirst());
		inputPassLast(detailFlightBook.getStrPassLast());
		selectPassMeal(detailFlightBook.getStrPassMeal());
		selectCreditCard(detailFlightBook.getStrCreditCard());
		inputCreditNumber(detailFlightBook.getStrCreditNumber());
		inputCreditCardFirstName(detailFlightBook.getStrCreditCardFirstName());
		inputCreditCardMiddleName(detailFlightBook.getStrCreditCardMiddleName());
		selectExpMonthCreditCard(detailFlightBook.getStrExpMonthCreditCard());
		selectExpYearCreditCard(detailFlightBook.getStrExpYearCreditCard());
		
	}
	
	public void clickConfirmSecurePurchase() throws InterruptedException {
		// TODO Auto-generated method stub
		clickSecurePurchase();
	}
	
}
