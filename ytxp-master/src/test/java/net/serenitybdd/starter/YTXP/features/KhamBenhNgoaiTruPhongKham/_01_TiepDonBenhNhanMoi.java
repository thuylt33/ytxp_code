package net.serenitybdd.starter.YTXP.features.KhamBenhNgoaiTruPhongKham;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.YTXP.features.Login;
import net.serenitybdd.starter.YTXP.steps.KhamBenhNgoaiTruPhongKham.TiepDonBenhNhanMoi_Steps;
import net.serenitybdd.starter.util.GlobalVariable;
import net.serenitybdd.starter.util.Util;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTagValuesOf;

@RunWith(SerenityRunner.class)
@WithTagValuesOf({ "feature:KhamNgoaiTruPhongKham", "function:tiepDonBenhNhanMoi" })

public class _01_TiepDonBenhNhanMoi {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	Login acc;

	@Steps
	TiepDonBenhNhanMoi_Steps user;

	@Before
	public void on_TiepDonBenhNhap_page() {
		acc.login("kiemthu_tudong", "1qazXSW@");
		user.on_tiepDonBenhNhanMoi_page();
	}

	public void tiepDonBenhNhanMoi_Steps(TiepDonBenhNhanMoi_Steps user) {
		// data
		String code = Util.getDay("day", 0, "yyMMddhhmm");
		String soBHYT = "HT201" + code;
		String fromDate = Util.getDay("month", -6, GlobalVariable.NORMAL_DATE);
		String toDate = Util.getDay("month", 6, GlobalVariable.NORMAL_DATE);
		String hoVaTen = "Kiểm thử tự động_" + code;
		Serenity.setSessionVariable("patientName").to(hoVaTen);
		String diaChi = "hanoi";
		// steps
		user.enter_hoVaTen(hoVaTen);
		user.enter_namSinh(1989);
		user.enter_diaChi(diaChi);
		user.enter_soBHYT(soBHYT);
		user.enter_date_from(fromDate);
		user.enter_date_to(toDate);
		user.choose_dichVu();
		user.choose_phongKham();
		user.click_on_Luu_button();
		user.can_see_message("Tiếp nhận thành công");
	}

	@Test
	public void tiepDonBenhNhanMoi() {
		tiepDonBenhNhanMoi_Steps(user);

	}

}
