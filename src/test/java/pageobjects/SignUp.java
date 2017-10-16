package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUp {

	@FindBy(xpath = "//a[text()='Sign Up']")
	public static WebElement SignUpButton;

	@FindBy(xpath = "//input[@placeholder='Email']")
	public static WebElement Email;

	@FindBy(xpath = "//input[@placeholder='Confirm Your Email']")
	public static WebElement ConfirmedEmail;

	@FindBy(xpath = "//input[@placeholder='Password']")
	public static WebElement SignUpPassword;

	@FindBy(xpath = "//input[@placeholder='Confirm Your Password']")
	public static WebElement SignUpConfirmPassword;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	public static WebElement FirstName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	public static WebElement LastName;

	@FindBy(id = "gender")
	public static WebElement Gender;

	@FindBy(id = "select--date-month")
	public static WebElement Month;

	@FindBy(id = "select--date-day")
	public static WebElement Day;

	@FindBy(id = "select--date-year")
	public static WebElement Year;

	@FindBy(xpath = "//input[@placeholder='Address 1']")
	public static WebElement Address;

	@FindBy(xpath = "//input[@placeholder='City']")
	public static WebElement City;

	@FindBy(id = "stateSelect")
	public static WebElement State;

	@FindBy(xpath = "//input[@placeholder='ZIP Code']")
	public static WebElement ZIPCode;

	@FindBy(xpath = "//input[@placeholder='Phone number']")
	public static WebElement Phone;

	@FindBy(xpath = "//button[contains(text(),'\n" + "    All done. Sign me up!\n" + "    ')]")
	public static WebElement SignUpFormButton;

}
