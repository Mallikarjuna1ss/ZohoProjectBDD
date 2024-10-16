package StepDefinationfile;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ZohoHomePageSteps {
	private static WebDriver driver;
	private static WebDriverWait wait;

	public ZohoHomePageSteps() {
	}

	@BeforeAll
	public static void setUp() {
		// Automatically setup the ChromeDriver
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Set your desired timeout
		driver.manage().window().maximize();

	}

	@AfterAll
	public static void tearDown() {
		// Close the browser and clean up
		if (driver != null) {
			driver.quit(); // Close the browser
		}
	}

	@Given("the user is on the Zoho homepage")
	public void userIsOnZohoHomepage() {

		driver.get("https://www.zoho.com/");
	}

	@Then("the user checks the top menu bar")
	public void userChecksTopMenuBar() {
		// Locate the top menu bar using its ID or other locators
		WebElement topMenuBar = driver.findElement(By.id("header")); // Ensure the ID is correct
		// Assert that the top menu bar is displayed
		Assert.assertTrue("Top menu bar is not displayed", topMenuBar.isDisplayed());
		System.out.println("Top menu bar is displayed correctly.");

	}

	@Given("I am on the homepage")
	public void i_am_on_the_homepage() throws Exception {
		driver.get("https://www.zoho.com/");
		Thread.sleep(3000);
	}

	@When("I click on the {string} button")
	public void i_click_on_the_button(String button) throws InterruptedException {
		driver.findElement(By.xpath("//li[normalize-space()='Products']")).click();
		Thread.sleep(3000);

		if (button.equals("Products")) {
			WebElement productsButton = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".zwc-all-product.active")));
			productsButton.isEnabled();
		}

	}

	@Then("I should see the products menu expanded")
	public void i_should_see_the_products_menu_expanded() throws InterruptedException {

		WebElement productsMenu = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".zwc-tab-category")));
		Assert.assertTrue("product menu is not displayed", productsMenu.isDisplayed());
	}

	@When("I click on the {string} link")
	public void i_click_on_the_link(String link) {
		if (link.equals("Customers")) {
			WebElement customersLink = driver.findElement(By.linkText("Customers"));
			customersLink.isEnabled();
			customersLink.click();
		}
	}

	@Then("I should be navigated to the {string} page")
	public void i_should_be_navigated_to_the_page(String page) {
		String expectedUrl = "https://www.zoho.com/" + page;
		Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));
	}

	@When("I expand the {string} dropdown")
	public void i_expand_the_dropdown(String dropdown) throws InterruptedException {
		if (dropdown.equals("Company")) {
			WebElement companyDropdown = driver.findElement(By.cssSelector(".zwc-company-dropdown"));
			companyDropdown.click();
		} else if (dropdown.equals("More Links")) {

			WebElement moreLinksDropdown = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".zwc-more-links")));
			moreLinksDropdown.click();
		}
	}

	@Then("I should see the following options:")
	public void i_should_see_the_following_options(DataTable options) {
		List<String> expectedOptions = options.asList(String.class);
		List<WebElement> actualOptions = driver
				.findElements(By.cssSelector(".zwc-company-lists li a, .zwc-more-link-list li a"));

		// Filter out empty options from actualOptions
		List<String> actualOptionTexts = actualOptions.stream().map(WebElement::getText)
				.filter(text -> !text.trim().isEmpty()) // Exclude empty or whitespace-only options
				.collect(Collectors.toList());

		// Print expected and actual options for debugging
		System.out.println("Expected options: " + expectedOptions);
		System.out.println("Actual options: " + actualOptionTexts);

		// Check if the number of expected and actual options match
		Assert.assertEquals("Mismatch in number of expected and actual options", expectedOptions.size(),
				actualOptionTexts.size());

		// Verify each option
		for (int i = 0; i < expectedOptions.size(); i++) {
			String expected = expectedOptions.get(i).trim();
			String actual = actualOptionTexts.get(i).trim();
			Assert.assertTrue("Option mismatch: Expected [" + expected + "] but found [" + actual + "]",
					actual.equalsIgnoreCase(expected));
		}
	}

	@When("I look for the {string} button")
	public void i_look_for_the_button(String buttonName) {
		WebElement button = driver.findElement(By.xpath("//a[normalize-space()='" + buttonName + "']"));
		Assert.assertTrue(buttonName + " button is not visible", button.isDisplayed());
	}

	@Then("the {string} button should be visible")
	public void the_button_should_be_visible(String buttonName) throws InterruptedException {
		WebElement button = driver.findElement(By.xpath("//a[normalize-space()='" + buttonName + "']"));
		button.isEnabled();
		Assert.assertTrue(buttonName + " button is not visible", button.isDisplayed());
	}

	@When("I click on the {string} icon1")
	public void i_click_on_the_icon1(String iconName) {
		WebElement icon = null;
		switch (iconName) {
		case "Search":
			icon = driver.findElement(By.cssSelector(".zgh-search-icon")); // Update with actual selector for search
																			// icon
			break;
		case "Notification":
			icon = driver.findElement(By.cssSelector(".notification-icon")); // Update with actual selector for
																				// notification icon
			break;
		}

		if (icon != null) {
			icon.click();
			wait.until(ExpectedConditions.visibilityOf(icon)); // Wait for the icon action to complete
		} else {
			Assert.fail("Icon not found: " + iconName);
		}
	}

	@Then("the search bar should be displayed")
	public void the_search_bar_should_be_displayed() {
		// Wait for the search bar to be visible
		WebElement searchBar = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[aria-label='Zoho Search']")));

		// Assert that the search bar is displayed
		Assert.assertTrue("Search bar is not displayed", searchBar.isDisplayed());
		System.out.println("Search bar is displayed correctly.");
	}

	@When("I click on the {string} icon")
	public void i_click_on_the_icon(String iconName) {
		WebElement notificationIcon;

		if (iconName.equalsIgnoreCase("Notification")) {
			// Update the selector to match the actual notification icon
			notificationIcon = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".zgh-announcement-icon")));
		} else {
			throw new IllegalArgumentException("Icon not recognized: " + iconName);
		}

		notificationIcon.click();
		System.out.println("Clicked on the " + iconName + " icon.");
	}

	@Then("the notifications panel should be displayed")
	public void the_notifications_panel_should_be_displayed() {
		// Ensure you are waiting for the panel to be visible
		WebElement notificationPanel = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".zgh-announcement-container"))); // Update
																														// this
																														// selector
																														// as
																														// needed

		Assert.assertTrue("Notifications panel is not displayed", notificationPanel.isDisplayed());
		System.out.println("Notifications panel is displayed.");
	}

}
