package loginpkg;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import file.read.pkg.FileRead;
import io.github.bonigarcia.wdm.WebDriverManager;
import repository.LoginRepository;

public class Login 
{

	public static void main(String[] args) throws IOException
	{
		
		XSSFSheet sh= FileRead.readF("LoginData.xlsx", "Sheet1");
		
		System.out.println("File Opened Sucessfully");
	//	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
	
		
		driver.manage().window().maximize();
		driver.get("https://livpure.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		LoginRepository.user_Button(driver).click();
		
		for(int i=1;i<=3; i++)
		{
			String em=sh.getRow(i).getCell(0).toString();
			String pw=sh.getRow(i).getCell(1).toString();
			///wait.until(ExpectedConditions.elementToBeClickable(acc));
	        LoginRepository.email(driver).sendKeys(em);
			LoginRepository.password(driver).sendKeys(pw);
			LoginRepository.login(driver).click();
			try
			{
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					
				 WebElement logout = LoginRepository.logout(driver);
				
				//WebElement logout= driver.findElement(By.xpath("//div[contains(text(),'Logout')]"));
				//wait.until(ExpectedConditions.elementToBeClickable(logout));
				
				JavascriptExecutor js= (JavascriptExecutor)driver;
				
				js.executeScript("arguments[0].click();", logout);
			}
			catch(Exception e)
			{
				//System.out.println(e);
				System.out.println("Invalid username/password: " +em+ " , " +pw);
				driver.navigate().back();
			}

		}
		driver.close();
	}
}



