package net.serenitybdd.starter.YTXP.features.KhamBenhNoiTru;

import static org.junit.Assert.assertTrue;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.YTXP.pages.KhamBenhNoiTru.DangKyNhapVien_Dialog;
import net.serenitybdd.starter.YTXP.pages.KhamBenhNoiTru.DanhSachNhapVien_Page;
import net.serenitybdd.starter.YTXP.pages.KhamBenhNoiTru.HoSoKhamBenh_Page;
import net.serenitybdd.starter.YTXP.pages.KhamBenhNoiTru.NhapVienChiDinhTuNgoaiTru_Page;
import net.thucydides.core.annotations.Step;

public class NhapVienChiDinhTuNgoaiTru_Steps {
	NhapVienChiDinhTuNgoaiTru_Page page;
	DangKyNhapVien_Dialog nhapVienPage;
	DanhSachNhapVien_Page dsNhapVienPage;
	HoSoKhamBenh_Page hoSoKhamPage;
	GenaralObject gen;

	@Step
	public void go_to_KhamBenhNgoaiTru_page() {
		page.go_to_KhamBenhNgoaiTru_page();
		gen.wait_for_grid_loading_disappear();
		gen.wait_for_preloader_disappear();

	}

	@Step
	public void filter_by_status(String status) {
		page.click_on_arrow_combo_status(status);
		gen.choose_combo_option(status);
		gen.wait_for_grid_loading_disappear();
		gen.wait_for_preloader_disappear();

	}

	@Step
	public void filter_by_fromDate(String fromDate) {
		page.enter_fromDate(fromDate);
		gen.wait_for_preloader_disappear();

	}

	@Step
	public void click_on_timKiem_button() {
		page.click_on_timKiem_button();
		gen.wait_for_grid_loading_disappear();
		gen.wait_for_preloader_disappear();
	}

	@Step
	public void choose_the_first_record() {
		page.doubleClick_onThe_first_record();
		gen.wait_for_preloader_disappear();
		get_patientName();

	}

	private void get_patientName() {
		String patientName = hoSoKhamPage.get_patientName();
		Serenity.setSessionVariable("patientName").to(patientName);
	}

	@Step
	public void click_on_dangKyNhapVien_link() {
		hoSoKhamPage.click_on_dangKyNhapVien_link();
		gen.wait_for_preloader_disappear();
	}

	@Step
	public void choose_loaiBenhAn() {
		nhapVienPage.click_arrCb_loaiBenhAn();
		gen.wait_for_grid_loading_disappear();
		gen.choose_combo_option(0);
	}

	@Step
	public void choose_khoaNoiTru() {
		nhapVienPage.click_arrCB_khoaNoiTru();
		gen.wait_for_grid_loading_disappear();
		gen.choose_combo_option(0);

	}

	@Step
	public void choose_lyDoNhapVien() {
		nhapVienPage.click_arrCb_lyDoNhapVien();
		gen.wait_for_grid_loading_disappear();
		gen.choose_combo_option(0);

	}

	@Step
	public void choose_phongBenh() {
		nhapVienPage.click_arrCb_phongBenh();
		gen.wait_for_grid_loading_disappear();
		gen.choose_combo_option(0);
	}

	@Step
	public void choose_giuongBenh() {
		nhapVienPage.click_arrCb_giuongBenh();
		gen.wait_for_grid_loading_disappear();
		gen.choose_combo_option(0);
	}

	@Step
	public void choose_bacSiDieuTri() {
		nhapVienPage.click_arrCb_bsDieuTri();
		gen.wait_for_grid_loading_disappear();
		gen.choose_combo_option(0);
	}

	@Step
	public void clickOn_Luu_button() {
		nhapVienPage.clickOn_Luu_button();
	}

	@Step
	public void can_see_message(String expectedMessage) {
		assertTrue(gen.get_toast_message_content().contains(expectedMessage));
	}

	@Step
	public void goTo_danhSachNhapVien() {
		page.goTo_danhSachNhapVien();
	}

	@Step
	public void dsNhapVien_filter_by_fromDate(String fromDate) {
		dsNhapVienPage.enter_fromDate(fromDate);
		gen.wait_for_preloader_disappear();

	}

	@Step
	public void dsNhapVien_filter_by_toDate(String today) {
		dsNhapVienPage.enter_toDate(today);
		gen.wait_for_preloader_disappear();

	}

	@Step
	public void dsNhapVien_click_on_timKiem_button() {
		dsNhapVienPage.click_timKiem_button();
		gen.wait_for_grid_loading_disappear();
		gen.wait_for_preloader_disappear();

	}

	@Step
	public void dsNhapVien_filter_by_patientName(String patientName) {
		dsNhapVienPage.enter_patientName(patientName);
	}

	public void can_see_patient_on_the_grid(String patientName) {
		// TODO Auto-generated method stub
		assertTrue(patientName.equalsIgnoreCase(dsNhapVienPage.get_patient_name_on_grid()));
		
	}

}
