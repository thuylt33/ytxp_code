package net.serenitybdd.starter.YTXP.steps.NhapKhoThuoc;

import static org.junit.Assert.assertTrue;

import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.YTXP.pages.HomePage;
import net.serenitybdd.starter.YTXP.pages.PhieuNhapKho.PhieuNhapKho_Page;
import net.serenitybdd.starter.YTXP.pages.PhieuNhapKho.ThemMoiPhieuNhapKho_Page;
import net.thucydides.core.annotations.Step;

public class PhieuNhapKho_Steps  {
	PhieuNhapKho_Page page;
	ThemMoiPhieuNhapKho_Page insertPage;
	HomePage home;
	GenaralObject genObj;

	@Step("Go to Phiếu nhập kho page")
	public void on_phieuNhapKho_page() {
		genObj.wait_for_preloader_disappear();
		home.open_menu_duoc_pham();
		home.choose_menu_phieu_nhap_kho();
		genObj.wait_for_grid_loading_disappear();
	}
	
	@Step("Can see button Thêm mới")
	public void can_see_button_themMoi() {
		assertTrue(page.button_themMoi_isVisible());
	}

	@Step("Can see textbox Số phiếu")
	public void can_see_textBox_soPhieu() {
		assertTrue(page.textBox_soPhieu_isVisible());
	}

	@Step("Can see textbox Số hóa đơn")
	public void can_see_textBox_soHoaDon() {
		assertTrue(page.textBox_soHoaDon_isVisible());

	}

	@Step("Click on combobox Nhà cung cấp")
	public void click_combobox_nhaCungCap() {
		page.click_combobox_nhaCungCap();
	}

	@Step("Can see at least 1 option on Nhà cung cấp Combobox")
	public void can_see_option_on_combobox_nhaCungCap() {
		assertTrue(genObj.number_of_comboOption() > 0);
	}

	@Step("Click on combobox Kho nhận")
	public void click_combobox_khoNhan() {
		page.click_combobox_khoNhan();
	}

	@Step("Can see at least 1 option on Kho nhận Combobox")
	public void can_see_option_on_combobox_khoNhan() {
		assertTrue(genObj.number_of_comboOption() > 0);

	}

	@Step("Click on Thêm mới button")
	public void click_on_themMoi_button() {
		page.click_on_themMoi_button();
		genObj.wait_for_preloader_disappear();
	}

	@Step("Can see textbox Số Seri")
	public void on_insert_form_can_see_textBox_soSeri() {
		assertTrue(insertPage.insertForm_textBox_soSeri_isVisible());
	}

	@Step("Can see textbox Số hóa đơn")
	public void on_insert_form_can_see_textBox_soHoaDon() {
		assertTrue(insertPage.insertForm_textBox_soHoaDon_isVisible());

	}

	@Step("Can see combobox Người nhận")
	public void on_insert_form_can_see_comboBox_nguoiNhan() {
		assertTrue(insertPage.insertForm_comboBox_nguoiNhan_isVisible());

	}

	@Step("Can see combobox Kho nhận")
	public void on_insert_form_can_see_comboBox_khoNhan() {
		assertTrue(insertPage.insertForm_comboBox_khoNhan_isVisible());

	}

	@Step("Can see combobox Nhà cung cấp")
	public void on_insert_form_can_see_comboBox_nhaCungCap() {
		assertTrue(insertPage.insertForm_comboBox_nhaCungCap_isVisible());

	}

	@Step("Can see grid Nhập thuốc")
	public void on_insert_form_can_see_grid_nhapThuoc() {
		assertTrue(insertPage.insertForm_grid_nhapThuoc_isVisible());

	}

	@Step("Can see at least 1 option on Người nhận Combobox")
	public void on_insert_form_can_see_option_on_combobox_nguoiNhan() {
		insertPage.click_on_combobox_nguoiNhan();
		assertTrue(genObj.number_of_comboOption() > 0);
		insertPage.click_on_combobox_nguoiNhan();
	}

	@Step("Can see at least 1 option on Kho nhận Combobox")
	public void on_insert_form_can_see_option_on_combobox_khoNhan() {
		insertPage.click_on_combobox_khoNhan();
		assertTrue(genObj.number_of_comboOption() > 0);
		insertPage.click_on_combobox_khoNhan();
	}

	@Step("Can see at least 1 option on Nhà Cung cấp Combobox")
	public void on_insert_form_can_see_option_on_combobox_nhaCungCap() {
		insertPage.click_on_combobox_nhaCungCap();
		assertTrue(genObj.number_of_comboOption() > 0);
		insertPage.click_on_combobox_nhaCungCap();
	}

}
