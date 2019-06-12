package net.serenitybdd.starter.YTXP.features.KhamNgoaiTruPhuongXa;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.YTXP.features.Login;
import net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa.ChiDinhDichVu_Steps;
import net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa.KeDonThuoc_Steps;
import net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa.KhamNgoaiTruPhuongXa_Steps;
import net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa.XacNhanChiPhi_Steps;
import net.serenitybdd.starter.util.Util;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTagValuesOf;

@RunWith(SerenityRunner.class)
@WithTagValuesOf({ "feature:KhamNgoaiTruPhuongXa", "function:xacNhanChiPhi" })
public class _04_XacNhanChiPhi {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	Login acc;
	@Steps
	KhamNgoaiTruPhuongXa_Steps user;
	@Steps
	ChiDinhDichVu_Steps chiDinhUser;
	@Steps
	KeDonThuoc_Steps keDonUser;

	@Steps
	XacNhanChiPhi_Steps xacNhanUser;

	@Before
	public void on_the_khamNgoaiTruPhuongXa_page() {
		acc.login("auto_test", "1qazXSW@");
		user.on_khamBenhXaPhuong_page();
	}

	@Test
	public void xacNhanChiPhi() {
		_01_ThemBenhNhanMoi createNew = new _01_ThemBenhNhanMoi();
		createNew.themBenhNhanMoi(user);

		_02_ChiDinhDichVuThanhCong chiDinh = new _02_ChiDinhDichVuThanhCong();
		chiDinh.chiDinhDichVu(chiDinhUser, "Xét nghiệm");
		chiDinhUser.closeDialog();

		_03_KeDonThuoc keDon = new _03_KeDonThuoc();
		keDon.keDonThuoc(keDonUser);
		keDonUser.closeDialog();

		String[] indexList = { "1. Khám bệnh", "3. Xét nghiệm", "8. Thuốc, dịch truyền" };
		xacNhanChiPhiSteps(xacNhanUser,indexList);

	}

	public void xacNhanChiPhiSteps(XacNhanChiPhi_Steps xacNhanUser, String[] indexList) {
		xacNhanUser.click_on_In_button();
		xacNhanUser.choose_inBangKeBHYT();
		xacNhanUser.open_bangKe();
		xacNhanUser.save_bangKe();

		xacNhanUser.can_see_section(indexList);
	}

}
