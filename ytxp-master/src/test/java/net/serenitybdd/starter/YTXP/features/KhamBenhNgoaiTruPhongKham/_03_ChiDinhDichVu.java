package net.serenitybdd.starter.YTXP.features.KhamBenhNgoaiTruPhongKham;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.YTXP.features.Login;
import net.serenitybdd.starter.YTXP.features.KhamNgoaiTruPhuongXa._02_ChiDinhDichVuThanhCong;
import net.serenitybdd.starter.YTXP.steps.KhamBenhNgoaiTruPhongKham.KhamBenhNgoaiTru_Steps;
import net.serenitybdd.starter.YTXP.steps.KhamBenhNgoaiTruPhongKham.TiepDonBenhNhanMoi_Steps;
import net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa.ChiDinhDichVu_Steps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTagValuesOf;

@RunWith(SerenityRunner.class)
@WithTagValuesOf({ "feature:KhamNgoaiTruPhongKham", "function:chiDinhDichVu" })

public class _03_ChiDinhDichVu {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	Login acc;

	@Steps
	TiepDonBenhNhanMoi_Steps tiepDonUser;

	@Steps
	KhamBenhNgoaiTru_Steps khamBenhUser;

	@Steps
	ChiDinhDichVu_Steps user;

	@Before
	public void on_TiepDonBenhNhap_page() {
		acc.login("kiemthu_tudong", "1qazXSW@");
		tiepDonUser.on_tiepDonBenhNhanMoi_page();
	}

	@Test
	public void chiDinhDichVu() {
		_01_TiepDonBenhNhanMoi tiepDon = new _01_TiepDonBenhNhanMoi();
		tiepDon.tiepDonBenhNhanMoi_Steps(tiepDonUser);

		_02_KhamBenhNgoaiTru khamBenh = new _02_KhamBenhNgoaiTru();
		khamBenh.chuyenKhamBenh_Steps(khamBenhUser);

		_02_ChiDinhDichVuThanhCong chiDinh = new _02_ChiDinhDichVuThanhCong();
		chiDinh.chiDinhDichVu(user, "Chẩn đoán hình ảnh");
	}

	/*public void chiDinhDichVu_Steps(ChiDinhDichVu_Steps user) {
		user.click_on_chiDinhDichVu_link();
		user.choose_dichVu_group("Chẩn đoán hình ảnh");
		user.choose_a_service();
		user.click_on_Luu_button();
		user.can_see_message("Cập nhật dữ liệu thành công");

	}*/
}
