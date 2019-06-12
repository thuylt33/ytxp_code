package net.serenitybdd.starter.YTXP.pages.KhamBenhNoiTru;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.starter.YTXP.pages.GenaralObject;

public class DanhSachNhapVien_Page extends PageObject {

	@FindBy(id = "id_ngaythang_NoiTru-inputEl")
	WebElementFacade txt_frDate;

	public void enter_fromDate(String fromDate) {
		txt_frDate.clear();
		txt_frDate.type(fromDate);
	}

	@FindBy(id = "id_DenNgaythang_NoiTru-inputEl")
	WebElementFacade txt_toDate;

	public void enter_toDate(String today) {
		txt_toDate.clear();
		txt_toDate.type(today);
	}

	@FindBy(id = "btnTimKiem_NT")
	WebElementFacade btn_timKiem;

	public void click_timKiem_button() {
		btn_timKiem.click();
	}

	@FindBy(id = "txt_SearchBnNt")
	WebElementFacade txt_searchName;

	public void enter_patientName(String patientName) {
		txt_searchName.type(patientName);
	}

	

	public String get_patient_name_on_grid() {
		GenaralObject gen = new GenaralObject();
		int patientName_index = gen.index_of_grid_column("grd_danhsachBNNoiTru", "Tên bệnh nhân");
		By patientName = By.xpath("//div[@id='grd_danhsachBNNoiTru']//td[" + patientName_index + "]/div");
		return this.getDriver().findElement(patientName).getText();
	}

}
