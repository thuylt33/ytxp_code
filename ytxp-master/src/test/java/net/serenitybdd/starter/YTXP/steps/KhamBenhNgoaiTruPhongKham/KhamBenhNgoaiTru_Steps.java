package net.serenitybdd.starter.YTXP.steps.KhamBenhNgoaiTruPhongKham;

import static org.junit.Assert.assertTrue;

import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.YTXP.pages.KhamBenhNgoaiTruPhongKham.KhamBenhNgoaiTru_Page;
import net.thucydides.core.annotations.Step;

public class KhamBenhNgoaiTru_Steps {
	KhamBenhNgoaiTru_Page page;
	GenaralObject gen;

	@Step
	public void go_to_KhamBenhNgoaiTru_page() {
		page.go_to_KhamBenhNgoaiTru_page();
		gen.wait_for_grid_loading_disappear();
		gen.wait_for_preloader_disappear();

	}
	

	@Step
	public void choose_the_firsh_record() {
		page.doubleClick_on_row(0);
		gen.wait_for_preloader_disappear();

	}

	@Step
	public void enter_trieuChung(String trieuChung) {
		page.enter_trieuChung(trieuChung);
	}

	@Step
	public void enter_benhChinh(String benhChinh) {
		page.enter_benhChinh(benhChinh);
	}

	@Step
	public void choose_bacSiKham() {
		page.click_arrCombo_bacSiKham();
		gen.choose_combo_option(0);

	}

	@Step
	public void click_on_Luu_button() {
		page.click_on_Luu_button();
	}

	@Step
	public void can_see_message(String expectedMessage) {
		assertTrue(gen.get_toast_message_content().contains(expectedMessage));

	}

}
