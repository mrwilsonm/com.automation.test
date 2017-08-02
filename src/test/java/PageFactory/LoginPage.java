package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    WebDriver driver;

    @FindBy(linkText="Home")
    WebElement linkHome;
  
    @FindBy(name="userName")
    WebElement userName;
  
    @FindBy(name="password")
    WebElement pass;
   
    @FindBy(name="login")
    WebElement login;
    
    @FindBy(xpath="//tr[3]/td/font")
    WebElement textoLogin;

    
    public LoginPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    
    public void clickHome(){
            linkHome.click();
    }
    
    public void setUserName(String strUserName){
        userName.sendKeys(strUserName);
    }
   
    public void setPassword(String strPassword){
    	pass.sendKeys(strPassword);
    }

    public void clickLogin(){
            login.click();
    }
  
    public String getLoginTitle(){
    	return    textoLogin.getText();
    }

}