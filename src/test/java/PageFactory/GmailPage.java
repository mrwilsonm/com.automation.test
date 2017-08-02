package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import helpUtil.BrowserDriver;

import org.openqa.selenium.interactions.*;

import static org.hamcrest.MatcherAssert.assertThat;

public class GmailPage {

	WebDriver driver;
	
	public GmailPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	
	void getDriver() {
		BrowserDriver.getCurrentDriver("chrome");
		driver = BrowserDriver.getCurrentDriver();
	}

	void openUrl(String strUrl) {
		driver.get(strUrl);
	}
	
	public void abrirPagina(String strUrl){
		getDriver();
		openUrl(strUrl);
	}


	public void accesoCuentaGmail(String strCuentaCorreo, String strPass) throws InterruptedException {
		// TODO Auto-generated method stub
		loguearGmail(strCuentaCorreo, strPass);
	}

	
	/*private void clickFlechaCuentas(){
		WebElement lnkFlechaCuentas = driver.findElement(By.cssSelector("span > svg"));
		lnkFlechaCuentas.click();
	}
	
	private void clickOtraCuenta(){
		WebElement lnkOtraCuenta = driver.findElement(By.xpath("//*[@id='identifierLink']//*[text()='Usar otra cuenta']"));
		lnkOtraCuenta.click();
	}*/
	
	
	private void clickSiguienteLogueo() throws InterruptedException{
		WebElement lnkSiguienteLogueo = driver.findElement(By.cssSelector("span.RveJvd.snByac"));
		lnkSiguienteLogueo.click();
		
	}
	
	private void inputCuentaCorreo(String strCuentaCorreo){
		WebElement txtCuentaCorreo = driver.findElement(By.id("identifierId"));
		txtCuentaCorreo.sendKeys(strCuentaCorreo);
	}
	
	private void inputPass(String strPass){
		WebElement txtPass = driver.findElement(By.name("password"));
		txtPass.sendKeys(strPass);
	}
	
	private void clickRedactar() throws InterruptedException {
	    WebElement btnRedactar = driver.findElement(By.cssSelector(".T-I.J-J5-Ji.T-I-KE.L3"));
	    btnRedactar.click();
	    Thread.sleep(2000);
	}

	private void inputDestinatario(String strCorreoDestinatario) {
		WebElement txtDestinatario = driver.findElement(By.xpath(".//textarea[contains(@aria-label, 'To')]"));
		txtDestinatario.sendKeys(strCorreoDestinatario);
	}
	
	private void inputAsunto(String strAsunto) {
		WebElement txtAsunto = driver.findElement(By.name("subjectbox"));
		txtAsunto.sendKeys(strAsunto);	
	}

	private void inputContenidoEmail(String strContenidoEmail) {
		WebElement divContenidoEmail = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
		divContenidoEmail.sendKeys(strContenidoEmail);
		
	}
	
	private void clickEnviarEmail() throws InterruptedException {
		WebElement btnEnviarEmail = driver.findElement(By.xpath("//td/div/div/div[4]/table/tbody/tr/td/div/div[2]"));
		btnEnviarEmail.click();
		Thread.sleep(12000);
		
	}
    
	private void verifyUltimoEmail(String strAsunto) {
	//private void verifyUltimoEmail() {
		WebElement lblUltimoEmail = driver.findElement(By.xpath("//div [@class='y6']/span[contains(.,'')]"));
		String strAsuntoTemp = lblUltimoEmail.getText();
		assertThat(strAsunto, !equals(strAsuntoTemp));
		//Vericar la existencia del correo
	}
	
	//private void clikRightEliminarEmail(String strAsunto) {
	private void clikRightEliminarEmail() throws InterruptedException {
		WebElement lblEliminarEmail = driver.findElement(By.xpath("//div [@class='y6']/span[contains(.,'')]"));
		Actions acAction = new Actions(driver);
		
		acAction.contextClick(lblEliminarEmail).perform();
		
		//WebElement lnkEliminar = driver.findElement(By.xpath("//*[@class='J-N']//*[text()='Delete']"));
		WebElement lnkEliminar = driver.findElement(By.xpath("//*[@class='J-N']//*[text()='Delete']"));
		
		lnkEliminar.click();
		Thread.sleep(2000);
	}
	private void dragAndDropDevolverEmailABandeja() throws InterruptedException {
		WebElement txtBuscarGoogle = driver.findElement(By.name("q"));
		txtBuscarGoogle.sendKeys("in:trash ");
		txtBuscarGoogle.sendKeys(Keys.ENTER);
		WebElement lblDevolverEmailABandeja = driver.findElement(By.xpath("//div[4]/div/div/table/tbody/tr/td[4]/div[2]"));
		WebElement lnkBandejaEntrada = driver.findElement(By.xpath("//a[contains(text(),'Inbox')]"));
		Thread.sleep(2000);
		(new Actions(driver)).dragAndDrop(lblDevolverEmailABandeja, lnkBandejaEntrada).perform();
	}
	private void clickBandejaEntrada() throws InterruptedException {
		WebElement lnkBandejaEntrada = driver.findElement(By.xpath("//a[contains(text(),'Inbox')]"));
		lnkBandejaEntrada.click();
		Thread.sleep(5000);
	}

	
	public void loguearGmail(String strCuentaCorreo, String strPass) throws InterruptedException{
		//clickFlechaCuentas();
		//clickOtraCuenta();
		inputCuentaCorreo(strCuentaCorreo);
		clickSiguienteLogueo();
		Thread.sleep(2000);
		inputPass(strPass);
		clickSiguienteLogueo();
		Thread.sleep(5000);
	}

	public void clickRedactarCorreo() throws InterruptedException {
		// TODO Auto-generated method stub
		clickRedactar();
	}

	public void ingresarCorreoDestinatario(String strCorreoDestinatario) {
		// TODO Auto-generated method stub
		inputDestinatario(strCorreoDestinatario);
	}

	public void ingresarAsuntoYCuerpoEmail(String strAsunto, String strContenidoEmail) {
		// TODO Auto-generated method stub
		inputAsunto(strAsunto);
		inputContenidoEmail(strContenidoEmail);
	}

	public void clickEnviarCorreo() throws InterruptedException {
		// TODO Auto-generated method stub
		clickEnviarEmail();
	}

	public void verificarEmailBandejaEntrada(String strAsunto) {
		// TODO Auto-generated method stub
		verifyUltimoEmail(strAsunto);
	}

	public void eliminarEmailClickDerecho() throws InterruptedException {
		// TODO Auto-generated method stub
		clikRightEliminarEmail();
	}

	public void moverEmailElimnadoABandejaEntrada() throws InterruptedException {
		// TODO Auto-generated method stub
		dragAndDropDevolverEmailABandeja();
		clickBandejaEntrada();
	}
	
	


	
}
