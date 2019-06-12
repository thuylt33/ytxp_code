package net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa;

import static org.junit.Assert.assertTrue;

import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.YTXP.pages.KhamNgoaiTruPhuongXa.KeDonThuoc_Page;
import net.serenitybdd.starter.YTXP.pages.KhamNgoaiTruPhuongXa.KhamNgoaiTruPhuongXa_Page;
import net.thucydides.core.annotations.Step;

public class KeDonThuoc_Steps {
	KhamNgoaiTruPhuongXa_Page khamPage;
	KeDonThuoc_Page page;
	GenaralObject genObj;

	@Step
	public void choose_maThuoc() {
		page.click_on_arrCombo_maThuoc();
		genObj.choose_table_option(0);
	}

	@Step
	public void enter_soNgay(int i) {
		page.enter_soNgay(i);
	}

	@Step
	public void enter_soLuong(int i) {
		page.click_on_soLuong_field();
		page.enter_soLuong(i);
	}

	@Step
	public void click_luu_button() {
		page.click_luu_button();
	}

	@Step
	public void can_see_message(String expectedMessage) {
		assertTrue(genObj.get_toast_message_content().contains(expectedMessage));
	}

	@Step
	public void click_on_keDonThuoc() {
		khamPage.click_on_keDonThuoc();
		genObj.wait_for_preloader_disappear();
		genObj.wait_for_preloader_disappear();

	}

	@Step
	public void closeDialog() {
		genObj.close_dialog();
	}

}
