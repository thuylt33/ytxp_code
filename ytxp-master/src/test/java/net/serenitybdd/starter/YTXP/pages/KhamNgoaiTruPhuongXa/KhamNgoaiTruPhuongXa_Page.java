package net.serenitybdd.starter.YTXP.pages.KhamNgoaiTruPhuongXa;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.util.Util;

public class KhamNgoaiTruPhuongXa_Page extends PageObject {
	@FindBy(id = "xp_tiepnhan_mathebhyt")
	WebElementFacade txt_maTheBHYT;

	public void enter_soBHYT(String soBHYT) {
		txt_maTheBHYT.type(soBHYT);
	}

	@FindBy(id = "xp_tiepnhan_date_bh_tungay-inputEl")
	WebElementFacade txt_TiepNhan_fromDate;

	public void enter_date_from(String fromDate) {
		txt_TiepNhan_fromDate.type(fromDate);
	}

	@FindBy(id = "xp_tiepnhan_date_bh_denngay-inputEl")
	WebElementFacade txt_TiepNhan_toDate;

	public void enter_date_to(String toDate) {
		txt_TiepNhan_toDate.type(toDate);
	}

	@FindBy(id = "xp_tiepnhan_hoten")
	WebElementFacade txt_tiepNhan_hoTen;

	public void enter_hoVaTen(String hoVaTen) {
		txt_tiepNhan_hoTen.type(hoVaTen);
	}

	@FindBy(id = "xp_tiepnhan_namsinh")
	WebElementFacade txt_tiepNhan_namSinh;

	public void enter_namSinh(String namSinh) {
		txt_tiepNhan_namSinh.type(namSinh);
	}

	@FindBy(id = "xp_tiepnhan_tqx_viettat")
	WebElementFacade txt_tiepNhan_diaChi_vietTat;

	public void enter_diaChi_vietTat(String diaChi) {
		txt_tiepNhan_diaChi_vietTat.type(diaChi);
		try {
			Util.sendFunctionKey(this.getDriver(), Keys.TAB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(id = "xp_id_frmChanDoanSoBo")
	WebElementFacade txt_tiepNhan_trieuChung;

	public void enter_trieuChung(String trieuChung) {
		txt_tiepNhan_trieuChung.type(trieuChung);

	}

	@FindBy(id = "token-input-xp_id_xp_frmMachinhICD10")
	WebElementFacade txt_tiepNhan_maBenhChinh;

	public void enter_benhChinh(String benhChinh) {
		txt_tiepNhan_maBenhChinh.type(benhChinh);
		try {
			Thread.sleep(500);
			Util.sendFunctionKey(this.getDriver(), Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//td[@id='xp_combo_BacSiKhamBenh-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arr_combo_bsKham;

	public void click_on_arrowCombo_bsKham() {
		arr_combo_bsKham.click();
	}

	@FindBy(xpath = "//td[@id='xp_cbb_KetQuaKhamBenh-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arr_combo_ketQuaKham;

	public void click_on_arrowCombo_ketQuaKham() {
		arr_combo_ketQuaKham.click();
	}

	@FindBy(xpath = "//td[@id='xp_tiepnhan_index_cb_dichvu-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arr_combo_dichVu;

	public void click_on_arrowCombo_dichVu() {
		arr_combo_dichVu.click();
	}

	@FindBy(xpath = "//td[@id='xp_tiepnhan_index_cb_phongkham-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arr_combo_phongKham;

	public void click_on_arrowCombo_phongKham() {
		arr_combo_phongKham.click();
	}

	@FindBy(id = "xp_btn_khambenh_luuhosokhambenh")
	WebElementFacade btn_luu;

	public void click_on_Luu_button() {
		btn_luu.click();
	}

	@FindBy(id = "xp_XuTri_CapToaThuoc")
	WebElementFacade link_xuTri_capToaThuoc;

	public void click_on_keDonThuoc() {
		link_xuTri_capToaThuoc.click();
	}

	@FindBy(xpath = "//*[contains(@id,'XuTri_ChiDinhDichVu')]")
	WebElementFacade link_chiDinhDichVu;

	public void click_on_chiDinhDichVu_link() {
		link_chiDinhDichVu.click();
	}

	@FindBy(id = "ct_form_page1_bt_print")
	WebElementFacade btn_in;

	public void click_on_In_button() {
		btn_in.click();
	}

	@FindBy(xpath = "//a[contains(@onclick,'ViewPdfBangKeChiPhi01BV')]")
	List<WebElementFacade> link_in;

	public void choose_inBangKeBHYT() {
		link_in.get(1).click();
	}

	@FindBy(xpath = "//div[@id='XacNhanChiPhi_XacNhanChiPhi_InMau01-body']//iframe")
	WebElementFacade iframe_pdf;

	public String get_chiPhi_PDF_path() {
		String url = iframe_pdf.getAttribute("src");
		return url;
	}

}
