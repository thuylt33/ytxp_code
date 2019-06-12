package net.serenitybdd.starter.YTXP.pages.PhieuNhapKho;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.YTXP.pages.HomePage;
import net.serenitybdd.starter.util.Util;

public class ThemMoiPhieuNhapKho_Page extends PageObject {

	@FindBy(id = "soseriadd")
	WebElementFacade txt_soSeri;

	public boolean insertForm_textBox_soSeri_isVisible() {
		return txt_soSeri.isVisible();
	}

	public void enter_soSeri(String code) {
		txt_soSeri.type(code);
	}

	@FindBy(id = "sohoadonadd")
	WebElementFacade txt_soHoaDon;

	public boolean insertForm_textBox_soHoaDon_isVisible() {
		return txt_soHoaDon.isVisible();
	}

	public void enter_soHoaDon(String code) {
		txt_soHoaDon.type(code);

	}

	@FindBy(id = "NhapKho_Index_cbb_NguoiNhan-inputEl")
	WebElementFacade txt_nguoiNhan;

	public boolean insertForm_comboBox_nguoiNhan_isVisible() {
		return txt_nguoiNhan.isVisible();
	}

	@FindBy(id = "NhapKho_Index_cbb_DonViNhan-inputEl")
	WebElementFacade txt_khoNhan;

	public boolean insertForm_comboBox_khoNhan_isVisible() {
		return txt_khoNhan.isVisible();
	}

	@FindBy(id = "NhapKho_Index_cbb_NhaCungCap-inputEl")
	WebElementFacade txt_nhaCungCap;

	public boolean insertForm_comboBox_nhaCungCap_isVisible() {
		return txt_nhaCungCap.isVisible();
	}

	@FindBy(id = "grd_DSThemMoiThuoc")
	WebElementFacade grid_themMoiThuoc;

	public boolean insertForm_grid_nhapThuoc_isVisible() {
		return grid_themMoiThuoc.isVisible();
	}

	@FindBy(xpath = "//td[@id='NhapKho_Index_cbb_NguoiNhan-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arCb_nguoiNhan;

	public void click_on_combobox_nguoiNhan() {
		arCb_nguoiNhan.click();
	}

	@FindBy(xpath = "//td[@id='NhapKho_Index_cbb_DonViNhan-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arCb_khoNhan;

	public void click_on_combobox_khoNhan() {
		arCb_khoNhan.click();
	}

	@FindBy(xpath = "//td[@id='NhapKho_Index_cbb_NhaCungCap-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arCb_nhaCungCap;

	public void click_on_combobox_nhaCungCap() {
		arCb_nhaCungCap.click();
	}

	@FindBy(id = "ngayhoadonadd-inputEl")
	WebElementFacade txt_ngayHoaDon;

	public void enter_ngayHoaDon(String today) {
		txt_ngayHoaDon.type(today);
	}

	@FindBy(xpath = "//td[@id='NhapKho_Index_cbb_NguonNhapHang-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arCb_nguonNhapHang;

	public void click_arrow_combo_nguonNhapHang() {
		arCb_nguonNhapHang.click();
	}

	@FindBy(id = "ngaynhaphangadd-inputEl")
	WebElementFacade txt_ngayNhapHang;

	public void enter_ngayNhapHang(String today) {
		txt_ngayNhapHang.type(today);
	}

	@FindBy(xpath = "//div[@id='grd_DSThemMoiThuoc-body']//table/tbody/tr/td[4]")
	List<WebElementFacade> mathuoc_field;

	public void click_on_maThuoc_field(int index) {
		mathuoc_field.get(index).click();
	}

	@FindBy(xpath = "//td[@id='cbx_ProvincesList-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arCb_maThuoc;

	public void click_on_combobox_maThuoc(int index) {
		arCb_maThuoc.click();
	}

	private static final String grid_column_xpath = "//div[@id='grd_DSThemMoiThuoc-body']//table/tbody/tr/td";

	@FindBy(xpath = grid_column_xpath + "[9]")
	List<WebElementFacade> soLuong_field;

	public void click_on_soLuong_field(int index) {
		evaluateJavascript(Util.nodeInDOM(grid_column_xpath + "[9]") + ".scrollIntoView()");
		if (!txt_soLuong.isDisplayed())
			soLuong_field.get(index).click();
	}

	@FindBy(xpath = "//input[@name='SOLUONGBANDAU']")
	WebElementFacade txt_soLuong;

	public void enter_soLuong(int soLuong) {
		txt_soLuong.clear();
		txt_soLuong.type(soLuong + "");
	}

	@FindBy(xpath = grid_column_xpath + "[10]")
	List<WebElementFacade> tiLe_field;

	public void click_on_tiLe_field(int index) {
		evaluateJavascript(Util.nodeInDOM(grid_column_xpath + "[10]") + ".scrollIntoView()");
		tiLe_field.get(index).click();

	}

	@FindBy(xpath = "//input[@name='TYLEQUYDOI']")
	WebElementFacade txt_tiLe;

	public void enter_tiLe(int tiLe) {
		txt_tiLe.clear();
		txt_tiLe.type(tiLe + "");
	}

	@FindBy(xpath = grid_column_xpath + "[12]")
	List<WebElementFacade> donGia_field;

	public void click_on_donGia_field(int index) {
		evaluateJavascript(Util.nodeInDOM(grid_column_xpath + "[12]") + ".scrollIntoView()");
		donGia_field.get(index).click();
	}

	@FindBy(xpath = "//input[@name='DONGIAMUA']")
	WebElementFacade txt_donGia;

	public void enter_donGia(int donGia) {
		txt_donGia.clear();
		txt_donGia.type("" + donGia);
	}

	@FindBy(xpath = grid_column_xpath + "[17]")
	List<WebElementFacade> loSX_field;

	public void click_on_loSX_field(int index) {
		evaluateJavascript(Util.nodeInDOM(grid_column_xpath + "[17]") + ".scrollIntoView()");
		loSX_field.get(index).click();
	}

	@FindBy(xpath = "//input[@name='SOKIEMSOAT']")
	WebElementFacade txt_loSX;

	public void enter_loSX(int loSX) {
		txt_loSX.clear();
		txt_loSX.type("" + loSX);
	}

	@FindBy(xpath = grid_column_xpath + "[19]")
	List<WebElementFacade> hanDung_field;

	public void click_on_hanDungX_field(int index) {
		evaluateJavascript(Util.nodeInDOM(grid_column_xpath + "[19]") + ".scrollIntoView()");
		hanDung_field.get(index).click();
	}

	@FindBy(xpath = "//input[@name='HANDUNG']")
	WebElementFacade txt_hanDung;

	public void enter_hanDung(String hanDung) {
		txt_hanDung.clear();
		txt_hanDung.type(hanDung);
	}

	@FindBy(xpath = grid_column_xpath + "[20]")
	List<WebElementFacade> ttPheDuyet_field;

	public void click_on_ttPheDuyet_field(int index) {
		evaluateJavascript(Util.nodeInDOM(grid_column_xpath + "[20]") + ".scrollIntoView()");
		ttPheDuyet_field.get(index).click();
	}

	@FindBy(xpath = "//input[@name='MATHUOCTHAU']")
	WebElementFacade txt_ttPheDuyet;

	public void enter_ttPheDuyet(int ttPheDuyet) {
		txt_ttPheDuyet.clear();
		txt_ttPheDuyet.type(ttPheDuyet + "");
	}

	String add_more_row_xpath = grid_column_xpath + "[2]//img";

	public void scroll_to_the_first_row() {
		evaluateJavascript(Util.nodeInDOM(add_more_row_xpath) + ".scrollIntoView()");
	}

	public void add_more_row() {
		evaluateJavascript(Util.nodeInDOM(add_more_row_xpath) + ".click()");
	}

	public void click_on_add_button() {
		evaluateJavascript("document.getElementById('btnAdd').click()");
	}

}
