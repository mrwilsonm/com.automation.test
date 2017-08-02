package stepsDefinition;

import PageFactory.OpenPage;

public class OpenSteps {
	
	OpenPage openPage;
	
	public void abrirPagina(String strUrl){
		openPage.openPage(strUrl);
	}

}
