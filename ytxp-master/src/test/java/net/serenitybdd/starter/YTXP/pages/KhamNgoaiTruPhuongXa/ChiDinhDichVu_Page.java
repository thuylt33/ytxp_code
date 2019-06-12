package net.serenitybdd.starter.YTXP.pages.KhamNgoaiTruPhuongXa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ChiDinhDichVu_Page extends PageObject {

	By service_group(String name) {
		return By.xpath("//div[@id='KhamBenh_ViewChiDinhDichVu_tree_ChiDinhDichVu-body']"
				+ "//span[contains(@class,'tree-node-text')][contains(text(),'" + name + "')]");
	}

	public void choose_dichVu_group(String groupName) {
		this.getDriver().findElement(service_group(groupName)).click();
	}

	/*
	 * @FindBy(xpath =
	 * "//div[@id='KhamBenh_ViewChiDinhDichVu_tree_ChiDinhDichVu-body']//span[contains(@class,'x-tree-node-text')][contains(text(),'Xét nghiệm')]"
	 * ) WebElementFacade folder_xetNghiem;
	 * 
	 * 
	 * public void click_dichVu(String dichVu) { folder_xetNghiem.click(); }
	 */

	@FindBy(xpath = "//div[@id='KhamBenh_ViewChiDinhDichVu_grid_DichVu-body']//div[contains(@class,'x-grid-row-checker')]")
	List<WebElementFacade> cbx_dichVus;

	public void choose_the_first_dichVu() {
		cbx_dichVus.get(0).click();
	}

	@FindBy(id = "KhamBenh_ViewChiDinhDichVu_Add")
	WebElementFacade btn_add;

	public void click_on_LuuLai_button() {
		btn_add.click();
	}

}
