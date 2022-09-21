
package Flipkart.genericUtility;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
//Author @Rameshwar
public class BaseClassFlipkart {
	public WebDriver driver=null;
	public	FileUtility fLib=new FileUtility();
	public	ExcelUtility eLib=new ExcelUtility();
	public	JavaUtility jLib=new JavaUtility();
	public static WebDriver sDriver;
	@BeforeSuite
	public void bs() {
 		System.out.println("database connection");
	}
	@BeforeTest
	public void bt() {
		System.out.println("execute script in parallel mode");
	}	
	//@Parameters("browser")
	@BeforeClass
	public void bc() throws Throwable {
	String browserName=fLib.getPropertyKeyValue("browser");
	String url=fLib.getPropertyKeyValue("url1");
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver=new EdgeDriver();
		}else {
			System.out.println("specify a valid browser");
	}
		sDriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);		
	}
	
	@BeforeMethod
	public void bm() throws Throwable {
	System.out.println("Login to the application");
	}
	@AfterMethod
	public void am() {
		System.out.println("Logout from the application");
	}
		
	@AfterClass
	public void ac() {
	driver.quit();
	}
		
	@AfterTest
	public void at() {
		System.out.println("close parallel mode execution");
	}
	
	@AfterSuite
	public void as() {
		System.out.println("close database connection");
	}
}