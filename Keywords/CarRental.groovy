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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class CarRental {

	def orderCars() {
		WebUI.navigateToUrl("https://www.traveloka.com/en-id/car-rental", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('without_driver'), FailureHandling.STOP_ON_FAILURE)

		/* Region */
		WebUI.click(findTestObject('input_region'), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('input_region'), "Jakarta", FailureHandling.STOP_ON_FAILURE)

		/* Find specified element from list region */
		WebUI.click(findTestObject('select_region',[('region'):'Jakarta']), FailureHandling.STOP_ON_FAILURE)

		/* Start Date */
		def date_start = getDate(2)
		def time_start = getTime(9, 0)
		WebUI.click(findTestObject('choose_date_start'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('select_date_start', [('date') : date[0], ('month') : date[1], ('year') : date[2]]), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('select_time_start', [('hour') : time[0], ('minute') : time[1]]), FailureHandling.STOP_ON_FAILURE)

		/* End Date */
		def date_end = getDate(5)
		def time_end = getTime(11, 0)
		WebUI.click(findTestObject('choose_date_end'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('select_date_end', [('date') : date[0], ('month') : date[1], ('year') : date[2]]), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('select_time_end', [('hour') : time[0], ('minute') : time[1]]), FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('search_car'), FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementNotVisible(findTestObject('label_car_rental_without_driver'), 5, FailureHandling.STOP_ON_FAILURE)


		/* Select Car*/
		WebUI.click(findTestObject('select_car',[("brand") : "Daihatsu All New Ayla", ("transmission") : "AUTOMATIC",
			("seats") : "6 seats", ("price") : "Rp 312.000"]), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('continue'), FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementNotVisible(findTestObject('label_car_rental_without_driver'), 5, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('select_provider',[("brand") : "TRAC Astra Jakarta", ("price") : "RP 924.000"]), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('continue'), FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementNotVisible(findTestObject('label_car_rental_without_driver'), 5, FailureHandling.STOP_ON_FAILURE)


		/* Pickup Loc*/
		WebUI.scrollToElement(findTestObject('label_pickup_location'), 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('rental_office'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('dropdown_rental_office'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('choose_rental_office'), FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementNotVisible(findTestObject('popup_please_wait'), 10, FailureHandling.STOP_ON_FAILURE)


		/* Drop Loc*/
		WebUI.scrollToElement(findTestObject('label_drop_location'), 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('other_location'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('input_other_location'), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('input_other_location'),"Gambir Station", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('select_location',[("location") : "Gambir Station"]), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('drop_notes'), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('drop_notes'),"Please on time !", FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementNotVisible(findTestObject('popup_please_wait'), 10, FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('continue'), FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementNotVisible(findTestObject('label_your_booking'), 5, FailureHandling.STOP_ON_FAILURE)

		/* Contact Details*/
		WebUI.click(findTestObject('full_name'), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('full_name'),"Albertus Titan", FailureHandling.STOP_ON_FAILURE)
		WebUI.selectOptionByLabel(findTestObject('country_code'), "+62", false, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('phone_number'), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('phone_number'),"856565656", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('email'), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('email'),"atitan@gmail.com", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('save_contact'), FailureHandling.STOP_ON_FAILURE)

		/* Driver Details*/
		WebUI.selectOptionByLabel(findTestObject('title'), "Mr", false, FailureHandling.STOP_ON_FAILURE)
		WebUI.selectOptionByLabel(findTestObject('country_code'), "+62", false, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('phone_number'), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('phone_number'),"812323221", FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('save_driver'), FailureHandling.STOP_ON_FAILURE)




		/* Special Request */
		WebUI.click(findTestObject('special_req'), FailureHandling.STOP_ON_FAILURE)
		WebUI.sendKeys(findTestObject('special_req'),"Please remove vanilla fragrance if exist", FailureHandling.STOP_ON_FAILURE)
		String insurance = "from test data"
		if (insurance == "Y")WebUI.check(findTestObject('personal_accident_insurance'), FailureHandling.STOP_ON_FAILURE)


		/** Assertion */
		/* Rental Detail*/
		/* Pickup Location*/
		/* Drop location*/
		/* Contact Detail*/
		/* Driver Detail*/

		WebUI.click(findTestObject('continue_payment'), FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForPageLoad(10, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('popup_confirmation'), 5, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('continue_confirmation'), FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementNotVisible(findTestObject('popup_please_wait'), 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('popup_confirmation'), 5, FailureHandling.STOP_ON_FAILURE)
		
		/* Payment */
		WebUI.click(findTestObject('method_bank_transfer'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('select_bank',[("bank") : "BCA Transfer"]), FailureHandling.STOP_ON_FAILURE)
		
		/** Assertion */
		/* Price Detail*/
		
		WebUI.click(findTestObject('payment_procced'), FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementNotVisible(findTestObject('popup_processing'), 10, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('form_payment_detail'), 5, FailureHandling.STOP_ON_FAILURE)
		
	}

	def getDate(int additionDay) {
		/* fungsi untuk mendapatkan current day + addition day
		 * return String array[date, month, year]
		 */
	}

	def getTime(int hour, int minute) {
		/* fungsi untuk mendapatkan format jam
		 * return String array[hour, minute]
		 */
	}
}
