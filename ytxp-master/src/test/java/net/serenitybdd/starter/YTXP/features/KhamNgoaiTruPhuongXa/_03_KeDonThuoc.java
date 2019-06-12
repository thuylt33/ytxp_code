package net.serenitybdd.starter.YTXP.features.KhamNgoaiTruPhuongXa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.YTXP.features.Login;
import net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa.KeDonThuoc_Steps;
import net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa.KhamNgoaiTruPhuongXa_Steps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTagValuesOf;

@RunWith(SerenityRunner.class)
@WithTagValuesOf({ "feature:KhamNgoaiTruPhuongXa", "function:keDonThuoc" })

public class _03_KeDonThuoc {
	

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	Login acc;
	@Steps
	KhamNgoaiTruPhuongXa_Steps user;
	@Steps
	KeDonThuoc_Steps keDon;

	@Before
	public void on_the_khamNgoaiTruPhuongXa_page() {
		acc.login("auto_test", "1qazXSW@");
		user.on_khamBenhXaPhuong_page();
	}

	public void keDonThuoc(KeDonThuoc_Steps keDon) {
		keDon.click_on_keDonThuoc();
		keDon.choose_maThuoc();
		keDon.enter_soNgay(1);
		keDon.enter_soLuong(1);
		keDon.click_luu_button();
		keDon.can_see_message("Cập nhật dữ liệu thành công");
	}

	@Test
	public void themMoiBenhNhaVaKeDonThuoc() {
		_01_ThemBenhNhanMoi createNew = new _01_ThemBenhNhanMoi();
		createNew.themBenhNhanMoi(user);
		keDonThuoc(keDon);
	}

	@After
	public void logout() {
		acc.logOut();
	}
}
