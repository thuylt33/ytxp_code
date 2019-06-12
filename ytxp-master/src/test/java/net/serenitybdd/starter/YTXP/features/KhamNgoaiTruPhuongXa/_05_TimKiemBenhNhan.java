package net.serenitybdd.starter.YTXP.features.KhamNgoaiTruPhuongXa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.YTXP.features.Login;
import net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa.DanhSachKhamBenh_Steps;
import net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa.KhamNgoaiTruPhuongXa_Steps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTagValuesOf;

@RunWith(SerenityRunner.class)
@WithTagValuesOf({ "feature:KhamNgoaiTruPhuongXa", "function:timKiemBenhNhan" })
public class _05_TimKiemBenhNhan {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	Login acc;
	@Steps
	KhamNgoaiTruPhuongXa_Steps user;
	@Steps
	DanhSachKhamBenh_Steps dskham;
	

	@Before
	public void on_the_khamNgoaiTruPhuongXa_page() {
		acc.login("auto_test", "1qazXSW@");
		user.on_khamBenhXaPhuong_page();
	}
	@Test
	public void timKiemBenhNhan() {
		_01_ThemBenhNhanMoi createNew = new _01_ThemBenhNhanMoi();
		createNew.themBenhNhanMoi(user);
		
		String hoVaTen = Serenity.sessionVariableCalled("patientName").toString();
		dskham.open_DanhSachKhamBenh_tab();
		dskham.enter_hoVaTen(hoVaTen);
		dskham.click_on_timKiem_button();
		dskham.can_see_patient_on_the_grid(hoVaTen);
	}
}
