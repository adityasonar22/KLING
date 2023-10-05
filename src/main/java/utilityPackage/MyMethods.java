package utilityPackage;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import basePackage.BaseInit;

	public class MyMethods extends BaseInit {
		
		public static void signIn() throws InterruptedException {
			
			driver.get(sitedata.getProperty("url"));
			logs.info("User URL is loaded");
			
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div/div/div/button[1]")).click(); 
			logs.info("Key is Entered");
			
			driver.findElement(By.xpath("//*[@id=\"controlled-tab-example-tabpane-login\"]/form/div[1]/input")).sendKeys("adityajetester@gmail.com");
			logs.info("User email address entered");
			
			
			driver.findElement(By.xpath("//*[@id=\"controlled-tab-example-tabpane-login\"]/form/div[2]/input")).sendKeys("Aditya@123");
			logs.info("User password entered");
			
			driver.findElement(By.xpath("//*[@id=\"controlled-tab-example-tabpane-login\"]/form/button[2]")).click();
			logs.info("User Login Successfully");
			Thread.sleep(2000);
			
			driver.findElement(By.linkText("Spin Wheel")).click();
			Thread.sleep(10000);
			
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/form/div[1]/input")).clear();
			Thread.sleep(1000);
		}
		
		public static void signOUT() {
			
			
		}
		
		
		public static Object[][] getTestData(ExcelFileReader data, String sheetName) {
		    List<List<Object>> testData = new ArrayList<>();
		    List<Integer> integers = data.readIntegers(sheetName, 0); // Integers in the first column
		    List<String> xpaths = data.readXPaths(sheetName, 1); // Xpaths in the second column

		    int size = Math.min(integers.size(), xpaths.size());

		    for (int i = 0; i < size; i++) {
		        List<Object> rowData = new ArrayList<>();
		        rowData.add(integers.get(i));
		        rowData.add(xpaths.get(i));
		        testData.add(rowData);
		    }

		    Object[][] myData = new Object[testData.size()][2]; // 2 columns: integer and xpath

		    for (int i = 0; i < testData.size(); i++) {
		        myData[i] = testData.get(i).toArray();
		    }

		    return myData;
		}
		
		
		/*
		public Object[][] getTestData() {
		    ExcelFileReader data = new ExcelFileReader("./src/main/resources/testInformation/websitePanel.xlsx");
		    List<Integer> integers = data.readIntegers("SpinnWheels", 0); // Integers in the first column
		    List<String> xpaths = data.readXPaths("SpinnWheels", 1); // Xpaths in the second column

		    int size = Math.min(integers.size(), xpaths.size());

		    Object[][] testData = new Object[size][2]; // 2 columns: integer and xpath

		    for (int i = 0; i < size; i++) {
		        testData[i][0] = integers.get(i);
		        testData[i][1] = xpaths.get(i);
		    }

		    data.close();

		    return testData;
		}
		*/
		
	}	
		
	
		
	




