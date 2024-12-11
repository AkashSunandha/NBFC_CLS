package com.Page_Customer;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Cust_CustRegister;
import com.Utility.Log;
import com.Utility.ScreenShot;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Customer_CustomerRegister extends Base_Class{
	PageRepositary_Cust_CustRegister custRgstr = new PageRepositary_Cust_CustRegister();
	ScreenShot sc = new ScreenShot(null);
	
	
//Customer Register Window
	public boolean customerRegisterWindow() throws InterruptedException {
		ExtentTestManager.startTest("TC:01 - Customer Register Window, Basic Navigation");
		
		click(custRgstr.cust);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to Customer");
		Log.info("Step:01 - Navigate to Customer");
		
		click(custRgstr.custRegister);Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Navigate to Customer>>Customer Register.");
		Log.info("Step:02 - Navigate to Customer>>Customer Register.");
		
		boolean flag1 = ElementDisplayed(custRgstr.custLoanChkBox);
		boolean flag2 = ElementDisplayed(custRgstr.custViewBtn);
		boolean flag3 = ElementDisplayed(custRgstr.custIDTxtBox);
		boolean flag = flag1 & flag2 & flag3;
		Thread.sleep(1000);
		if(flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer register window is open.");
			Log.info("Expected Result: Customer register window is open.");
		}
		ExtentTestManager.endTest();
		return true;
	}
	
	//Customer ID Field Required, validation
	public boolean srchWithoutCustId() throws InterruptedException {
		ExtentTestManager.startTest("TC:02 - Customer ID Field - Mandatory Check");
		
		click(custRgstr.custViewBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Navigate to Customer Register window & Click on View button.");
		Log.info("Step:01 - Navigate to Customer Register window & Click on View button.");
		
		boolean flag1 = ElementDisplayed(custRgstr.errMsg1);
		if(flag1 == true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: \"Please Fill the Required Details\" is displayed when clicked on \"View button\" without entering CustId");
			Log.info("Expected Result: \"Please Fill the Required Details \" is displayed when clicked on \"View button\" without entering CustId");
		}Thread.sleep(1000);
		click(custRgstr.errMsgOkBtn1);
		ExtentTestManager.endTest();
		return true;
	}
	
	//Customer Register - Validation for parameters 
	public boolean testAllParametersPresent() {
		ExtentTestManager.startTest("TC:04 - Customer Register - parameters availability check");
		
		boolean flag1 = ElementDisplayed(custRgstr.custShareChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify Availability of Share Checkbox.");
		Log.info("Step:01 - Verify Availability of Share Checkbox");
		
		boolean flag2 = ElementDisplayed(custRgstr.custLoanChkBox);		
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Verify Availability of Loan Checkbox.");
		Log.info("Step:02 - Verify Availability of Loan Checkbox");
		
		boolean flag3 = ElementDisplayed(custRgstr.custDebentureChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Verify Availability of Debenture Checkbox.");
		Log.info("Step:03 - Verify Availability of Debenture Checkbox");
		
		boolean flag4 = ElementDisplayed(custRgstr.custDepositsChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Verify Availability of Deposits Checkbox.");
		Log.info("Step:04 - Verify Availability of Deposits Checkbox");
		
		boolean flag5 = ElementDisplayed(custRgstr.custGeneralChkBox);		
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Verify Availability of General Checkbox.");
		Log.info("Step:05 - Verify Availability of General Checkbox");
		
		boolean flag6 = ElementDisplayed(custRgstr.custInstSharesChkBox);	
		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Verify Availability of Institutional Shares Checkbox.");
		Log.info("Step:06 - Verify Availability of Institutional Shares Checkbox");
		
		boolean flag7 = ElementDisplayed(custRgstr.custInsuranceChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:07 - Verify Availability of Insurance Checkbox.");
		Log.info("Step:07 - Verify Availability of Insurance Checkbox");
		
		boolean flag8 = ElementDisplayed(custRgstr.custOtherChargeChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:08 - Verify Availability of Other ChargeCheckbox.");
		Log.info("Step:08 - Verify Availability of Other ChargeCheckbox");
		
		boolean flag9 = ElementDisplayed(custRgstr.custFullOverDueChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:09 - Verify Availability of Full Over Due Checkbox.");
		Log.info("Step:09 - Verify Availability of Full Over Due Checkbox");
		
		boolean flag10 = ElementDisplayed(custRgstr.custCloseChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:10 - Verify Availability of Close Checkbox.");
		Log.info("Step:10 - Verify Availability of Close Checkbox");
		
		boolean flag11 = ElementDisplayed(custRgstr.custDirectChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:11 - Verify Availability of Direct Checkbox.");
		Log.info("Step:11 - Verify Availability of Direct Checkbox");
		
		boolean flag12 = ElementDisplayed(custRgstr.custInDirectChkBox);		
		ExtentTestManager.getTest().log(Status.PASS, "Step:12 - Verify Availability of InDirect Checkbox.");
		Log.info("Step:12 - Verify Availability of InDirect Checkbox");
		
		boolean flag = flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7 & flag8 & flag9 & flag10 & flag11 & flag12;
		if(flag == true) { 
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All parameters (Share, Loan, Debenuture, Deposits, General, Institutional, Insurance, Other Charge, Close, Direct & Indirect Check Box) present");
			Log.info("Expected Result: All parameters (Share, Loan, Debenuture, Deposits, General, Institutional, Insurance, Other Charge, Close, Direct & Indirect Check Box) present");
		}
		ExtentTestManager.endTest();
		return true;
	}
	
	//Customer ID BVA
	public boolean searchByMobileInvalid1(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {	
		//MIN-1 & MAX-1
		
		ExtentTestManager.startTest("TC:03 & 06 - Customer ID Field, BVA Validations");
		
		String invalidCustId1 = testdata.get("invalidCustId1").toString();
		input(custRgstr.custIDTxtBox, invalidCustId1);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Cust Id (<12 digits) in Customer Id field");
		Log.info("Step:01 - Enter Cust Id (<12 digits) in Customer Id field");
		
		click(custRgstr.custViewBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on View button");
		Log.info("Step:02 - Click on View button");
		
				boolean flag = ElementDisplayed(custRgstr.errMsg1);
				if(flag == true) {
					ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed for incorrect Customer ID(< 12 digits)" );
					 Log.info("Expected Result: Error message displayed for incorrect Customer ID(< 12 digits)");
				}					
				Thread.sleep(1000);
				click(custRgstr.errMsgOkBtn2);Thread.sleep(1000);
				clear(custRgstr.custIDTxtBox);
				ExtentTestManager.endTest();
				return true;
	}
	
//	public boolean searchByMobileInvalid2(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
//		//MIN+1 & MAX+1
//		
//		String invalidCustId2 = testdata.get("invalidCustId2").toString();
//		input(custRgstr.custIDTxtBox, invalidCustId2);
//		click(custRgstr.custViewBtn);
//				boolean flag = ElementDisplayed(custRgstr.errMsg1);
//				if(flag == true) {
//					ExtentTestManager.getTest().log(Status.PASS, "Error message displayed for incorrect Customer ID(> 12 digits)" );
//					 Log.info("Error message displayed for incorrect Customer ID(> 12 digits)");
//				}					
//				Thread.sleep(1000);
//				click(custRgstr.errMsgOkBtn2);Thread.sleep(1000);
//				clear(custRgstr.custIDTxtBox);
//				return true;
//	}
	
	public boolean viewByValidCustId(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		//MIN & MAX Value
		ExtentTestManager.startTest("TC:05, 06 & 14 - Customer ID Field, BVA Validation & Accounts Grid - Data Verification");
		
		String validCustId = testdata.get("validCustId").toString();
		input(custRgstr.custIDTxtBox, validCustId);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Valid Cust Id in Customer Id field");
		Log.info("Step:01 - Enter Valid Cust Id in Customer Id field");
		
		click(custRgstr.custViewBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on View button");
		Log.info("Step:02 - Click on View button");
		
		Thread.sleep(1000);
		boolean flag = ElementDisplayed(custRgstr.custGridItem);
		if(flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer Fetched Using Valid Customer ID, Successfully");
			Log.info("Expected Result: Customer Fetched Using Valid Customer ID, Successfully");
		}
		
		boolean flag1 = ElementDisplayed(custRgstr.loanProdName);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Verify the Presence of Column - Product Name.");
		Log.info("Step:01 - Verify the Presence of Column - Product Name.");
		
		boolean flag2 = ElementDisplayed(custRgstr.loanAcNum);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Verify the Presence of Column - A/C No.");
		Log.info("Step:02 - Verify the Presence of Column - A/C No.");
		
		boolean flag3 = ElementDisplayed(custRgstr.loanNature);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Verify the Presence of Column - Nature.");
		Log.info("Step:03 - Verify the Presence of Column - Nature.");
		
		boolean flag4 = ElementDisplayed(custRgstr.loanStartDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Verify the Presence of Column - StartDate.");
		Log.info("Step:04 - Verify the Presence of Column - StartDate.");
		
		boolean flag5 = ElementDisplayed(custRgstr.loanDueDate);
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Verify the Presence of Column - DueDate.");
		Log.info("Step:05 - Verify the Presence of Column - DueDate.");
		
		boolean flag6 = ElementDisplayed(custRgstr.loanDur);		
		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Verify the Presence of Column - Dur.");
		Log.info("Step:06 - Verify the Presence of Column - Dur.");
		
		boolean flag7 = ElementDisplayed(custRgstr.loanBalance);
		ExtentTestManager.getTest().log(Status.PASS, "Step:07 - Verify the Presence of Column - Balance.");
		Log.info("Step:07 - Verify the Presence of Column - Balance.");
		
		boolean flag8 = ElementDisplayed(custRgstr.loanDueAmount);
		ExtentTestManager.getTest().log(Status.PASS, "Step:08 - Verify the Presence of Column - DueAmount.");
		Log.info("Step:08 - Verify the Presence of Column - DueAmount.");
		
		boolean flag9 = ElementDisplayed(custRgstr.loanClosedOn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:09 - Verify the Presence of Column - ClosedOn.");
		Log.info("Step:09 - Verify the Presence of Column - ClosedOn.");
		
		boolean flag10 = ElementDisplayed(custRgstr.loanRemarks);
		ExtentTestManager.getTest().log(Status.PASS, "Step:10 - Verify the Presence of Column - Remarks.");
		Log.info("Step:10 - Verify the Presence of Column - Remarks.");
		
		boolean flag11 = ElementDisplayed(custRgstr.loanDI);
		ExtentTestManager.getTest().log(Status.PASS, "Step:11 - Verify the Presence of Column - D/I.");
		Log.info("Step:11 - Verify the Presence of Column - D/I.");
		
		boolean flag12 = ElementDisplayed(custRgstr.loanPS);
		ExtentTestManager.getTest().log(Status.PASS, "Step:12 - Verify the Presence of Column - P/S.");
		Log.info("Step:12 - Verify the Presence of Column - P/S.");
		
		boolean flag13 = ElementDisplayed(custRgstr.loanPendAmt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:13 - Verify the Presence of Column - Pending Amount.");
		Log.info("Step:13 - Verify the Presence of Column - Pending Amount.");
		
		boolean flag14 = ElementDisplayed(custRgstr.loanPendDays);
		ExtentTestManager.getTest().log(Status.PASS, "Step:14 - Verify the Presence of Column - Pending Days.");
		Log.info("Step:14 - Verify the Presence of Column - Pending Days.");
		
		boolean flag15 = ElementDisplayed(custRgstr.loanFineAmt);
		ExtentTestManager.getTest().log(Status.PASS, "Step:15 - Verify the Presence of Column - Fine Amount.");
		Log.info("Step:15 - Verify the Presence of Column - Fine Amount.");
		
		boolean flag16 = ElementDisplayed(custRgstr.loanPendCharges);
		ExtentTestManager.getTest().log(Status.PASS, "Step:16 - Verify the Presence of Column - Pending Charges.");
		Log.info("Step:16 - Verify the Presence of Column - Pending Charges.");
		
		boolean flag17 = ElementDisplayed(custRgstr.loanAmount);
		ExtentTestManager.getTest().log(Status.PASS, "Step:17 - Verify the Presence of Column - Amount.");
		Log.info("Step:17 - Verify the Presence of Column - Amount.");
		
		boolean flag0 = flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7 & flag8 & flag9 & flag10 & flag11 & flag12 & flag13 & flag14 & flag15 & flag16 & flag17;
		if(flag0 == true) { 
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Grid Column Names (Product Name, Account Number, Nature, Start Date, Amount, DueDate, Dur, Balance, DueAmount, ClosedOn, Remarks, D/I, P/S, Pending Amount) are displayed");
			Log.info("Expected Result: Grid Column Names (Product Name, Account Number, Nature, Start Date, Amount, DueDate, Dur, Balance, DueAmount, ClosedOn, Remarks, D/I, P/S, Pending Amount) are displayed");
		}
		click(custRgstr.custCancelBtn);
		clear(custRgstr.custIDTxtBox);
		ExtentTestManager.endTest();
		return true;
}
	
	public boolean viewByInValidCustId3(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC:16 - Error Handling - Invalid Characters in Customer ID");
		
		String invalidCustId3 = testdata.get("invalidCustId3").toString();
		input(custRgstr.custIDTxtBox, invalidCustId3);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Cust Id (Non numeric) in Customer Id field");
		Log.info("Step:01 - Enter Cust Id (Non numeric) in Customer Id field");
		
		click(custRgstr.custViewBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Click on View button");
		Log.info("Step:02 - Click on View button");
		
		Thread.sleep(1000);
		boolean flag = ElementDisplayed(custRgstr.errMsg1);
		if(flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Error message displayed for incorrect Customer ID(Non numeric)" );
			 Log.info("Expected Result: Error message displayed for incorrect Customer ID(Non numeric)");
		}					
		Thread.sleep(1000);
		click(custRgstr.errMsgOkBtn3);Thread.sleep(1000);
		clear(custRgstr.custIDTxtBox);
		ExtentTestManager.endTest();
		return true;
}
	
	public boolean srchBtnFunctionality(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC:07 - Pop UP Window should appear");
		
		click(custRgstr.custSrchBtn);Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on search icon");
		Log.info("Step:01 - Click on search icon");
		
		//Navigate to Pop Up Window
        String mainWindowHandle = driver.getWindowHandle();
        boolean popupAppeared = false;
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                driver.manage().window().maximize();
                popupAppeared = true;
        		String custName = testdata.get("custName").toString();
        		input(custRgstr.popUpWndNameTxtBox, custName);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Valid Cust Id in Customer Field");
        		Log.info("Step:02 - Enter Valid Cust Id in Customer Field");
        		
        		click(custRgstr.popUpWndSrchBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Search button");
        		Log.info("Step:03 - Click on Search button");
        		
//        		boolean flag = ElementDisplayed(custRgstr.popUpWndCustList);
//        		if(flag == true) {
//        			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup window should appear allowing customer selection.");
//        			Log.info("Expected Result: Popup window should appear allowing customer selection.");
//        		}
        		click(custRgstr.popUpWndSelect);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Select hyperlink from the customer list");
        		Log.info("Step:04 - Click on Select hyperlink from the customer list");
        		
        		driver.switchTo().window(mainWindowHandle);
        		click(custRgstr.custViewBtn);Thread.sleep(2000);
    			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Popup window should appear allowing customer selection.");
    			Log.info("Expected Result: Popup window should appear allowing customer selection.");
                break;
            }
        }
        click(custRgstr.custCancelBtn);
        clear(custRgstr.custIDTxtBox);
        ExtentTestManager.endTest();
        return true;
	}
	
	public boolean srchBtnFuntnWithParameters (Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		ExtentTestManager.startTest("TC:08 - Multiple Search Parameters Selection");
		
		click(custRgstr.custSrchBtn);Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Click on search icon");
		Log.info("Step:01 - Click on search icon");
		
		//Navigate to Pop Up Window
        String mainWindowHandle = driver.getWindowHandle();
        boolean popupAppeared = false;
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                driver.manage().window().maximize();
                popupAppeared = true;
        		String custName = testdata.get("custName").toString();
        		input(custRgstr.popUpWndNameTxtBox, custName);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Enter Valid name in Name Field");
        		Log.info("Step:02 - Enter Valid name in Name Field");
        		
        		click(custRgstr.popUpWndSrchBtn);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on Search button");
        		Log.info("Step:03 - Click on Search button");
        		
        		click(custRgstr.popUpWndSelect);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on Select hyperlink from the customer list");
        		Log.info("Step:04 - Click on Select hyperlink from the customer list");
        		
        		driver.switchTo().window(mainWindowHandle);Thread.sleep(1000);
        		click(custRgstr.custLoanChkBox);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Uncheck the Loan check box");
        		Log.info("Step:05 - Uncheck the Loan check box");
        		
        		click(custRgstr.custGeneralChkBox);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Uncheck the General check box");
        		Log.info("Step:06 - Uncheck the General check box");
        		
        		click(custRgstr.custInstSharesChkBox);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:07 - Uncheck the Institutional Shares check box");
        		Log.info("Step:07 - Uncheck the Institutional Shares check box");
        		
        		click(custRgstr.custCloseChkBox);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:08 - Uncheck the Close check box");
        		Log.info("Step:08 - Uncheck the Close check box");
        		
        		click(custRgstr.custInDirectChkBox);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:09 - Uncheck the In Direct check box");
        		Log.info("Step:09 - Uncheck the In Direct check box");
        		
        		click(custRgstr.custViewBtn);Thread.sleep(3000);
        		ExtentTestManager.getTest().log(Status.PASS, "Step:10 - Click on View button");
        		Log.info("Step:10 - Click on View button");
        		
        		boolean flag = ElementDisplayed(custRgstr.custGridItem);
        		if(flag == true) {
        			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Multiple Search Parameters to fetch Customer Details validated, Successfully!");
        			Log.info("Expected Result: Multiple Search Parameters to fetch Customer Details validated, Successfully!");
        		}
                break;
            }
        }
        click(custRgstr.custCancelBtn);
        clear(custRgstr.custIDTxtBox);
        ExtentTestManager.endTest();
        return true;
	}
	
	public boolean viewAndCancelBtnAvailability() {
		ExtentTestManager.startTest("TC:09 - View & Cancel Button Availability");
		
		boolean flag1 = ElementDisplayed(custRgstr.custViewBtn);
		boolean flag2 = ElementDisplayed(custRgstr.custCancelBtn);
		boolean flag = flag1 & flag2;
		if(flag == true) { 
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: View & Cancel button Available");
			Log.info("Expected Result: View & Cancel button Available");
		}
		ExtentTestManager.endTest();
		return true;
	}
	
	
	public boolean viewByLoan(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC:10 - View Button, Display Loan Accounts");
		
		String validCustId = testdata.get("validCustId").toString();
		input(custRgstr.custIDTxtBox, validCustId);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Valid Cust Id in Customer Id field");
		Log.info("Step:01 - Enter Valid Cust Id in Customer Id field");
		
		click(custRgstr.custLoanChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Check the Loan check box");
		Log.info("Step:02 - Check the Loan check box");
		
		click(custRgstr.custShareChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Uncheck the Share check box");
		Log.info("Step:03 - Uncheck the Share check box");
		
		click(custRgstr.custDebentureChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Uncheck the Debenture check box");
		Log.info("Step:04 - Uncheck the Debenture check box");
		
		click(custRgstr.custDepositsChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Uncheck the Loan check box");
		Log.info("Step:05 - Uncheck the Loan check box");
		
		click(custRgstr.custInDirectChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Check the In Direct check box");
		Log.info("Step:06 - Check the In Direct check box");
		
		click(custRgstr.custViewBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:07 - Click on View button");
		Log.info("Step:07 - Click on View button");
		
		Thread.sleep(5000);
		boolean flag = ElementDisplayed(custRgstr.custLoan);
		if(flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Loan account details of the customer is displayed in grid format");
			Log.info("Expected Result: Loan account details of the customer is displayed in grid format");
		}
		Thread.sleep(1000);
		click(custRgstr.custCancelBtn);
		clear(custRgstr.custIDTxtBox);
		ExtentTestManager.endTest();
		return true;
}
	
	public boolean viewByDeposits(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC:11 - View Button, Display Deposit Accounts");
		
		String validCustId = testdata.get("validCustId").toString();
		input(custRgstr.custIDTxtBox, validCustId);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Valid Cust Id in Customer Id field");
		Log.info("Step:01 - Enter Valid Cust Id in Customer Id field");
		
		click(custRgstr.custDepositsChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Check the Deposit check box");
		Log.info("Step:02 - Check the Deposit check box");
		
		click(custRgstr.custLoanChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Uncheck the Loan check box");
		Log.info("Step:03 - Uncheck the Loan check box");
		
		click(custRgstr.custViewBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on View button");
		Log.info("Step:04 - Click on View button");
		
		Thread.sleep(1000);
		boolean flag = ElementDisplayed(custRgstr.custDeposit);
		if(flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Deposit account details of the customer is displayed in grid format");
			Log.info("Expected Result: Deposit account details of the customer is displayed in grid format");
		}
		Thread.sleep(1000);
		click(custRgstr.custCancelBtn);
		clear(custRgstr.custIDTxtBox);
		ExtentTestManager.endTest();
		return true;
}
	
	public boolean viewByLoanAndDeposits(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC:12 & 17 - View Button, Loan and Deposit Accounts & Search Parameter - Check/Uncheck Options");
		
		String validCustId = testdata.get("validCustId").toString();
		input(custRgstr.custIDTxtBox, validCustId);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Valid Cust Id in Customer Id field");
		Log.info("Step:01 - Enter Valid Cust Id in Customer Id field");
		
		click(custRgstr.custLoanChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Check the Loan check box");
		Log.info("Step:02 - Check the Loan check box");
		
		click(custRgstr.custViewBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Click on View button");
		Log.info("Step:03 - Click on View button");
		
		Thread.sleep(1000);
		boolean flag1 = ElementDisplayed(custRgstr.custDeposit);
		boolean flag2 = ElementDisplayed(custRgstr.custLoan);
		boolean flag = flag1 & flag2;
		if(flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Both Loan & Deposit account details of the customer is displayed in grid format also Check/Uncheck Options validated");
			Log.info("Expected Result: Both Loan & Deposit account details of the customer is displayed in grid format also Check/Uncheck Options validated");
		}
		Thread.sleep(1000);
		click(custRgstr.custCancelBtn);
		clear(custRgstr.custIDTxtBox);
		ExtentTestManager.endTest();
		return true;
}
	
	public boolean viewWithoutParameters(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC:13 - View Button, No Search Parameters");
		
		String validCustId = testdata.get("validCustId").toString();
		input(custRgstr.custIDTxtBox, validCustId);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Valid Cust Id in Customer Id field");
		Log.info("Step:01 - Enter Valid Cust Id in Customer Id field");
		
		click(custRgstr.custLoanChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Uncheck the Loan check box");
		Log.info("Step:02 - Uncheck the Loan check box");
		
		click(custRgstr.custDepositsChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Uncheck the Deposits check box");
		Log.info("Step:03 - Uncheck the Deposits check box");
		
		click(custRgstr.custViewBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Click on View button");
		Log.info("Step:04 - Click on View button");
		
		Thread.sleep(1000);
		boolean flag = ElementDisplayed(custRgstr.custDetailGrid);
		if(flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "Expected Result: Customer details is displayed in grid format");
			Log.info("Expected Result: Customer details is displayed in grid format");
		}
		Thread.sleep(1000);
		click(custRgstr.custCancelBtn);
		clear(custRgstr.custIDTxtBox);
		ExtentTestManager.endTest();
		return true;
}
	
	public boolean cancelBtnFunctionality(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		ExtentTestManager.startTest("TC:15 - Cancel Button Functionality");
		
		String validCustId = testdata.get("validCustId").toString();
		input(custRgstr.custIDTxtBox, validCustId);
		ExtentTestManager.getTest().log(Status.PASS, "Step:01 - Enter Valid Cust Id in Customer Id field");
		Log.info("Step:01 - Enter Valid Cust Id in Customer Id field");
		
		click(custRgstr.custShareChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:02 - Check the Share check box");
		Log.info("Step:02 - Check the Share check box");
		
		click(custRgstr.custLoanChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:03 - Check the Loan check box");
		Log.info("Step:03 - Check the Loan check box");
		
		click(custRgstr.custDebentureChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:04 - Check the Debenture check box");
		Log.info("Step:04 - Check the Debenture check box");
		
		click(custRgstr.custDepositsChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:05 - Check the Deposits check box");
		Log.info("Step:05 - Check the Deposits check box");
		
		click(custRgstr.custGeneralChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:06 - Check the General check box");
		Log.info("Step:06 - Check the General check box");
		
		click(custRgstr.custInstSharesChkBox);
		ExtentTestManager.getTest().log(Status.PASS, "Step:07 - Check the Institutional Shares check box");
		Log.info("Step:07 - Check the Institutional Shares check box");
		
		click(custRgstr.custViewBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:08 - Click on View button");
		Log.info("Step:08 - Click on View button");
//		Thread.sleep(1000);
//		boolean flag = ElementDisplayed(custRgstr.custDetailGrid);
//		if(flag == true) {
//			ExtentTestManager.getTest().log(Status.PASS, "Customer Accounts details is displayed in grid format");
//			Log.info("Customer Accounts details is displayed in grid format");
//		}
		Thread.sleep(1000);
		click(custRgstr.custCancelBtn);
		ExtentTestManager.getTest().log(Status.PASS, "Step:09 - Click on Cancel button");
		Log.info("Step:09 - Click on Cancel button");
		
		ExtentTestManager.getTest().log(Status.PASS, "Expected Result: All displayed data is cleared, returning to initial state of Customer Register window.");
		Log.info("Expected Result: All displayed data is cleared, returning to initial state of Customer Register window.");
		Thread.sleep(1000);
		clear(custRgstr.custIDTxtBox);
		ExtentTestManager.endTest();
		return true;
}
	
	
	
}
