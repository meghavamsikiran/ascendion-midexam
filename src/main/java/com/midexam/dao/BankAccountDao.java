package com.midexam.dao;

import com.midexam.entity.BankAccount;

public interface BankAccountDao {
	
	public void createAccount(BankAccount bankAccount);
	public void displayAllAccountDetails();
	public void updatecustomerNameByActNumber(int actNumber, String customerName);
	public void deleteAccountById(int actNumber);
	public void findAccByactNumber(int actNumber);
	public void findAccByCustomerName(String customerName);
	public void findAccByBranchCode(int branchCode);	
	public void groupByActNumberCustomerNameCity();
}
