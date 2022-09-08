package learnActionClass;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ERail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://erail.in");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement eleFrom = driver.findElement(By.id("txtStationFrom"));
		eleFrom.clear();
		eleFrom.sendKeys("MS"); //if no delay in loading -- eleFrom.sendKeys("MS",Keys.TAB); 
		Thread.sleep(500);
		eleFrom.sendKeys(Keys.TAB);
		
		WebElement eleTo=driver.findElement(By.id("txtStationTo"));
		eleTo.clear();
		eleTo.sendKeys("MDU");
		Thread.sleep(500);
		eleTo.sendKeys(Keys.TAB);
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		
		Set<String> trainName=new HashSet<String>();
		
		List<WebElement> eleTrainNameList = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr/td[2]"));
		//Set<WebElement> setW=new HashSet<WebElement>(eleTrainNameList);
		
		System.out.println("---Train Names---");
		for(WebElement e:eleTrainNameList) {
			System.out.println(e.getText());
			trainName.add(e.getText());
		}
		System.out.println("---------");
		
		if(eleTrainNameList.size()==trainName.size())
			System.out.println("No duplicate train names");
		
		//alternate approach
		
		int rowSize = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr")).size();
		
		for(int i=1;i<=rowSize;i++)
			System.out.println(driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText());
		
		driver.close();
	}

}
