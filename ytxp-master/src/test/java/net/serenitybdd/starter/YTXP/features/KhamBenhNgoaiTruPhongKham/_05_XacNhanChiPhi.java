package net.serenitybdd.starter.YTXP.features.KhamBenhNgoaiTruPhongKham;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.YTXP.features.Login;
import net.serenitybdd.starter.YTXP.features.KhamNgoaiTruPhuongXa._02_ChiDinhDichVuThanhCong;
import net.serenitybdd.starter.YTXP.features.KhamNgoaiTruPhuongXa._04_XacNhanChiPhi;
import net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa.ChiDinhDichVu_Steps;
import net.serenitybdd.starter.YTXP.steps.KhamBenhNgoaiTruPhongKham.KeDonThuoc_Steps;
import net.serenitybdd.starter.YTXP.steps.KhamBenhNgoaiTruPhongKham.KhamBenhNgoaiTru_Steps;
import net.serenitybdd.starter.YTXP.steps.KhamBenhNgoaiTruPhongKham.TiepDonBenhNhanMoi_Steps;
import net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa.XacNhanChiPhi_Steps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTagValuesOf;

@RunWith(SerenityRunner.class)
@WithTagValuesOf({ "feature:KhamNgoaiTruPhongKham", "function:xacNhanChiPhi" })
public class _05_XacNhanChiPhi {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	Login acc;

	@Steps
	TiepDonBenhNhanMoi_Steps tiepDonUser;

	@Steps
	ChiDinhDichVu_Steps chiDinhUser;

	@Steps
	KhamBenhNgoaiTru_Steps khamBenhUser;

	@Steps
	KeDonThuoc_Steps keDonUser;

	@Steps
	XacNhanChiPhi_Steps user;

	@Before
	public void on_TiepDonBenhNhap_page() {
		acc.login("kiemthu_tudong", "1qazXSW@");
		tiepDonUser.on_tiepDonBenhNhanMoi_page();
	}

	@Test
	public void xacNhanChiPhi() {
		_01_TiepDonBenhNhanMoi tiepDon = new _01_TiepDonBenhNhanMoi();
		tiepDon.tiepDonBenhNhanMoi_Steps(tiepDonUser);

		_02_KhamBenhNgoaiTru khamBenh = new _02_KhamBenhNgoaiTru();
		khamBenh.chuyenKhamBenh_Steps(khamBenhUser);

		_02_ChiDinhDichVuThanhCong chiDinh = new _02_ChiDinhDichVuThanhCong();
		chiDinh.chiDinhDichVu(chiDinhUser, "Chẩn đoán hình ảnh");
		chiDinhUser.closeDialog();

		_04_KeDonThuoc keDon = new _04_KeDonThuoc();
		keDon.keDonThuoc_Steps(keDonUser);
		keDonUser.close_dialog();

		_04_XacNhanChiPhi xacNhanCP = new _04_XacNhanChiPhi();
		String[] indexList = { "1. Khám bệnh", "4. Chẩn đoán hình ảnh", "8. Thuốc, dịch truyền" };
		xacNhanCP.xacNhanChiPhiSteps(user, indexList);
	}
}
