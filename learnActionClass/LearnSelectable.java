package learnActionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnSelectable {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/selectable.html");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement ele1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement ele3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement ele5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		WebElement ele7 = driver.findElement(By.xpath("//li[text()='Item 7']"));
		
		Actions builder=new Actions(driver);
		builder.keyDown(Keys.CONTROL)
		.click(ele1)
		.click(ele3)
		.click(ele5)
		.click(ele7)
		.keyUp(Keys.CONTROL)
		.perform();
		
		
	}

}
