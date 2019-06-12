package net.serenitybdd.starter.YTXP.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.starter.util.Util;

public class GenaralObject extends PageObject {
	@FindBy(xpath = "//div[contains(@class,'boundlist-floating')][not(contains(@style,'none'))]//ul[@class='x-list-plain']/li")
	List<WebElementFacade> comboOption;

	public int number_of_comboOption() {
		return comboOption.size();
	}

	public void choose_combo_option(int index) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		comboOption.get(index).click();
	}

	public void choose_combo_option(String value) {
		for (WebElementFacade option : comboOption) {
			if (option.getText().equalsIgnoreCase(value)) {
				option.click();
				return;
			}
		}
	}

	@FindBy(xpath = "//div[contains(@class,'boundlist-floating')][not(contains(@style,'none'))]//tr[contains(@class,'item')]")
	List<WebElementFacade> table_option;

	public int number_of_table_option() {
		return table_option.size();
	}

	public void choose_table_option(int index) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		table_option.get(index).click();
	}

	By preloader = By.xpath("//div[@id='preloader'][contains(@style,'block')]");

	public void wait_for_preloader_disappear() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitForRenderedElementsToDisappear(preloader);
	}

	By grid_loading = By.xpath(
			"//div[contains(@id,'loadmask')][contains(@class,'x-mask-msg-default')][not(contains(@style,'none'))]");

	public void wait_for_grid_loading_disappear() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitForRenderedElementsToDisappear(grid_loading);
	}

	public static final String subfix_arrowCombobox = "/following-sibling::td//div";

	@FindBy(xpath = "//div[contains(@class,'x-message-box')]//a[not(contains(@style,'none'))]//span[text()='Đồng ý']/following-sibling::span")
	WebElementFacade ok_button;

	public void click_on_confirm_button() {
		evaluateJavascript(Util.nodeInDOM(
				"//div[contains(@class,'x-message-box')]//a[not(contains(@style,'none'))]//span[text()='Đồng ý']/following-sibling::span")
				+ ".click()");
//		ok_button.click();
	}

	@FindBy(xpath = "//div[contains(@class,'toast-message')]")
	WebElementFacade toast_message;

	public String get_toast_message_content() {
		return toast_message.getText();
	}

	String present_header_on_grid_xpath(String idGrid) {
		return "//div[@id='" + idGrid
				+ "']//div[contains(@class,'column-header-default')][not(contains(@style,'non'))]//span[contains(@class,'text')]";
	}

	/**
	 * return the index of the column on the grid, start at 1 return -1 if does not
	 * exist
	 * 
	 * @param gridID     TODO
	 * @param headerName
	 * 
	 * @return
	 */
	public int index_of_grid_column(String gridID, String headerName) {
		List<WebElement> headers = this.getDriver().findElements(By.xpath(present_header_on_grid_xpath(gridID)));
		for (int i = 0; i < headers.size(); i++) {
			if (headerName.equalsIgnoreCase(headers.get(i).getText())) {
				return i + 1;
			}
		}
		return -1;
	}

	@FindBy(xpath = "//img[contains(@class,'x-tool-close')]")
	WebElementFacade btn_close;

	public void close_dialog() {
		btn_close.click();
	}

}
