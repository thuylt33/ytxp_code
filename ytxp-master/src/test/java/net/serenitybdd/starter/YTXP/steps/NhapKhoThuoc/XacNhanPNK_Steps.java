package net.serenitybdd.starter.YTXP.steps.NhapKhoThuoc;

import static org.junit.Assert.assertTrue;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.YTXP.pages.PhieuNhapKho.XacNhanPNK_Page;
import net.serenitybdd.starter.util.Util;
import net.thucydides.core.annotations.Step;

public class XacNhanPNK_Steps {
	GenaralObject genObj;
	XacNhanPNK_Page page;

	@Step
	public void can_see_button_xacNhan_enable() {
		assertTrue(page.button_xacNhan_isEnable());
	}

	@Step
	public void can_see_button_huyXacNhan_enable() {
		assertTrue(page.button_huyXacNhan_isEnable());

	}

	@Step
	public void can_see_number_of_pill_records(int numberOf_pillRecords) {
		assertTrue(numberOf_pillRecords == page.get_numberof_pillRecords());

	}

	@Step
	public void click_on_button_xacNhan() {
		page.click_on_button_xacNhan();
		genObj.click_on_confirm_button();
	}

	@Step
	public void can_see_message(String expectedMessage) {
		assertTrue(genObj.get_toast_message_content().equalsIgnoreCase(expectedMessage));
		
	}
	@Step
	public void can_see_xacNhan_button_isDisabled() {
		assertTrue(page.button_xacNhan_isDisable());
	}

}
