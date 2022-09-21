package flipkart.com;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import Flipkart.genericUtility.BaseClassFlipkart;
import Flipkart.genericUtility.ExcelUtility;
import Flipkart.genericUtility.WebDriverUtility;
import pomPages.FlipKartAddToCartPage;
import pomPages.FlipKartPage;
public class FlipkartCartTest extends BaseClassFlipkart {
	@Test
	public void cartTest() throws IOException, Throwable {
		FlipKartPage fp = new FlipKartPage(driver);
		/* handle popup if come */
		try {
			driver.findElement(By.xpath("//button[text()='✕']")).click();
		} catch (Exception e) {
			System.out.println("No such element");
		}
		ExcelUtility eu = new ExcelUtility();
		String expectedProductName = eu.getDataFromExcel("Sheet1", 1, 0);
		/* enter product name in search text field */
		fp.enterProductName();
		/* click on the search button */
		fp.clikOnSearch();
		/* click on the product */
		fp.clickOnProduct();
		String partialWindowTitle = "DARSHANAM WORLD 220v 500w Portable";
		WebDriverUtility wb = new WebDriverUtility();
		/* switch to window */
		wb.swithToWindow(driver, partialWindowTitle);
		/* click on add to cart button */
		FlipKartAddToCartPage fpcartadd = new FlipKartAddToCartPage(driver);
		fpcartadd.addTocartButton();
		/* back to navigate */
		Navigation nav = driver.navigate();
		//wb.waitForPageToLoad(driver);
		nav.back();
		// nav.to("https://www.flipkart.com/darshanam-world-220v-500w-portable-electric-heater-mini-fan-desktop-household-wall-handy-heating-stove-radiator-warmer-machine-winter-room/p/itm30edbe6db6994?pid=ROHG9R5RWDHK9V2T&lid=LSTROHG9R5RWDHK9V2T1NUA0T&marketplace=FLIPKART&q=Winter+heater&store=search.flipkart.com&srno=s_1_1&otracker=search&otracker1=search&fm=Search&iid=f1c3e38d-766d-4dda-ba96-1010341b04ee.ROHG9R5RWDHK9V2T.SEARCH&ppt=sp&ppn=sp&ssid=3vc9nefes00000001663688833925&qH=6ba29a25c515e01f");
		WebElement cartIcon = driver.findElement(By.xpath("//div[@class='YUhWwv']"));
		/* click on cart */
		wb.waitForElementVisibility(driver, cartIcon);
		fp.clickOnCart();
		/* assertion of add product name */
		/* get actual product t */
		wb.waitForPageToLoad(driver);
		String actualProductName = fp.getCartValidation();
		System.out.println("actualProductName is : " + actualProductName);
		System.out.println("expectedProductName :"+expectedProductName);
		Assert.assertEquals(actualProductName, expectedProductName);
//		if (actualProductName.equals(expectedProductName)) {
		System.out.println("Product is added successfully to the cart");
//		} else {
//			System.out.println("Product is not added  to the cart");
//		}
		System.out.println("Add to cart end to end scenario : Test case is passed");
		driver.close();
		driver.quit();
	}
}
