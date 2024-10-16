package StepDefinationfile;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignInPageStepDefination {

	private WebDriver driver;
	private WebDriverWait wait;

	public SignInPageStepDefination() {
	}

	@Before
	public void setUp() {
		if (driver == null) {
			// Automatically setup the ChromeDriver
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set your desired timeout
			driver.manage().window().maximize();
			driver.get("https://www.zoho.com/");
		}

	}

	@After
	public void tearDown() throws InterruptedException {

		if (driver != null) {
			Thread.sleep(3000);
			driver.close(); // Close the browser
			driver = null;
		}

	}

	@Given("the user is in the Zoho homepage")
	public void userIsinZohoHomepage() {
		System.out.println("User is on the Zoho homepage");

	}

	@When("the user clicks on the Sign In button")
	public void userClicksOnSignInButton() {

		WebElement signInButton = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@class='zgh-login'][normalize-space()='Sign In']")));
		signInButton = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
		signInButton.click();
	}

	@And("the user enters the username")
	public void userEntersTheUsername() {
		WebElement usernameField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login_id']")));
		usernameField.clear();
		usernameField.sendKeys("mallu155188@gmail.com"); // Replace with the actual username or fetch it from a
															// configuration file
	}

	@And("the user clicks on the Next button")
	public void userClicksOnNextButton() {
		WebElement nextButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='nextbtn']")));
		nextButton.click();
	}

	@And("the user enters the password")
	public void userEntersThePassword() {
		WebElement passwordField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		passwordField.clear();
		passwordField.sendKeys("4jn15cv039"); // Replace with the actual password or fetch it from a
												// configuration file
	}

	@And("the user clicks on the Final Sign In button")
	public void userClicksOnFinalSignInButton() {
		WebElement signInButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='nextbtn']")));
		signInButton.click();
	}

	@Then("the user should be redirected to the Zoho dashboard page")
	public void the_user_should_be_redirected_to_the_zoho_dashboard_page() {
		String expectedTitle = "Zoho Home";
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleIs(expectedTitle));

		String expectedURL = "https://home.zoho.in/home";
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(expectedURL));

	}

}
