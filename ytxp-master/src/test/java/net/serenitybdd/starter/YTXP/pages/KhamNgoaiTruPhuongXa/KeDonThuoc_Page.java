package net.serenitybdd.starter.YTXP.pages.KhamNgoaiTruPhuongXa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.util.Util;

public class KeDonThuoc_Page extends PageObject {
	GenaralObject genObj;
	@FindBy(xpath = "//td[@id='KhamBenh_ToaThuoc_cb_MaThuoc-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arrCombo_maThuoc;

	public void click_on_arrCombo_maThuoc() {
		arrCombo_maThuoc.click();
	}

	@FindBy(xpath = "//input[@name='SONGAY']")
	WebElementFacade txt_soNgay;

	public void enter_soNgay(int i) {
		txt_soNgay.type(i + "");
	}

	By soLuong_field() {
		return By.xpath("//div[@id='KhamBenh_ToaThuoc_grid_AddToaThuoc']//tr[@role='row']/td["
				+ genObj.index_of_grid_column("KhamBenh_ToaThuoc_grid_AddToaThuoc", "S.Lượng") + "]");
	}

	public void click_on_soLuong_field() {
		this.getDriver().findElement(soLuong_field()).click();

	}

	@FindBy(xpath = "//input[@name='SOLUONG']")
	WebElementFacade txt_soLuong;

	public void enter_soLuong(int i) {
		txt_soLuong.type(i + "");
		try {
			Util.sendFunctionKey(this.getDriver(), Keys.TAB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(id = "KhamBenh_ToaThuoc_btn_Luu")
	WebElementFacade btn_luu;

	public void click_luu_button() {
		btn_luu.click();
	}

	

}
