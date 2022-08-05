package registration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import file.read.pkg.FileRead;
import io.github.bonigarcia.wdm.WebDriverManager;
import repository.RegRepository;

public class RegUser 
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		{
			XSSFSheet sh= FileRead.readF("Inputdata.xlsx", "Sheet2");
			System.out.println("File Opened Sucessfully");
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://livpure.com/");
			//Thread.sleep(9000);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			RegRepository.account(driver).click();
		    Thread.sleep(3000);
			RegRepository.register(driver).click();

			
			String a;
			int size = sh.getLastRowNum();
			System.out.println("Row size" +size);
			for(int i=1; i <= size; i++)
			{
				String fnm=sh.getRow(i).getCell(0).toString();
				String lnm=sh.getRow(i).getCell(1).toString();
				String email=sh.getRow(i).getCell(2).toString();
				String pwd=sh.getRow(i).getCell(3).toString();

				RegRepository.firstName(driver).sendKeys(fnm);
				RegRepository.lastName(driver).sendKeys(lnm);
				RegRepository.Email(driver).sendKeys(email);
				RegRepository.PW(driver).sendKeys(pwd);
				RegRepository.terms(driver).click();
				RegRepository.submit(driver).click();
				
				

			}
			driver.close();
		}
	}


}
