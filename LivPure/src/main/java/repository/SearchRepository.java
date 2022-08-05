package repository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchRepository 

{
	static WebElement element;
	public static WebElement search_icon(WebDriver driver)
	{
		element = driver.findElement(By.cssSelector("button[type='submit']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return element;
	}
	public static WebElement search_txt(WebDriver driver)
	{
		element = driver.findElement(By.name("q"));
		return element;
	}
	public static WebElement more(WebDriver driver)
	{
		element = driver.findElement(By.linkText("More Results"));
		return element;
	}
	public static WebElement logo(WebDriver driver)
	{
		element = driver.findElement(By.cssSelector("img[alt='Livpure ']"));
		return element;
	}

}
