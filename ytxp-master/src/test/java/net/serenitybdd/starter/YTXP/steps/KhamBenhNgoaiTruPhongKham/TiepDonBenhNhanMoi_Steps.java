package net.serenitybdd.starter.YTXP.steps.KhamBenhNgoaiTruPhongKham;

import static org.junit.Assert.assertTrue;

import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.YTXP.pages.HomePage;
import net.serenitybdd.starter.YTXP.pages.KhamBenhNgoaiTruPhongKham.TiepDonBenhNhanMoi_Page;
import net.thucydides.core.annotations.Step;

public class TiepDonBenhNhanMoi_Steps {
	TiepDonBenhNhanMoi_Page page;
	GenaralObject gen;

	@Step
	public void on_tiepDonBenhNhanMoi_page() {
		page.click_tiepDon_menu();
		page.click_tiepDonBenhNhan_subMenu();
		gen.wait_for_preloader_disappear();
	}

	@Step
	public void enter_hoVaTen(String hoVaTen) {
		page.enter_hoVaTen(hoVaTen);
	}

	@Step
	public void enter_namSinh(int i) {
		page.enter_namSinh(i);
	}

	@Step
	public void enter_diaChi(String diaChi) {
		page.enter_diaChi_vietTat(diaChi);
	}

	@Step
	public void enter_soBHYT(String soBHYT) {
		page.enter_soBHYT(soBHYT);
	}

	@Step
	public void enter_date_from(String fromDate) {
		page.enter_date_from(fromDate);
	}

	@Step
	public void enter_date_to(String toDate) {
		page.enter_date_to(toDate);
	}

	@Step
	public void choose_dichVu() {
		page.click_arrCombo_dichVu();
		gen.choose_combo_option(0);
	}
	@Step
	public void choose_phongKham() {
		page.click_arrCombo_phongKham();
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
