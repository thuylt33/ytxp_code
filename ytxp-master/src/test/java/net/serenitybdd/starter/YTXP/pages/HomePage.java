package net.serenitybdd.starter.YTXP.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.starter.util.Util;

public class HomePage extends PageObject {
	By tab_button(String tabname) {
		return By.xpath("//a[contains(@class,'x-tab')]//span[text()='" + tabname + "']");
	}

	public boolean tab_button_is_displayed(String tabname) {
		return this.getDriver().findElement(tab_button(tabname)).isDisplayed();
	}

	@FindBy(id = "lbLogout_Link")
	WebElementFacade logout;

	public boolean logout_button_is_displayed() {
		return logout.isPresent();
	}

	@FindBy(xpath = "//li[@data-id='DuocPham']")
	WebElementFacade mainMenuDuocPham;

	public void open_menu_duoc_pham() {
		mainMenuDuocPham.click();
	}

	@FindBy(xpath = "//a[@data-id='DuocPham.NhapTuNhaCungCap']")
	WebElementFacade subMenuPhieuNhapKho;

	public void choose_menu_phieu_nhap_kho() {
		subMenuPhieuNhapKho.click();
	}

	public void logOut() {
		evaluateJavascript("document.getElementById('lbLogout_Link').click()");
	}

	@FindBy(xpath = "//a[@data-id='KhamBenh.KhamBenhXaPhuong']")
	WebElementFacade subMenuKhamBenhXaPhuong;

	public void click_on_subMenu_KhamBenhXaPhuong() {
		subMenuKhamBenhXaPhuong.click();
	}

	@FindBy(xpath = "//li[@data-id='NgoaiTru']")
	WebElementFacade mainNgoaiTru;

	public void click_on_menu_khamBenh() {
		mainNgoaiTru.click();
	}

	public void open_DanhSachKhamBenh_tab() {
		evaluateJavascript(Util.nodeInDOM("//*[@data-id='KhamBenh.DSKhamBenhXaPhuong']")+".click()");
	}

}
