package net.serenitybdd.starter.YTXP.features.KhamBenhNoiTru;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.YTXP.features.Login;
import net.serenitybdd.starter.util.GlobalVariable;
import net.serenitybdd.starter.util.Util;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTagValuesOf;

@RunWith(SerenityRunner.class)
@WithTagValuesOf({ "feature:KhamBenhNoiTru", "function:nhapVienChiDinhTuNgoaiTru" })

public class _01_NhapVienChiDinhTuNgoaiTru {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	Login acc;

	@Steps
	NhapVienChiDinhTuNgoaiTru_Steps user;

	@Before
	public void on_TiepDonBenhNhap_page() {
		acc.login("kiemthu_tudong", "1qazXSW@");
	}

	@Test
	public void nhapVienChiDinhTuNgoaiTru() {
		user.go_to_KhamBenhNgoaiTru_page();
		String fromDate = Util.getDay("month", -12, GlobalVariable.NORMAL_DATE);
		on_khamBenhNgoaiTru_search_for("BHYT-Chưa xác nhân CP", fromDate);
		user.choose_the_first_record();
		user.click_on_dangKyNhapVien_link();
		enter_thongTinNhapVien();
		user.goTo_danhSachNhapVien();

		String today = Util.getDay("month", 0, GlobalVariable.NORMAL_DATE);
		String patientName = Serenity.sessionVariableCalled("patientName").toString();
		on_dsNhapVien_search_for(fromDate, today, patientName);
		user.can_see_patient_on_the_grid(patientName);

	}

	public void on_dsNhapVien_search_for(String fromDate, String today, String patientName) {
		user.dsNhapVien_filter_by_fromDate(fromDate);
		user.dsNhapVien_filter_by_toDate(today);
		user.dsNhapVien_filter_by_patientName(patientName);
		user.dsNhapVien_click_on_timKiem_button();

	}

	public void enter_thongTinNhapVien() {
		user.choose_loaiBenhAn();
		user.choose_khoaNoiTru();
		user.choose_lyDoNhapVien();
		user.choose_phongBenh();
		user.choose_giuongBenh();
		user.choose_bacSiDieuTri();
		user.clickOn_Luu_button();
		user.can_see_message("Lưu thành công");

	}

	public void on_khamBenhNgoaiTru_search_for(String status, String fromDate) {
		user.filter_by_status(status);
		user.filter_by_fromDate(fromDate);
		user.click_on_timKiem_button();

	}

}
