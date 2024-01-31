package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class iframe {
 
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "your_chromedriver_path");
		WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-infobars");
		options.setAcceptInsecureCerts(false);

		driver.get("http://jqueryui.com/droppable/");


		System.out.println(driver.findElements(By.tagName("iframe")).size()); 
		driver.switchTo().frame(0);

		Actions a = new Actions(driver);

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		a.dragAndDrop(source, target).build().perform();

		driver.switchTo().defaultContent();

	}
}
