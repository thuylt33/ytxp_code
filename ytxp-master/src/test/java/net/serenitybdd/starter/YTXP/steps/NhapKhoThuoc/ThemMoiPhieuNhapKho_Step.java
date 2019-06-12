package net.serenitybdd.starter.YTXP.steps.NhapKhoThuoc;

import static org.junit.Assert.assertTrue;

import org.apache.bcel.generic.DLOAD;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.starter.YTXP.pages.GenaralObject;
import net.serenitybdd.starter.YTXP.pages.HomePage;
import net.serenitybdd.starter.YTXP.pages.PhieuNhapKho.ThemMoiPhieuNhapKho_Page;
import net.serenitybdd.starter.util.Util;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class ThemMoiPhieuNhapKho_Step {
	ThemMoiPhieuNhapKho_Page page;
	GenaralObject genObj;

	@Step
	public void enter_soSeri(String code) {
		page.enter_soSeri(code);
	}

	@Step
	public void enter_soHoaDon(String code) {
		page.enter_soHoaDon(code);

	}

	@Step
	public void enter_ngayHoaDon(String today) {
		page.enter_ngayHoaDon(today);
	}

	@Step
	public void choose_nguonNhapHang() {
		page.click_arrow_combo_nguonNhapHang();
		genObj.choose_combo_option(0);
	}

	@Step
	public void enter_ngayNhapHang(String today) {
		page.enter_ngayNhapHang(today);

	}

	@Step
	public void choose_nguoiNhan() {
		page.click_on_combobox_nguoiNhan();
		genObj.choose_combo_option(0);
	}

	@Step
	public void choose_nhaCungCap() {
		page.click_on_combobox_nhaCungCap();
		genObj.choose_combo_option(0);

	}

	@Step
	public void choose_khoNhan() {
		page.click_on_combobox_khoNhan();
		genObj.choose_combo_option(0);

	}

	@Step("Add Thuốc, STT: {0}; Số lượng: {1}; Tỉ lệ: {2}; Đơn giá: {3}; Lô SX: {4}; Hạn dùng: {5}; Thứ tự phê duyệt: {6}")
	public void add_thuoc(int index, int soLuong, int tiLe, int donGia, int loSX, String hanDung, int ttPheDuyet) {
		choose_thuoc(index);
		enter_soLuong(index, soLuong);
		enter_tiLe(index, tiLe);
		enter_donGia(index, donGia);
		enter_loSX(index, loSX);
		enter_hanDung(index, hanDung);
		enter_ttPheDuyet(index, ttPheDuyet);

	}

	@Step("Enter Thứ tự phê duyệt {1}")
	public void enter_ttPheDuyet(int index, int ttPheDuyet) {
		page.click_on_ttPheDuyet_field(index);
		page.enter_ttPheDuyet(ttPheDuyet);
	}

	@Step("Enter Hạn dùng {1}")
	public void enter_hanDung(int index, String hanDung) {
		page.click_on_hanDungX_field(index);
		page.enter_hanDung(hanDung);
	}

	@Step("Enter Lô Sản xuất {1}")
	public void enter_loSX(int index, int loSX) {
		page.click_on_loSX_field(index);
		page.enter_loSX(loSX);
	}

	@Step("Enter Đơn giá {1}")
	public void enter_donGia(int index, int donGia) {
		page.click_on_donGia_field(index);
		page.enter_donGia(donGia);
	}

	@Step("Enter Tỉ lệ {1}")
	public void enter_tiLe(int index, int tiLe) {
		page.click_on_tiLe_field(index);
		page.enter_tiLe(tiLe);

	}

	@Step("Enter số lượng: {1}")
	public void enter_soLuong(int index, int soLuong) {
		page.click_on_soLuong_field(index);
		page.enter_soLuong(soLuong);

	}

	@Step("Choose Thuốc number {0}")
	public void choose_thuoc(int index) {
		page.click_on_maThuoc_field(index);
		page.click_on_combobox_maThuoc(index);
		genObj.choose_table_option(index);
	}

	@Step("Scroll to the first row, then click add more row")
	public void add_more_row() {
		page.scroll_to_the_first_row();
		page.add_more_row();

	}

	@Step
	public void click_on_add_button() {
		page.click_on_add_button();
		genObj.click_on_confirm_button();
	}
	@Step
	public void can_see_message(String expectedMess) {
		assertTrue(expectedMess.equalsIgnoreCase(genObj.get_toast_message_content()));
		String soSeri = Serenity.sessionVariableCalled("soSeri").toString();
		
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String file = variables.getProperty("ytxt.pnk.listSoSeri");
		String fileName = System.getProperty("user.dir") + file;

		Util.addMoreLine(fileName, soSeri);
	}

}
