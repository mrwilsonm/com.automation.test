package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import helpUtil.BrowserDriver;

public class OpenPage {

	WebDriver driver;
	
	public OpenPage(WebDriver driver){

        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	
	void getDriver() {
		BrowserDriver.getCurrentDriver("chrome");
		driver = BrowserDriver.getCurrentDriver();
	}

	void openUrl(String strUrl) {
		driver.get(strUrl);
	}
	
		
	public void openPage(String strUrl){
		getDriver();
		openUrl(strUrl);
	}
}
