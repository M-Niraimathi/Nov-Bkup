package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Definition {

WebDriver driver;
@Given("^Login application should be launched$")
public void login_application_should_be_launched()  {
    // Write code here that turns the phrase above into concrete actions
	  System.setProperty("webdriver.chrome.driver", "C:\\Manipal\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
    
}

@When("^to validate login with valid credentials$")
public void to_validate_login_with_valid_credentials() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	 driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  driver.findElement(By.id("btnLogin")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("welcome")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
	  Thread.sleep(3000);
}

@Then("^Login should be successful$")
public void login_should_be_successful()  {
    // Write code here that turns the phrase above into concrete actions
	String Expectedtitle = "OrangeHRM";
	String ActualTitle = driver.getTitle();
	Assert.assertEquals(Expectedtitle, ActualTitle);
	
	System.out.println("done");
	driver.close();
	   
}
}
