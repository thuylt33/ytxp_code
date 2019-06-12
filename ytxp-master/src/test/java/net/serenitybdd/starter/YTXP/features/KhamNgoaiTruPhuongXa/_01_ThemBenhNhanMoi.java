package net.serenitybdd.starter.YTXP.features.KhamNgoaiTruPhuongXa;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.YTXP.features.Login;
import net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa.KhamNgoaiTruPhuongXa_Steps;
import net.serenitybdd.starter.util.GlobalVariable;
import net.serenitybdd.starter.util.Util;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTagValuesOf;

@RunWith(SerenityRunner.class)
@WithTagValuesOf({ "feature:KhamNgoaiTruPhuongXa", "function:themBenhNhanMoi" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class _01_ThemBenhNhanMoi {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	@Steps
	Login acc;
	@Steps
	KhamNgoaiTruPhuongXa_Steps user;

	@Before
	public void on_the_khamNgoaiTruPhuongXa_page() {
		acc.login("auto_test", "1qazXSW@");
		user.on_khamBenhXaPhuong_page();
	}

	public void themBenhNhanMoi(KhamNgoaiTruPhuongXa_Steps user) {
		// data
		String code = Util.getDay("day", 0, "yyMMddhhmm");
		String soBHYT = "HT201" + code;
		String fromDate = Util.getDay("month", -6, GlobalVariable.NORMAL_DATE);
		String toDate = Util.getDay("month", 6, GlobalVariable.NORMAL_DATE);
		String hoVaTen = "Kiểm thử tự động_" + code;
		Serenity.setSessionVariable("patientName").to(hoVaTen);
		String diaChi = "hanoi";
		// step
		user.enter_soBHYT(soBHYT);
		user.enter_date_from(fromDate);
		user.enter_date_to(toDate);
		user.enter_hoVaTen(hoVaTen);
		user.enter_namSinh("2000");
		user.enter_diaChi(diaChi);
		user.enter_trieuChung("Đau đầu");
		user.enter_benhChinh("D53.0");
		user.choose_bsKham();
		user.choose_ketQuaKham();
		user.choose_dichVu();
		user.choose_phongKham();
		user.click_on_Luu_button();
		user.can_see_message("Đã lưu thông tin khám bệnh");
	}

	@Test
	public void themBenhNhanMoi() {
		themBenhNhanMoi(user);
	}

	@After
	public void logOut() {
		acc.logOut();
	}

}
