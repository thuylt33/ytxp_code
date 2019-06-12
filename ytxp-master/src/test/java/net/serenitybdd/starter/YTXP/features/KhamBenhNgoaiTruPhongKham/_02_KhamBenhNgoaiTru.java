package net.serenitybdd.starter.YTXP.features.KhamBenhNgoaiTruPhongKham;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.YTXP.features.Login;
import net.serenitybdd.starter.YTXP.steps.KhamBenhNgoaiTruPhongKham.KhamBenhNgoaiTru_Steps;
import net.serenitybdd.starter.YTXP.steps.KhamBenhNgoaiTruPhongKham.TiepDonBenhNhanMoi_Steps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTagValuesOf;

@RunWith(SerenityRunner.class)
@WithTagValuesOf({ "feature:KhamNgoaiTruPhongKham", "function:khamBenhNgoaiTru" })

public class _02_KhamBenhNgoaiTru {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	Login acc;

	@Steps
	TiepDonBenhNhanMoi_Steps tiepDonUser;

	@Steps
	KhamBenhNgoaiTru_Steps user;

	@Before
	public void on_TiepDonBenhNhap_page() {
		acc.login("kiemthu_tudong", "1qazXSW@");
		tiepDonUser.on_tiepDonBenhNhanMoi_page();
	}

	public void chuyenKhamBenh_Steps(KhamBenhNgoaiTru_Steps user) {
		user.go_to_KhamBenhNgoaiTru_page();
		user.choose_the_firsh_record();
		user.enter_trieuChung("Đau đầu");
		user.enter_benhChinh("A92");
		user.choose_bacSiKham();
		user.click_on_Luu_button();
		user.can_see_message("Đã lưu thông tin khám bệnh");
	}

	@Test
	public void tiepDon_va_chuyen_KhamBenhNgoaiTru() {
		_01_TiepDonBenhNhanMoi tiepDon = new _01_TiepDonBenhNhanMoi();
		tiepDon.tiepDonBenhNhanMoi_Steps(tiepDonUser);
		
		chuyenKhamBenh_Steps(user);
	}
}
