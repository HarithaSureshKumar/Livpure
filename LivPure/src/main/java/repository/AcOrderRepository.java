package repository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcOrderRepository 
{
	static WebElement element;
	public static WebElement ac(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(50));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		element = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/img[1]"));
		return element;
	}
	public static WebElement split_ac(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		element = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[3]/section[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[6]/div[1]/form[1]/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]/img[1]"));
		return element;
	}
	public static WebElement add_cart(WebDriver driver)
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		element = driver.findElement(By.xpath("//form/div[1]/div[5]/div[2]/button/span[2]"));
		return element;
	}
	
	public static WebElement login(WebDriver driver)
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		element = driver.findElement(By.linkText("Log in"));
		return element;
	}
	public static WebElement email(WebDriver driver)
	{
		
		element = driver.findElement(By.name("customer[email]"));
		return element;
	}
	
	public static WebElement pswd(WebDriver driver)
	{
		element = driver.findElement(By.name("customer[password]"));
		return element;
	}
	public static WebElement signin(WebDriver driver)
	{
		element = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/form[1]/button[1]"));
		return element;
	}
	public static WebElement address(WebDriver driver)
	{
		element = driver.findElement(By.id("checkout_shipping_address_address1"));
		return element;
	}
	public static WebElement city(WebDriver driver)
	{
		element = driver.findElement(By.name("checkout[shipping_address][city]"));
		return element;
	}
	public static WebElement pinCode(WebDriver driver)
	{
		element = driver.findElement(By.name("checkout[shipping_address][zip]"));
		return element;
	}
	public static WebElement phNo(WebDriver driver)
	{
		element = driver.findElement(By.name("checkout[shipping_address][phone]"));
		return element;
	}
	public static WebElement con_ship(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		element = driver.findElement(By.id("continue_button"));
		return element;
	}
	public static WebElement  con_pay(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		element = driver.findElement(By.xpath("//*[@id=\"continue_button\"]"));
		return element;
	}
	public static WebElement  pay_mode(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		element = driver.findElement(By.xpath("//form[1]/div[1]/div[2]/div[1]/fieldset[1]/div[3]/div[1]/input[1]"));
		return element;
	}
	public static WebElement  card_Num(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id=\"card_number\"]"));
		return element;
	}
	public static WebElement  expiry_date(WebDriver driver)
	{
		element = driver.findElement(By.name("card[expiry]"));
		return element;
	}
	public static WebElement  card_name(WebDriver driver)
	{
		element = driver.findElement(By.id("card_name"));
		return element;
	}
	public static WebElement  cvv_no(WebDriver driver)
	{
		element = driver.findElement(By.name("card[cvv]"));
		return element;
	}
	public static WebElement  close(WebDriver driver)
	{
		element = driver.findElement(By.id("modal-close"));
		return element;
	}
	public static WebElement  yes_cancel(WebDriver driver)
	{
		element = driver.findElement(By.id("positiveBtn"));
		return element;
	}
	
	
}
	
	

