package net.serenitybdd.starter.YTXP.pages.KhamNgoaiTruPhuongXa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DanhSachKhamBenh_Page extends PageObject {

	@FindBy(id = "txt_SearchBnKb")
	WebElementFacade txt_searchContent;

	public void enter_hoVaTen(String hoVaTen) {
		txt_searchContent.type(hoVaTen);
	}

	@FindBy(id = "btnInsert")
	WebElementFacade btn_find;

	public void click_on_timKiem_button() {
		btn_find.click();
	}

	public boolean grid_has_the_patient(String hoVaTen) {
		By path = By.xpath(
				"//div[@id='grd_danhsachBNKhamBenh-body']//div[contains(@class,'x-grid-cell-inner')][contains(text(),'"
						+ hoVaTen.toUpperCase() + "')]");
		return this.getDriver().findElements(path).size() > 0;
	}

}
