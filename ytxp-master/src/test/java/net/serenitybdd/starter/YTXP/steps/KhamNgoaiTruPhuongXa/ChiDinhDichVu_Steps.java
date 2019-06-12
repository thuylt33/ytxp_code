package net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa;

import static org.junit.Assert.assertTrue;

import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.YTXP.pages.HomePage;
import net.serenitybdd.starter.YTXP.pages.KhamNgoaiTruPhuongXa.ChiDinhDichVu_Page;
import net.serenitybdd.starter.YTXP.pages.KhamNgoaiTruPhuongXa.KhamNgoaiTruPhuongXa_Page;
import net.thucydides.core.annotations.Step;

public class ChiDinhDichVu_Steps {
	KhamNgoaiTruPhuongXa_Steps khamSteps;
	ChiDinhDichVu_Page page;
	KhamNgoaiTruPhuongXa_Page khamPage;
	GenaralObject genObj;
	HomePage home;

	/**
	 * @deprecated Use {@link #click_group_dichVu(String)} instead
	 */
	@Step
	public void click_group_dichVu() {
		click_group_dichVu("Xét nghiệm");
	}

	@Step
	public void click_group_dichVu(String dichVu) {
		page.choose_dichVu_group(dichVu);
	}

	@Step
	public void choose_dichVu() {
		page.choose_the_first_dichVu();
	}

	@Step
	public void click_on_LuuLai_button() {
		page.click_on_LuuLai_button();
	}

	@Step
	public void can_see_message(String expectedMessage) {
		assertTrue(genObj.get_toast_message_content().contains(expectedMessage));
	}

	@Step
	public void click_on_chiDinhDichVu_link() {
		khamPage.click_on_chiDinhDichVu_link();
		genObj.wait_for_preloader_disappear();
		genObj.wait_for_preloader_disappear();
	}

	@Step
	public void closeDialog() {
		genObj.close_dialog();
	}
	

}
