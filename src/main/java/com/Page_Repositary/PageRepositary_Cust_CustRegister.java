package com.Page_Repositary;

import org.openqa.selenium.By;

public class PageRepositary_Cust_CustRegister {
	//PC Registration
	public By formName = By.xpath("//*[@id='Username']");
	public By formBranchName = By.xpath("//select[@id='ddlBranches']/option[text()='TRIVANDRUM']");
	public By formComputerName = By.xpath("//*[@id=\"MacName\"]");
	public By formSubmitBtn = By.xpath("/html/body/div[2]/div[11]/div/button/span");
	
	//Login Module
	public By loginUserName = By.xpath("//*[@id=\"txtUserName_txt\"]");
	public By loginPasswrd = By.xpath("//*[@id=\"txtPassword_txt\"]");
	public By loginButton = By.xpath("//*[@id=\"imgbtnSubmit\"]");
	public By logoutMsg = By.xpath("//*[@id=\"logMessage\"]");
	public By logoutOk = By.xpath("/html/body/div[1]/div/div[2]/div/form/div[11]/div[3]/div/button[1]");

	//Customer Register Window
	public By cust = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[1]/div");
	public By custRegister = By.xpath("/html/body/form/div[7]/div[1]/div/div/div/div/div/div/div/ul/li[1]/ul/li[5]");
	public By custIDTxtBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_txtCustomerId_txt\"]");
	public By custSrchBtn = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/div[2]/div[1]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/a/img");
	public By custShareChkBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_ucProductGroup_0\"]");
	public By custLoanChkBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_ucProductGroup_2\"]");
	public By custDebentureChkBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_ucProductGroup_4\"]");
	public By custDepositsChkBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_ucProductGroup_1\"]");
	public By custGeneralChkBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_ucProductGroup_3\"]");
	public By custInstSharesChkBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_ucProductGroup_5\"]");
	public By custInsuranceChkBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_chkInsurance\"]");
	public By custOtherChargeChkBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_ChkRecoveries\"]");
	public By custFullOverDueChkBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_ChkfullOD\"]");
	public By custCloseChkBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_cblTypes_0\"]");
	public By custDirectChkBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_cblTypes_1\"]");
	public By custInDirectChkBox = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_cblTypes_2\"]");
	public By custViewBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_btnAddCustomer1\"]");
	public By custCancelBtn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_btnCancel\"]");
	public By custGridItem = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/div[2]/div[1]/table/tbody/tr[4]/td/div/table/tbody/tr/td/div/div/table/tbody/tr[2]");
	public By custLoan = By.xpath("//td[@class='SubHead' and contains(text(), 'Loan')]");
	public By custDeposit = By.xpath("//td[@class='SubHead' and contains(text(), 'Deposits')]");
	public By custDetailGrid = By.xpath("//*[@id=\"tblCustList\"]");
	
	//Loan Grid Column Names
	public By loanProdName = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_lstLiability1_ctrl1_Div1\"]//tr[@class='GridHeader']/td[contains(text(), 'Product Name')]");
	public By loanAcNum = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_lstLiability1_ctrl1_Div1\"]//tr[@class='GridHeader']/td[contains(text(), 'A/C No')]");
	public By loanNature = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_lstLiability1_ctrl1_Div1\"]//tr[@class='GridHeader']/td[contains(text(), 'Nature')]");
	public By loanStartDate = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_lstLiability1_ctrl1_Div1\"]//tr[@class='GridHeader']/td[contains(text(), 'StartDate')]");
	public By loanDueDate = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_lstLiability1_ctrl1_Div1\"]//tr[@class='GridHeader']/td[contains(text(), 'DueDate')]");
	public By loanDur = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_lstLiability1_ctrl1_Div1\"]//tr[@class='GridHeader']/td[contains(text(), 'Dur')]");
	public By loanBalance = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_lstLiability1_ctrl1_Div1\"]//tr[@class='GridHeader']/td[contains(text(), 'Balance')]");
	public By loanDueAmount = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_lstLiability1_ctrl1_Div1\"]//tr[@class='GridHeader']/td[contains(text(), 'DueAmount')]");
	public By loanClosedOn = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_lstLiability1_ctrl1_Div1\"]//tr[@class='GridHeader']/td[contains(text(), 'ClosedOn')]");
	public By loanRemarks = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_lstLiability1_ctrl1_Div1\"]//tr[@class='GridHeader']/td[contains(text(), 'Remarks')]");
	public By loanDI = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_lstLiability1_ctrl1_Div1\"]//tr[@class='GridHeader']/td[contains(text(), 'D/I')]");
	public By loanPS = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_lstLiability1_ctrl1_Div1\"]//tr[@class='GridHeader']/td[contains(text(), 'P/S')]");
	public By loanPendAmt = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_lstLiability1_ctrl1_lstLiabilityInner_TdPendingAmount\"]");
	public By loanPendDays = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_lstLiability1_ctrl1_lstLiabilityInner_TdPendingDays\"]");
	public By loanFineAmt = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_lstLiability1_ctrl1_lstLiabilityInner_lblFineAmount\"]");
	public By loanPendCharges = By.xpath("//*[@id=\"ctl00_ctl00_CPH1_PRDCNT_LiabilityCustomerSearch1_lstLiability1_ctrl1_lstLiabilityInner_lblPendingCharges\"]");
	public By loanAmount = By.xpath("/html/body/form/div[7]/div[3]/div/div/div[2]/div/div/div[2]/div[4]/table/tbody/tr[4]/td/div/table/tbody/tr[1]/td[5]");

	//Error Window
	public By errMsg1 = By.xpath("//*[@id=\"ctl00_ctl00_lblErrorMessage\"]");
	public By errMsgOkBtn1 = By.xpath("//*[@id=\"closePleail\"]");
	public By errMsgOkBtn2 = By.xpath("//*[@id=\"closeThiche\"]");
	public By errMsgOkBtn3 = By.xpath("//*[@id=\"closeInprma\"]");

	//POP Up Window
	public By popUpWindow = By.xpath("/html/body/form/div[3]/div/div/div[1]/table");
	public By popUpWndSrchBtn = By.xpath("//*[@id=\"PopQuick1_btnSearch\"]");
	public By popUpWndNameTxtBox = By.xpath("//*[@id=\"PopQuick1_txtName\"]");
	public By popUpWndMobNumTxtBox = By.xpath("//*[@id=\"PopQuick1_txtMobileNo\"]");
	public By popUpWndCustIdTxtBox = By.xpath("//*[@id=\"PopQuick1_txtCustID\"]");
	public By popUpWndCustList = By.xpath("//*[@id=\"tblCustList\"]");
	public By popUpWndSelect = By.xpath("//*[@id=\"PopQuick1_lst_ctrl0_linkSelect\"]");
}
