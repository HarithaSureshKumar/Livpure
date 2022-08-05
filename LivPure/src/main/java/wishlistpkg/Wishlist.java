package wishlistpkg;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import file.read.pkg.FileRead;
import io.github.bonigarcia.wdm.WebDriverManager;
import repository.SearchRepository;

public class Wishlist
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		{
			
			System.out.println("File Opened Sucessfully");
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://livpure.com/");
			//Thread.sleep(9000);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(By.id("cancel1")).click();
			
			System.out.println("Ad closed!");
			XSSFSheet sh= FileRead.readF("Search.xlsx", "Sheet2");
			String product=sh.getRow(1).getCell(0).toString();
			SearchRepository.search_icon(driver).click();
			SearchRepository.search_txt(driver).sendKeys(product);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			SearchRepository.more(driver).click();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,800)");
			Thread.sleep(3000);
			WebElement Latex_Mattress=driver.findElement(By.xpath("/html/body/main/div[1]/div[2]/ul/div[7]/form/div[1]/div/div[1]/a/div[2]/div/img"));
			Latex_Mattress.click();
			WebElement wishlist=driver.findElement(By.xpath("/html/body/main/div[2]/section/div[1]/div[1]/div/div/div[2]/div/div/form/div/div[1]/div/div/button"));
			wishlist.click();
			
}
}
}