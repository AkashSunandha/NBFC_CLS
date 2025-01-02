package com.test.Customer;

import java.io.IOException;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Page_Customer.Customer_CustomerRegister;
import com.Page_Repositary.PageRepositary_Cust_CustRegister;
import com.Page_Repositary.PageRepositary_Cust_CustSearch;
import com.Utility.Log;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

public class AllScenarios_Cust_CustRegister extends Base_Class{
	com.Utility.ExcelReader ExcelReader;
	Base_Class Base_Class;
	Log log;
	TestListener TestListener; 
	com.Utility.ScreenShot screenShot;
	PageRepositary_Cust_CustRegister custRgstr = new PageRepositary_Cust_CustRegister();
	com.Page_Customer.Customer_CustomerSearch custSrchMthds = new com.Page_Customer.Customer_CustomerSearch();
	Customer_CustomerRegister custRgstrMthds = new Customer_CustomerRegister();
	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("Customer_CustRegister");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
	}
	
	@Test(dataProvider = "TestData")
	public void customerRegister(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException{
		try {
			if(testdata.get("Run").toString().equalsIgnoreCase("Yes")){
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				context.setAttribute("fileName", "Login");
//				ExtentTestManager.endTest();
				
				
				//Application launch
				ExtentTestManager.startTest("Firefox Driver & Application Launch");
				Base_Class.SetUp();
				ExtentTestManager.endTest();
				Thread.sleep(2000);


				//PC Registration
				custSrchMthds.pcRegistration(testdata, context);
				
				//User Login
				custSrchMthds.userLoginValidPaswrd(testdata, context);

				//TC No. - 01 --> Customer Register Window
				custRgstrMthds.customerRegisterWindow();
				
				//TC No. - 02 --> Customer ID Field - Mandatory Check, validation
				custRgstrMthds.srchWithoutCustId();
				
				//TC No. - 04 --> Customer Register - parameters - Validation for parameters availability
				custRgstrMthds.testAllParametersPresent();
				
				//TC No. - 03,05 & 06 --> Customer ID Field BVA
				//MIN-1 & MAX-1
				custRgstrMthds.searchByMobileInvalid1(testdata, context);
				//MIN & MAX Value & TC No. - 14 --> Accounts Grid - Data Verification
				custRgstrMthds.viewByValidCustId(testdata, context);
				
				//TC No. - 16 --> Error Handling - Invalid Characters in Customer ID text box
				custRgstrMthds.viewByInValidCustId3(testdata, context);
				
				//TC No. - 07 --> Pop UP Window should appear
				custRgstrMthds.srchBtnFunctionality(testdata, context);
				
				//TC No. - 08 --> Multiple Search Parameters Selection
				custRgstrMthds.srchBtnFuntnWithParameters(testdata, context);
				
				//TC No. - 09 --> View & Cancel Button Availability
				custRgstrMthds.viewAndCancelBtnAvailability();
				
				//TC No. - 10 --> View Loan Account details of Customer
				custRgstrMthds.viewByLoan(testdata, context);
				
				//TC No. - 11 --> View Deposit Account details of Customer
				custRgstrMthds.viewByDeposits(testdata, context);
				
				//TC No. - 12 --> View Loan & Deposit Account details of Customer
				//& TC No. - 17 -->Search Parameter - Check/Uncheck Options
				custRgstrMthds.viewByLoanAndDeposits(testdata, context);
				
				//TC No. - 13 --> View Button - No Search Parameters (fetch without any parameters)
				custRgstrMthds.viewWithoutParameters(testdata, context);
				
				//TC No. - 15 --> Cancel Button Functionality
				custRgstrMthds.cancelBtnFunctionality(testdata, context);
				

				
				//Sign out
				Thread.sleep(5000);
				custSrchMthds.signOut();
				driver.close();
				
				// EndTest
//				ExtentTestManager.endTest();
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
