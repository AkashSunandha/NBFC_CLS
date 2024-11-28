package com.Page_Customer;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestContext;

import com.BasePackage.Base_Class;
import com.Page_Repositary.PageRepositary_Cust_CustRegister;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class Customer_CustomerRegister extends Base_Class{
	PageRepositary_Cust_CustRegister custRgstr = new PageRepositary_Cust_CustRegister();
	
	//Customer Register Window
	public boolean customerRegisterWindow() throws InterruptedException {
		click(custRgstr.cust);
		click(custRgstr.custRegister);Thread.sleep(2000);
		boolean flag1 = ElementDisplayed(custRgstr.custLoanChkBox);
		boolean flag2 = ElementDisplayed(custRgstr.custViewBtn);
		boolean flag3 = ElementDisplayed(custRgstr.custIDTxtBox);
		boolean flag = flag1 & flag2 & flag3;
		Thread.sleep(1000);
		if(flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "TC No. - 01 --> Customer Register Window loaded Successfully!");
			Log.info("TC No. - 01 --> Customer Register Window loaded Successfully!");
		}
		return true;
	}
	
	//Customer ID Field Required, validation
	public boolean srchWithoutCustId() throws InterruptedException {
		click(custRgstr.custViewBtn);
		boolean flag1 = ElementDisplayed(custRgstr.errMsg1);
		if(flag1 == true) {
			ExtentTestManager.getTest().log(Status.PASS, "TC No. - 02 --> \"Please Fill the Required Details\" is displayed when clicked on \"View button\" without entering CustId");
			Log.info("TC No. - 02 --> \"Please Fill the Required Details \" is displayed when clicked on \"View button\" without entering CustId");
		}Thread.sleep(1000);
		click(custRgstr.errMsgOkBtn1);
		return true;
	}
	
	//Customer Register - Validation for parameters 
	public boolean testAllParametersPresent() {
		boolean flag1 = ElementDisplayed(custRgstr.custShareChkBox);
		boolean flag2 = ElementDisplayed(custRgstr.custLoanChkBox);
		boolean flag3 = ElementDisplayed(custRgstr.custDebentureChkBox);
		boolean flag4 = ElementDisplayed(custRgstr.custDepositsChkBox);
		boolean flag5 = ElementDisplayed(custRgstr.custGeneralChkBox);
		boolean flag6 = ElementDisplayed(custRgstr.custInstSharesChkBox);
		boolean flag7 = ElementDisplayed(custRgstr.custInsuranceChkBox);
		boolean flag8 = ElementDisplayed(custRgstr.custOtherChargeChkBox);
		boolean flag9 = ElementDisplayed(custRgstr.custFullOverDueChkBox);
		boolean flag10 = ElementDisplayed(custRgstr.custCloseChkBox);
		boolean flag11 = ElementDisplayed(custRgstr.custDirectChkBox);
		boolean flag12 = ElementDisplayed(custRgstr.custInDirectChkBox);
		boolean flag = flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7 & flag8 & flag9 & flag10 & flag11 & flag12;
		if(flag == true) { 
			ExtentTestManager.getTest().log(Status.PASS, "TC No. - 04 --> All parameters (Share, Loan, Debenuture, Deposits, General, Institutional, Insurance, Other Charge, Close, Direct & Indirect Check Box) present");
			Log.info("TC No. - 04 --> All parameters (Share, Loan, Debenuture, Deposits, General, Institutional, Insurance, Other Charge, Close, Direct & Indirect Check Box) present");
		}return true;
	}
	
	//Customer ID BVA
	public boolean searchByMobileInvalid1(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		//MIN-1 & MAX-1
		
		String invalidCustId1 = testdata.get("invalidCustId1").toString();
		input(custRgstr.custIDTxtBox, invalidCustId1);
		click(custRgstr.custViewBtn);
				boolean flag = ElementDisplayed(custRgstr.errMsg1);
				if(flag == true) {
					ExtentTestManager.getTest().log(Status.PASS, "TC No. - 03 & 06 --> Error message displayed for incorrect Customer ID(< 12 digits)" );
					 Log.info("TC No. - 03 & 06 --> Error message displayed for incorrect Customer ID(< 12 digits)");
				}					
				Thread.sleep(1000);
				click(custRgstr.errMsgOkBtn2);Thread.sleep(1000);
				clear(custRgstr.custIDTxtBox);
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
		String validCustId = testdata.get("validCustId").toString();
		input(custRgstr.custIDTxtBox, validCustId);
		click(custRgstr.custViewBtn);
		Thread.sleep(1000);
		boolean flag = ElementDisplayed(custRgstr.custGridItem);
		if(flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "TC No. - 05 & 06 --> Customer Fetched Using Valid Customer ID, Successfully");
			Log.info("TC No. - 05 & 06 --> Customer Fetched Using Valid Customer ID, Successfully");
		}
		
		boolean flag1 = ElementDisplayed(custRgstr.loanProdName);
		boolean flag2 = ElementDisplayed(custRgstr.loanAcNum);
		boolean flag3 = ElementDisplayed(custRgstr.loanNature);
		boolean flag4 = ElementDisplayed(custRgstr.loanStartDate);
		boolean flag5 = ElementDisplayed(custRgstr.loanDueDate);
		boolean flag6 = ElementDisplayed(custRgstr.loanDur);
		boolean flag7 = ElementDisplayed(custRgstr.loanBalance);
		boolean flag8 = ElementDisplayed(custRgstr.loanDueAmount);
		boolean flag9 = ElementDisplayed(custRgstr.loanClosedOn);
		boolean flag10 = ElementDisplayed(custRgstr.loanRemarks);
		boolean flag11 = ElementDisplayed(custRgstr.loanDI);
		boolean flag12 = ElementDisplayed(custRgstr.loanPS);
		boolean flag13 = ElementDisplayed(custRgstr.loanPendAmt);
		boolean flag14 = ElementDisplayed(custRgstr.loanPendDays);
		boolean flag15 = ElementDisplayed(custRgstr.loanFineAmt);
		boolean flag16 = ElementDisplayed(custRgstr.loanPendCharges);
		boolean flag17 = ElementDisplayed(custRgstr.loanAmount);
		boolean flag0 = flag1 & flag2 & flag3 & flag4 & flag5 & flag6 & flag7 & flag8 & flag9 & flag10 & flag11 & flag12 & flag13 & flag14 & flag15 & flag16 & flag17;
		if(flag0 == true) { 
			ExtentTestManager.getTest().log(Status.PASS, "TC No. - 14 --> Grid Column Names (Product Name, Account Number, Nature, Start Date, Amount, DueDate, Dur, Balance, DueAmount, ClosedOn, Remarks, D/I, P/S, Pending Amount) are displayed");
			Log.info("TC No. - 14 --> Grid Column Names (Product Name, Account Number, Nature, Start Date, Amount, DueDate, Dur, Balance, DueAmount, ClosedOn, Remarks, D/I, P/S, Pending Amount) are displayed");
		}
		click(custRgstr.custCancelBtn);
		clear(custRgstr.custIDTxtBox);
return true;
}
	
	public boolean viewByInValidCustId3(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		String invalidCustId3 = testdata.get("invalidCustId3").toString();
		input(custRgstr.custIDTxtBox, invalidCustId3);
		click(custRgstr.custViewBtn);
		Thread.sleep(1000);
		boolean flag = ElementDisplayed(custRgstr.errMsg1);
		if(flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "TC No. - 16 --> Error message displayed for incorrect Customer ID(Non numeric)" );
			 Log.info("TC No. - 16 --> Error message displayed for incorrect Customer ID(Non numeric)");
		}					
		Thread.sleep(1000);
		click(custRgstr.errMsgOkBtn3);Thread.sleep(1000);
		clear(custRgstr.custIDTxtBox);
		return true;
}
	
	public boolean srchBtnFunctionality(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		click(custRgstr.custSrchBtn);Thread.sleep(1000);
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
        		click(custRgstr.popUpWndSrchBtn);
        		boolean flag = ElementDisplayed(custRgstr.popUpWndCustList);
        		if(flag == true) {
        			ExtentTestManager.getTest().log(Status.PASS, "TC No. - 07 --> Popup window Displayed & Search Button Functionality validated, Successfully!");
        			Log.info("TC No. - 07 --> Popup window Displayed & Search Button Functionality validated, Successfully!");
        		}
        		click(custRgstr.popUpWndSelect);
        		driver.switchTo().window(mainWindowHandle);
        		click(custRgstr.custViewBtn);Thread.sleep(2000);
                break;
            }
        }
        click(custRgstr.custCancelBtn);
        clear(custRgstr.custIDTxtBox);
		return true;
	}
	
	public boolean srchBtnFuntnWithParameters (Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException {
		click(custRgstr.custSrchBtn);Thread.sleep(1000);
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
        		click(custRgstr.popUpWndSrchBtn);
        		click(custRgstr.popUpWndSelect);
        		driver.switchTo().window(mainWindowHandle);Thread.sleep(1000);
        		click(custRgstr.custLoanChkBox);
        		click(custRgstr.custGeneralChkBox);
        		click(custRgstr.custInstSharesChkBox);
        		click(custRgstr.custCloseChkBox);
        		click(custRgstr.custInDirectChkBox);
        		click(custRgstr.custViewBtn);Thread.sleep(3000);
        		boolean flag = ElementDisplayed(custRgstr.custGridItem);
        		if(flag == true) {
        			ExtentTestManager.getTest().log(Status.PASS, "TC No. - 08 --> Multiple Search Parameters to fetch Customer Details validated, Successfully!");
        			Log.info("TC No. - 08 --> Multiple Search Parameters to fetch Customer Details validated, Successfully!");
        		}
                break;
            }
        }
        click(custRgstr.custCancelBtn);
        clear(custRgstr.custIDTxtBox);
		return true;
	}
	
	public boolean viewAndCancelBtnAvailability() {
		boolean flag1 = ElementDisplayed(custRgstr.custViewBtn);
		boolean flag2 = ElementDisplayed(custRgstr.custCancelBtn);
		boolean flag = flag1 & flag2;
		if(flag == true) { 
			ExtentTestManager.getTest().log(Status.PASS, "TC No. - 09 --> View & Cancel button Available");
			Log.info("TC No. - 09 --> View & Cancel button Available");
		}return true;
	}
	
	
	public boolean viewByLoan(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		String validCustId = testdata.get("validCustId").toString();
		input(custRgstr.custIDTxtBox, validCustId);
		click(custRgstr.custLoanChkBox);
		click(custRgstr.custShareChkBox);
		click(custRgstr.custDebentureChkBox);
		click(custRgstr.custDepositsChkBox);
		click(custRgstr.custInDirectChkBox);
		click(custRgstr.custViewBtn);
		Thread.sleep(1000);
		boolean flag = ElementDisplayed(custRgstr.custLoan);
		if(flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "TC No. - 10 --> Loan account details of the customer is displayed in grid format");
			Log.info("TC No. - 10 --> Loan account details of the customer is displayed in grid format");
		}
		Thread.sleep(1000);
		click(custRgstr.custCancelBtn);
		clear(custRgstr.custIDTxtBox);
return true;
}
	
	public boolean viewByDeposits(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		String validCustId = testdata.get("validCustId").toString();
		input(custRgstr.custIDTxtBox, validCustId);
		click(custRgstr.custDepositsChkBox);
		click(custRgstr.custLoanChkBox);
		click(custRgstr.custViewBtn);
		Thread.sleep(1000);
		boolean flag = ElementDisplayed(custRgstr.custDeposit);
		if(flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "TC No. - 11 --> Deposit account details of the customer is displayed in grid format");
			Log.info("TC No. - 11 --> Deposit account details of the customer is displayed in grid format");
		}
		Thread.sleep(1000);
		click(custRgstr.custCancelBtn);
		clear(custRgstr.custIDTxtBox);
return true;
}
	
	public boolean viewByLoanAndDeposits(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		String validCustId = testdata.get("validCustId").toString();
		input(custRgstr.custIDTxtBox, validCustId);
		click(custRgstr.custLoanChkBox);
		click(custRgstr.custViewBtn);
		Thread.sleep(1000);
		boolean flag1 = ElementDisplayed(custRgstr.custDeposit);
		boolean flag2 = ElementDisplayed(custRgstr.custLoan);
		boolean flag = flag1 & flag2;
		if(flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "TC No. - 12 & 17 --> Both Loan & Deposit account details of the customer is displayed in grid format");
			Log.info("TC No. - 12 & 17 --> Both Loan & Deposit account details of the customer is displayed in grid format");
		}
		Thread.sleep(1000);
		click(custRgstr.custCancelBtn);
		clear(custRgstr.custIDTxtBox);
return true;
}
	
	public boolean viewWithoutParameters(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		String validCustId = testdata.get("validCustId").toString();
		input(custRgstr.custIDTxtBox, validCustId);
		click(custRgstr.custLoanChkBox);
		click(custRgstr.custDepositsChkBox);
		click(custRgstr.custViewBtn);
		Thread.sleep(1000);
		boolean flag = ElementDisplayed(custRgstr.custDetailGrid);
		if(flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "TC No. - 13 --> Customer details is displayed in grid format");
			Log.info("TC No. - 13 --> Customer details is displayed in grid format");
		}
		Thread.sleep(1000);
		click(custRgstr.custCancelBtn);
		clear(custRgstr.custIDTxtBox);
return true;
}
	
	public boolean cancelBtnFunctionality(Map<Object, Object> testdata, ITestContext context) throws ClassNotFoundException, InterruptedException, IOException  {
		String validCustId = testdata.get("validCustId").toString();
		input(custRgstr.custIDTxtBox, validCustId);
		click(custRgstr.custShareChkBox);
		click(custRgstr.custLoanChkBox);
		click(custRgstr.custDebentureChkBox);
		click(custRgstr.custDepositsChkBox);
		click(custRgstr.custGeneralChkBox);
		click(custRgstr.custInstSharesChkBox);
		click(custRgstr.custViewBtn);
		Thread.sleep(1000);
		boolean flag = ElementDisplayed(custRgstr.custDetailGrid);
		if(flag == true) {
			ExtentTestManager.getTest().log(Status.PASS, "Customer Accounts details is displayed in grid format");
			Log.info("Customer Accounts details is displayed in grid format");
		}
		Thread.sleep(1000);
		click(custRgstr.custCancelBtn);
		ExtentTestManager.getTest().log(Status.PASS, "TC No. - 15 --> All displayed data is cleared, returned Customer Register window.");
		Log.info("TC No. - 15 --> All displayed data is cleared, returned Customer Register window.");
		Thread.sleep(1000);
		clear(custRgstr.custIDTxtBox);
		return true;
}
	
	
	
}
