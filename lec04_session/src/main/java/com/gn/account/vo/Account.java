package com.gn.account.vo;

public class Account {
	private int accountNo;
	private String accountId;
	private String accountPw;
	private String rememberAccount;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(int accountNo, String accountId, String accountPw, String rememberAccount) {
		super();
		this.accountNo = accountNo;
		this.accountId = accountId;
		this.accountPw = accountPw;
		this.rememberAccount = rememberAccount;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountPw() {
		return accountPw;
	}

	public void setAccountPw(String accountPw) {
		this.accountPw = accountPw;
	}

	public String getRememberAccount() {
		return rememberAccount;
	}

	public void setRememberAccount(String rememberAccount) {
		this.rememberAccount = rememberAccount;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountId=" + accountId + ", accountPw=" + accountPw
				+ ", rememberAccount=" + rememberAccount + "]";
	}
	
	
	
}
