package Demo_AutoIt;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Download_pdf {
	public static void main(String[] args) throws InterruptedException, IOException {

		String downfilepath = System.getProperty("user.dir") + File.separator + "downloads";

		ChromeOptions opt = new ChromeOptions();

		opt.addArguments("--disable-notifications");
		opt.addArguments("--disable-infobars");
		opt.addArguments("--disable-popup-blocking");
		opt.addArguments("--disable-extensions");
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("plugins.always_open_pdf_externally", true);
		prefs.put("download.default_directory", downfilepath);
		opt.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://sample-files.com/documents/pdf/#google_vignette");
		WebElement downlink = driver.findElement(By.xpath("//a[@href='/downloads/documents/pdf/basic-text.pdf'][normalize-space()='Download']"));
		downlink.click();
		Thread.sleep(5000);
		File dwnlded = new File(downfilepath + File.separator + "basic-text.pdf");
		if (dwnlded.exists()) {
			System.out.println("Downloaded");
			PDDocument document = Loader.loadPDF(dwnlded);
			PDFTextStripper pdf = new PDFTextStripper();
			String text = pdf.getText(document);
			System.out.println(text);

			document.close();
		} else {
			System.out.println("Not downloaded");
		}
		driver.quit();
	}
}