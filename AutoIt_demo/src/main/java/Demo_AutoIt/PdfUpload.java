package Demo_AutoIt;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PdfUpload {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://pdf2doc.com/");
		WebElement file  = driver.findElement(By.xpath("//span[normalize-space()='UPLOAD FILES']"));
		file.click();
		System.out.println("clicked");
	
		Runtime.getRuntime().exec("\"C:\\Users\\Muhindhar S V\\OneDrive\\Documents\\AutoIt_Scripts\\FileUpload.exe\"");
		Thread.sleep(5000);
		System.out.println("Uploaded");
		//driver.quit();
		System.out.println("closed");
	}
}
