package searchpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import file.read.pkg.FileRead;
import io.github.bonigarcia.wdm.WebDriverManager;
import repository.SearchRepository;

public class Search {

	public static void main(String[] args) throws IOException, InterruptedException
	{

		XSSFSheet sh= FileRead.readF("Search.xlsx", "Sheet1");
		System.out.println("File Opened Sucessfully");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://livpure.com/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//int size=sh.getLastRowNum();
		//System.out.println("Row Size" +size);
		for(int i=1;i<=6; i++)
		{
			String product=sh.getRow(i).getCell(0).toString();
			Actions act= new Actions(driver);
			SearchRepository.search_icon(driver).click();
			SearchRepository.search_txt(driver).sendKeys(product);
			
			
			Thread.sleep(4000);
			try
			{
			
			   SearchRepository.more(driver).click();
				String msg= driver.findElement(By.className("page-header__title")).getText();
				System.out.println(msg);
			}
	
			catch(Exception e)
			{
				System.out.println("No results found");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				JavascriptExecutor js=(JavascriptExecutor)driver;
				SearchRepository.logo(driver);
				js.executeScript("arguments[0].click();", SearchRepository.logo(driver));
				
				
				
			}
			
			
			Thread.sleep(4000);
			
			/*WebElement search= driver.findElement(By.xpath("//header/div[3]/div[1]/div[2]/div[1]/button[1]/span[1]"));

			act.moveToElement(search).doubleClick().build().perform();
			act.moveToElement(search).sendKeys(product).click().build().perform();		
			WebElement sea= driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/div[2]/div[2]/form[1]/input[5]"));
			WebElement search=driver.findElement(By.xpath("//body/div[7]/div[1]/div[1]/div[2]/div[2]/form[1]/button[1]"));
			search.click();*/
		}

	}


}
