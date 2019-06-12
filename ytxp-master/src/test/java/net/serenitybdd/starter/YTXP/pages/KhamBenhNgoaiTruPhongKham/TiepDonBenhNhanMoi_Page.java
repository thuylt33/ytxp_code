package net.serenitybdd.starter.YTXP.pages.KhamBenhNgoaiTruPhongKham;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.util.GlobalVariable;
import net.serenitybdd.starter.util.Util;

public class TiepDonBenhNhanMoi_Page extends PageObject {

	@FindBy(xpath = "//li[@data-id='TiepDon']")
	WebElementFacade menu_tiepDon;

	public void click_tiepDon_menu() {
		menu_tiepDon.click();
	}

	@FindBy(xpath = "//a[@data-id='TiepDon.TiepDonBenhNhan']")
	WebElementFacade submenu_tiepDonBenhNhan;

	public void click_tiepDonBenhNhan_subMenu() {
		submenu_tiepDonBenhNhan.click();
	}

	@FindBy(id = "tiepnhan_hoten")
	WebElementFacade txt_hoVaTen;

	public void enter_hoVaTen(String hoVaTen) {
		txt_hoVaTen.type(hoVaTen);
	}

	@FindBy(id = "tiepnhan_namsinh")
	WebElementFacade txt_namSinh;

	public void enter_namSinh(int i) {
		txt_namSinh.type(i + "");
	}

	@FindBy(id = "tiepnhan_tqx_viettat")
	WebElementFacade txt_diaChi;

	public void enter_diaChi_vietTat(String diaChi) {
		txt_diaChi.type(diaChi);
		try {
			Util.sendFunctionKey(this.getDriver(), Keys.TAB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(id = "tiepnhan_mathebhyt")
	WebElementFacade txt_soBHYT;

	public void enter_soBHYT(String soBHYT) {
		txt_soBHYT.type(soBHYT);
	}

	@FindBy(id = "tiepnhan_date_bh_tungay-inputEl")
	WebElementFacade txt_fromdate;

	public void enter_date_from(String fromDate) {
		txt_fromdate.type(fromDate);
	}

	@FindBy(id = "tiepnhan_date_bh_denngay-inputEl")
	WebElementFacade txt_toDate;

	public void enter_date_to(String toDate) {
		txt_toDate.type(toDate);
	}

	@FindBy(xpath = "//td[@id='tiepnhan_index_cb_dichvu-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arrCombo_dichVu;

	public void click_arrCombo_dichVu() {
		arrCombo_dichVu.click();
	}

	@FindBy(xpath = "//td[@id='tiepnhan_index_cb_phongkham-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arrCombo_phongKham;

	public void click_arrCombo_phongKham() {
		arrCombo_phongKham.click();
	}

	public void click_on_Luu_button() {
		evaluateJavascript("document.getElementById('tiepnhan_bt_save').click()");
	}

}
