package net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa;

import static org.junit.Assert.assertTrue;

import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.YTXP.pages.HomePage;
import net.serenitybdd.starter.YTXP.pages.KhamNgoaiTruPhuongXa.KhamNgoaiTruPhuongXa_Page;
import net.thucydides.core.annotations.Step;

public class KhamNgoaiTruPhuongXa_Steps {
	KhamNgoaiTruPhuongXa_Page page;
	HomePage home;
	GenaralObject genObj;

	@Step
	public void on_khamBenhXaPhuong_page() {
		home.click_on_menu_khamBenh();
		home.click_on_subMenu_KhamBenhXaPhuong();
		genObj.wait_for_preloader_disappear();
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
	public void enter_hoVaTen(String hoVaTen) {
		page.enter_hoVaTen(hoVaTen);
	}

	@Step
	public void enter_namSinh(String namSinh) {
		page.enter_namSinh(namSinh);
	}

	@Step
	public void enter_diaChi(String diaChi) {
		page.enter_diaChi_vietTat(diaChi);
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
	public void choose_bsKham() {
		page.click_on_arrowCombo_bsKham();
		genObj.choose_combo_option(0);
	}

	@Step
	public void choose_ketQuaKham() {
		page.click_on_arrowCombo_ketQuaKham();
		genObj.choose_combo_option(0);

	}

	@Step
	public void choose_dichVu() {
		page.click_on_arrowCombo_dichVu();
		genObj.choose_combo_option(0);
	}

	@Step
	public void choose_phongKham() {
		page.click_on_arrowCombo_phongKham();
		genObj.choose_combo_option(0);
	}

	@Step
	public void click_on_Luu_button() {
		page.click_on_Luu_button();
	}

	@Step
	public void can_see_message(String expectedMess) {
		assertTrue(genObj.get_toast_message_content().contains(expectedMess));
	}

	@Step
	public void click_on_keDonThuoc() {
		page.click_on_keDonThuoc();
		genObj.wait_for_preloader_disappear();
		genObj.wait_for_preloader_disappear();
	}
	



}
