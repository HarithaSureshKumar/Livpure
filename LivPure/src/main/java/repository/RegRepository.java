package repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegRepository
{
static WebElement element;
public static WebElement account(WebDriver driver)
{
	
   element = driver.findElement(By.xpath("//header/div[3]/div[1]/div[2]/a[1]/span[1]/*[1]"));
	return element;
}
public static WebElement register(WebDriver driver)
{
	element= driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
	return element;
}

public static WebElement firstName(WebDriver driver)
{
	element= driver.findElement(By.name("customer[first_name]"));
	return element;
}
public static WebElement lastName(WebDriver driver)
{
	element= driver.findElement(By.name("customer[last_name]"));
	return element;
}
public static WebElement Email(WebDriver driver)
{
	element= driver.findElement(By.name("customer[email]"));
	return element;
}
public static WebElement PW(WebDriver driver)
{
	element= driver.findElement(By.name("customer[password]"));
	return element;
}
public static WebElement terms(WebDriver driver)
{
	element= driver.findElement(By.name("agree_terms"));
	return element;
}
public static WebElement submit(WebDriver driver)
{
	element= driver.findElement(By.xpath("/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/form[1]/button[1]"));
	return element;
}


}