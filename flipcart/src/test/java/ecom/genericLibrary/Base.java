package ecom.genericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ecom.objectRepository.CartPage;
import ecom.objectRepository.HomePage;
import ecom.objectRepository.LoginPage;
import ecom.objectRepository.MobilePage;


public class Base {
	
	public WebDriver driver=null;
	public FileLib lib;
	public static WebDriver driverListener;
	public String pathprop="./src\\ecom\\genericLibrary\\commonData.properties";
	public String pathexcel="./src\\ecom\\genericLibrary\\FlipcartScenarios.xlsx";
	public HomePage hp;
	public LoginPage lp;
	public MobilePage mp;
	public CartPage cp;
	@BeforeClass
	public void configBC()
	{
		lib=new FileLib();
		String value=lib.getPropertyKeyValue(pathprop, "browser");
		
		//Step 1:Launch the browser and Enter the URL
		if(value.equals("chrome"))
		{
			driver=new ChromeDriver();
			driverListener=driver;
		}
		else if(value.equals("Firefox"))
		{
			driver=new FirefoxDriver();
			driverListener=driver;
		}
		hp=PageFactory.initElements(driver, HomePage.class);
		lp=PageFactory.initElements(driver, LoginPage.class);
		mp=PageFactory.initElements(driver, MobilePage.class);
		cp=PageFactory.initElements(driver, CartPage.class);
		
		//Enter URL
		driver.manage().window().maximize();
		driver.get(lib.getPropertyKeyValue(pathprop, "url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Step 2:Clear Pop up if appears
		if(lp.getClosePopup().isDisplayed())
		{
			Reporter.log("Login pop up is Displayed Successfully",true);
			lp.getClosePopup().click();
		}
	}
	
	
	@BeforeMethod
	public void configBM()
	{
		//Step 3:Click on Login button in HomePage
		Reporter.log("Finding Login link in HomePage",true);
		hp.getLoginLink().click();
		Reporter.log("Found Login link in HomePage and Clciked",true);
		
		//Step 4:Enter Valid User name and Password and click on Login
		Reporter.log("Finding Username textfield in Login Popup",true);
		lp.getUserName().sendKeys(lib.getPropertyKeyValue(pathprop, "username"));
		Reporter.log("Found username textfield in Login Popup and Entered Username",true);
		Reporter.log("Finding Password textfield in Login Popup",true );
		lp.getPassword().sendKeys(lib.getPropertyKeyValue(pathprop, "password"));
		Reporter.log("Found password textfield in Login Popup and Entered Password",true);
		Reporter.log("Finding Login button in Login Popup",true);
		lp.getLoginButton().click();
		Reporter.log("Found Login button in Login Popup and clicked",true);
		
		//Verify the HomePage is displayed Successfully
		String expHomePageTitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!".replace(" ", "");
		String actHomePageTitle=driver.getTitle().replace(" ", "");
		
		Assert.assertEquals(expHomePageTitle, actHomePageTitle);
		Reporter.log("HomePage is displayed Successfully",true);
	}
	
	@AfterMethod
	public void configAM()
	{
		//Logout from the Application
		Actions act=new Actions(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Reporter.log("Finding Profile Name Button in HomePage",true);
		act.moveToElement(hp.getProfileName()).perform();
		Reporter.log("Found Profile Name Button in HomePage and clicked",true);
	
		Reporter.log("Finding Logout Button in HomePage",true);
		hp.getLogoutButton().click();
		Reporter.log("Found Logout Button in HomePage and clicked",true);
			
		//Verify that the Logout is successful
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try
		{
		if(hp.getProfileName().isDisplayed())
			Reporter.log("Logout is failed",true);	
		}
		catch(Throwable ob)
		{
			Reporter.log("Logout is successful",true);
		}
	}
	
	@AfterClass
	public void configAC()
	{
		//Close the Browser
		driver.quit();
	}
	
	


}
