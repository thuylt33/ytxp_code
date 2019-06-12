package net.serenitybdd.starter.YTXP.pages.PhieuNhapKho;

import java.util.List;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class XacNhanPNK_Page extends PageObject {
	@FindBy(xpath = "//a[@id='btnXacNhan'][not(contains(@class,'disabled'))]")
	WebElementFacade btn_xacNhan;

	public boolean button_xacNhan_isEnable() {
		return btn_xacNhan.isEnabled();
	}

	public boolean button_xacNhan_isDisable() {
		return !btn_xacNhan.isVisible();
	}

	@FindBy(id = "btnHuyXacNhan")
	WebElementFacade btn_huyXacNhan;

	public boolean button_huyXacNhan_isEnable() {
		return btn_huyXacNhan.isEnabled();
	}

	@FindBy(xpath = "//div[@id='grd_DSChiTietPhieuNhap']//tr[contains(@class,'data-row')]")
	List<WebElementFacade> gridBodyRow;

	public int get_numberof_pillRecords() {
		System.out.println("Number of Pill records = " + gridBodyRow.size());
		return gridBodyRow.size();
	}

	public void click_on_button_xacNhan() {
		btn_xacNhan.click();
	}

}
