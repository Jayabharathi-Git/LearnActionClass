package learnActionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDoubleClick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://myntra.com");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement eleMen = driver.findElement(By.xpath("//a[text()='Men']"));
		Actions builder=new Actions(driver);
		
		//doubleClick
		//builder.doubleClick(eleMen).perform();
		//mouseHover
		//builder.moveToElement(eleMen).perform();
		
		//right click
		builder.contextClick(eleMen).perform();
		
		

	}

}
