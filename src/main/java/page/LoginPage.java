package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

    public LoginPage(WebDriver driver) {
	this.driver = driver;
}

	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	WebElement userNameElement;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement passwordElement;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button")
	WebElement signinButton;

	public void insertUserName(String userName) {

		userNameElement.sendKeys(userName);
	}

	public void insertPassword(String password) {

		passwordElement.sendKeys(password);
	}

	public void clickSigninButton() {
		signinButton.click();
	}

}
