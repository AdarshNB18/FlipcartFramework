package ecom.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginLink;
	
	@FindBy(xpath="//input[@name='q']")
	private WebElement searchBox;
	
	@FindBy(xpath="//a/span[text()='Cart']")
	private WebElement cartButton;
	
	@FindBy(xpath = "//div[text()='Adarsh']")
	private WebElement profileName;
	
	@FindBy(xpath="//div[text()='Logout']")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchEnter;

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getCartButton() {
		return cartButton;
	}

	public WebElement getProfileName() {
		return profileName;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}
	
	public WebElement getsearchEnter()
	{
		return searchEnter;
	}
	
}