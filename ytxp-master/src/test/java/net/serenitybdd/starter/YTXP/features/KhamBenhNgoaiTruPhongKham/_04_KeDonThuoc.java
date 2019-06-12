package net.serenitybdd.starter.YTXP.features.KhamBenhNgoaiTruPhongKham;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.YTXP.features.Login;
import net.serenitybdd.starter.YTXP.steps.KhamBenhNgoaiTruPhongKham.KeDonThuoc_Steps;
import net.serenitybdd.starter.YTXP.steps.KhamBenhNgoaiTruPhongKham.KhamBenhNgoaiTru_Steps;
import net.serenitybdd.starter.YTXP.steps.KhamBenhNgoaiTruPhongKham.TiepDonBenhNhanMoi_Steps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTagValuesOf;

@RunWith(SerenityRunner.class)
@WithTagValuesOf({ "feature:KhamNgoaiTruPhongKham", "function:keDonThuoc" })
public class _04_KeDonThuoc {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	Login acc;

	@Steps
	TiepDonBenhNhanMoi_Steps tiepDonUser;

	@Steps
	KhamBenhNgoaiTru_Steps khamBenhUser;

	@Steps
	KeDonThuoc_Steps user;

	@Before
	public void on_TiepDonBenhNhap_page() {
		acc.login("kiemthu_tudong", "1qazXSW@");
		tiepDonUser.on_tiepDonBenhNhanMoi_page();
	}

	@Test
	public void keDonThuoc() {
		_01_TiepDonBenhNhanMoi tiepDon = new _01_TiepDonBenhNhanMoi();
		tiepDon.tiepDonBenhNhanMoi_Steps(tiepDonUser);

		_02_KhamBenhNgoaiTru khamBenh = new _02_KhamBenhNgoaiTru();
		khamBenh.chuyenKhamBenh_Steps(khamBenhUser);

		keDonThuoc_Steps(user);
	}

	public void keDonThuoc_Steps(KeDonThuoc_Steps user) {
		user.click_on_keDonThuoc_link();
		user.add_some_thuoc();
		user.click_on_Luu_button();
		user.can_see_message("Cập nhật dữ liệu thành công");
		
	}
	
}
