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

class successMakeAppointment {
	@Given("I open browser and navigate to website")
	def openBrowserNavigateWebsite() {
		WebUI.openBrowser('')
		
		WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')
	}

	@Then("I login in that website with username (.*) and password (.*)")
	def loginToWebsite(String username, String password) {
		WebUI.click(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Login/iconToggleSidebar'))

		WebUI.click(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Login/loginHyperlinkSidebar'))
	
		WebUI.setText(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Login/usernameFieldLoginPage'), username)
		
		WebUI.setText(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Login/passwordFieldLoginPage'), password)

		WebUI.click(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Login/buttonLogin'))
	
		WebUI.verifyElementVisible(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Login/textValidationSucessLogin'))
	}

	@When("I select a value (.*) in dropdown facility field")
	def selectFacilityValue(String facility) {
		WebUI.selectOptionByValue(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Appointment/selectFacilityDropdown'), facility, true)
	}
	
	@And("I figure it out to select hospital readmission checklist (.*)")
	def conditionCheckReadmission(String readmission) {
		if (readmission == 'Y') {
			WebUI.click(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Appointment/applyReadmission'))
		}
	}
	
	@And("I select a value (.*) radio button Healthcare Program")
	def selectRadioButtonHealthProgram(String healthcare_program) {
		if (healthcare_program == 'radio_program_medicaid') {
			WebUI.click(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Appointment/radioHealthcareProgramMedicaid'))
		} else if (healthcare_program == 'radio_program_medicare') {
			WebUI.click(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Appointment/radioHealthcareProgramMedicare'))
		} else if (healthcare_program == 'radio_program_none') {
			WebUI.click(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Appointment/radioHealthcareProgramNone'))
		} 
	}
	
	@And("I input visit schedule and set date")
	def inputScheculeVisit() {
		WebUI.click(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Appointment/visitScheduleDate'))
		
		WebUI.click(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Appointment/clickDateVisit'))
	}
	
	@And("Write a comment")
	def writeComment() {
		WebUI.setText(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Appointment/inputComment'), 'test')
	}
	
	@And("Click Book Appointment button")
	def bookAppointment() {
		WebUI.click(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Appointment/buttonBookAppointment'))
	}
	
	@Then("Success create appointment and verify the input (.*) (.*) (.*)")
	def successCreateAppointment(String facility, String healthcare_program, String readmission) {
		WebUI.verifyElementVisible(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Appointment/verifyAppointmentConfirmation'))
	
		WebUI.verifyElementText(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Appointment/validateFacility'), facility)
		
		if (healthcare_program == 'radio_program_medicare') {
			healthcare_program = 'Medicare'
		} else if (healthcare_program == 'radio_program_medicaid') {
			healthcare_program = 'Medicaid'
		} else if (healthcare_program == 'radio_program_none') {
			healthcare_program = 'None'
		}
		
		WebUI.verifyElementText(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Appointment/validateProgram'), healthcare_program)
		
		if (readmission == 'Y') {
			readmission = 'Yes'
		} else if (readmission == 'N') {
			readmission = 'No'
		}
		
		WebUI.verifyElementText(findTestObject('Object Repository/KatalonDemo - CURA Healthcare Service/Appointment/validateReadmission'), readmission)
	}
}