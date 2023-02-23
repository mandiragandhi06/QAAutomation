package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelUtilites.ExcelReader;

public class LoginTests {
	ExcelReader obj;
	WebDriver driver=null;
	Object[][] data = null;
	
	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	}
	
	@BeforeMethod
	public void browserSetup(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}
	
	@DataProvider(name="loginData")
	public Object[][] populateData() throws IOException{
		obj = new ExcelReader();
		data = obj.readData();
		//verify Data by print 
		System.out.println("***** Data *****");
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data[i].length;j++){
				System.out.println("data["+i+"]["+j+"]="+data[i][j]);
			}
		}
		return data;
	}
	
	@Test(dataProvider="loginData")
	public void signUpTests(String email,String firstname , String lastname, String password, String CompanyName, String CompanyAddress,String	Country,String	State,String City,String ZIP,String	OrgType
) throws InterruptedException{
		
		//Open Website
		driver.get("https://spec.atsspecsolutions.com/ ");
		//Click Log in option
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[20]/div/div[2]/div/div[2]/div[3]/div/div/div/button[1]/span[1]")).click();
		Thread.sleep(2000);
		
		//Fill page fields
		driver.findElement(By.name("email")).sendKeys(email);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[20]/div/div[2]/div/div[2]/div[4]/form/div/div/div[4]/div/div/div/input")).sendKeys(password);

		//Click Login button
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[20]/div/div[2]/div/div[2]/div[4]/form/div/div[2]/div[3]/button/span[1]")).click();
		Thread.sleep(6000);
		
		// Click new project button
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[20]/div/div[2]/div/div[2]/div[4]/form/div/div[2]/div[3]/button/span[1]")).click();
		
		// Create new project
		
		// Project Name		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[20]/div/div[2]/div[2]/div[1]/div/div/div/div/div/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(CompanyName);
		//Country Name
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[20]/div/div[2]/div/div[2]/div[4]/form/div/div/div[5]/button/span[1]")).sendKeys(Country);
		//Province Name
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[20]/div/div[2]/div/div[2]/div[4]/form/div/div/div[4]/div/div/div/input")).sendKeys(State);
		// City name
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[20]/div/div[2]/div/div[2]/div[4]/form/div/div/div[4]/div/div/div/input")).sendKeys(City);
		// Address
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[20]/div/div[2]/div[2]/div[1]/div/div/div/div/div/div/form/div[1]/div[1]/div/div/div/input")).sendKeys(CompanyAddress);
		//Bid Date
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[20]/div/div[2]/div/div[2]/div[4]/form/div/div/div[4]/div/div/div/input")).sendKeys("2022-04-20");
		//Area
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[20]/div/div[2]/div/div[2]/div[4]/form/div/div/div[4]/div/div/div/input")).sendKeys("1000");
		
		//Click Next
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[20]/div/div[2]/div[2]/div[1]/div/div/div/div/div/div/form/div[2]/button[2]/span[1]")).click();
		
		//Select building
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[20]/div/div[2]/div/div[2]/div[4]/form/div/div[2]/div[3]/button/span[1]")).click();
		
		//Select bbuiiding type
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[20]/div/div[2]/div/div[2]/div[3]/div/div/div/button[1]/span[1]")).click();
		
		//Click Next
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[20]/div/div[2]/div[2]/div[1]/div/div/div/div/div/div/form/div[2]/button[2]/span[1]")).click();	
		
		//Click FInish
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[20]/div/div[2]/div[2]/div[1]/div/div/div/div/div/div/form/div[2]/button[2]/span[1]")).click();	
		System.out.println("Project created  Successfully !!");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}
