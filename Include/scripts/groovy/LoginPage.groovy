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

class LoginPage {
	@Given("I open website page and navigate to login page")
	def openWebsiteNavigateLoginPage() {
		WebUI.openBrowser('')

		WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

		WebUI.click(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Login/iconToggleSidebar'))

		WebUI.click(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Login/loginHyperlinkSidebar'))
	}

	@When("I input username (.*) or password (.*) with incorrect value")
	def inputFailUsernamePassword(String username, String password) {
		WebUI.setText(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Login/usernameFieldLoginPage'), username)

		WebUI.setText(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Login/passwordFieldLoginPage'), password)

		WebUI.click(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Login/buttonLogin'))
	}

	@Then("I see validation not able to login")
	def verifyFailedLogin() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Login/textValidationFailedLogin'))
	}

	@When("I input username (.*) and password (.*) with correct value")
	def inputUsernamePassword(String username, String password) {
		WebUI.setText(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Login/usernameFieldLoginPage'), username)

		WebUI.setText(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Login/passwordFieldLoginPage'), password)

		WebUI.click(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Login/buttonLogin'))
	}

	@Then("I successfully login")
	def verifySuccessLogin() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Login/textValidationSucessLogin'))

		WebUI.closeBrowser()
	}
}