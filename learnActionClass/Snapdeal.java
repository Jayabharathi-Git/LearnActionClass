package learnActionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.snapdeal.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement eleMen = driver.findElement(By.xpath("//li[@navindex='1']"));
		Actions builder = new Actions(driver);

		WebElement eleShirts = driver.findElement(By.xpath("//span[text()='Shirts']"));
		builder.moveToElement(eleMen).pause(1000).click(eleShirts).perform();

		WebElement eleFirstShirt = driver.findElement(By.xpath("//div[@class='product-tuple-image ']//img"));

		WebElement eleQuickView = driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));

		builder.moveToElement(eleFirstShirt).perform();
		builder.moveToElement(eleQuickView).click().perform();

		driver.close();

	}
}
