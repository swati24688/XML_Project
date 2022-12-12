package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;

	@Test
	@Parameters({"userName", "password", "dashboardHeaderText"})
	public void validUserShouldAbleToLogin(String userName, String password, String DashboardValidationText) {

		driver = BrowserFactory.init();
// create and object using pageFactory.initElements and pass WebDriver
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(DashboardValidationText);

		BrowserFactory.tearDown();
	}

}
