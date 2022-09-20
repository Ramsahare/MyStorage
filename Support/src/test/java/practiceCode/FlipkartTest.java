package practiceCode;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
//author @Rameshwar
public class FlipkartTest {
	@Test
	public void productTest() throws InterruptedException {
		//launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String expectedProducttext = "DARSHANAM WORLD 220v 500w Portable";
		//navigate tot he url
		driver.get("https://www.flipkart.com/");
		try {
			driver.findElement(By.xpath("//button[text()='✕']")).click();
		} catch (Exception e) {
			System.out.println("No such element");
		}
		// enter product name in the product
		driver.findElement(By.name("q")).sendKeys("winter heater");
		// to click on search button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
//		List<WebElement> autosuggestionList = driver
//				.findElements(By.xpath("//div[@class='lrtEPN _17d0yO']/span[@class='r85cly']"));
//		for (WebElement AutoSugession : autosuggestionList) {
//			String first = AutoSugession.getText();
//			if(first.equals("winter heater")) {
//				AutoSugession.click();
//				System.out.println("Successfully clicked on first option");
//			}else {
//				System.out.println("Unable to clicked on first option");
//			}
		// }
		// to0 click on the product
		driver.findElement(By.xpath("//a[text()='DARSHANAM WORLD 220v 500w Portable Electric Heater Mini...']")).click();

		// click on add to cart
		Set<String> allWindowIds = driver.getWindowHandles();
		// Iterator<String> windowWithIndex = allWindowIds.iterator();
		int totalWinowIds = allWindowIds.size();
		System.out.println(totalWinowIds);
		for (String ids : allWindowIds) {
			driver.switchTo().window(ids);
			System.out.println(ids);
		}
		String windowtitle = driver.getTitle();
		System.out.println(windowtitle);
		Thread.sleep(4000);
		//click on add to cart
		driver.findElement(By.xpath("//li[@class='col col-6-12']/button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		Navigation nav = driver.navigate();
		Thread.sleep(4000);
		nav.back();
		nav.to("https://www.flipkart.com/search?q=winter%20heater&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
		driver.findElement(By.xpath("//div[@class='YUhWwv']")).click();
		Thread.sleep(5000);
		String actualProductText = driver.findElement(By.xpath("//a[text()='DARSHANAM WORLD 220v 500w Portable Electric Heater Mini Fan Heater Desktop Household Wall Handy Heating Stove Radiator Warmer Machine for Winter Electric Heater Mini Fan Heater Desktop Household Wall Handy Heating Stove Radiator Warmer Machine for Winter Fan Room Heater']")).getText();
		if(actualProductText.contains(expectedProducttext)) {
			System.out.println("Product is added sccessfully to the cart");
		}else {
			System.out.println("Product is not  added to the cart");
		}
//		driver.close();
		Thread.sleep(4000);
	driver.quit();
	}
}
