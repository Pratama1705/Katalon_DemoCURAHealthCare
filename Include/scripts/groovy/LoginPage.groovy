import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import java.util.concurrent.TimeUnit

class LoginPage {
	WebDriver driver
	String result = '';

	@Given("I open website page and navigate to login page")
	def openWebsiteNavigateLoginPage() {
		// Set driver chrome
		System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverPath())
		driver = new ChromeDriver()
		driver.manage().window().maximize()

		// Go to url website
		driver.get('https://katalon-demo-cura.herokuapp.com/')

		// Wait implicity
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Click icon sidebar toggle
		driver.findElement(By.xpath('//a[@id="menu-toggle"]')).click()

		// Wait implicity
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		// Click login hyperlink
		driver.findElement(By.xpath('//a[text()="Login"]')).click()

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("I input username (.*) or password (.*) with incorrect value")
	def inputFailUsernamePassword(String username, String password) {
		// Input Username
		driver.findElement(By.xpath('//input[@id="txt-username"]')).sendKeys(username);

		// Input Password
		driver.findElement(By.xpath('//input[@id="txt-password"]')).sendKeys(password);

		// Waiting
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Click Login
		driver.findElement(By.xpath('//button[@id="btn-login"]')).click();
	}

	@Then("I see validation not able to login")
	def verifyFailedLogin() {
		// Verify Text Failed is Shown
		Boolean textFailed = driver.findElement(By.xpath('//p[contains(text(), "Login failed!")]')).isDisplayed();

		// Logic True/False
		if (textFailed) {
			result = "PASS";
		} else {
			result = "FAILED";
		}

		// Assertion
		assert(result == "PASS");

		result = '';
		driver.quit();
	}

	@When("I input username (.*) and password (.*) with correct value")
	def inputUsernamePassword(String username, String password) {
		driver.findElement(By.xpath('//input[@id="txt-username"]')).sendKeys(username);

		driver.findElement(By.xpath('//input[@id="txt-password"]')).sendKeys(password);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath('//button[@id="btn-login"]')).click();
	}

	@Then("I successfully login")
	def verifySuccessLogin() {
		Boolean textSuccess = driver.findElement(By.xpath('//section[@id="appointment"]/div/div/div/h2')).isDisplayed();

		// Logic True/False
		if (textSuccess) {
			result = "PASS";
		} else {
			result = "FAILED";
		}

		// Assertion
		assert(result == "PASS");

		result = '';
		driver.quit();
	}
}