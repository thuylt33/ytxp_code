package net.serenitybdd.starter.YTXP.features.NhapKhoThuoc;

import org.codehaus.groovy.transform.LazyASTTransformation;
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
import net.serenitybdd.starter.YTXP.steps.NhapKhoThuoc.PhieuNhapKho_Steps;
import net.serenitybdd.starter.YTXP.steps.NhapKhoThuoc.TimKiemPNK_Steps;
import net.serenitybdd.starter.YTXP.steps.NhapKhoThuoc.XacNhanPNK_Steps;
import net.serenitybdd.starter.util.GlobalVariable;
import net.serenitybdd.starter.util.Util;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class _03_TimKiemVaXacNhanPhieuNhapKho {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	Login acc;
	@Steps
	PhieuNhapKho_Steps user;
	@Steps
	TimKiemPNK_Steps searcher;
	@Steps
	XacNhanPNK_Steps approver;

	@Before
	public void onThePage() {
		acc.login("auto_test", "1qazXSW@");
		user.on_phieuNhapKho_page();
	}

	public String pnkFilePath(String customProperties) {
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String file = variables.getProperty(customProperties);
		return System.getProperty("user.dir") + file;
	}

	public String getTheRecentPNKAdded() {
		String pnkFile = pnkFilePath("ytxt.pnk.listSoSeri");
		return Util.getALine(pnkFile, -1);
	}

	public String getTheRecentPNKApproved() {
		String pnkFile = pnkFilePath("ytxt.pnk.listSoSeri.done");
		return Util.getALine(pnkFile, -1);
	}

	public void timeKiemPNK(String code, String fromDate, String toDate, String trangThai) {
		searcher.enter_soHoaDon(code);
		searcher.enter_date_from(fromDate);
		searcher.enter_date_to(toDate);
		searcher.enter_trangThai(trangThai);
		searcher.click_on_search_button();
	}

	@Test
	public void _01_timKiemPhieuNhapKho_chuaXacNhan() {
		// data
		String code = getTheRecentPNKAdded();
		Serenity.setSessionVariable("code").to(code);
		String lastYear = Util.getDay("year", -1, GlobalVariable.NORMAL_DATE);
		String today = Util.getDay("year", 0, GlobalVariable.NORMAL_DATE);
		// step
		timeKiemPNK(code, lastYear, today, "Chưa xác nhận");
		searcher.can_see_a_record_which_has(code, 5);
	}

	@Test
	public void _02_xemPhieuNhapKho_chuaXacNhan() {
		_01_timKiemPhieuNhapKho_chuaXacNhan();
		searcher.click_on_view_button();
		approver.can_see_button_xacNhan_enable();
		approver.can_see_button_huyXacNhan_enable();
		approver.can_see_number_of_pill_records(5);
	}

	@Test
	public void _03_xacNhanPhieuNhapKho() {
		_01_timKiemPhieuNhapKho_chuaXacNhan();
		searcher.click_on_view_button();
		approver.click_on_button_xacNhan();
		approver.can_see_message("Thao tác thành công!");
		approver.can_see_xacNhan_button_isDisabled();
		// remove code from recent Added file, add to recent approved file
		String code = Serenity.sessionVariableCalled("code").toString();
		Util.deleteALine(pnkFilePath("ytxt.pnk.listSoSeri"), code);
		Util.addMoreLine(pnkFilePath("ytxt.pnk.listSoSeri.done"), code);
	}

	@Test
	public void _04_timKiemPhieuNhapKho_daXacNhan() {
		// data
		String code = getTheRecentPNKApproved();
		String lastYear = Util.getDay("year", -1, GlobalVariable.NORMAL_DATE);
		String today = Util.getDay("year", 0, GlobalVariable.NORMAL_DATE);
		// step
		timeKiemPNK(code, lastYear, today, "Đã xác nhận");
		searcher.can_see_a_record_which_has(code, 5);
	}

	@After
	public void logout() {
		acc.logOut();
	}
}
