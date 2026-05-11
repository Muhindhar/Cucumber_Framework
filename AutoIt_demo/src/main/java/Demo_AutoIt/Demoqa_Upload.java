package Demo_AutoIt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demoqa_Upload {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");
		WebElement btn = driver.findElement(By.xpath("//input[@id='uploadFile']"));
		btn.sendKeys("C:\\Users\\Muhindhar S V\\OneDrive\\Documents\\GCE pp certit.pdf");
		String msg = driver.findElement(By.id("uploadedFilePath")).getText();
		System.out.println(msg);
		driver.quit();
		
	}
}
