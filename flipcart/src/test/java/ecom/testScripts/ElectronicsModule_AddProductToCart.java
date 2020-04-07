package ecom.testScripts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ecom.genericLibrary.Base;

@Listeners(ecom.genericLibrary.EventListeners.class)
public class ElectronicsModule_AddProductToCart extends Base{
	
	@Test
	public void addIphoneToCartTest()
	{	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"));
		//Pre-condition:Delete if same product already exist in cart
		driver.navigate().refresh();
		Reporter.log("Finding Cart Button in HomePage",true);
		hp.getCartButton().click();
		Reporter.log("Found Cart Button in HomePage and Clicked",true);
		try
		{
			if(cp.getConfirmMobile().isDisplayed())
			{
				Reporter.log("Finding Remove Product From Cart Link",true);
				cp.getRemoveProductFromCart().click();
				Reporter.log("Found Remove Product From Cart Link and Clicked",true);
				Reporter.log("Finding Confirm Removing Of Product From Cart Link",true);
				cp.getConfirmRemovingProduct().click();
				Reporter.log("Found Confirm Removing Of Product Ffrom Cart Link and Clicked",true);
			}
		}
		catch(Throwable ob)
		{
			Reporter.log("Product not Present in Cart",true);
		}
		
		//Pre-Condition:Count Of Products in Cart Before Adding a Product
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int noOfItemsInCartBeforeAdding=0;
		try
		{
		Reporter.log("Finding NumberOfProducts Details in Cart Page",true);
		String[] noOfItemsDetails=cp.getNoOfProductsDetails().getText().split(" ");
		Reporter.log("Found NumberOfProducts Details in Cart Page and gotText",true);
		String[] noOfItemsBeforeAdding=noOfItemsDetails[1].split("");
		noOfItemsInCartBeforeAdding=Integer.parseInt(noOfItemsBeforeAdding[1]);
		System.out.println("Number Of Products in Cart Before Adding a Product is:"+noOfItemsInCartBeforeAdding);
		}
		catch(Throwable ob)
		{
			noOfItemsInCartBeforeAdding=0;
			System.out.println("Cart is empty");
		}
		
		//Step 5:Enter 'Apple iPhone XR (64GB) - Black' into Search Box and click enter
		Reporter.log("Finding SearchBox to enter the Product name",true);
		hp.getSearchBox().sendKeys(lib.getExcelData(pathexcel, "TestData", 1, 0),Keys.ENTER);
		Reporter.log("Found Searchbox and Entered the Product name",true);
		
		WebDriverWait wait1=new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.titleContains("Apple IPhone XR (64GB) Black - Buy Products Online at Best Price in India - All Categories | Flipkart.com"));
		//Verify that the product page is displayed successfully
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
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//Switch to Child Tab
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> i=windows.iterator();
		String pid=i.next();
		String cid=i.next();
		driver.switchTo().window(cid);		
		
		WebDriverWait wait2=new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.titleContains("Apple iPhone XR ( 64 GB Storage, 0 GB RAM ) Online at Best Price On Flipkart.com"));
		
		//Verify that the Mobile Page is displayed
		String expMobilePageTitle="Apple iPhone XR ( 64 GB Storage, 0 GB RAM ) Online at Best Price On Flipkart.com".replace(" ", "");
		String actMobilePageTitle=driver.getTitle().replace(" ", "");
		boolean isDisplayedMobilePage=expMobilePageTitle.contains(actMobilePageTitle);
		
		Assert.assertTrue(isDisplayedMobilePage);
		Reporter.log("Mobile page is displayed  Successfully",true);
		
		
		//Step 7:Click on 'Add To Cart' button in 'Apple iPhone XR (64GB) - Black' page
		Reporter.log("Finding Add to Cart button in Mobile Page");
		mp.getAddToCartButton().click();
		Reporter.log("Found Add to Cart button in Mobile Page and Clicked",true);
		
		//Step 8:Verify that Product added to Cart Successfully
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int noOfItemsInCartAfterAdding=0;
		try 
		{	
		Reporter.log("Finding NumberOfProducts Details in Cart Page after adding a product",true);
		String[] noOfItemsDetails=cp.getNoOfProductsDetails().getText().split(" ");
		Reporter.log("Found NumberOfProducts Details in Cart Page After adding a Product",true);
		String[] noOfItemsAfterAdding=noOfItemsDetails[1].split("");
		noOfItemsInCartAfterAdding=Integer.parseInt(noOfItemsAfterAdding[1]);
		System.out.println("Number Of Products in Cart After Adding a Product is:"+noOfItemsInCartAfterAdding);
		}
		catch(Throwable ob)
		{
			Reporter.log("Product not added to the Cart",true);
		}
		
		Assert.assertEquals(noOfItemsInCartBeforeAdding+1, noOfItemsInCartAfterAdding);
		Reporter.log("Product added to cart Successfully",true);
		driver.navigate().back();
		
	}

}
