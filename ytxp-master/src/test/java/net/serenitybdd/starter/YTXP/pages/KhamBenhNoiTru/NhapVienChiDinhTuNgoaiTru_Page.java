package net.serenitybdd.starter.YTXP.pages.KhamBenhNoiTru;

import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.util.Util;

public class NhapVienChiDinhTuNgoaiTru_Page extends PageObject {

	public void go_to_KhamBenhNgoaiTru_page() {
		evaluateJavascript(Util.nodeInDOM("//a[@data-id='KhamBenh.KhamBenhNgoaiTru']") + ".click()");
	}

	@FindBy(xpath = "//td[@id='xp_id_trangthaiBN_khambenh-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arrCb_status;

	public void click_on_arrow_combo_status(String status) {
		arrCb_status.click();
	}

	@FindBy(id = "xp_id_ngaythang_khambenh-inputEl")
	WebElementFacade txt_fromDate;

	public void enter_fromDate(String fromDate) {
		txt_fromDate.clear();
		txt_fromDate.type(fromDate);
	}

	@FindBy(id = "xp_btnInsert")
	WebElementFacade btn_timKiem;

	public void click_on_timKiem_button() {
		btn_timKiem.click();

	}

	@FindBy(xpath = "//div[@id='xp_grd_danhsachBNKhamBenh']//tr[@role='row']")
	List<WebElementFacade> rows;

	public void doubleClick_onThe_first_record() {
		Actions action = new Actions(this.getDriver());
		action.moveToElement(rows.get(0)).doubleClick().perform();

	}

	

	public void goTo_danhSachNhapVien() {
		evaluateJavascript(Util.nodeInDOM("//a[@data-id='NoiTru.DSTiepNhanNoiTru']") + ".click()");
	}





}
