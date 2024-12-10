package com.test.Customer;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Pages_LeaveModule.Leave_EWCLeaveRequest;
import com.Pages_LeaveModule.Methods_NBFC_CLS;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import org.openqa.selenium.By;

public class AllScenarios_Cust_CustSearch extends Base_Class{
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	PageRepositary_Cust_CustSearch custSearch = new PageRepositary_Cust_CustSearch();	
	TestListener TestListener; 
	com.Utility.ScreenShot screenShot;
	
	
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();


	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Customer_CustSearch");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}

	@Test(dataProvider = "TestData")
	public void customerSearch(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		
		try {
			if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");

				//TC No. - 01 --> Application launch
				Base_Class.SetUp();
				Thread.sleep(2000);
								
				//PC Registration
				custSrchMthds.pcRegistration(testdata, context);
				
				//TC No. - 03, 91 --> Invalid Login - Incorrect Password
				custSrchMthds.userLoginInValidPaswrd(testdata, context);

				//TC No. - 02 --> Valid Login
				custSrchMthds.userLoginValidPaswrd(testdata, context);

				//TC No. - 04, 95 --> Navigate to Customer Search
				Thread.sleep(4000);
				custSrchMthds.customerSearchWindow();
				
				//TC No. - 05, 09 & TC - 13--> Mobile Field - BVA Validations
				custSrchMthds.mobileFieldBVA(testdata, context);
				
				//TC No. - 06, 22, 24, 27, 32, 39, 41, 42, 52, 54, 56, 65, 69, 84, 97, 98, 99, 106, 107, 120 --> Fetch Customer by Name
				custSrchMthds.nameFieldECP(testdata, context);
				
				//TC No. - 07, 55 --> Fetch Customers Without Inputs
				custSrchMthds.searchWithoutInputs();
				
				//TC No. - 08 --> Invalid Aadhaar Number
				custSrchMthds.searchByInvalidAadhaar(testdata, context);
			
				//TC No. - 10 --> Clear Functionality
				custSrchMthds.clearFunctionality(testdata, context);
				
				//TC No. - 11 --> Toggle Is Institutional Checkbox
				custSrchMthds.fetchInstitutions();
				
				//TC No. - 12 --> Verify the field House Name
				custSrchMthds.houseName(testdata, context);
				
				//TC No. - 13, 14 & 16 --> Verify the field Doc Type & Doc No
//				custSrchMthds.docTypeAndDocNo(testdata, context);
				
				//TC No. - 15 --> Verify the field PAN No
				custSrchMthds.panNum(testdata, context);
				
				//TC No. - 17 --> Check KYC Compliant Only Check box
				custSrchMthds.kycCompliantOnly();
				
				//TC No. - 18 --> Check Active Only Check box
				custSrchMthds.isActiveOnly();
				
				//TC No. - 19 --> Check Prospects Only Check box
				custSrchMthds.prospectsOnly();
				
				//TC No. - 20 --> Check Include Reject Checkbox
				custSrchMthds.includeReject();				
				
				//TC No. - 24 --> Edit Customer Last Name - Valid Edit
				custSrchMthds.custLastNameEdit(testdata, context);
				
				//TC No. - 28 & 31--> Last Name Field - ECP Validations
				custSrchMthds.lastNameECP(testdata, context);
				
				//TC No. - 34 --> View Customer Details
				custSrchMthds.viewCustDetails(testdata, context);
				
				//TC No. - 44, 45, --> Open Attachment Popup {Errors work on it}
				custSrchMthds.attachmentPopUp(testdata, context);
				
				//TC No. - 57, 58, 59, 60, 61, 62 --> Freeze {Errors work on it}
				custSrchMthds.freeze(testdata, context);
				
				//TC No. - 71, 72, 74, 80, 82, 88, --> Activate{Errors work on it}
				custSrchMthds.active(testdata, context);
				
				//TC No. - 101, 102, 103 --> Delete Customer - Authorized Customer
				custSrchMthds.deleteCust(testdata, context);

				//TC No. - 105 --> Logout
				Thread.sleep(5000);
				custSrchMthds.signOut();
				
			// EndTest
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
			}		
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	@DataProvider(name = "TestData")
	public static Object[][] gettestdate() throws IOException {

		Object[][] objectarry = null;
		java.util.List<Map<String, String>> completedata = com.Utility.ExcelReader.getdata();

		objectarry = new Object[completedata.size()][1];

		for (int i = 0; i < completedata.size(); i++) {
			objectarry[i][0] = completedata.get(i);
		}
		return objectarry;
	}
	
}


