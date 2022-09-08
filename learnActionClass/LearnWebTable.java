package learnActionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWebTable {

public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/table.html");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		System.out.println(driver.findElement(By.xpath("//table//tr[3]/td[2]")).getText());
		
		int rowSize = driver.findElements(By.xpath("//table//tr")).size();
		int colSize = driver.findElements(By.xpath("//table//tr//th")).size();
		for(int i=2;i<=rowSize;i++)
			//int colSize=driver.findElements(By.xpath("//table//tr["+i"+"]/td")).size();
			for(int j=1;j<colSize;j++)
			System.out.println(driver.findElement(By.xpath("//table//tr["+i+"]/td["+j+"]")).getText());
			

}

}
