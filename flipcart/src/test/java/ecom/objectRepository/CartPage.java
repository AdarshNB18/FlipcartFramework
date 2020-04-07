package ecom.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {
	
	@FindBy(xpath = "//a[text()='Apple iPhone XR (Black, 64 GB)']")
	private WebElement confirmMobile;
	
	@FindBy(xpath = "//a[text()='Apple iPhone XR (Black, 256 GB)']")
	private WebElement confirmMobileStorage;
	
	@FindBy(xpath = "//a[text()='Apple iPhone XR (Blue, 64 GB)']")
	private WebElement confirmMobileColor;
	
	@FindBy(xpath = "//span[text()='Price details']/parent::div/div/div/div[contains(text(),'Price')]")
	private WebElement noOfProductsDetails;
	
	@FindBy(xpath = "//a[text()='Apple iPhone XR (Black, 64 GB)']/ancestor::div[@class='PaJLWc']/following-sibling::div/descendant::div[text()='Remove']")
	private WebElement removeProductFromCart;
	
	@FindBy(xpath = "//div[text()='Are you sure you want to remove this item?']/parent::div/descendant::div[text()='Remove']")
	private WebElement confirmRemovingProduct;
	
	@FindBy(xpath = "//a[text()='Apple iPhone XR (Black, 64 GB)']/ancestor::div[@class='PaJLWc']/following-sibling::div/descendant::div[text()='Save for later']")
	private WebElement saveForLater;
	
	@FindBy(xpath = "//a[text()='Apple iPhone XR (Black, 64 GB)']/ancestor::div[@class='PaJLWc']/following-sibling::div/descendant::div[text()='Move to cart']")
	private WebElement moveToCart;
	
	public WebElement getConfirmMobile() {
		return confirmMobile;
	}

	public WebElement getConfirmMobileStorage() {
		return confirmMobileStorage;
	}

	public WebElement getConfirmMobileColor() {
		return confirmMobileColor;
	}

	public WebElement getNoOfProductsDetails() {
		return noOfProductsDetails;
	}

	public WebElement getRemoveProductFromCart() {
		return removeProductFromCart;
	}

	public WebElement getConfirmRemovingProduct() {
		return confirmRemovingProduct;
	}

	public WebElement getSaveForLater() {
		return saveForLater;
	}

	public WebElement getMoveToCart() {
		return moveToCart;
	}
	
	
}
