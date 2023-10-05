package websitePanel;




import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




import utilityPackage.MyMethods;


public class SpinnWheels extends ParentWebsitePanel1  {
	
	
	
	@BeforeClass
	public void beforeMethod() throws InterruptedException  {
		
		MyMethods.signIn();
		Thread.sleep(5000);
		
	}
	
	
	
	@Test(dataProvider = "getTestDataFromXLS")
	public void testSpinWheels(int integerValue, String xpath) throws InterruptedException {
		
	    WebElement ip = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form/div[1]/input"));
	    ip.sendKeys(String.valueOf(integerValue)); // Convert integer to string here
	    WebElement spinnbtn = driver.findElement(By.xpath(xpath));
	    spinnbtn.click();
	    
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form/button")).click();
	    
	    // Create object of WebDriverWait class

	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

	   // Wait till the element is not visible

	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[1]/button")));
	    
	    String spinnwheelResult = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]")).getText();
	    Thread.sleep(20000);
	    System.out.println("Final Result is:-"+spinnwheelResult);
	    
	    String winResult="The Result is Win";
	    //String lossResult="The Result is Loss";
	    
	    if(spinnwheelResult == winResult) {
	    	
	    	System.out.println("User Win the Spin Wheel!");
	    	
	    }else {
	    	
	    	System.out.println("User Loss the Spin Wheel!");
	    }
	}
	
	@DataProvider
	public Object[][] getTestDataFromXLS() {
		
		return MyMethods.getTestData(tsa, "SpinnWheels");
	}
	

}	
		
		
	
	


