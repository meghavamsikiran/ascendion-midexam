package com.midexam.dao;

import java.util.List;

import com.midexam.entity.BankAccount;
import com.midexam.util.EntityUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class BankAccountDaoImpl implements BankAccountDao {
	
	EntityManager em = null;
	EntityTransaction et = null;
	
	@Override
	public void createAccount(BankAccount bankAccount) {
		em = EntityUtil.getEntityManager();
		et = em.getTransaction();
		et.begin();
		em.persist(bankAccount);
		et.commit();
		System.out.println("==> Record Inserted Successfully");
		em.close();
	}

	@Override
	public void displayAllAccountDetails() {
		em = EntityUtil.getEntityManager();
		Query query = null;
		query = em.createQuery("Select b from BankAccount as b");
		List<BankAccount> list = query.getResultList();
		for(BankAccount b: list)
		{
			System.out.println(b);
		}
	}

	@Override
	public void updatecustomerNameByActNumber(int actNumber, String customerName) {
	    em = EntityUtil.getEntityManager();
	    et = em.getTransaction();
	    et.begin();
	    BankAccount bankAccount = em.find(BankAccount.class, actNumber);
	    if(bankAccount != null) {
	        bankAccount.setCustomerName(customerName);
	        et.commit();
	        System.out.println("===> Updated Customer Name Successfully!");
	    } else {
	        System.out.println("No account found with actNumber " + actNumber);
	    }
	    em.close();
	}

	@Override
	public void deleteAccountById(int actNumber) {
		em = EntityUtil.getEntityManager();
		et = em.getTransaction();
		et.begin();
		BankAccount bankAccount = em.find(BankAccount.class, actNumber);
		if(bankAccount != null) {
			em.remove(bankAccount);
			et.commit();
			System.out.println("===>Account Deleted Successfully!");
		}
		else
		{
			System.out.println("No account found with actNumber"+actNumber);
		}
		em.close();
	}

	@Override
	public void findAccByactNumber(int actNumber) {
	    em = EntityUtil.getEntityManager();
	    BankAccount bankAccount = em.find(BankAccount.class, actNumber);
	    if(bankAccount != null) {
	        System.out.println("Account Exists!");
	        System.out.println(bankAccount);
	    } 
	    else {
	        System.out.println("Account Not Found with actNumber " + actNumber);
	    }
	    em.close();
	}
	
	@Override
	public void findAccByCustomerName(String customerName) {
	    em = EntityUtil.getEntityManager();
	    Query query = em.createQuery("SELECT b FROM BankAccount b WHERE b.customerName = :customerName");
	    query.setParameter("customerName", customerName);
	    List<BankAccount> list = query.getResultList();
	    if(list.isEmpty()) {
	        System.out.println("No accounts found with customerName " + customerName);
	    } else {
	        for(BankAccount b : list) {
	            System.out.println(b);
	        }
	    }
	    em.close();
	}
	
	@Override
	public void findAccByBranchCode(int branchCode) {
	    em = EntityUtil.getEntityManager();
	    Query query = em.createQuery("select b from BankAccount b where b.branchCode = :branchCode");
	    query.setParameter("branchCode", branchCode);
	    List<BankAccount> list = query.getResultList();
	    if(list.isEmpty()) {
	        System.out.println("No accounts found with branchCode " + branchCode);
	    } else {
	        for(BankAccount b : list) {
	            System.out.println(b);
	        }
	    }
	    em.close();
	}

	@Override
	public void groupByActNumberCustomerNameCity() {
	    em = EntityUtil.getEntityManager();
	    Query query = em.createQuery("select b.actNumber, b.customerName, b.city from BankAccount b group by b.actNumber, b.customerName, b.city");
	    List<Object[]> list = query.getResultList();
	    for(Object[] obj : list) {
	        System.out.println("actNumber" + obj[0] + "\ncustomerName: " + obj[1] + "\nCity: " + obj[2]);
	    }
	    em.close();
	}
}
