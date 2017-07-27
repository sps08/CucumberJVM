package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.Constants;

public class Contact {
	
	public WebDriver driver;
	
	@FindBy(how= How.XPATH , using = Constants.anyText)
	public WebElement txtAddress;
	
	@FindBy(how= How.ID , using = Constants.FirstName)
	public WebElement FirstName;
	
	@FindBy(how= How.ID , using = Constants.LastName)
	public WebElement LastName;

	@FindBy(how= How.NAME , using = Constants.Email)
	public WebElement Email;
	
	@FindBy(how= How.XPATH , using = Constants.Phone)
	public WebElement Phone;

	@FindBy(how= How.NAME , using = Constants.Inquiry)
	public WebElement Inquiry;
		
	@FindBy(how= How.ID , using = Constants.Company)
	public WebElement Company;

	@FindBy(how= How.ID , using = Constants.Description)
	public WebElement Description;
	
	@FindBy(how= How.XPATH , using = Constants.Submit)
	public WebElement btnSubmit;
	
	public Contact(WebDriver dr){
		driver=dr;
		PageFactory.initElements(driver,this);
	}
	
	public void FillSubmitForm() throws IOException{
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(Constants.CONFIG_FILE_PATH);
		
		prop.load(fis);
		
		FirstName.sendKeys(prop.getProperty("fname"));
		LastName.sendKeys(prop.getProperty("lname"));
		Email.sendKeys(prop.getProperty("email"));
		Phone.sendKeys(prop.getProperty("phone"));
		Select dd = new Select(Inquiry);
		dd.selectByValue(prop.getProperty("inquiry"));
		Company.sendKeys(prop.getProperty("company"));
		Description.sendKeys(prop.getProperty("desc"));	
	}
			
	public void ClickSubmitBtn() throws IOException{
		btnSubmit.click();
	}
	
	public String ContactText(){
		return txtAddress.getText();
	}
}
