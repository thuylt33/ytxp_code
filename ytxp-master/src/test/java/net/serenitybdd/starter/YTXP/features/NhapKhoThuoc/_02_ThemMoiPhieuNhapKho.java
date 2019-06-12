package net.serenitybdd.starter.YTXP.features.NhapKhoThuoc;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.starter.YTXP.features.Login;
import net.serenitybdd.starter.YTXP.steps.NhapKhoThuoc.PhieuNhapKho_Steps;
import net.serenitybdd.starter.YTXP.steps.NhapKhoThuoc.ThemMoiPhieuNhapKho_Step;
import net.serenitybdd.starter.util.GlobalVariable;
import net.serenitybdd.starter.util.Util;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTagValuesOf;

@RunWith(SerenityRunner.class)
@WithTagValuesOf({ "feature:NhapKhoThuoc", "function:themMoiPNK" })

public class _02_ThemMoiPhieuNhapKho {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	Login acc;
	@Steps
	PhieuNhapKho_Steps user;
	@Steps
	ThemMoiPhieuNhapKho_Step addingUser;

	@Before
	public void onThePage() {
		acc.login("auto_test", "1qazXSW@");
		user.on_phieuNhapKho_page();
	}

	@Test
	public void themMoiPhieuNhapKho() {
		// data
		String code = Util.getUniqueCode();
		String today = Util.getDay("day", 0, GlobalVariable.NORMAL_DATE);
		Serenity.setSessionVariable("soSeri").to(code);
		// step
		user.click_on_themMoi_button();
		addingUser.enter_soSeri(code);
		addingUser.enter_soHoaDon(code);
		addingUser.enter_ngayHoaDon(today);
		addingUser.choose_nguonNhapHang();
		addingUser.enter_ngayNhapHang(today);
		addingUser.choose_nguoiNhan();
		addingUser.choose_khoNhan();
		addingUser.choose_nhaCungCap();
		add_some_medical();
		addingUser.click_on_add_button();
		addingUser.can_see_message("Thao tác thành công!");

	}

	private void add_some_medical() {
		Random r = new Random();
		int rand1, rand2;
		for (int i = 0; i < 5; i++) {
			rand1 = r.nextInt(98) + 1;
			rand2 = r.nextInt(8) + 1;
			addingUser.add_thuoc(i, rand1 * 100, rand2, rand1 * rand1, rand2,
					Util.getDay("month", rand2, GlobalVariable.NORMAL_DATE), i + 1);
			addingUser.add_more_row();
		}
	}

	@After
	public void logout() {
		acc.logOut();
	}
}
