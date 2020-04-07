package ecom.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobilePage {
	
	@FindBy(xpath = "//div[text()='Apple iPhone XR (Black, 64 GB)']")
	private WebElement selectMobile; 
	
	@FindBy(xpath = "//button[text()='ADD TO CART']")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//button[text()='GO TO CART']")
	private WebElement goToCartButton;
	
	@FindBy(xpath = "//a[text()='256 GB']")
	private WebElement Storage;
	
	@FindBy(xpath = "//span[text()='Color']/parent::div/ul/li[@id='swatch-2-color']")
	private WebElement color;

	public WebElement getSelectMobile() {
		return selectMobile;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public WebElement getGoToCartButton() {
		return goToCartButton;
	}

	public WebElement getStorage() {
		return Storage;
	}

	public WebElement getColor() {
		return color;
	}

}
