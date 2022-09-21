package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipKartPage {
	//initialization
	public FlipKartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	// declaration of webelement
	// search text field
	@FindBy(name = "q")
	private WebElement searchTextField;
	// search button
	@FindBy(xpath = "//button[@class='L0Z3Pu']")
	private WebElement searchButton;
//cart button
	@FindBy(xpath = "//div[@class='YUhWwv']")
	private WebElement cartButton;
	//
	@FindBy(xpath = "//a[text()='DARSHANAM WORLD 220v 500w Portable Electric Heater Mini Fan Heater Desktop Household Wall Handy Heating Stove Radiator Warmer Machine for Winter Electric Heater Mini Fan Heater Desktop Household Wall Handy Heating Stove Radiator Warmer Machine for Winter Fan Room Heater']")
	private WebElement cartValidation;

	// product name
	@FindBy(xpath = "//div[@data-id='ROHG9R5RWDHK9V2T']/child::div[@class='_4ddWXP']/descendant::a[contains(text(),'DARSHANAM WORLD 220v 500w')]")
	private WebElement productName;

	public String getCartValidation() {
		return cartValidation.getText();
	}

	public WebElement getCartButton() {
		return cartButton;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public String getProductName() {
		return productName.getAttribute("title");
	}

//Business logic
	public void enterProductName() {
		searchTextField.sendKeys("Winter heater");
	}

	public void clikOnSearch() {
		searchButton.click();
	}

	public void clickOnProduct() {
		productName.click();
	}

	public void clickOnCart() {
		cartButton.click();
	}

	public void getCartProductText() {
		cartValidation.getText();
	}
}
