package ecom.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(xpath = "//form/div/input[@type='text']")
	private WebElement userName;
	
	@FindBy(xpath="//div/input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//button/span[text()='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//button[text()='✕']")
	private WebElement closePopup;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getClosePopup() {
		return closePopup;
	}

}
