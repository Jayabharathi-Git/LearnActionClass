package learnActionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Dropdown.html");


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement eleSelenium = driver.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option[text()='Selenium']"));
		WebElement eleAppium = driver.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option[text()='Appium']"));
		
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL)
		.click(eleSelenium)
		.click(eleAppium)
		.keyUp(Keys.CONTROL)
		.perform();
		
		driver.close();
	}
	
}


