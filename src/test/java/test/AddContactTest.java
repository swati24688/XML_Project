package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddContactTest {

	WebDriver driver;

	@Test
	@Parameters({ "userName", "password", "dashboardHeaderText", "fullName", "companyName", "email", "phone", "address",
			"city", "country", "states", "zip" })
	public void userShouldBeAbleToAddCustomer(String userName, String password, String DashboardValidationText,
			String fullName, String companyName, String email, String phone, String address, String city,
			String country, String states, String zip) throws InterruptedException {

		driver = BrowserFactory.init();

//		phone = "" + (Math.random() * Math.pow(10, 10));
		LoginPage LogInPage = PageFactory.initElements(driver, LoginPage.class);

		LogInPage.insertUserName(userName);
		LogInPage.insertPassword(password);
		LogInPage.clickSigninButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(DashboardValidationText);
		dashboardPage.clickCustomersButton();
		dashboardPage.clickAddCustomerButton();

		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
		addContactPage.insertFullName(fullName);
		addContactPage.selectCompany(companyName);
		addContactPage.insertEmail(email);
		addContactPage.insertPhoneNum(phone);
		addContactPage.insertaddress(address);
		addContactPage.insertCity(city);
		addContactPage.insertState(states);
		addContactPage.insertZip(zip);
		addContactPage.selectCountry(country);
		addContactPage.clickSaveButton();
        dashboardPage.clickListCustomerButton();
        addContactPage.insertSearchBoxListCustomer();
        addContactPage.validateInsertNameAndDelete();
        addContactPage.validateInsertedNameOnSearchBarAndProfile();
        
	}

}
