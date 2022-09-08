package learnActionClass;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TryErail {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			
			driver.get("https://erail.in/");
			
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			WebElement source = driver.findElement(By.id("txtStationFrom"));
			source.clear();
			source.sendKeys("MS");
			Thread.sleep(200);
			source.sendKeys(Keys.TAB);
			WebElement des = driver.findElement(By.id("txtStationTo"));
			des.clear();
			des.sendKeys("MDU");
			Thread.sleep(200);
			des.sendKeys(Keys.TAB);
			WebElement sort = driver.findElement(By.id("chkSelectDateOnly"));
			sort.click();
			
			
			List<WebElement> train = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]/a"));
			
			Set<WebElement> setelement= new TreeSet<WebElement>(train);
			

			int listsize = train.size();
			
			
			int setsize = setelement.size();
			
			if (listsize ==setsize)
			{
				System.out.println("equal - no duplicate");
			}
			else
			{
				System.out.println("duplicate");
			}
	}


}
