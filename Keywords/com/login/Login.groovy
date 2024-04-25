package com.login

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.thoughtworks.selenium.webdriven.commands.GetText

import internal.GlobalVariable

public class Login {
	def login(HashMap loginHashMap) {
		String username = loginHashMap.get("username")
		String password = loginHashMap.get("password")

		WebUI.waitForElementClickable(findTestObject('Object Repository/Login/button_Login'), 5, FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('Object Repository/Login/input_Username_username'), username, FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('Object Repository/Login/input_Password_password'), password, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Login/button_Login'), FailureHandling.STOP_ON_FAILURE)
	}

	def loginValidation(HashMap loginHashMap) {
		String username = loginHashMap.get("username")
		String password = loginHashMap.get("password")
		String TYPE_TESTCASE = loginHashMap.get("TYPE_TESTCASE")
		String VALIDATION = loginHashMap.get("VALIDATION")

		switch(TYPE_TESTCASE) {
			case "Positive":
				WebUI.verifyElementText(findTestObject('Object Repository/Dashboard/h6_Dashboard'), "Dashboard", FailureHandling.STOP_ON_FAILURE)
				logout()
				break;
			case "Negative":
				if (username != "" && password!= "") {
					WebUI.verifyElementVisible(findTestObject('Object Repository/Login/div_Invalid credentials'), FailureHandling.STOP_ON_FAILURE)
				}
				else if(username == "") {
					WebUI.verifyElementVisible(findTestObject('Object Repository/Login/username_required'), FailureHandling.STOP_ON_FAILURE)
				}
				else if(password == "") {
					WebUI.verifyElementVisible(findTestObject('Object Repository/Login/password_Required'), FailureHandling.STOP_ON_FAILURE)
				}
				break;
			default:
				KeywordUtil.markFailedAndStop("Tidak ada tipe test case yang valid")
		}
	}

	def logout() {
		WebUI.click(findTestObject('Object Repository/Navigation/span_User'), FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Logout/a_Logout'), 5, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Logout/a_Logout'), FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForPageLoad(5, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Login/button_Login'), 5, FailureHandling.STOP_ON_FAILURE)
	}
}
