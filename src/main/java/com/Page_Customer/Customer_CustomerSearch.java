package com.Page_Customer;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class Customer_CustomerSearch extends Base_Class{
	Log log= new Log();
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();		
	com.Utility.ExcelReader ExcelReader = new com.Utility.ExcelReader("Customer_CustSearch");
	Base_Class Base_Class= new Base_Class();
	
	
	public boolean pcRegistration(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("PC Registration");
		
		String pcRegFormName = testdata.get("pcRegFormName").toString();
		input(custSearch.formName, pcRegFormName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter User Name in Name field.");
		Log.info("Step:01 - Enter User Name in Name field.");
		
		String pcRegFormPcName = testdata.get("pcRegFormPcName").toString();	
		input(custSearch.formComputerName, pcRegFormPcName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter PC Name in Name field.");
		Log.info("Step:02 - Enter PC Name in Name field.");
		
		click(custSearch.formBranchName);
		click(custSearch.formBranchNameTrivandrum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Select a Branch Name from the Dropdown.");
		Log.info("Step:03 - Select a Branch Name from the Dropdown.");
		
		click(custSearch.formSubmitBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Submit Button.");
		Log.info("Step:04 - Click on Submit Button.");
		
		//DB Connection
			com.BasePackage.Base_Class.DatabaseConnector();
			driver.navigate().refresh();
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: PC Registered Successfully!");
			Log.info("Expected Result: PC Registered Successfully!");
			ExtentTestManager.endTest();
			Thread.sleep(3000);
		return true;
	}
	
	public boolean userLoginInValidPaswrd(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("Invalid Login - Incorrect Password");
		
		String loginUserName = testdata.get("loginUserName").toString();
		input(custSearch.loginUserName, loginUserName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Eneter Valid User Name");
		Log.info("Step:01 - Enetered Valid User Name");
		
		String loginInValidPassword = testdata.get("loginInValidPassword").toString();
		input(custSearch.loginPasswrd, loginInValidPassword);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Eneter Invalid Password");
		Log.info("Step:02 - Enetered Invalid Password");
		
		click(custSearch.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
		Log.info("Step:03 - Click on Login Button");
		
		Thread.sleep(1000);
		if(ElementDisplayed(custSearch.invalidPaswrdErrMsg)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expect Result: Error message displayed indicating incorrect password.");
			Log.info("Expect Result: Error message displayed indicating incorrect password.");
		}
		clear(custSearch.loginUserName);
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean userLoginValidPaswrd(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("Valid Login");
		
		String loginUserName = testdata.get("loginUserName").toString();
		input(custSearch.loginUserName, loginUserName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Eneter valid User Name");
		Log.info("Step:01 - Enetered valid User Name");
		
		String loginValidPassword = testdata.get("loginValidPassword").toString();
		input(custSearch.loginPasswrd, loginValidPassword);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Eneter valid Password");
		Log.info("Step:02 - Enetered valid Password");
		
		click(custSearch.loginButton);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Login Button");
		Log.info("Step:03 - Click on Login Button");
		
		Thread.sleep(5000);

			if(ElementDisplayed(custSearch.home)){
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged in successfully and dashboard visible");
				Log.info("Expected Result: User is logged in successfully and dashboard visible");
			}
			
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean customerSearchWindow() throws InterruptedException {
		ExtentTestManager.startTest("Navigate to Customer Search");
		
		click(custSearch.cust);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Expand the Customer module in the left menu bar.");
		Log.info("Step:01 - Expand the Customer module in the left menu bar.");
		
		click(custSearch.custSrch);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select Customer Search.");
		Log.info("Step:02 - Select Customer Search.");
		
		Thread.sleep(2000);
		if(ElementDisplayed(custSearch.custSrchTxt)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Search Window loaded Successfully!");
			Log.info("Expected Result: Customer Search Window loaded Successfully!");
		}
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean mobileFieldBVA(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		
		ExtentTestManager.startTest("Mobile Field - BVA Validations");
		
				//Min-1 & Max-1 (<10 digits)
				String invalidMobileNum1 = testdata.get("invalidMobileNum1").toString();
				input(custSearch.custMobile, invalidMobileNum1);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Invlalid Mobile num in moblie field(<10 Digits)");
				Log.info("Step:01 - Enter Invlalid Mobile num in moblie field(<10 Digits)");
		
				click(custSearch.custSearchBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Search button.");
				Log.info("Step:02 - Click on the Search button.");
				
				Thread.sleep(1000);
				if(ElementDisplayed(custSearch.custErrorMsg)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed for incorrect Mobile NO.(< 10 digits)" );
					 Log.info("Expected Result: Error message displayed for incorrect Mobile NO.(< 10 digits)");
				}					
				Thread.sleep(1000);
				click(custSearch.custClearBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the Clear Data");
				Log.info("Step:03 - Click on the Clear Data");
				
		//Min+1 & Max+1 (>10 digits)
				Thread.sleep(1000);
				String invalidMobileNum2 = testdata.get("invalidMobileNum2").toString();
				input(custSearch.custMobile, invalidMobileNum2);
				ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Enter Invlalid Mobile num in moblie field(>10 Digits)");
				Log.info("Step:04 - Enter Invlalid Mobile num in moblie field(>10 Digits)");
				
				click(custSearch.custSearchBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Click on the Search button.");
				Log.info("Step:05 - Click on the Search button.");
				
				Thread.sleep(1000);
				if(ElementDisplayed(custSearch.custErrorMsg)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed for incorrect Mobile NO.(> 10 digits)" );
					 Log.info("Expected Result: Error message displayed for incorrect Mobile NO.(> 10 digits)");
				}	
				Thread.sleep(1000);
				click(custSearch.custClearBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Click on the Clear Data");
				Log.info("Step:06 - Click on the Clear Data");
				
		//Min & Max (=10 digits)
				String validMobileNum = testdata.get("validMobileNum").toString();
				input(custSearch.custMobile, validMobileNum);
				ExtentTestManager.getTest().log(Status.PASS, "Step:07 - Enter Valid Mobile num in moblie field");
				Log.info("Step:07 - Enter Valid Mobile num in moblie field");
				
				click(custSearch.custSearchBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:08 - Click on the Search button.");
				Log.info("Step:08 - Click on the Search button.");
						
				Thread.sleep(1000);
				if(ElementDisplayed(custSearch.custGridItem)) {
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Fetched Customer with Valid Mobile No., Successfully!");
						Log.info("Expected Result: Fetched Customer with Valid Mobile No., Successfully!");
					}
					click(custSearch.custClearBtn);
					ExtentTestManager.getTest().log(Status.PASS, "Step:09 - Click on the Clear Data");
					Log.info("Step:09 - Click on the Clear Data");
					
					ExtentTestManager.endTest();						
		return true;
		}
	
	public boolean nameFieldECP(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {

		ExtentTestManager.startTest("Name Field - ECP Validations");
		
		
		//Search By Name --> Numeric Input
		String nameNumeric = testdata.get("nameNumeric").toString();
		input(custSearch.custName, nameNumeric);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Invlalid Name in Name field(Numeric Input)");
		Log.info("Step:01 - Enter Invlalid Name in Name field(Numeric Input)");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Search button.");
		Log.info("Step:02 - Click on the Search button.");
		
		Thread.sleep(1000);
		if(ElementDisplayed(custSearch.custErrorMsg)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed for incorrect Name (Numeric Input)");
			 Log.info("Expected Result: Error message displayed for incorrect Name (Numeric Input)");
		}
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the Clear Data");
		Log.info("Step:03 - Click on the Clear Data");
		
		
		//Search By Name --> Alphanumeric Input
		String nameAlphanumeric = testdata.get("nameAlphanumeric").toString();
		input(custSearch.custName, nameAlphanumeric);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Enter Invlalid Name in Name field(Alphanumeric Input)");
		Log.info("Step:04 - Enter Invlalid Name in Name field(Alphanumeric Input)");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Click on the Search button.");
		Log.info("Step:05 - Click on the Search button.");
		Thread.sleep(1000);
		if(ElementDisplayed(custSearch.custErrorMsg)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed for incorrect Name (Alphanumeric)");
			 Log.info("Expected Result: Error message displayed for incorrect Name (Alphanumeric)");
		}
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Click on the Clear Data");
		Log.info("Step:06 - Click on the Clear Data");
		
		
		//Search By Name --> Alphabet Input
		String validName = testdata.get("validName").toString();				
		input(custSearch.custName, validName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:07 - Enter Valid Name in Name field(Alphabet Input)");
		Log.info("Step:07 - Enter Valid Name in Name field(Alphabet Input)");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:08 - Click on the Search button.");
		Log.info("Step:08 - Click on the Search button.");
		Thread.sleep(1000);
		if(ElementDisplayed(custSearch.custListTable)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Fetched Using Name, Successfully");
			Log.info("Expected Result: Fetched Customer with Valid Name, Successfully!");
		}	
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:09 - Click on the Clear Data");
		Log.info("Step:09 - Click on the Clear Data");
		
		
		//Search By Name --> Name not in DB
		String invalidName = testdata.get("invalidName").toString();				
		input(custSearch.custName, invalidName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:10 - Enter Non-Existing Name in Name field");
		Log.info("Step:10 - Enter Vlalid Name in Name field(Alphabet Input)");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:11 - Click on the Search button.");
		Log.info("Step:11 - Click on the Search button.");
		
		Thread.sleep(1000);
		if(ElementDisplayed(custSearch.custErrorMsg)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: No results found and appropriate message displayed.");
			Log.info("Expected Result: No results found and appropriate message displayed.");
		}
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:12 - Click on the Clear Data");
		Log.info("Step:12 - Click on the Clear Data");
		
		
		//Search By Name --> Special Characters Input
		String nameSpecialChar = testdata.get("nameSpecialChar").toString();				
		input(custSearch.custName, nameSpecialChar);
		ExtentTestManager.getTest().log(Status.PASS, "Step:13 - Enter Special Characters Name in Name field");
		Log.info("Step:13 - Enter Special Characters Name in Name field");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:14 - Click on the Search button.");
		Log.info("Step:14 - Click on the Search button.");
		
		Thread.sleep(1000);
		if(ElementDisplayed(custSearch.custErrorMsg)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: No results found and appropriate message displayed.");
			Log.info("Expected Result: No results found and appropriate message displayed.");
		}
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:15 - Click on the Clear Data");
		Log.info("Step:15 - Click on the Clear Data");
		
		ExtentTestManager.endTest();
		return true;
		}
	
	public boolean searchWithoutInputs() throws InterruptedException {
		
		ExtentTestManager.startTest("Search Without Filters");
		
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Clear Data");
		Log.info("Step:01 - Click on the Clear Data");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Search button without entering any filters.");
		Log.info("Step:02 - Click on the Search button without entering any filters.");
		
		Thread.sleep(1000);
		boolean flag1 = ElementDisplayed(custSearch.custListTable);
		boolean flag = flag1;
		if(flag == true) {
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All Availabe customer details displayed, Successfully!");
		Log.info("Expected Result: All Availabe customer details displayed, Successfully!");
				}
		
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the Clear Data");
		Log.info("Step:03 - Click on the Clear Data");
		
		ExtentTestManager.endTest();
		return true;
	}
	
	
	public boolean searchByInvalidAadhaar(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
				//AADHAAR No < 12 digits.
		
		ExtentTestManager.startTest("Invalid Aadhaar Number");
		
		String invalidAadhaar = testdata.get("invalidAadhaar").toString();
		input(custSearch.custAadhaar, invalidAadhaar);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Invalid Aadhaar num in Aadhaar field");
		Log.info("Step:01 - Enter Invalid Aadhaar num in Aadhaar field");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Search button");
		Log.info("Step:02 - Click on the Search button");
		
		Thread.sleep(1000);
		if(ElementDisplayed(custSearch.custErrorMsg)) {
					ExtentTestManager.getTest().log(Status.PASS, "Error message displayed for incorrect Aadhaar(< 12 digits)");
					Log.info("Error message displayed for incorrect Aadhaar(< 12 digits)");
				}						
		
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the Clear Data");
		Log.info("Step:03 - Click on the Clear Data");
		
		ExtentTestManager.endTest();
		return true;
	}
	
//	public boolean searchByMobileInvalid1(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
//		//click(NBFC_Locators.custSrch);
//		
//		String invalidMobileNum1 = testdata.get("invalidMobileNum1").toString();
//		input(custSearch.custMobile, invalidMobileNum1);
//				click(custSearch.custSearchBtn);
//				boolean flag1 = ElementDisplayed(custSearch.custErrorMsg);
//				boolean flag = flag1;
//				if(flag == true) {
//					ExtentTestManager.getTest().log(Status.PASS, "Error message displayed for incorrect Mobile NO.(< 10 digits)" );
//					 Log.info("Error message displayed for incorrect Mobile NO.(< 10 digits)");
//				}					
//				Thread.sleep(1000);
//				click(custSearch.custClearBtn);
//				return true;
//	}
	
//	public boolean searchByMobileInvalid2(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
//		String invalidMobileNum2 = testdata.get("invalidMobileNum2").toString();
//		input(custSearch.custMobile, invalidMobileNum2);
//		click(custSearch.custSearchBtn);
//		boolean flag1 = ElementDisplayed(custSearch.custErrorMsg);
//		boolean flag = flag1;
//		if(flag == true) {
//			ExtentTestManager.getTest().log(Status.PASS, "Error message displayed for incorrect Mobile NO.(> 10 digits)" );
//			 Log.info("Error message displayed for incorrect Mobile NO.(> 10 digits)");
//		}					
//		Thread.sleep(1000);
//		click(custSearch.custClearBtn);
//		return true;
//		}
	
//	public boolean searchByMobileValid(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
//				//MIN & MAX Value (Positive Scenario)
//		String validMobileNum = testdata.get("validMobileNum").toString();
//		input(custSearch.custMobile, validMobileNum);
//				click(custSearch.custSearchBtn);
//				Thread.sleep(1000);
//				boolean flag1 = ElementDisplayed(custSearch.custGridItem);
//				boolean flag = flag1;
//				if(flag == true) {
//					ExtentTestManager.getTest().log(Status.PASS, "Customer Fetched Using Valid Mobile No., Successfully");
//					Log.info("Fetched Customer with Valid Mobile No., Successfully!");
//				}
//				click(custSearch.custClearBtn);
//		return true;
//		}
	
//	public boolean searchByNameNumeric(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
//				
//				//Search By Name --> Numeric Input
//		String nameNumeric = testdata.get("nameNumeric").toString();
//		input(custSearch.custName, nameNumeric);
//
//				click(custSearch.custSearchBtn);
//				Thread.sleep(1000);
//				boolean flag1 = ElementDisplayed(custSearch.custErrorMsg);
//				boolean flag = flag1;
//				if(flag == true) {
//					ExtentTestManager.getTest().log(Status.PASS, "Error message displayed for incorrect Name (Numeric)");
//					 Log.info("Error message displayed for incorrect Name (Numeric)");
//				}
//				click(custSearch.custClearBtn);					
//				return true;
//	}
//public boolean searchByNameAlpanumeric(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
//	//Search By Name --> Alphanumeric Input
//	String nameAlphanumeric = testdata.get("nameAlphanumeric").toString();
//	input(custSearch.custName, nameAlphanumeric);
//	click(custSearch.custSearchBtn);
//	Thread.sleep(1000);
//	boolean flag1 = ElementDisplayed(custSearch.custErrorMsg);
//	boolean flag = flag1;
//	if(flag == true) {
//		ExtentTestManager.getTest().log(Status.PASS, "Error message displayed for incorrect Name (Alphanumeric)");
//		 Log.info("Error message displayed for incorrect Name (Alphanumeric)");
//	}
//	click(custSearch.custClearBtn);
//	return true;
//}
//
//public boolean searchByValidName(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
//				//Search By Name --> Alphabet Input
//				String validName = testdata.get("validName").toString();				
//				input(custSearch.custName, validName);
//				click(custSearch.custSearchBtn);
//				Thread.sleep(1000);
//				boolean flag1 = ElementDisplayed(custSearch.custGridItem);
//				boolean flag = flag1;
//				if(flag == true) {
//					ExtentTestManager.getTest().log(Status.PASS, "Customer Fetched Using Name, Successfully");
//					Log.info("Fetched Customer with Valid Name, Successfully!");
//				}
//				
//				
//				click(custSearch.custClearBtn);
//	return true;
//	}
//	
//public boolean searchByInValidName(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
//	//Search By Name --> Name not in DB
//	String invalidName = testdata.get("invalidName").toString();				
//	input(custSearch.custName, invalidName);
//	click(custSearch.custSearchBtn);
//	Thread.sleep(1000);
//	boolean flag1 = ElementDisplayed(custSearch.custGridItem);
//	boolean flag = flag1;
//	if(flag == true) {
//		ExtentTestManager.getTest().log(Status.PASS, "No results found and appropriate message displayed.");
//		Log.info("No results found and appropriate message displayed.");
//	}
//	click(custSearch.custClearBtn);
//return true;
//}
//
//public boolean searchByNameSpecialChar(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
//	//Search By Name --> Special Characters Input
//	String nameSpecialChar = testdata.get("nameSpecialChar").toString();				
//	input(custSearch.custName, nameSpecialChar);
//	click(custSearch.custSearchBtn);
//	Thread.sleep(1000);
//	boolean flag1 = ElementDisplayed(custSearch.custGridItem);
//	boolean flag = flag1;
//	if(flag == true) {
//		ExtentTestManager.getTest().log(Status.PASS, "No results found and appropriate message displayed.");
//		Log.info("No results found and appropriate message displayed.");
//	}
//	click(custSearch.custClearBtn);
//return true;
//}

//	public boolean searchByParentOrSpouse() throws InterruptedException{
//		
//				//Search By Parent Or Spouse Name --> Numeric Input
//				click(custSearch.custClearBtn);
//				click(custSearch.custParentSpouse);
//				input(custSearch.custParentSpouse, "1234567890");
//				click(custSearch.custSearchBtn);
//				Thread.sleep(1000);
//				if(ElementDisplayed(custSearch.custErrorPopMsg)) {
//					ExtentTestManager.getTest().log(Status.PASS, "Valid ERROR Msg Disaplyed --> No Data Found.....!");
//					 Log.info("Valid ERROR Msg Disaplyed --> No Data Found.....!");
//					click(custSearch.custErrorPopMsgClose);
//				}
////				if(driver.findElement(NBFC_Locators.custErrorMsg).isDisplayed()) {
////					System.out.println(driver.findElement(NBFC_Locators.custErrorMsg).getText() + " --> Valid ERROR Message is Displayed." );
////				}
//				
//				//Search By Parent Or Spouse Name --> Alphanumeric Input
//				click(custSearch.custClearBtn);
//				input(custSearch.custParentSpouse, "ABCD12345");
//				click(custSearch.custSearchBtn);
//				if(ElementDisplayed(custSearch.custErrorPopMsg)) {
//					ExtentTestManager.getTest().log(Status.PASS, "Valid ERROR Msg Disaplyed --> No Data Found.....!");
//					 Log.info("Valid ERROR Msg Disaplyed --> No Data Found.....!");
//					click(custSearch.custErrorPopMsgClose);
//				}
////				if(driver.findElement(NBFC_Locators.custErrorMsg).isDisplayed()) {
////					System.out.println(driver.findElement(NBFC_Locators.custErrorMsg).getText() + " --> Valid ERROR Message is Displayed." );
////				}
//				Thread.sleep(2000);
//				
//				//Search By Parent Or Spouse Name --> Alphabet Input
//				click(custSearch.custClearBtn);
//				input(custSearch.custParentSpouse, "JAYA PRASAD");
//				click(custSearch.custSearchBtn);
//
//		return true;
//	}
	

	
	public boolean clearFunctionality(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		ExtentTestManager.startTest("Clear Functionality");
		
		String validName = testdata.get("validName").toString();				
		input(custSearch.custName, validName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Name in Name field");
		Log.info("Step:01 - Enter Name in Name field");
		
		String validMobileNum = testdata.get("validMobileNum").toString();
		input(custSearch.custMobile, validMobileNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Moblie Num in Moblie field");
		Log.info("Step:02 - Enter Moblie Num in Moblie field");
		
		String invalidAadhaar = testdata.get("invalidAadhaar").toString();
		input(custSearch.custAadhaar, invalidAadhaar);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Aadhaar Num in Aadhaar field");
		Log.info("Step:03 - Enter Aadhaar Num in Aadhaar field");
		
		click(custSearch.custClearBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on the Clear Data");
		Log.info("Step:04 - Click on the Clear Data");
		
		try {
			if(ElementDisplayed(custSearch.custListTable)) {
				ExtentTestManager.getTest().log(Status.PASS, "Clear Functionality, Failed");
				Log.info("Clear Functionality, Failed");
			}
		}catch(Exception e) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All Inputs Cleared., Successfully!");
			Log.info("Expected Result: All Inputs Cleared., Successfully!");
		}
		
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean fetchInstitutions() throws InterruptedException {
				click(custSearch.custClearBtn);
				
				ExtentTestManager.startTest("Toggle Is Institutional Checkbox");
				
				click(custSearch.custKYCCompliantOnly);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Uncheck KYC Compliant Only checkbox");
				Log.info("Step:01 - Uncheck KYC Compliant Only checkbox");
				
				click(custSearch.custActiveOnly);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Uncheck Active Only checkbox");
				Log.info("Step:02 - Uncheck Active Only checkbox");
				
				click(custSearch.custProspectsOnly);
				ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Uncheck Prospects Only checkbox");
				Log.info("Step:03 - Uncheck Prospects Only checkbox");
				
				click(custSearch.custIsInstitutional);
				ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Check Prospects Only checkbox");
				Log.info("Step:04 - Check Prospects Only checkbox");
				
				click(custSearch.custSearchBtn);Thread.sleep(2000);
				ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Click on the Search button");
				Log.info("Step:05 - Click on the Search button");
				
				try {
//					boolean tableDisplayed = ElementDisplayed(NBFC_Locators.custTable);
					if(ElementDisplayed(custSearch.custTable)) {
						ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Grid displays only institutional customers.");
						Log.info("Expected Result: Grid displays only institutional customers.");
						}
				}
				catch(Exception e1)
				{
					ExtentTestManager.getTest().log(Status.PASS, "Failed to Fetch Institutional Customers in the Grid");
					Log.info("Failed to Fetch Institutional Customers in the Grid");
				}
				Thread.sleep(1000);
				click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean houseName(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
				
		ExtentTestManager.startTest("Verify the field House Name");
		
				//Alphanumeric
				String houseNameAlphanumeric = testdata.get("houseNameAlphanumeric").toString();				
				input(custSearch.custHouseName, houseNameAlphanumeric);
				ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter House name in House field (Alphanumeric Input)");
				Log.info("Step:01 - Enter Invalid Aadhaar num in Aadhaar field");
				
				click(custSearch.custSearchBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Search button");
				Log.info("Step:02 - Click on the Search button");
				
				if(ElementDisplayed(custSearch.custListTable)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Fetched with House Name (Alphanumeric Input), Successfully!");
					Log.info("Expected Result: Customer Fetched with House Name (Alphanumeric Input), Successfully!");
				}
				Thread.sleep(2000);
				click(custSearch.custClearBtn);
				
				
				//Alphabet
				String houseNameAlphabet = testdata.get("houseNameAlphabet").toString();				
				input(custSearch.custHouseName, houseNameAlphabet);
				ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter House name in House field (Alphanumeric Input)");
				Log.info("Step:01 - Enter Invalid Aadhaar num in Aadhaar field");
				
				click(custSearch.custSearchBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on the Search button");
				Log.info("Step:02 - Click on the Search button");
				
				if(ElementDisplayed(custSearch.custListTable)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Fetched with House Name(Alphabetic Input), Successfully!");
					Log.info("Expected Result: Customer Fetched with House Name(Alphabetic Input), Successfully!");
				}
				Thread.sleep(2000);
				click(custSearch.custClearBtn);
				
				//Numeric
				String houseNameNumeric = testdata.get("houseNameNumeric").toString();				
				input(custSearch.custHouseName, houseNameNumeric);
				ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Enter House name in House field (Numeric Input)");
				Log.info("Step:05 - Enter House name in House field (Numeric Input)");
				
				click(custSearch.custSearchBtn);
				ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Click on the Search button");
				Log.info("Step:06 - Click on the Search button");
				
				if(ElementDisplayed(custSearch.custListTable)) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Fetched with House Name(Numeric Input), Successfully!");
					Log.info("Expected Result: Customer Fetched with House Name(Numeric Input), Successfully!");
				}
				Thread.sleep(2000);
				click(custSearch.custClearBtn);
				ExtentTestManager.endTest();
		return true;
	}
	
	public boolean docTypeAndDocNo(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		ExtentTestManager.startTest("Verify the field Doc Type & Doc No.");
		
		click(custSearch.custDocType);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on Doc Type drop down box.");
		Log.info("Step:01 - Click on Doc Type drop down box");
		
		click(custSearch.custDocTypeElectionId);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select a document type from the drop down.");
		Log.info("Step:02 - Select a document type from the drop down.");
		
		String docNum = testdata.get("docNum").toString();				
		input(custSearch.custHouseName, docNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Document number in Doc No. field.");
		Log.info("Step:03 - Enter Document number in Doc No. field.");

		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on the Search button");
		Log.info("Step:04 - Click on the Search button");
		
		if(ElementDisplayed(custSearch.custListTable)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Doc type is selecting from the dropdown successfully and details should be displayed against the given DOC type, Successfully!");
			Log.info("Expected Result: Doc type is selecting from the dropdown successfully and details should be displayed against the given DOC type, Successfully!");
		}
		Thread.sleep(2000);
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean panNum(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		ExtentTestManager.startTest("Verify the field PAN No");
		
		String alphanumericPanNum = testdata.get("alphanumericPanNum").toString();				
		input(custSearch.custPanNum, alphanumericPanNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter PAN number in PAN NO. field.");
		Log.info("Step:01 - Enter PAN number in PAN NO. field.");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on the Search button.");
		Log.info("Step:02 - Click on the Search button.");
		
		if(ElementDisplayed(custSearch.custListTable)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer details should be shows in the grid against the given PAN No.");
			Log.info("Expected Result: Customer details should be shows in the grid against the given PAN No.");
		}
		Thread.sleep(2000);
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
return true;
}
	
	public boolean kycCompliantOnly() throws InterruptedException {
		
		ExtentTestManager.startTest("Check KYC Compliant Only Checkbox.");
		
		click(custSearch.custActiveOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Uncheck Active Only checkbox");
		Log.info("Step:01 - Uncheck Active Only checkbox");
		
		click(custSearch.custProspectsOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Uncheck Prospects Only checkbox");
		Log.info("Step:02 - Uncheck Prospects Only checkbox");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the Search button.");
		Log.info("Step:03 - Click on the Search button.");
		
		Thread.sleep(1000);
		if(ElementDisplayed(custSearch.custListTable)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only shows the KYC completed customer details.");
			Log.info("Expected Result: Only shows the KYC completed customer details.");
		}
		Thread.sleep(2000);
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean isActiveOnly() throws InterruptedException {
		
		ExtentTestManager.startTest("Check Active Only, Checkbox");
		
		click(custSearch.custKYCCompliantOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Uncheck KYC Compliant Only checkbox");
		Log.info("Step:01 - Uncheck KYC Compliant Only checkbox");
		
		click(custSearch.custProspectsOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Uncheck Prospects Only checkbox");
		Log.info("Step:02 - Uncheck Prospects Only checkbox");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the Search button.");
		Log.info("Step:03 - Click on the Search button.");
		
		Thread.sleep(1000);
		if(ElementDisplayed(custSearch.statusActive)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only shows the Active customer details.");
			Log.info("Expected Result: Only shows the Active customer details.");
		}
		Thread.sleep(2000);
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean prospectsOnly() throws InterruptedException {
		
		ExtentTestManager.startTest("Check Prospects Only Checkbox");
		
		click(custSearch.custKYCCompliantOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Uncheck KYC Compliant Only checkbox");
		Log.info("Step:01 - Uncheck KYC Compliant Only checkbox");
		
		click(custSearch.custActiveOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Uncheck Active Only checkbox");
		Log.info("Step:02 - Uncheck Active Only checkbox");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on the Search button.");
		Log.info("Step:03 - Click on the Search button.");
		
		Thread.sleep(1000);
		if(ElementDisplayed(custSearch.custListTable)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Only listing the customer which dont have accounts.");
			Log.info("Expected Result: Only listing the customer which dont have accounts.");
		}
		Thread.sleep(2000);
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean includeReject() throws InterruptedException {
		
		ExtentTestManager.startTest("Check Include Reject Checkbox");
		
		click(custSearch.custKYCCompliantOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Uncheck KYC Compliant Only checkbox");
		Log.info("Step:01 - Uncheck KYC Compliant Only checkbox");
		
		click(custSearch.custProspectsOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Uncheck Prospects Only checkbox");
		Log.info("Step:02 - Uncheck Prospects Only checkbox");
		
		click(custSearch.custActiveOnly);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Uncheck Active Only checkbox");
		Log.info("Step:03 - Uncheck Active Only checkbox");
		
		click(custSearch.custIncludeReject);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Check the Include Reject checkbox");
		Log.info("Step:04 - Check the Include Reject checkbox");
		
		click(custSearch.custSearchBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Click on the Search button.");
		Log.info("Step:05 - Click on the Search button.");
		
		Thread.sleep(1000);
		if(ElementDisplayed(custSearch.custGridItem)) {
			ExtentTestManager.getTest().log(Status.PASS, "Listing the customer include rejected customer ");
			Log.info("Listing the customer include rejected customer ");
		}
		Thread.sleep(2000);
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
		return true;
	}
	
	public boolean custLastNameEdit(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		ExtentTestManager.startTest("Edit Customer Last Name - Valid Edit");
		
		String validCustId = testdata.get("validCustId").toString();
//		click(custSearch.custId);
		input(custSearch.custId, validCustId);
		click(custSearch.custSearchBtn);Thread.sleep(1000);
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select an existing customer.");
		Log.info("Step:01 -  Select an existing customer.");Thread.sleep(1000);
		
		click(custSearch.custEditBtn);Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Click Edit button.");
		Log.info("Step:02 -  Click Edit button.");
		Thread.sleep(1000);		
		SwitchToFrame(custSearch.iframe);
		click(custSearch.custLastName);
		driver.findElement(custSearch.custLastName).clear();
		String validLastName = testdata.get("validLastName").toString();
		input(custSearch.custLastName, validLastName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 -  Modify the last name in customer details.");
		Log.info("Step:03 -  Modify the last name in customer details.");
		
		ScrollUntilElementVisible(custSearch.custCheckAvailabilityBtn);Thread.sleep(1000);
		click(custSearch.custCheckAvailabilityBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click Check Availability Button.");
		Log.info("Step:04 - Click Check Availability Button.");
		
		//Navigate to Pop Up Window
        String mainWindowHandle = driver.getWindowHandle();
        boolean popupAppeared = false;
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                driver.manage().window().maximize();
                popupAppeared = true;
    			if(ElementDisplayed(custSearch.popWindowErrMsg)) {
    				driver.close();
    				driver.switchTo().window(mainWindowHandle);
    			}        
            }
            }
        
        SwitchToFrame(custSearch.iframe);		
		click(custSearch.custSaveNProceedBtn);
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Click on Save and Proceed button.");
		Log.info("Step:05 - Click on Save and Proceed button.");
		driver.switchTo().defaultContent();
		
		if(ElementDisplayed(custSearch.savedPopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer details are updated successfully.");
			Log.info("Expected Result: Customer details are updated successfully.");
		}
		click(custSearch.savedPopUp);
		
		Thread.sleep(2000);
		click(custSearch.custSrch);
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
		return true;
}
	
	public boolean clearLastNameEdit(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		String validCustId = testdata.get("validCustId").toString();
		click(custSearch.custId);
		input(custSearch.custId, validCustId);
		click(custSearch.custSearchBtn);Thread.sleep(1000);
		click(custSearch.custSelect);
		click(custSearch.custEditBtn);Thread.sleep(2000);
		driver.findElement(custSearch.custLastName).clear();
		click(custSearch.custCheckAvailabilityBtn);Thread.sleep(1000);
		click(custSearch.custSaveNProceedBtn);Thread.sleep(4000);
		if(ElementDisplayed(custSearch.savedPopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Last name edited successfully");
			Log.info("Last name edited successfully");
		}
		click(custSearch.savedPopUp);
		Thread.sleep(2000);
		click(custSearch.custSrch);
		return true;
}
	
	public boolean lastNameECP(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		ExtentTestManager.startTest("Last Name Field - ECP Validations");
		
		String validCustId2 = testdata.get("validCustId2").toString();
		click(custSearch.custId);
		input(custSearch.custId, validCustId2);
		click(custSearch.custSearchBtn);Thread.sleep(1000);
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 -  Select an existing customer.");
		Log.info("Step:01 -  Select an existing customer.");
		Thread.sleep(1000);
		
		click(custSearch.custEditBtn);
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 -  Click Edit button.");
		Log.info("Step:02 -  Click Edit button.");
		
		//Numeric Name input
		SwitchToFrame(custSearch.iframe);
		click(custSearch.custLastName);
		driver.findElement(custSearch.custLastName).clear();
		String numericLastName = testdata.get("numericLastName").toString();
		input(custSearch.custLastName, numericLastName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 -  Enter Last Name in Last Name field (Numeric Input).");
		Log.info("Step:03 -  Enter Last Name in Last Name field (Numeric Input).");
		
		click(custSearch.lastNameTxt);Thread.sleep(1000);
		if(ElementDisplayed(custSearch.invalidlastNamePopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Numeric inputs prompts error message.");
			Log.info("Expected Result: Numeric inputs prompts error message.");
		}
		click(custSearch.invalidlastNamePopUp);
		
		//AlphaNumeric Name input
		click(custSearch.custLastName);
		driver.findElement(custSearch.custLastName).clear();
		String alphanumericLastName = testdata.get("alphanumericLastName").toString();
		input(custSearch.custLastName, alphanumericLastName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 -  Enter Last Name in Last Name field (AlphaNumeric Input).");
		Log.info("Step:04 -  Enter Last Name in Last Name field (AlphaNumeric Input).");
		
		click(custSearch.lastNameTxt);Thread.sleep(1000);
		if(ElementDisplayed(custSearch.invalidlastNamePopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: AlphaNumeric inputs prompts error message.");
			Log.info("Expected Result: AlphaNumeric inputs prompts error message.");
		}
		click(custSearch.invalidlastNamePopUp);
		
		//Special Characters Name input
		click(custSearch.custLastName);
		driver.findElement(custSearch.custLastName).clear();
		String specialCharacterLastName = testdata.get("specialCharacterLastName").toString();
		input(custSearch.custLastName, specialCharacterLastName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 -  Enter Last Name in Last Name field (Special Characters Input).");
		Log.info("Step:05 -  Enter Last Name in Last Name field (Special Characters Input).");
		
		click(custSearch.lastNameTxt);Thread.sleep(1000);
		if(ElementDisplayed(custSearch.invalidlastNamePopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Special Characters inputs prompts error message.");
			Log.info("Expected Result: Special Characters inputs prompts error message.");
		}
		click(custSearch.invalidlastNamePopUp);
		
		//Alphabetic Name input
		click(custSearch.custLastName);
		driver.findElement(custSearch.custLastName).clear();
		String validLastName = testdata.get("validLastName").toString();
		input(custSearch.custLastName, validLastName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:06 -  Enter Last Name in Last Name field (Alphabetic Input).");
		Log.info("Step:06 -  Enter Last Name in Last Name field (Alphabetic Input).");
		
		click(custSearch.lastNameTxt);		
		ScrollUntilElementVisible(custSearch.custCheckAvailabilityBtn);Thread.sleep(1000);
		click(custSearch.custCheckAvailabilityBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:07 - Click Check Availability Button.");
		Log.info("Step:07 - Click Check Availability Button.");
		
		//Navigate to Pop Up Window
	        String mainWindowHandle = driver.getWindowHandle();
	        boolean popupAppeared = false;
	        for (String handle : driver.getWindowHandles()) {
	            if (!handle.equals(mainWindowHandle)) {
	                driver.switchTo().window(handle);
	                driver.manage().window().maximize();
	                popupAppeared = true;
	    			if(ElementDisplayed(custSearch.popWindowErrMsg)) {
	    				driver.switchTo().window(mainWindowHandle);
	    			}        
	            }
	            }
	        SwitchToFrame(custSearch.iframe);
			click(custSearch.custSaveNProceedBtn);
			Thread.sleep(2000);
			ExtentTestManager.getTest().log(Status.PASS, "Step:08 - Click on Save and Proceed button.");
			Log.info("Step:08 - Click on Save and Proceed button.");
			
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
			if(ElementDisplayed(custSearch.savedPopUp)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Alphabetic inputs are allowed.");
				Log.info("Expected Result: Alphabetic inputs are allowed.");
			}
			click(custSearch.savedPopUp);
			
			click(custSearch.custSrch);
			click(custSearch.custClearBtn);
			ExtentTestManager.endTest();
		return true;
}
	
	public boolean viewCustDetails(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		ExtentTestManager.startTest("View Customer Details");
		
		String validCustId = testdata.get("validCustId").toString();
		click(custSearch.custId);
		input(custSearch.custId, validCustId);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid Customer Id in Customer ID field.");
		Log.info("Step:01 - Enter valid Customer Id in Customer ID field.");
		
		click(custSearch.custSearchBtn);Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Search button.");
		Log.info("Step:02 - Click on Search button.");
		
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Select the customer from the list.");
		Log.info("Step:03 - Select the customer from the list.");
		
		click(custSearch.custViewBtn);Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on the View button.");
		Log.info("Step:04 - Click on the View button.");
		
		if(ElementDisplayed(custSearch.personalDetails)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer details page displays KYC, address, and bank details.");
			Log.info("Expected Result: Customer details page displays KYC, address, and bank details.");
		}
		ScrollUntilElementVisible(custSearch.previousBtn);
		click(custSearch.previousBtn);		
		Thread.sleep(1000);
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
		return true;
	}
	

	public boolean docNum(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		String docNum = testdata.get("docNum").toString();				
		input(custSearch.custDocNum, docNum);
		click(custSearch.custDocType);
		click(custSearch.custDocTypeElection);
		click(custSearch.custSearchBtn);Thread.sleep(1000);
		if(ElementDisplayed(custSearch.custListTable)) {
			ExtentTestManager.getTest().log(Status.PASS, "Customer details should be shows in the grid against the given PAN No");
			Log.info("Customer details should be shows in the grid against the given PAN No");
		}
		Thread.sleep(2000);
		click(custSearch.custClearBtn);
return true;
}
	
	public boolean attachmentPopUp(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		ExtentTestManager.startTest("Attachment Popup");
		
		String custIDAttachments = testdata.get("custIDAttachments").toString();
		click(custSearch.custId);
		input(custSearch.custId, custIDAttachments);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter valid Customer Id in Customer ID field.");
		Log.info("Step:01 - Enter valid Customer Id in Customer ID field.");
		
		click(custSearch.custSearchBtn);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Search button.");
		Log.info("Step:02 - Click on Search button.");
		
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Select the customer from the list.");
		Log.info("Step:03 - Select the customer from the list.");
		
		click(custSearch.custAttachmentsBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on the Attachments button.");
		Log.info("Step:04 - Click on the Attachments button.");
		
		Thread.sleep(1000);
		//Navigate to Pop Up Window
        String mainWindowHandle = driver.getWindowHandle();
        boolean popupAppeared = false;
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                //driver.manage().window().maximize();
                popupAppeared = true;
                if(ElementDisplayed(custSearch.photoSignWndow)) {
        			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Attachment popup window open.");
        			Log.info("Expected Result: Attachment popup window open."); 			
        		}
                ExtentTestManager.endTest();
        		Thread.sleep(1000);
        		if(ElementDisplayed(custSearch.attachmentImg)) {
        			ExtentTestManager.startTest("Attachment Popup Image Display");
        			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Image is visible in the attachment popup");
        			Log.info("Expected Result: Image is visible in the attachment popup");
        		}
    			ExtentTestManager.endTest();
        		Thread.sleep(1000);
        		
        		ExtentTestManager.startTest("Image Button Functionality");
        		click(custSearch.attachmentImg);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the image button.");
        		Log.info("Step:01 - Click on the image button.");
        		
        		if(ElementDisplayed(custSearch.attachmentZoom)) {        			
        			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Image is displayed in a larger view");
        			Log.info("Expected Result: Image is displayed in a larger view");
        		}
        		Thread.sleep(1000);
        		
        		//click(custSearch.attachmentRotate);
        		click(custSearch.attachmentClose);
//        		click(custSearch.attachmentZoom);
//        		if(ElementDisplayed(custSearch.attachmentZoom)) {
//        			ExtentTestManager.getTest().log(Status.PASS, "Image zooms in/out as expected");
//        			Log.info("Image zooms in/out as expected");
//        		}
//        		Thread.sleep(1000);   
            }
            driver.switchTo().window(mainWindowHandle);
            }
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
return true;
}	
	
	public boolean freeze(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		ExtentTestManager.startTest("Freeze Customer");
		
		//freeze window
		click(custSearch.custClearBtn);
		click(custSearch.custSearchBtn);
		Thread.sleep(1000);
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer from the list.");
		Log.info("Step:01 - Select a customer from the list.");
		
		click(custSearch.freeze);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Freeze button.");
		Log.info("Step:02 - Click on Freeze button.");
		
		Thread.sleep(1000);
		if(ElementDisplayed(custSearch.custFreezeWndow)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Freeze window opens with customer details");
			Log.info("Expected Result: Freeze window opens with customer details");
		}
		ExtentTestManager.endTest();
		
		//freeze column names availability check
		ExtentTestManager.startTest("Verify Customer Details in Freeze Window");
		
		boolean flag1 = ElementDisplayed(custSearch.freezeCustId);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify the Presence of Column - Customer ID.");
		Log.info("Step:01 - Verify the Presence of Column - Customer ID.");
		
		boolean flag2 = ElementDisplayed(custSearch.freezeName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Verify the Presence of Column - Name.");
		Log.info("Step:02 - Verify the Presence of Column - Name.");
		
		boolean flag3 = ElementDisplayed(custSearch.freezeRisk);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Verify the Presence of Column - Risk.");
		Log.info("Step:03 - Verify the Presence of Column - Risk.");
		
		boolean flag4 = ElementDisplayed(custSearch.freezePanNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Verify the Presence of Column - PAN No.");
		Log.info("Step:04 - Verify the Presence of Column - PAN No.");
		
		boolean flag5 = ElementDisplayed(custSearch.freezeCrntAge);
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Verify the Presence of Column - Current Age.");
		Log.info("Step:05 - Verify the Presence of Column - Current Age.");
		
		boolean flag6 = ElementDisplayed(custSearch.freezeCustType);
		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Verify the Presence of Column - Customer Type.");
		Log.info("Step:06 - Verify the Presence of Column - Customer Type.");
		
		boolean flag0 = flag1 & flag2 & flag3 & flag4 & flag5 & flag6;
		if(flag0 == true) { 
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Grid Column Names (Customer ID, Name, Risk, PAN No., Current Age, Customer Type) are displayed");
			Log.info("Expected Result: Grid Column Names (Customer ID, Name, Risk, PAN No., Current Age, Customer Type) are displayed");
		}
		ExtentTestManager.endTest();
		
		//freeze without filling mandatory fields
		ExtentTestManager.startTest("Attempt to Freeze Without Checkbox");
		
		click(custSearch.freezeSubmitBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Submit button without checking the freeze checkbox");
		Log.info("Step:01 - Click Submit button without checking the freeze checkbox");
		
		Thread.sleep(1000);
		if(ElementDisplayed(custSearch.freezeErrMsgPopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed: \"Please select the freeze checkbox\"");
			Log.info("Expected Result: Error message displayed: \"Please select the freeze checkbox\"");
		}
		click(custSearch.freezeErrMsgOKBtn);
		Thread.sleep(1000);
		ExtentTestManager.endTest();
		
		//freeze future date
		ExtentTestManager.startTest("Select Future Date for Freeze");
		
		click(custSearch.freezeCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Check the freeze checkbox");
		Log.info("Step:01 - Check the freeze checkbox");
		
		clear(custSearch.freezeDateTxtBox);
		String freezeFutureDate = testdata.get("freezeFutureDate").toString();
		input(custSearch.freezeDateTxtBox, freezeFutureDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Select a future date from the calendar.");
		Log.info("Step:02 - Select a future date from the calendar.");
		
		String freezeAlphabetComment = testdata.get("freezeAlphabetComment").toString();
		input(custSearch.freezeRemark, freezeAlphabetComment);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Enter Remarks in Remarks field.");
		Log.info("Step:03 - Enter Remarks in Remarks field.");
		
		click(custSearch.freezeSubmitBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Submit button.");
		Log.info("Step:04 - Click on Submit button.");
		
		if(ElementDisplayed(custSearch.futureDateErrMsgPopUp)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message is displayed: \\\"Future dates not allowed\\\"");
			Log.info("Expected Result: Error message is displayed: \"Future dates not allowed\"");
		}
		click(custSearch.futureDateErrMsgOkBtn);
		ExtentTestManager.endTest();
		
		//freeze customer - alphabetic input
//		//click(custSearch.freezeCheckBox);
//		//String freezeAlphabetComment = testdata.get("freezeAlphabetComment").toString();
//		input(custSearch.freezeRemark, freezeAlphabetComment);
//		click(custSearch.freezeSubmitBtn);
//		if(ElementDisplayed(custSearch.freeszeListGrid)) {
//			ExtentTestManager.getTest().log(Status.PASS, "Customer is updated into freeze list");
//			Log.info("Customer is updated into freeze list");
//		}
//		
//		//freeze customer - numeric input
//		click(custSearch.freezeCheckBox);
//		String freezeNumericComment = testdata.get("freezeNumericComment").toString();
//		input(custSearch.freezeRemark, freezeNumericComment);
//		click(custSearch.freezeSubmitBtn);
//		if(ElementDisplayed(custSearch.freeszeListGrid)) {
//			ExtentTestManager.getTest().log(Status.PASS, "Customer is updated into freeze list");
//			Log.info("Customer is updated into freeze list");
//		}
//		
//		//freeze customer - Alphanumeric input
//		click(custSearch.freezeCheckBox);
//		String freezeAlphanumericComment = testdata.get("freezeAlphanumericComment").toString();
//		input(custSearch.freezeRemark, freezeAlphanumericComment);
//		click(custSearch.freezeSubmitBtn);
//		if(ElementDisplayed(custSearch.freeszeListGrid)) {
//			ExtentTestManager.getTest().log(Status.PASS, "Customer is updated into freeze list");
//			Log.info("Customer is updated into freeze list");
//		}
		
		//cancel freeze
		ExtentTestManager.startTest("Cancel Freeze Operation");
		
		click(custSearch.freezeCancelBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on Cancel button.");
		Log.info("Step:01 - Click on Cancel button.");
		if(ElementDisplayed(custSearch.custSrch)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Action is canceled, navigates back to customer search window");
			Log.info("Expected Result: Action is canceled, navigates back to customer search window");
		}
		ExtentTestManager.endTest();
		click(custSearch.custClearBtn);
return true;
}	
	
	public boolean active(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		ExtentTestManager.startTest("Select Customer and Open Active Window");
		
		//Select Customer and Open Active Window
		click(custSearch.custClearBtn);
		click(custSearch.custSearchBtn);Thread.sleep(1000);
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a customer from the list.");
		Log.info("Step:01 - Select a customer from the list.");
		
		click(custSearch.activate);Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click 'Active' button");
		Log.info("Step:02 - Click 'Active' button");Thread.sleep(5000);
		
		if(ElementDisplayed(custSearch.custActiveWndow)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Active window opens showing customer details");
			Log.info("Expected Result: Customer Active window opens showing customer details");
		}
		ExtentTestManager.endTest();
		
		
		//Verify Customer Details Display
		ExtentTestManager.startTest("Verify Customer Details Display");
		
		boolean flag1 = ElementDisplayed(custSearch.freezeCustId);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify the Presence of Column - Customer ID.");
		Log.info("Step:01 - Verify the Presence of Column - Customer ID.");
		
		boolean flag2 = ElementDisplayed(custSearch.freezeName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Verify the Presence of Column - Name.");
		Log.info("Step:02 - Verify the Presence of Column - Name.");
		
		boolean flag3 = ElementDisplayed(custSearch.freezeRisk);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Verify the Presence of Column - Risk.");
		Log.info("Step:03 - Verify the Presence of Column - Risk.");
		
		boolean flag4 = ElementDisplayed(custSearch.freezePanNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Verify the Presence of Column - PAN No.");
		Log.info("Step:04 - Verify the Presence of Column - PAN No.");
		
		boolean flag5 = ElementDisplayed(custSearch.freezeCrntAge);
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Verify the Presence of Column - Current Age.");
		Log.info("Step:05 - Verify the Presence of Column - Current Age.");
		
		boolean flag6 = ElementDisplayed(custSearch.freezeCustType);
		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Verify the Presence of Column - Customer Type.");
		Log.info("Step:06 - Verify the Presence of Column - Customer Type.");
		
		boolean flag0 = flag1 & flag2 & flag3 & flag4 & flag5 & flag6;
		if(flag0 == true) { 
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Grid Column Names (Customer ID, Name, Risk, PAN No., Current Age, Customer Type) are displayed");
			Log.info("Expected Result: Grid Column Names (Customer ID, Name, Risk, PAN No., Current Age, Customer Type) are displayed");
		}
		ExtentTestManager.endTest();
		
		//Submit De-activation Without Date
		ExtentTestManager.startTest("Submit Deactivation Without Date");
		
		click(custSearch.deactiveCheckBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Check the Deactivate Checkbox");
		Log.info("Step:01 - Check the Deactivate Checkbox");
		
		clear(custSearch.activateDateTxtBox);
		click(custSearch.activateDateTxt);
		input(custSearch.activateDateTxtBox,""+Keys.ENTER);
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Leave date empty");
		Log.info("Step:02 - Leave date empty");
		
		if(ElementDisplayed(custSearch.activateDateErrMsgPopUp)) {
			click(custSearch.activateDateErrMsgPopUp);
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message to select a date is displayed");
			Log.info("Expected Result: Error message to select a date is displayed");
		}
		ExtentTestManager.endTest();
		
		
		//Deactivate a Customer with Valid Date
		ExtentTestManager.startTest("Deactivate a Customer with Valid Date");
		
//		click(custSearch.deactiveCheckBox);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Check the Deactivate Checkbox");
//		Log.info("Step:01 - Check the Deactivate Checkbox");
		
		String freezeFutureDate = testdata.get("freezeFutureDate").toString();
		click(custSearch.activateDateTxtBox);
		input(custSearch.activateDateTxtBox, freezeFutureDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select a date from the calendar (not future date)");
		Log.info("Step:01 - Select a date from the calendar (not future date)");
		
		String freezeAlphabetComment = testdata.get("freezeAlphabetComment").toString();
		input(custSearch.freezeRemark, freezeAlphabetComment);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Remarks in Remarks field.");
		Log.info("Step:02 - Enter Remarks in Remarks field.");
		
		click(custSearch.freezeSubmitBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Submit Button");
		Log.info("Step:03 - Click on Submit Button");
		
		Thread.sleep(7000);
		if(ElementDisplayed(custSearch.deactivatedConfirmed)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer is moved to the deactivate list");
			Log.info("Expected Result: Customer is moved to the deactivate list");
		}
		click(custSearch.deactivatedConfirmed);
		ExtentTestManager.endTest();
		
		//click(custSearch.futureDateErrMsgOkBtn);
		
		//freeze customer - alphabetic input
//		click(custSearch.deactiveCheckBox);
//		//String freezeAlphabetComment = testdata.get("freezeAlphabetComment").toString();
//		input(custSearch.activateRemarkTxtBox, freezeAlphabetComment);
//		click(custSearch.freezeSubmitBtn);
//		if(ElementDisplayed(custSearch.activateListGrid)) {
//			ExtentTestManager.getTest().log(Status.PASS, "All input types are accepted, respecting varchar constraints");
//			Log.info("Customer is updated into freeze list");
//		}
//		
//		//freeze customer - numeric input
//		click(custSearch.deactiveCheckBox);
//		String freezeNumericComment = testdata.get("freezeNumericComment").toString();
//		input(custSearch.activateRemarkTxtBox, freezeNumericComment);
//		click(custSearch.freezeSubmitBtn);
//		if(ElementDisplayed(custSearch.activateListGrid)) {
//			ExtentTestManager.getTest().log(Status.PASS, "All input types are accepted, respecting varchar constraints");
//			Log.info("Customer is updated into freeze list");
//		}
//		
//		//freeze customer - Alphanumeric input
//		click(custSearch.deactiveCheckBox);
//		String freezeAlphanumericComment = testdata.get("freezeAlphanumericComment").toString();
//		input(custSearch.activateRemarkTxtBox, freezeAlphanumericComment);
//		click(custSearch.freezeSubmitBtn);
//		if(ElementDisplayed(custSearch.activateListGrid)) {
//			ExtentTestManager.getTest().log(Status.PASS, "Customer is updated into freeze list");
//			Log.info("Customer is updated into freeze list");
//		}
		
		//Activate Deactivated Customer
		
//		click(custSearch.custClearBtn);
//		click(custSearch.custId);
//		click(custSearch.custActiveOnly);
//		String inactiveCustomer = testdata.get("inactiveCustomer").toString();
//		input(custSearch.custId, inactiveCustomer);
//		click(custSearch.custSearchBtn);
//		click(custSearch.custSelect);
//		click(custSearch.activate);
//		Thread.sleep(1000);
//		if(ElementDisplayed(custSearch.custActiveWndow)) {
//			ExtentTestManager.getTest().log(Status.PASS, "Customer active window opens");
//			Log.info("Customer active window opens");
//		}
		
		//Verify Customer Details in Activation Window
//		boolean flag01 = ElementDisplayed(custSearch.freezeCustId);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify the Presence of Column - Customer ID.");
//		Log.info("Step:01 - Verify the Presence of Column - Customer ID.");
//		
//		boolean flag02 = ElementDisplayed(custSearch.freezeName);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Verify the Presence of Column - Name.");
//		Log.info("Step:02 - Verify the Presence of Column - Name.");
//		
//		boolean flag03 = ElementDisplayed(custSearch.freezeRisk);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Verify the Presence of Column - Risk.");
//		Log.info("Step:03 - Verify the Presence of Column - Risk.");
//		
//		boolean flag04 = ElementDisplayed(custSearch.freezePanNum);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Verify the Presence of Column - PAN No.");
//		Log.info("Step:04 - Verify the Presence of Column - PAN No.");
//		
//		boolean flag05 = ElementDisplayed(custSearch.freezeCrntAge);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Verify the Presence of Column - Current Age.");
//		Log.info("Step:05 - Verify the Presence of Column - Current Age.");
//		
//		boolean flag06 = ElementDisplayed(custSearch.freezeCustType);
//		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Verify the Presence of Column - Customer Type.");
//		Log.info("Step:06 - Verify the Presence of Column - Customer Type.");
//		
//		boolean flag00 = flag01 & flag02 & flag03 & flag04 & flag5 & flag06;
//		if(flag0 == true) { 
//			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Grid Column Names (Customer ID, Name, Risk, PAN No., Current Age, Customer Type) are displayed");
//			Log.info("Expected Result: Grid Column Names (Customer ID, Name, Risk, PAN No., Current Age, Customer Type) are displayed");
//		}
		
		//Activate Customer with Current Date
//		click(custSearch.deactiveCheckBox);
//		input(custSearch.activateRemarkTxtBox, freezeAlphabetComment);
//		click(custSearch.freezeSubmitBtn);
//		if(ElementDisplayed(custSearch.activateListGrid)) {
//			ExtentTestManager.getTest().log(Status.PASS, "Customer is moved into the active list");
//			Log.info("Customer is moved into the active list");
//		}
			
		
		//cancel Active window
		ExtentTestManager.startTest("Navigate to Customer Search After Cancel");
		
		click(custSearch.freezeCancelBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click Cancel button.");
		Log.info("Step:01 - Click Cancel button.");
		
		if(ElementDisplayed(custSearch.custSrch)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Page redirects back to the Customer Search window");
			Log.info("Expected Result: Page redirects back to the Customer Search window");
		}
	
		click(custSearch.custClearBtn);
		ExtentTestManager.endTest();
		return true;
	}
	
	
	public boolean deleteCust(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		click(custSearch.custClearBtn);
		
		ExtentTestManager.startTest("Delete Customer - Authorized Customer");
		
		String authorizedCustomer = testdata.get("authorizedCustomer").toString();
		input(custSearch.custId, authorizedCustomer);
		Thread.sleep(1000);
		click(custSearch.custSearchBtn);Thread.sleep(1000);
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select an authorized customer from the list.");
		Log.info("Step:01 - Select an authorized customer from the list.");
		
		click(custSearch.custDeleteBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Delete button");
		Log.info("Step:02 - Click on Delete button");
		
		Base_Class.AcceptAlert();Thread.sleep(9000);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Accept the Alert");
		Log.info("Step:03 - Accept the Alert");
		
			if(ElementDisplayed(custSearch.deleteAuthorizedPopUpOkBtn)) {
				ExtentTestManager.getTest().log(Status.PASS, "Validation message displayed: \"Cannot Delete. Authorized Customer.\"");
				Log.info("Validation message displayed: \"Cannot Delete. Authorized Customer.\"");
			}
		click(custSearch.deleteAuthorizedPopUpOkBtn);
		ExtentTestManager.endTest();
		
		
		//cancel delete
		click(custSearch.custClearBtn);
		ExtentTestManager.startTest("Cancel Deletion Confirmation");
		
		input(custSearch.custId, authorizedCustomer);
		Thread.sleep(1000);
		click(custSearch.custSearchBtn);Thread.sleep(1000);
		click(custSearch.custSelect);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Select an authorized customer from the list.");
		Log.info("Step:01 - Select an authorized customer from the list.");
		
		click(custSearch.custDeleteBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on Delete button");
		Log.info("Step:02 - Click on Delete button");
		
		Base_Class.DismissAlert();;
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Reject the Alert");
		Log.info("Step:03 - Reject the Alert");
		
			if(ElementDisplayed(custSearch.custListTable)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Deletion is canceled, customer remains in the list.");
				Log.info("Expected Result: Deletion is canceled, customer remains in the list.");
			}
			ExtentTestManager.endTest();
			
			
			//Click Delete Without Selection
			click(custSearch.custClearBtn);
			ExtentTestManager.startTest("Click Delete Without Selection");
			
			click(custSearch.custSearchBtn);Thread.sleep(1000);
			click(custSearch.custDeleteBtn);
			ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on the Delete button without selecting any customer.");
			Log.info("Step:01 - Click on the Delete button without selecting any customer.");
			
			if(ElementDisplayed(custSearch.deleteWithoutSelectOkBtn)) {
				ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed, e.g., \"Please select a customer to delete.\"");
				Log.info("Expected Result: Error message displayed, e.g., \"Please select a customer to delete.\"");
			}
			click(custSearch.deleteWithoutSelectOkBtn);

		return true;
	}
	
	
	
	public boolean signOut() throws InterruptedException {
		ExtentTestManager.startTest("Logout");
		click(custSearch.custSignOut);Thread.sleep(1000);
		if(ElementDisplayed(custSearch.loginButton)) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: User is logged out successfully, login screen is displayed.");
			Log.info("Expected Result: User is logged out successfully, login screen is displayed.");
		}
		driver.close();
		ExtentTestManager.endTest();
		return true;
	}
}

