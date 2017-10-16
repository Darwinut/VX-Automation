package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignIn {

	@FindBy(xpath = "//a[text()='Sign In']")
	public static WebElement SignInButton;

	@FindBy(xpath = "//input[@placeholder='Email or Elevate #']")
	public static WebElement UserEmail;

	@FindBy(xpath = "//input[@placeholder='Password']")
	public static WebElement UserPassword;

	@FindBy(css = "button.btn.btn-lg.btn-block.btn-alt-primary")
	public static WebElement UserSignInButton;

	@FindBy(xpath = "//a[text()='My Account']")
	public static WebElement MyAccount;

	@FindBy(xpath = "//a[text()='Sign Out']")
	public static WebElement SignOutButton;
}
