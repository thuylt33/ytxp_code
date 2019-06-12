package net.serenitybdd.starter.YTXP.steps;

import static org.junit.Assert.assertTrue;

import net.serenitybdd.starter.YTXP.pages.HomePage;
import net.serenitybdd.starter.YTXP.pages.LoginPage;
import net.thucydides.core.annotations.Step;

public class LoginSteps {
	LoginPage page;
	HomePage home;

	@Step
	public void on_the_log_in_page() {
		page.open();
	}

	@Step("Enter username {0} and password {1}")
	public void enter_credential(String username, String pass) {
		page.enter_username(username);
		page.enter_password(pass);
		page.click_login();
	}
	@Step
	public void can_see_tab_button(String tabname) {
		assertTrue(home.tab_button_is_displayed(tabname));
	}
	@Step
	public void can_see_logout_button() {
		assertTrue(home.logout_button_is_displayed());
	}
	@Step
	public void logOut() {
		home.logOut();
	}

}
