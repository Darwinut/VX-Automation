package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SetUp {
	public static void pageObjectinitation(WebDriver driver) {
		PageFactory.initElements(driver, pageobjects.SignUp.class);
		PageFactory.initElements(driver, pageobjects.SignIn.class);
	}
}
