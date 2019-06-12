package net.serenitybdd.starter.YTXP.features.KhamNgoaiTruPhuongXa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.YTXP.features.Login;
import net.serenitybdd.starter.YTXP.steps.LoginSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import net.thucydides.core.webdriver.WebDriverFacade;
import net.thucydides.core.webdriver.WebDriverFactory;
import net.thucydides.core.webdriver.Configuration;
import net.thucydides.core.webdriver.DriverConfiguration;

//@RunWith(SerenityRunner.class)
public class test2Browser {
	
	@Managed(uniqueSession = false)
	public WebDriverFactory webdriver1, webdriver2;
//	
//	@Managed(uniqueSession = false)
//	public WebDriver webdriver2;
	
	@Steps
	LoginSteps user1;
	@Steps
	LoginSteps user2;
	
	@Test
	public void test2Browsers() {
		Configuration conf1 = null;
//		conf1.setDefaultBaseUrl("https://hisone.ytecoso.vn/");
		SerenityWebdriverManager driver1 = new SerenityWebdriverManager (webdriver1,null); 
		SerenityWebdriverManager driver2 = new SerenityWebdriverManager (webdriver2,null);
		
	/*	Login acc1 = new Login(driver1.getWebdriver(), user1);
		Login acc2 = new Login(driver2.getWebdriver(), user2);*/
	/*	acc1.login();
		acc2.login();*/
	}

}
