package repository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginRepository 
{
	static WebElement element;
	public static WebElement user_Button(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
	   element = driver.findElement(By.xpath("//header/div[3]/div[1]/div[2]/a[1]/span[1]/*[1]"));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}
	
	
	
	public static WebElement email(WebDriver driver)
	{
		
	   element = driver.findElement(By.name("customer[email]"));
		return element;
	}
	public static WebElement password(WebDriver driver)
	{
		
	   element = driver.findElement(By.name("customer[password]"));
		return element;
	}
	public static WebElement login(WebDriver driver)
	{
		
	   element = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/form[1]/button[1]"));
		return element;
	}
	public static WebElement logout(WebDriver driver)
	{
		
	   element = driver.findElement(By.xpath("//div[contains(text(),'Logout')]"));
	
	   //wait.until(ExpectedConditions.elementToBeClickable(logout));
		return element;
	}
}
