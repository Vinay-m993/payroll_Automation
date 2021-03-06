package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashBoardPage;
import pages.LoginPage;
import utilities.ExcelDataUtil;

public class LoginTest extends ExcelDataUtil {

	/*
	 * @DataProvider(name="userCredential") public Object[][] userCredential() {
	 * Object[][] data=new Object[2][2]; data[0][0]="carol"; data[0][1]="1q2w3e4r";
	 * 
	 * data[1][0]="alexa"; data[1][1]="1q2w3e4r";
	 * 
	 * return data; }
	 * 
	 * @Test(dataProvider="userCredential") public void verifyCredential(String
	 * username, String password) { LoginPage credential=new LoginPage(driver);
	 * credential.enterUsername(username); credential.enterPassword(password);
	 * credential.clickonLogin(); }
	 */

	// @Test(dataProvider = "readExcel")
	public void verifyLoginCredentials(String userName, String userPassword) {
		LoginPage login = new LoginPage(driver);
		login.userCredentials(userName, userPassword);
	}

	// @Test
	public void verifyUsernameText() {
		LoginPage login = new LoginPage(driver);
		String Act = login.getUserNameText();
		String Exp = "Username";
		Assert.assertEquals(Act, Exp, "Invalid username text");
	}

	// @Test
	public void verifyPasswordText() {
		LoginPage login = new LoginPage(driver);
		String ExpPasswordText = "Password";
		String ActPasswordText = login.getPasswordText();
		Assert.assertEquals(ActPasswordText, ExpPasswordText);
	}

	// @Test
	public void verifyRememberText() {
		LoginPage login = new LoginPage(driver);
		String Actual = login.getRemembermeText();
		String Exp = "Remember Me";
		Assert.assertEquals(Actual, Exp, "Invalid Remember Text");
	}

	// @Test
	public void verifyResetText() {
		LoginPage login = new LoginPage(driver);
		String Actual = login.getResetText();
		String Exp = "reset it";
		Assert.assertEquals(Actual, Exp, "Invalid Reset Text");
	}

	// @Test
	public void verifyCheckboxClicked() {
		LoginPage login = new LoginPage(driver);
		login.clickonLogin();
		Boolean result = login.isLoginPageCheckboxClicked();
		Assert.assertTrue(result, "Button is not clicked");
	}

	// @Test
	public void verifyResetLink() {
		LoginPage login = new LoginPage(driver);
		login.ClickonReset();
	}

	// @Test
	public void verifyElementIsClickable() {
		LoginPage login = new LoginPage(driver);
		login.isElementClickable();
	}

	// @Test(dataProvider = "readExcel")
	public void verifyValidLogin(String name, String password) throws Exception {
		LoginPage login = new LoginPage(driver);
		login.userCredentials(name, password);
		DashBoardPage dashboard = new DashBoardPage(driver);
		String ActText = dashboard.getHeaderTitle();
		String ExpText = "Payroll Application";
		Assert.assertEquals(ActText, ExpText, "Login Failure");

	}

}
