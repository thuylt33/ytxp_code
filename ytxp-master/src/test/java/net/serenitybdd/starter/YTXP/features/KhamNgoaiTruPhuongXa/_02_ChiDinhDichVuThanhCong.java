package net.serenitybdd.starter.YTXP.features.KhamNgoaiTruPhuongXa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.YTXP.features.Login;
import net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa.ChiDinhDichVu_Steps;
import net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa.KhamNgoaiTruPhuongXa_Steps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTagValuesOf;

@RunWith(SerenityRunner.class)
@WithTagValuesOf({ "feature:KhamNgoaiTruPhuongXa", "function:chiDinhDichVu" })
public class _02_ChiDinhDichVuThanhCong {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	Login acc;
	@Steps
	KhamNgoaiTruPhuongXa_Steps user;

	@Steps
	ChiDinhDichVu_Steps chiDinh;

	@Before
	public void on_the_khamNgoaiTruPhuongXa_page() {
		acc.login("auto_test", "1qazXSW@");
		user.on_khamBenhXaPhuong_page();
	}


	public void chiDinhDichVu(ChiDinhDichVu_Steps chiDinh, String dichVu) {
		chiDinh.click_on_chiDinhDichVu_link();
		chiDinh.click_group_dichVu(dichVu);
		chiDinh.choose_dichVu();
		chiDinh.click_on_LuuLai_button();
		chiDinh.can_see_message("Cập nhật dữ liệu thành công");
	}

	@Test
	public void themMoiBenhNhaVahiDinhDichVu() {
		_01_ThemBenhNhanMoi createNew = new _01_ThemBenhNhanMoi();
		createNew.themBenhNhanMoi(user);
		chiDinhDichVu(chiDinh, "Xét nghiệm");
	}

	@After
	public void logout() {
		acc.logOut();
	}
}
