package net.serenitybdd.starter.YTXP.features.NhapKhoThuoc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.YTXP.features.Login;
import net.serenitybdd.starter.YTXP.steps.NhapKhoThuoc.PhieuNhapKho_Steps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTagValuesOf;

@RunWith(SerenityRunner.class)
@WithTagValuesOf({ "feature:NhapKhoThuoc", "function:kiemTraManHinhPNK" })

public class _01_KiemTraManHinhPhieuNhapKho {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	Login acc;
	@Steps
	PhieuNhapKho_Steps user;

	@Before
	public void onThePage() {
		acc.login("auto_test", "1qazXSW@");
		user.on_phieuNhapKho_page();
	}

	@Test
	public void Kiem_tra_man_hinh_phieu_nhap_kho() {
		user.can_see_button_themMoi();
		user.can_see_textBox_soPhieu();
		user.can_see_textBox_soHoaDon();
		user.click_combobox_nhaCungCap();
		user.can_see_option_on_combobox_nhaCungCap();
		user.click_combobox_khoNhan();
		user.can_see_option_on_combobox_khoNhan();
	}

	@Test
	public void Kiem_tra_man_hinh_them_moi_phieu_nhap_kho() {
		user.click_on_themMoi_button();
		user.on_insert_form_can_see_textBox_soSeri();
		user.on_insert_form_can_see_textBox_soHoaDon();
		user.on_insert_form_can_see_comboBox_nguoiNhan();
		user.on_insert_form_can_see_comboBox_khoNhan();
		user.on_insert_form_can_see_comboBox_nhaCungCap();
		user.on_insert_form_can_see_grid_nhapThuoc();
		user.on_insert_form_can_see_option_on_combobox_nguoiNhan();
		user.on_insert_form_can_see_option_on_combobox_khoNhan();
		user.on_insert_form_can_see_option_on_combobox_nhaCungCap();
	}

	@After
	public void logout() {
		acc.logOut();
	}
}
