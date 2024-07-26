package com.midexam.service;

import com.midexam.dao.BankAccountDao;
import com.midexam.dao.BankAccountDaoImpl;
import com.midexam.entity.BankAccount;

public class BankAccountServiceImpl implements BankAccountService {
	
	BankAccountDao bankAccountDao = null;
	
	@Override
	public void createAccount(BankAccount bankAccount) {
		bankAccountDao = new BankAccountDaoImpl();
		bankAccountDao.createAccount(bankAccount);
		
	}

	@Override
	public void displayAllAccountDetails() {
		bankAccountDao = new BankAccountDaoImpl();
		bankAccountDao.displayAllAccountDetails();
	}

	@Override
	public void updatecustomerNameByActNumber(int actNumber, String customerName) {
		bankAccountDao = new BankAccountDaoImpl();
		bankAccountDao.updatecustomerNameByActNumber(actNumber, customerName);
	}

	@Override
	public void deleteAccountById(int actNumber) {
		bankAccountDao = new BankAccountDaoImpl();
		bankAccountDao.deleteAccountById(actNumber);
	}

	@Override
	public void findAccByactNumber(int actNumber) {
		bankAccountDao = new BankAccountDaoImpl();
		bankAccountDao.findAccByactNumber(actNumber);
	}

	@Override
	public void findAccByCustomerName(String customerName) {
		bankAccountDao = new BankAccountDaoImpl();
		bankAccountDao.findAccByCustomerName(customerName);
	}

	@Override
	public void findAccByBranchCode(int branchCode) {
		bankAccountDao = new BankAccountDaoImpl();
		bankAccountDao.findAccByBranchCode(branchCode);
	}

	@Override
	public void groupByActNumberCustomerNameCity() {
		bankAccountDao = new BankAccountDaoImpl();
		bankAccountDao.groupByActNumberCustomerNameCity();
	}
}
