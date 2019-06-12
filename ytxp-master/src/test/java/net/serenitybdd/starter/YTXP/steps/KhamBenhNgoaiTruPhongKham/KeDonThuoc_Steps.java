package net.serenitybdd.starter.YTXP.steps.KhamBenhNgoaiTruPhongKham;

import static org.junit.Assert.assertTrue;

import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.YTXP.pages.KhamBenhNgoaiTruPhongKham.KhamBenhNgoaiTru_Page;
import net.serenitybdd.starter.YTXP.pages.KhamNgoaiTruPhuongXa.KeDonThuoc_Page;
import net.thucydides.core.annotations.Step;

public class KeDonThuoc_Steps {
	KhamBenhNgoaiTru_Page khamBenhPage;
	KeDonThuoc_Page page;
	GenaralObject gen;

	@Step
	public void click_on_keDonThuoc_link() {
		khamBenhPage.click_on_keDonThuoc_link();
		gen.wait_for_preloader_disappear();
		gen.wait_for_preloader_disappear();

	}

	@Step
	public void add_some_thuoc() {
		page.click_on_arrCombo_maThuoc();
		gen.choose_table_option(0);
		enter_soNgayThuoc(1);
		enter_soLuong(1);

	}

	@Step
	public void enter_soNgayThuoc(int i) {
		page.enter_soNgay(i);

	}

	@Step
	public void enter_soLuong(int i) {
		page.click_on_soLuong_field();
		page.enter_soLuong(i);
	}

	@Step
	public void click_on_Luu_button() {
		page.click_luu_button();

	}

	@Step
	public void can_see_message(String expectedMessage) {
		assertTrue(gen.get_toast_message_content().contains(expectedMessage));

	}

	@Step
	public void close_dialog() {
		gen.close_dialog();
	}

}
