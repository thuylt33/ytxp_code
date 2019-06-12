package net.serenitybdd.starter.YTXP.features;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.YTXP.steps.LoginSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

//@RunWith(SerenityRunner.class)
public class Login {

/*	@Managed(uniqueSession = true)
	public WebDriver webdriver;
*/	@Steps
	LoginSteps user;


//	@Test
	public void login(String username, String password) {
		user.on_the_log_in_page();
		user.enter_credential(username, password);
		user.can_see_tab_button("Bàn làm việc");
		user.can_see_logout_button();
	}

	public void logOut() {
		user.logOut();
	}
}
