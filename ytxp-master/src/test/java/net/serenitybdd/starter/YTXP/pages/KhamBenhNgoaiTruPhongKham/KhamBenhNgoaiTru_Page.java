package net.serenitybdd.starter.YTXP.pages.KhamBenhNgoaiTruPhongKham;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.util.Util;

public class KhamBenhNgoaiTru_Page extends PageObject {

	public void go_to_KhamBenhNgoaiTru_page() {
		evaluateJavascript(Util.nodeInDOM("//a[@data-id='KhamBenh.KhamBenhNgoaiTru']") + ".click()");
	}

	@FindBy(xpath = "//div[@id='xp_grd_danhsachBNKhamBenh']//tr[@role='row']")
	List<WebElementFacade> rows;

	public void doubleClick_on_row(int i) {
		Actions action = new Actions(this.getDriver());
		action.moveToElement(rows.get(i)).doubleClick().perform();
	}

	@FindBy(id = "id_frmChanDoanSoBo")
	WebElementFacade txt_trieuChung;

	public void enter_trieuChung(String trieuChung) {
		txt_trieuChung.type(trieuChung);
	}

	@FindBy(id = "token-input-id_frmMaChinhICD10")
	WebElementFacade txt_benhChinh;

	public void enter_benhChinh(String string) {
		txt_benhChinh.type(string);
		try {
			Thread.sleep(1000);
			Util.sendFunctionKey(this.getDriver(), Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//td[@id='combo_BacSiKhamBenh-inputCell']" + GenaralObject.subfix_arrowCombobox)
	WebElementFacade arrCombo_bsKham;

	public void click_arrCombo_bacSiKham() {
		arrCombo_bsKham.click();
	}

	public void click_on_Luu_button() {
		evaluateJavascript("document.getElementById('btn_khambenh_luuhosokhambenh').click()");
	}

	@FindBy(id = "XuTri_CapToaThuoc")
	WebElementFacade link_keDonThuoc;

	public void click_on_keDonThuoc_link() {
		link_keDonThuoc.click();
	}

}
