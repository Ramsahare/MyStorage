package pomPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class FlipKartAddToCartPage {
	/*initialization*/
	public FlipKartAddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/*declaration */
	@FindBy(xpath="//li[@class='col col-6-12']/button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addTocartButton;
	public WebElement getAddTocartButton() {
		return addTocartButton;
	}
	/*Business logic*/
	public void addTocartButton() {
		addTocartButton.click();
	}
}
