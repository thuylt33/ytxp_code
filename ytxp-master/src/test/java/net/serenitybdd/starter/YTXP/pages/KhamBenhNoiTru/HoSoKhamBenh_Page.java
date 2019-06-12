package net.serenitybdd.starter.YTXP.pages.KhamBenhNoiTru;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class HoSoKhamBenh_Page extends PageObject {
	@FindBy(id = "id_frmHoTen")
	WebElementFacade lb_hoTen;

	public String get_patientName() {
		return lb_hoTen.getText();
	}

	public void click_on_dangKyNhapVien_link() {
		evaluateJavascript("document.getElementById('XuTri_ChiDinhNoiTru').click()");
	}

}
