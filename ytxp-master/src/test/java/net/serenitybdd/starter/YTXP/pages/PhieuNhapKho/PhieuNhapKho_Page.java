package net.serenitybdd.starter.YTXP.pages.PhieuNhapKho;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.YTXP.pages.HomePage;

public class PhieuNhapKho_Page extends PageObject {
	GenaralObject genObj;

	@FindBy(id = "duoc_nhapkho_btnadd")
	WebElementFacade btn_ThemMoi;

	public boolean button_themMoi_isVisible() {
		return btn_ThemMoi.isVisible();
	}

	@FindBy(id = "duoc_nhapkho_search_sophieu")
	WebElementFacade txt_soPhieu;

	public boolean textBox_soPhieu_isVisible() {
		return txt_soPhieu.isVisible();
	}

	@FindBy(id = "duoc_nhapkho_search_sohoadon")
	WebElementFacade txt_soHoaDon;

	public boolean textBox_soHoaDon_isVisible() {
		return txt_soHoaDon.isVisible();
	}

	@FindBy(xpath = "//td[@id='NhapKho_Index_cbb_KhoXuat-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arCb_nhaCungCap;

	public void click_combobox_nhaCungCap() {
		arCb_nhaCungCap.click();
	}

	@FindBy(xpath = "//td[@id='NhapKho_Index_cbb_KhoNhan-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arCb_khoNhan;

	public void click_combobox_khoNhan() {
		arCb_khoNhan.click();
	}

	public void click_on_themMoi_button() {
		btn_ThemMoi.click();
	}

	public void enter_soHoaDon(String code) {
		txt_soHoaDon.type(code);
	}

	@FindBy(id = "tungay-inputEl")
	WebElementFacade txt_dateFrom;

	public void enter_date_from(String lastYear) {
		txt_dateFrom.type(lastYear);
	}

	@FindBy(id = "denngay-inputEl")
	WebElementFacade txt_dateTo;

	public void enter_date_to(String today) {
		txt_dateTo.type(today);
	}

	@FindBy(xpath = "//button[contains(@onclick,'timkiemdonduoc')]")
	WebElementFacade btn_timKiem;

	public void click_on_search_button() {
		btn_timKiem.click();
	}

	@FindBy(xpath = "//img[@data-qtip='Xem']")
	List<WebElementFacade> btn_xem;

	public int get_total_result_on_grid() {
		return btn_xem.size();
	}

	By tongSoKhoan_cell(String soHoaDon) {
		return By.xpath("//div[text()='" + soHoaDon + "']/ancestor::tr/td["
				+ genObj.index_of_grid_column("grd_DSPhieuNhap", "Tổng số khoản") + "]");
	}

	public int get_tongSoKhoan_onGrid(String code) {
		int tongSoKhoan = Integer.parseInt(this.getDriver().findElement(tongSoKhoan_cell(code)).getText());
		System.out.println("Tong so khoan = " + tongSoKhoan);
		return tongSoKhoan; 
	}

	@FindBy(xpath = "//td[@id='cbtt-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arCb_trangThai;

	public void choose_trangThai(String trangThai) {
		arCb_trangThai.click();
		genObj.choose_combo_option(trangThai);
	}

	public void click_on_view_button() {
		btn_xem.get(0).click();
	}

}
