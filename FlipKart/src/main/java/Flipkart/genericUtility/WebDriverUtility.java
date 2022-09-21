package Flipkart.genericUtility;
import java.io.File;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;
public class WebDriverUtility {
	/**@author Rameshwar
	 * wait for page to load before identifying any synchronized element in DOM [HTML-Document]
	 * @parameter driver
	 */	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/**
		 * wait for page to load before identifying any assychronized[java scripts actions] element in DOM [HTML-Docuent]
		 * @parameter driver
		 */
	}
		public void waitForPageToLoadForJSElement(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);}
	    /**
	     * used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
	     * @parameter driver
	     * @parameter element
	     */
	public void waitForElementToBeClickAble(WebDriver driver,WebElement element) {
				WebDriverWait wait=new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.elementToBeClickable(element));}
				  /**
			     * used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
			     * @parameter driver
			     * @parameter element
			     * @parameter pollingTime in the form second
				 * @throws Throwable 
			     */
				public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws Throwable {
					FluentWait wait = new FluentWait(driver);
					wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
					wait.wait(20);
					wait.until(ExpectedConditions.elementToBeClickable(element));
				}
				/**
				 *  used to Switch to Any Window based on Window Title
				 * @parameter driver
				 * @parameter partialWindowTitle
				 */
				public void swithToWindow(WebDriver driver , String partialWindowTitle) {
				       Set<String> set = driver.getWindowHandles();
				         Iterator<String> it = set.iterator();

				          while (it.hasNext()) {
						          String wID = it.next();
						          driver.switchTo().window(wID);
						          String currentWindowTitle = driver.getTitle();
						          if(currentWindowTitle.contains(partialWindowTitle)) {
						        	  break;
						          }
					    	}
				}
				/**
				 * used to Switch to Alert Window & click on OK button
				 * @parameter driver
				 */
				public void swithToAlertWindowAndAccpect(WebDriver driver) {
					driver.switchTo().alert().accept();
				}
				/**
				 * used to Switch to Alert Window & click on Cancel button
				 * @parameter driver
				 */
				public void swithToAlertWindowAndCancel(WebDriver driver) {
					driver.switchTo().alert().dismiss();
				}
				/**
				 * used to Switch to Frame Window based on index
				 * @parameter driver
				 * @parameter index
				 */
				public void swithToFrame(WebDriver driver , int index) {
					driver.switchTo().frame(index);
				}
				
				/**
				 * used to Switch to Frame Window based on id or name attribute
				 * @parameter driver
				 * @parameter id_name_attribute
				 */
				public void swithToFrame(WebDriver driver , String id_name_attribute) {
					driver.switchTo().frame(id_name_attribute);
				}
				
				/**
				 * used to select the value from the dropDwon  based on index
				 * @parameter driver
				 * @parameter index
				 */
				public void select(WebElement element , int index) {
					Select sel = new Select(element);
					sel.selectByIndex(index);
				}
				/**
				 * used to select the value from the dropDwon  based on value / option avlaible in GUI
				 * @parameter element
				 * @parameter value
				 */
				public void select(WebElement element , String text) {
					Select sel = new Select(element);
					sel.selectByVisibleText(text);
				}
				/**
				 * used to place mouse cursor on specified element
				 * @parameter driver
				 * @parameter elemnet
				 */
				public void mouseOverOnElemnet(WebDriver driver , WebElement elemnet)
				{
					Actions act = new Actions(driver);
					act.moveToElement(elemnet).perform();
				}
				
				/**
				 * 	 used to right click on specified element

				 * @parameter driver
				 * @parameter elemnet
				 */
				public void rightClickOnElement(WebDriver driver , WebElement elemnet)
				{
					Actions act = new Actions(driver);
					act.contextClick(elemnet).perform();
				}	
				/**
				 * 
				 * @parameter driver
				 * @parameter javaScript
				 */
				public void executeJavaScript(WebDriver driver , String javaScript) {
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeAsyncScript(javaScript, null);
				}
				   public void waitAndClick(WebElement element) throws InterruptedException
				   {
					   int count = 0;
				       while(count<20) {
					    	   try {
					    	       element.click();
					    	       break;
					    	   }catch(Throwable e){
					    		   Thread.sleep(1000);
					    		   count++;
					    	   }
					  }				      
				   }
				   public String takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
					   String date=Calendar.getInstance().getTime().toString().replace(":", "-");
						TakesScreenshot ts=(TakesScreenshot)driver;
				    	File src=ts.getScreenshotAs(OutputType.FILE);
				    	File dest=new File("./src/test/resources/Screenshot/"+screenshotName+date+".png");
				    	Files.copy(src, dest);
				    	System.out.println("Screenshot successfull");
						return dest.getAbsolutePath();
				    }
				    
				    /**
				     * pass enter Key operation in to Browser
				     * @parameter driver
				     */
				   public void passEnterKey(WebDriver driver) {
					   Actions act = new Actions(driver);
					   act.sendKeys(Keys.ENTER).perform();
				   }
				
					
						
					
					public void waitForElementVisibility(WebDriver driver, WebElement orgHeaderMsg1) {
						// TODO Auto-generated method stub
					}
						
						public void waitForElementVisibility1(WebDriver driver, WebElement conHeaderMsg) {
							// TODO Auto-generated method stub
					}
			
						
					}
					
						
					
	


