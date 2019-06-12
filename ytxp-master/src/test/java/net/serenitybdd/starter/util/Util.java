package net.serenitybdd.starter.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.seleniumhq.jetty9.server.Authentication.User;

public class Util {
	/**
	 * Copy paste using Robot class
	 * 
	 * @param textCoppy
	 * @throws InterruptedException
	 */
	public static void coppyPaste(String textCoppy) throws InterruptedException {
		Robot robot;
		try {
			robot = new Robot();
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection stringSelection = new StringSelection(textCoppy);

			clipboard.setContents(stringSelection, null);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Send Key using Robot class
	 * 
	 * @param key
	 */
	public static void setKey(int key) {
		// button Ky so
		try {
			Robot robot;
			robot = new Robot();
			robot.setAutoDelay(50);
			robot.keyPress(key);
			robot.keyRelease(key);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param driver
	 * @param key
	 * @throws Exception
	 */
	public static void sendFunctionKey(WebDriver driver, Keys key) throws Exception {
		driver.switchTo().activeElement().sendKeys(key);
	}

	/**
	 * Su dung khi khong bat duoc doi tuong
	 * 
	 * @param driver
	 * @param text
	 * @throws Exception
	 */
	public static void sendKey(WebDriver driver, String text) throws Exception {
		driver.switchTo().activeElement().sendKeys(text);
	}

	/**
	 * Thực hiện lệnh js
	 */
	public static void executeJS(WebDriver driver, String javascript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(javascript);
	}

	/**
	 * using robot api, choose a file, press enter
	 * 
	 * @param path
	 */
	public static void chooseUploadFile(String path) {
		String autoITExecutable = ".\\uploadFile_chrm.exe " + path;
		try {
			Runtime.getRuntime().exec(autoITExecutable);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Choose path to save file
	 * 
	 * @param fullPath
	 */
	public static void saveFileTo(String folderPath, String fileName) {
		String autoITExecutable = ".\\saveFile_chrm.exe " + folderPath + " " + fileName;
		try {
			Runtime.getRuntime().exec(autoITExecutable);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Scroll down
	 */
	public static void scrollDown(WebDriver driver, int i) {
		executeJS(driver, "window.scrollBy(0," + i + ")");
	}

	public static void jsScrollInToView(WebDriver driver, String xpath) {
//		executeJS(driver, "document.evaluate(\"" + xpath
//				+ "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.scrollIntoView()");
		executeJS(driver, nodeInDOM(xpath) + ".scrollIntoView()");
	}

	/**
	 * Return DOM structer to get a node
	 * 
	 * @param xpath
	 * @return
	 */
	public static String nodeInDOM(String xpath) {
		return "document.evaluate(\"" + xpath
				+ "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue";
	}

	/**
	 * return unique code
	 */
	public static String getUniqueCode() {
		Date d = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		return dateFormat.format(d);
	}

	/**
	 * Hàm lấy ngày cách value ngày/tháng/năm so với ngày hiện tại value > 0 lấy
	 * thời điểm trong tương lại, value < 0 lấy thời điểm trong quá khứ
	 * 
	 * @param type: theo ngày, tháng, năm
	 * @param value: số ngày/tháng/năm cách thời điểm hiện tại muốn lấy.
	 * @param format: định dạng hiển thị của ngày trả về
	 * @return
	 */
	public static String getDay(String type, int value, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		Date date2 = null;
		switch (type) {
		case "day":
			cal.add(Calendar.DATE, value);
			date2 = cal.getTime();
			break;
		case "month":
			cal.add(Calendar.MONTH, value);
			date2 = cal.getTime();
			break;
		case "year":
			cal.add(Calendar.YEAR, value);
			date2 = cal.getTime();
			break;
		default:
			break;
		}
		return dateFormat.format(date2);
	}

	/**
	 * Nhập ngày trong trường hợp chỉ cho phép gõ ko cho sendkeys
	 * 
	 * @param date
	 */
	public static void typeCharSequence(WebDriver driver, String date) {
		try {
			for (int i = 0; i < date.length(); i++) {
				String KeyVal = Character.toString(date.charAt(i));
				driver.switchTo().activeElement().sendKeys(KeyVal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Add a String as a new line to a file
	 * 
	 * @param fileName
	 * @param stringAdded
	 */
	public static void addMoreLine(String fileName, String stringAdded) {
		File file = new File(fileName);
		boolean firstLine = false;
		try {
			file.createNewFile();
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			if (line == null || line.equals(""))
				firstLine = true;
			br.close();
			fr.close();
			FileWriter fw = new FileWriter(file, true);
			if (!firstLine)
				fw.write("\n");
			fw.write(stringAdded);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete a line if exist in the file
	 * 
	 * @param fileName
	 * @param stringNeedToDelete
	 */
	public static void deleteALine(String fileName, String stringNeedToDelete) {
		String tempfileName = System.getProperty("user.dir") + "/" + getUniqueCode() + "temp.csv";

		File file = new File(fileName);
		File temp = new File(tempfileName);

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();

			FileWriter fw = new FileWriter(temp, true);
			boolean firstTempLine = true;

			while (line != null) {
				if (!line.equals(stringNeedToDelete)) {

					if (!firstTempLine)
						fw.write("\n");
					fw.write(line);
					firstTempLine = false;
				}
				line = br.readLine();
			}
			fw.close();
			br.close();
			fr.close();
			file.delete();
			temp.renameTo(file);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Get the content of the index line of the file if index = -1 or index is to
	 * big. then return the last line index start from 0
	 * 
	 * @param filepath
	 * @return
	 */
	public static String getALine(String filepath, int index) {
		File file = new File(filepath);
		FileReader fr;
		String line = null;
		ArrayList<String> lines = new ArrayList();
		try {
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			line = br.readLine();
			while (line != null) {
				lines.add(line);
				line = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		if (index > lines.size() || index == -1)
			index = lines.size() - 1;
		return lines.get(index);
	}

	/**
	 * Fetch PDF content to a String
	 * 
	 * @param filePath
	 * @return
	 */

	public static String fetchPDFContent(String Path, String type) {
		String text = null;

		try {
			// Loading an existing document
			File file = null;
			if (type.equals("file")) {
				file = new File(Path);
			}
			if (type.equals("url")) {
				URL url = new URL(Path);
				try {
					file = Paths.get(url.toURI()).toFile();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}

			PDDocument document;
			document = PDDocument.load(file);

			// Instantiate PDFTextStripper class
			PDFTextStripper pdfStripper = new PDFTextStripper();

			// Retrieving text from PDF document
			text = pdfStripper.getText(document);
			System.out.println(text);

			// Closing the document
			document.close();
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;

	}

	@Test
	public void readPDF() {
//		fetchPDFContent("https://hisone.ytecoso.vn/BillingsArea/XacNhanChiPhiBHYT/ViewPDF?TiepNhanId=11443123&amp;LoaiDoiTuong=BaoHiem&amp;ManHinh=XP&amp;BENHVIENDATUYEN_ID=0&amp;loaiMau=0","url");
		fetchPDFContent("file:///D:/Workspace/YTXP/ViewPDF", "url");
	}
}
