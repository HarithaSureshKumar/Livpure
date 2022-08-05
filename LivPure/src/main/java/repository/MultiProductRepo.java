package repository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiProductRepo 
{
	static WebElement element;
	public static WebElement org_cleaner(WebDriver driver)
	{
		element = driver.findElement(By.linkText("Organic Cleaner"));
		return element;
	}
	public static WebElement add_cart(WebDriver driver)
	{
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		element = driver.findElement(By.xpath("//form/div[1]/div[5]/div[2]/button/span[2]"));
		return element;
	}
	public static WebElement close(WebDriver driver)
	{
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		element = driver.findElement(By.cssSelector("button[class='scd__close p-2 cursor-pointer absolute']"));
		return element;
	}
	public static WebElement home_logo(WebDriver driver)
	{
		element = driver.findElement(By.cssSelector("a[class='block py-2.5 logo-img relative']"));
		return element;
	}
	public static WebElement  mist_spray(WebDriver driver)
	{
		element = driver.findElement(By.xpath("/html/body/div[3]/section/div[2]/header[2]/div[3]/div/div[1]/ul/li[1]/div/div/div/div/ul/li[8]/div/ul/li[1]/a"));
		return element;
	}
	public static WebElement  add_cart2(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//form/div[1]/div[5]/div[2]/button/span[2]"));
		return element;
	}
	public static WebElement  checkout(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//form[1]/div[3]/div[5]/button[1]"));
		return element;
	}

}
