package singleorderpkg;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import file.read.pkg.FileRead;
import io.github.bonigarcia.wdm.WebDriverManager;
import repository.AcOrderRepository;

public class AcOrder 
{

	public static void main(String[] args) throws IOException, InterruptedException
	{

		//XSSFSheet sh= FileRead.readF("cart.xlsx", "Sheet1");

		System.out.println("File Opened Sucessfully");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://livpure.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.findElement(By.id("cancel1")).click();
		
		System.out.println("Ad closed!");
		
		AcOrderRepository.ac(driver).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(50));
		AcOrderRepository.split_ac(driver).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		js.executeScript("window.scrollBy(0,3100)");
		
		AcOrderRepository.add_cart(driver).click();
		System.out.println("product added to cart");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[1]/div[3]/div[5]/button[1]")));
		
		WebElement checkout=driver.findElement(By.xpath("//form[1]/div[3]/div[5]/button[1]"));
		Actions act=new Actions(driver);
		act.moveToElement(checkout).click().build().perform();
		AcOrderRepository.login(driver).click();
		
		XSSFSheet sh1= FileRead.readF("cart.xlsx", "Sheet1");
		String em=sh1.getRow(1).getCell(0).toString();
		String pw=sh1.getRow(1).getCell(1).toString();
		AcOrderRepository.email(driver).sendKeys(em);
		AcOrderRepository.pswd(driver).sendKeys(pw);
		AcOrderRepository.signin(driver).click();
	

		
		XSSFSheet sh2= FileRead.readF("cart.xlsx", "Sheet2");
		String addr=sh2.getRow(1).getCell(0).toString();
		String cty=sh2.getRow(1).getCell(1).toString();
		String pin=sh2.getRow(1).getCell(2).toString();
		String phone=sh2.getRow(1).getCell(3).toString();
		AcOrderRepository.address(driver).sendKeys(addr);
		AcOrderRepository.city(driver).sendKeys(cty);
		WebElement st1=driver.findElement(By.id("checkout_shipping_address_province"));
		Select state=new Select(st1);
		state.selectByVisibleText("Tamil Nadu");
		AcOrderRepository.pinCode(driver).sendKeys(pin);
        AcOrderRepository.phNo(driver).sendKeys(phone);
		AcOrderRepository.con_ship(driver).click();
		WebElement shp_method= driver.findElement(By.xpath("//form/div[1]/div[2]/div[2]/div/div/div/label/span[1]"));
		wait.until(ExpectedConditions.visibilityOf(shp_method));
	    System.out.println("Clicking on button");
	    AcOrderRepository.con_pay(driver).click();
		//js.executeScript("arguments[0].click();", cpay);
		System.out.println("Button clicked");
		AcOrderRepository.pay_mode(driver).click();
		WebElement com_Order=driver.findElement(By.xpath("//form[1]/div[3]/div[1]/button[1]/span[1]"));
		js.executeScript("arguments[0].click();", com_Order);
		//com_Order.click();

		
		XSSFSheet sh3= FileRead.readF("cart.xlsx", "Sheet3");
		String mob=sh3.getRow(1).getCell(0).toString();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		WebElement frame1= driver.findElement(By.cssSelector("iframe[allowpaymentrequest='true']"));
		driver.switchTo().frame(frame1);
		WebElement mob_Num=driver.findElement(By.xpath("//*[@id=\"contact\"]"));
		mob_Num.sendKeys(mob);
		WebElement proceed=driver.findElement(By.id("footer-cta"));
		proceed.click();
		//WebElement frame2= driver.findElement(By.cssSelector("iframe[allowpaymentrequest='true']"));
		//driver.switchTo().frame(frame2);
		WebElement card=driver.findElement(By.xpath("//*[@id=\"form-common\"]/div[1]/div/div/div[2]/div/div/button[1]"));
		card.click();
		
		XSSFSheet sh4= FileRead.readF("cart.xlsx", "Sheet4");
		String cardno=sh4.getRow(1).getCell(0).toString();
		String expiry=sh4.getRow(1).getCell(1).toString();
		String name=sh4.getRow(1).getCell(2).toString();
		String cvv=sh4.getRow(1).getCell(3).toString();
		AcOrderRepository.card_Num(driver).sendKeys(cardno);
		AcOrderRepository.expiry_date(driver).sendKeys(expiry);
        AcOrderRepository.card_name(driver).sendKeys(name);
		AcOrderRepository.cvv_no(driver).sendKeys(cvv);
		AcOrderRepository.close(driver).click();
		AcOrderRepository.yes_cancel(driver).click();
		driver.close();
		
		
		
		
	}


}

