package PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FlightConfirmationPage {

WebDriver driver;
	
	public FlightConfirmationPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	private String getMessageConfirmation(){
		WebElement lblMessageConfirmation = driver.findElement(By.xpath("//font[2]"));
		return lblMessageConfirmation.getText();
	}
	
	public void assertMessageConfirmation(String strMessageConfirmation) throws InterruptedException{
		assertThat(strMessageConfirmation, containsString(getMessageConfirmation()));
		Thread.sleep(2000);
	}



	
}
