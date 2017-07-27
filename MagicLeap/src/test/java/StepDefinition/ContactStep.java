package StepDefinition;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import Pages.PageLoad;
import Utilities.Constants;
import cucumber.api.Scenario;
import cucumber.api.java8.En;

public class ContactStep implements En {
	
	public static WebDriver driver;
//Pages.Contact cs;
	PageLoad pL;
	public Scenario scenario;
	ArrayList<Long> pageLoadList;
	
	public ContactStep() {
		
	Given("^open Chrome and start Web Application$", () -> {
		driver = Hook.getDriver();
		scenario = Hook.getScenario();
		driver.get(Constants.testUrl);
	});

	And("^navigate to Contact Page$", () -> {
		driver.navigate().to(Constants.ContactURL);
		scenario.write("User successfully navigate to Contact Page");
	});

	Then("^user is on the contact page and verify contact address$", () -> {
		String expectedText= "7500 west sunrise boulevard / plantation / florida / 33322";
		String concText = Hook.cs.ContactText();
		Assert.assertTrue("User is on Contact page and Contact address is available", concText.equals(expectedText));
		scenario.write("User successfully validated the Contact address");
	});

	Then("^Fill all the required contact fields$", () -> {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)","");
		try {
			Hook.cs.FillSubmitForm();
			scenario.write("User successfully Filled the Contact form");
		} catch (IOException e) {
			e.printStackTrace();
			//takeScreenshot
		}
	});

	Then("^Perform Submit Action$", () -> {
	    try {
		   Hook.cs.ClickSubmitBtn();
		   scenario.write("User successfully submitted the Contact Page");
		} catch (IOException e) {
			e.printStackTrace();	
			//Take ScreenShot
		}
	});

	Then("^user should be able to submit successfully$", () -> {
		Boolean isPresent = driver.findElements(By.xpath("//div[@class='subscribe']//a")).size()>0;
		if(isPresent){
			driver.findElements(By.xpath("//div[@class='subscribe']//a")).get(0).click();
			scenario.write("Contact page has been submitted and user is moved to the Home page");
		}else{
			scenario.write("Kindly check Something wrong in the Code");
		}
	});
	
	//Scenario 2
	Given("^User is on the contact page$", () -> {
		 driver = Hook.getDriver();
   		 driver.get(Constants.testUrl);
   		 driver.navigate().to(Constants.ContactURL);
   		 scenario = Hook.getScenario();
   		 System.out.println(scenario);
		 scenario.write("User is on Contact Screen");
	});

	Then("^Wrong Contact address is available to the user \"([^\"]*)\"$", (String text) -> {
		String value = Hook.cs.ContactText();
		if (value==text){
			scenario.write("Contact address is not matching with address "+ text);
		}
		else{
			scenario.write("Contact address is matching with address "+text);
		}
	});
	
	Given("^Hit \"([^\"]*)\" (\\d+) times$", (String urlString, Integer repeat) -> {
		pL = new PageLoad();
		scenario = Hook.getScenario();
		System.out.println(scenario);
		
		try {
			pageLoadList = pL.getresponse(urlString,repeat);
			scenario.write("User successfully Hit the URL "+repeat+ "  times");
		} catch (IOException e) {
			e.printStackTrace();
			scenario.write("User is not able te Hit tje Url" + e);
		}
	});
     
	Then("^Generate report with MIN, MAX and AVERAGE Time$", () -> {
		String Result = pL.pageLoadTimes(pageLoadList);
		scenario.write(Result);
	});
	}
}

