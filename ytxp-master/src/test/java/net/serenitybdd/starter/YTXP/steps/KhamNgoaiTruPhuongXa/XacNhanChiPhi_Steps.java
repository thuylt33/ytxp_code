package net.serenitybdd.starter.YTXP.steps.KhamNgoaiTruPhuongXa;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.Keys;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.YTXP.pages.KhamNgoaiTruPhuongXa.KhamNgoaiTruPhuongXa_Page;
import net.serenitybdd.starter.util.Util;
import net.thucydides.core.annotations.Step;

public class XacNhanChiPhi_Steps {

	KhamNgoaiTruPhuongXa_Page khamPage;
	GenaralObject gen;

	@Step
	public void click_on_In_button() {
		khamPage.click_on_In_button();
	}

	@Step
	public void choose_inBangKeBHYT() {
		khamPage.choose_inBangKeBHYT();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Step
	public void open_bangKe() {
		String url = khamPage.get_chiPhi_PDF_path();
		System.out.println(url);
		khamPage.getDriver().navigate().to(url);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Step
	public void save_bangKe() {
		try {
			String saveAs = Keys.chord(Keys.CONTROL, "s");
			Util.sendKey(khamPage.getDriver(), saveAs);
			Thread.sleep(2000); // cho cho window hien len
			String folderPath = System.getProperty("user.dir");
			String fileName = "bangke" + Util.getDay("day", 0, "yyMMddhhmmss") + ".pdf";
			String fullPath = folderPath + "/" + fileName;
			Serenity.setSessionVariable("bangKeFile").to(fullPath);
			Util.saveFileTo(folderPath, fileName);
			// cho download file xong
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Step ("Can see there section: {0}")
	public void can_see_section(String[] expectedString) {

		String path = Serenity.sessionVariableCalled("bangKeFile").toString();
		String report = Util.fetchPDFContent(path, "file");
		for (int i = 0; i < expectedString.length; i++)
			assertTrue(report.contains(expectedString[i]));
		File file = new File(path);
		file.delete();
	}



}
