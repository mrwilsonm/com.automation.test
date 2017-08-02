package helpUtil;

//import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpUtil.Enums.Browsers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Point;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import java.io.IOException;
import java.util.List;

public class BrowserDriver{
	private static final Logger LOGGER = Logger.getLogger(BrowserDriver.class.getName());
	private static WebDriver mDriver;

	public synchronized static WebDriver getCurrentDriver(String browser) throws WebDriverException {
		if(mDriver == null){
			try{
				mDriver = getBrowser(browser);
				}
			catch(Exception e){
				mDriver = getBrowser(browser);}
			finally{Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));}
		}

        return mDriver;
    }
	
	public synchronized static WebDriver getCurrentDriver(){
        return mDriver;
    }
	
	private static WebDriver getBrowser(String navegador){
		Browsers browser;
		WebDriver driver = null;
		browser = Browsers.browserForName(navegador.toLowerCase());

		try{
			switch(browser){
				case chrome:
					Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			    	Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
					driver = createChromeDriver();
					break;
				case safari:
					Runtime.getRuntime().exec("taskkill /F /IM safari.exe");
					Runtime.getRuntime().exec("taskkill /F /IM safaridriver.exe");
					driver = createSafariDriver();
					break;
				case firefox:
					Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
			   		Runtime.getRuntime().exec("taskkill /F /IM firefoxdriver.exe");
					driver = createFirefoxDriver();
					break;
				default:
					Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
					Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
					driver = createInternetExplorerDriver();
					break;
			} addAllBrowserSetup(driver);
		}catch (IOException e){
			e.printStackTrace();}

		return driver;
	}

	private static WebDriver createSafariDriver() {
		return new SafariDriver();
	}

	private static WebDriver createChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		return new ChromeDriver();
	}
	
	private static WebDriver createInternetExplorerDriver( ) {
		System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
		return  new InternetExplorerDriver();
    }
	
	private static WebDriver createFirefoxDriver( ) {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        return new FirefoxDriver();
    }

	private static void addAllBrowserSetup(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new Point(0, 0));
        //java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
        //driver.manage().window().setSize(dim);
        driver.manage().window().maximize();
	}

	public static void close(){
        try {
            getCurrentDriver().quit();
            mDriver = null;
            LOGGER.info("closing the browser");
        } catch (Exception e) {
            LOGGER.info("cannot close browser: unreachable browser");
        }
    }

	private static class BrowserCleanup implements Runnable {
        public void run(){
            close();
        }
    }
	
	public static void loadPage(String url){
		getCurrentDriver();
        LOGGER.info("Directing browser to:" + url);
        LOGGER.info("try to loadPage [" + url + "]");
        getCurrentDriver().get(url);
	}
	
	public static void reopenAndLoadPage(String url) {
        mDriver = null;
        getCurrentDriver();
        loadPage(url);
    }
	
	public static WebElement waitForElement(WebElement elementToWaitFor){
		return waitForElement(elementToWaitFor, null);
	}
	
	public static WebElement waitForElement(WebElement elementToWaitFor, Integer waitTimeInSeconds){
	    if(waitTimeInSeconds == null) {
	    	waitTimeInSeconds = 10;
	    }
	    
	    WebDriverWait wait = new WebDriverWait(getCurrentDriver(), waitTimeInSeconds);
	    return wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
	}
	
    public static WebElement getParent(WebElement element){
        return element.findElement(By.xpath(".."));
    }
    
    public static List<WebElement> getDropDownOptions(WebElement webElement){
        Select select = new Select(webElement);
        return select.getOptions();
    }
    
    public static WebElement getDropDownOption(WebElement webElement, String value){
    	WebElement option = null;
        List<WebElement> options = getDropDownOptions(webElement);

        for(WebElement element : options){
            if(element.getAttribute("value").equalsIgnoreCase(value)){
                option = element;
                break;
            }
        }

        return option;
    }
}