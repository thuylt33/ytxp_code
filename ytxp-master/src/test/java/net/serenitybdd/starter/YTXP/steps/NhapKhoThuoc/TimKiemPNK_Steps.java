package net.serenitybdd.starter.YTXP.steps.NhapKhoThuoc;

import static org.junit.Assert.assertTrue;

import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.YTXP.pages.PhieuNhapKho.PhieuNhapKho_Page;
import net.thucydides.core.annotations.Step;

public class TimKiemPNK_Steps {

	PhieuNhapKho_Page page;
	GenaralObject genObj;

	@Step
	public void enter_soHoaDon(String code) {
		page.enter_soHoaDon(code);
	}

	@Step
	public void enter_date_from(String lastYear) {
		page.enter_date_from(lastYear);
	}

	@Step
	public void enter_date_to(String today) {
		page.enter_date_to(today);
	}

	@Step
	public void click_on_search_button() {
		page.click_on_search_button();
		genObj.wait_for_grid_loading_disappear();
	}

	@Step("Can see a record with Số hóa đơn: {0} and has Tổng số khoản: {1}")
	public void can_see_a_record_which_has(String code, int tongSoKhoan) {
		assertTrue(page.get_total_result_on_grid() == 1);
		assertTrue(tongSoKhoan == page.get_tongSoKhoan_onGrid(code));

	}

	@Step
	public void enter_trangThai(String trangThai) {
		page.choose_trangThai(trangThai);
	}

	@Step
	public void click_on_view_button() {
		page.click_on_view_button();
		genObj.wait_for_preloader_disappear();
		genObj.wait_for_grid_loading_disappear();
	}

	

}
