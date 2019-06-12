package net.serenitybdd.starter.YTXP.pages;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

//@DefaultUrl("")
public class LoginPage extends PageObject {
	@FindBy(id = "username")
	WebElementFacade username;

	public void enter_username(String username2) {
		username.type(username2);
	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElementFacade submit;

	public void click_login() {
		submit.click();
	}

	@FindBy(id = "password")
	WebElementFacade password;

	public void enter_password(String pass) {
		password.type(pass);
	}

}
