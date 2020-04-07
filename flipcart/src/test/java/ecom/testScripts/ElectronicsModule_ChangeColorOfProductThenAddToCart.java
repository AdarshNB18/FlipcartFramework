package ecom.testScripts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ecom.genericLibrary.Base;
@Listeners(ecom.genericLibrary.EventListeners.class)
public class ElectronicsModule_ChangeColorOfProductThenAddToCart extends Base{
	
	@Test
	public void ChangeColorOfiPhoneThenAddToCart()
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"));
		//Step 5:Enter 'Apple iPhone XR (64GB) - Black' into Search Box and click enter
		wait.until(ExpectedConditions.elementToBeClickable(hp.getsearchEnter()));
		Reporter.log("Finding SearchBox to enter the Product name",true);
		hp.getSearchBox().sendKeys(lib.getExcelData(pathexcel, "TestData", 1, 0),Keys.ENTER);
		Reporter.log("Found Searchbox and Entered the Product name",true);
		
		WebDriverWait wait1=new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.titleContains("Apple IPhone XR (64GB) Black - Buy Products Online at Best Price in India - All Categories | Flipkart.com"));
		
		//Verify that the Product page is displayed

		String expProductPageTitle="Apple IPhone XR (64GB) Black - Buy Products Online at Best Price in India - All Categories | Flipkart.com".replace(" ", "");
		String actProductPageTitle=driver.getTitle().replace(" ", "");
		System.out.println(actProductPageTitle);
		boolean isDisplayedProductPage=expProductPageTitle.contains(actProductPageTitle);
		
		Assert.assertTrue(isDisplayedProductPage);
		Reporter.log("Product page is displayed successfully",true);
		
		//Step 6:Click on 'Apple iPhone XR (64GB) - Black' link in Product Page
		Reporter.log("Finding Mobile link in Product Page",true);
		mp.getSelectMobile().click();
		Reporter.log("Found Mobile Link in Product Page and Clicked",true);
		
		
		//Switch to Child Tab
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> i=windows.iterator();
		String pid=i.next();
		String cid=i.next();
		Reporter.log("Switching control to child window",true);
		driver.switchTo().window(cid);		
		Reporter.log("Control Switched to child window",true);
		
		WebDriverWait wait2=new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.titleContains("Apple iPhone XR ( 64 GB Storage, 0 GB RAM ) Online at Best Price On Flipkart.com"));
			
		//Verify that the Mobile Page is displayed
		String expMobilePageTitle="Apple iPhone XR ( 64 GB Storage, 0 GB RAM ) Online at Best Price On Flipkart.com".replace(" ", "");
		String actMobilePageTitle=driver.getTitle().replace(" ", "");
		boolean isDisplayedMobilePage=expMobilePageTitle.contains(actMobilePageTitle);
		
		Assert.assertTrue(isDisplayedMobilePage);
		Reporter.log("Mobile page is displayed  Successfully",true);
		
		//Step 7:Change Color of Selected Phone From 'Black' to 'Blue'
		Reporter.log("Finding Blue color button in Mobile Page",true);
		mp.getColor().click();
		Reporter.log("Found Blue color buttton in Mobile Page",true);
		WebDriverWait wait3=new WebDriverWait(driver, 20);
		wait3.until(ExpectedConditions.titleContains("Apple iPhone XR ( 64 GB Storage, 0 GB RAM ) Online at Best Price On Flipkart.com"));
		
		//Verify that the Mobile with 256GB storage is Selected
		String expStorageMobile="Apple iPhone XR ( 64 GB Storage, 0 GB RAM ) Online at Best Price On Flipkart.com".replace(" ", "");
		String actStorageMobile=driver.getTitle().replace(" ", "");
		boolean isDisplayedMobileStorage=expStorageMobile.contains(actStorageMobile);
		
		
		Assert.assertTrue(isDisplayedMobileStorage);
		Reporter.log("Blue Color Mobile is Selected Successfully",true);
		
		//Step 8:Click on 'Add To Cart' button in 'Apple iPhone XR (256GB) - Black' page
		Reporter.log("Finding Add to Cart button in Mobile Page");
		try
		{
			mp.getAddToCartButton().click();
		}
		catch(Throwable ob)
		{
			mp.getGoToCartButton().click();
		}
		Reporter.log("Found Add to Cart button in Mobile Page and Clicked",true);
		
		//Step 9:Verify Product added to cart Successfully 
		Reporter.log("Switching control to parent window",true);
		driver.switchTo().window(pid);		
		Reporter.log("Control Switched to parent window",true);
		driver.navigate().refresh();
		Reporter.log("Finding Cart button in Homepage",true);
		hp.getCartButton().click();
		Reporter.log("Found Cart button in HomePage",true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean isDisplayedCartProduct = false;
		for (int j = 0;  j< 3; j++) 
		{
			try
			{
				isDisplayedCartProduct=cp.getConfirmMobileColor().isDisplayed();
				break;
			}
			catch(Throwable e)
			{
				e.getMessage();
			}
		}
		
		Assert.assertTrue(isDisplayedCartProduct);
		Reporter.log("Product added to Cart Successfully",true);
		driver.navigate().back();
	}

}
