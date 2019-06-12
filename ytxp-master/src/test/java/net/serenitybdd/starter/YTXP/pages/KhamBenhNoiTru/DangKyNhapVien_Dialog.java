package net.serenitybdd.starter.YTXP.pages.KhamBenhNoiTru;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.starter.YTXP.pages.GenaralObject;

public class DangKyNhapVien_Dialog extends PageObject {

	@FindBy(xpath = "//td[@id='KB_ChiDinhNoiTru_CB_LoaiBenhAn-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arrCb_loaiBenhAn;

	public void click_arrCb_loaiBenhAn() {
		arrCb_loaiBenhAn.click();
	}

	@FindBy(xpath = "//td[@id='KB_ChiDinhNoiTru_CB_KhoaPhong-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arrCb_khoaNoiTru;

	public void click_arrCB_khoaNoiTru() {
		arrCb_khoaNoiTru.click();
	}

	@FindBy(xpath = "//td[@id='KB_ChiDinhNoiTru_CB_LyDo-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arrCb_lyDoNhapVien;

	public void click_arrCb_lyDoNhapVien() {
		arrCb_lyDoNhapVien.click();
	}

	@FindBy(xpath = "//td[@id='noitru_nhapkhoa_txt_phong_id-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arrCb_phongBenh;

	public void click_arrCb_phongBenh() {
		arrCb_phongBenh.click();
	}

	@FindBy(xpath = "//td[@id='noitru_nhapkhoa_txt_giuong_id-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arrCb_giuongBenh;

	public void click_arrCb_giuongBenh() {
		arrCb_giuongBenh.click();
	}

	@FindBy(xpath = "//td[@id='noitru_nhapkhoa_bacsidieutri_cb_id-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arrCb_bsDieuTri;

	public void click_arrCb_bsDieuTri() {
		arrCb_bsDieuTri.click();
	}

	@FindBy(id = "chidinhnoitru_luu")
	WebElementFacade btn_luu;

	public void clickOn_Luu_button() {
		btn_luu.click();
	}

}
