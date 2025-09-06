import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

WebUI.click(findTestObject('element/Login/iconToggleSidebar'))

WebUI.click(findTestObject('element/Login/loginHyperlinkSidebar'))

WebUI.setText(findTestObject('element/Login/usernameFieldLoginPage'), 'John Doe')

WebUI.setEncryptedText(findTestObject('element/Login/passwordFieldLoginPage'), 'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM')

WebUI.click(findTestObject('element/Login/buttonLogin'), FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('element/Appointment/selectFacilityDropdown'), 'Hongkong CURA Healthcare Center', 
    true)

WebUI.click(findTestObject('Object Repository/element/Appointment/applyReadmission'))

WebUI.click(findTestObject('Object Repository/element/Appointment/radioHealthcareProgramMedicaid'))

WebUI.click(findTestObject('Object Repository/element/Appointment/visitScheduleDate'))

WebUI.click(findTestObject('Object Repository/element/Appointment/clickDateVisit'))

WebUI.setText(findTestObject('Object Repository/element/Appointment/inputComment'), 'test')

WebUI.click(findTestObject('Object Repository/element/Appointment/buttonBookAppointment'))

WebUI.verifyElementVisible(findTestObject('element/Appointment/verifyAppointmentConfirmation'))

WebUI.verifyElementVisible(findTestObject('element/Appointment/validateFacility'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('element/Appointment/validateReadmission'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('element/Appointment/validateProgram'), FailureHandling.STOP_ON_FAILURE)

