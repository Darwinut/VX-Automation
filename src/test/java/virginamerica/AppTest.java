package virginamerica;

import credentials.Credential;
import helpers.EmailGenerator;
import helpers.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static pageobjects.SignIn.*;
import static pageobjects.SignUp.*;

public class AppTest {

	WebDriver driver;
	protected WebDriverWait wait;

	// Generating unique emails every time for signup
	public static String signupEmail = "john+" + EmailGenerator.getCurrentTime() + "@google.com";

	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		//Check if parameter passed from TestNG is 'firefox'
		/*if (browser.equalsIgnoreCase("firefox")) {
			//create firefox instance
			System.setProperty("webdriver.firefox.marionette", "C:/Users/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}*/
		//Check if parameter passed as 'chrome'
		if (browser.equalsIgnoreCase("chrome")) {
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver", "C:/Users/Drivers/chromedriver.exe");

			// create chrome instance
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			SetUp.pageObjectinitation(driver);
			wait = new WebDriverWait(driver, 20);
		}
		/*//Check if parameter passed as 'Edge'
		else if (browser.equalsIgnoreCase("Edge")) {
			//set path to Edge.exe
			System.setProperty("webdriver.edge.driver", "C:/Users/Drivers/MicrosoftWebDriver.exe");
			//create Edge instance
			driver = new EdgeDriver();
		}*/ else {
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	// Test Case 1 - User Signs In Successfully
	@Test(priority = 1)
	public void SignInSuccess() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.virginamerica.com/");

		SignInButton.click();

		UserEmail.sendKeys(Credential.usernameCorrect);
		UserPassword.sendKeys(Credential.passwordCorrect);

		UserSignInButton.click();

		Assert.assertTrue(MyAccount.isDisplayed());
		System.out.println("Test1: Successful. User Signed in Successfully");

		SignOutButton.click();

		Assert.assertTrue(SignInButton.isEnabled());
		System.out.println("User Signed Out");
	}

	// Test Case 2 - User cannot sign in with incorrect password
	@Test(priority = 2)
	public void SignInFailure() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.virginamerica.com/");

		SignInButton.click();

		UserEmail.sendKeys(Credential.usernameCorrect);
		UserPassword.sendKeys(Credential.incorrectPassword);

		UserSignInButton.click();

		Assert.assertTrue(UserSignInButton.isDisplayed());
		System.out.println("Test2: Successful. User cannot sign in with incorrect password");
	}

	// Test Case 3 - New User Sign Up
	@Test(priority = 3)
	public void SignUpSuccess() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.virginamerica.com/");

		SignUpButton.click();

		Email.sendKeys(signupEmail);
		ConfirmedEmail.sendKeys(signupEmail);
		SignUpPassword.sendKeys(Credential.password);
		SignUpConfirmPassword.sendKeys(Credential.password);
		FirstName.sendKeys(Credential.firstName);
		LastName.sendKeys(Credential.lastName);
		Gender.sendKeys("Male");
		Month.sendKeys(Credential.month);
		Day.sendKeys(Credential.day);
		Year.sendKeys(Credential.year);
		Address.sendKeys(Credential.address);
		City.sendKeys(Credential.city);

		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByVisibleText("Canada");
		country.selectByIndex(2);

		State.sendKeys(Credential.state);
		ZIPCode.sendKeys(Credential.zip);

		Phone.sendKeys(Credential.phone);

		WebElement element = driver.findElement(By.xpath("//input[@type='checkbox'][@placeholder='Terms and Conditions']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
		SignUpFormButton.click();
		Assert.assertTrue(SignOutButton.isDisplayed());
		System.out.println("Test3: Successful. New user is signed up successfully");

		SignOutButton.click();
		Assert.assertTrue(SignInButton.isEnabled());
		System.out.println("User Signed Out");
	}
}
