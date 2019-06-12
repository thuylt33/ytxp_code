package net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa;

import static org.junit.Assert.assertTrue;

import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.YTXP.pages.HomePage;
import net.serenitybdd.starter.YTXP.pages.KhamNgoaiTruPhuongXa.DanhSachKhamBenh_Page;
import net.thucydides.core.annotations.Step;

public class DanhSachKhamBenh_Steps {

	DanhSachKhamBenh_Page page;
	HomePage home;
	GenaralObject gen;

	@Step
	public void open_DanhSachKhamBenh_tab() {
		home.open_DanhSachKhamBenh_tab();
		gen.wait_for_preloader_disappear();
	}

	@Step
	public void enter_hoVaTen(String hoVaTen) {
		page.enter_hoVaTen(hoVaTen);
	}

	@Step
	public void click_on_timKiem_button() {
		page.click_on_timKiem_button();
	}
	@Step
	public void can_see_patient_on_the_grid(String hoVaTen) {
		assertTrue(page.grid_has_the_patient(hoVaTen));
	}

}
