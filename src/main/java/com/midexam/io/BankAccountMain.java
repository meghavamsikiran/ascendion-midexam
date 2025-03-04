package com.midexam.io;

import java.util.Scanner;

import com.midexam.entity.BankAccount;
import com.midexam.exception.InputMismatchException;
import com.midexam.service.BankAccountService;
import com.midexam.service.BankAccountServiceImpl;

public class BankAccountMain {
	static Scanner sc = null;
	static BankAccountService bankAccountService=null;
	 public static void main(String[] args) {
	        sc = new Scanner(System.in);
	        boolean displayMenu = true;

	        while (true) {
	            if (displayMenu) {

	            	System.out.println("\n1. Create Account");
	                System.out.println("2. Display All Account Details");
	                System.out.println("3. Update an Account By Id");
	                System.out.println("4. Delete an Account By Id");
	                System.out.println("5. Find BankAccount by actNumber");
	                System.out.println("6. Find BankAccounts by customerName");
	                System.out.println("7. Find BankAccounts by branchCode");
	                System.out.println("8. Group BankAccounts by actNumber, customerName, city");
	                System.out.println("Select an Option (1-8) or type 'no' to exit: ");
	            }

	            String inp = sc.next();
	            if (inp.equalsIgnoreCase("no")) {
	                break;
	            }
	            
	            try {
	                int ch = Integer.parseInt(inp);
	                
	                switch (ch) {
	                    case 1:
	                        createAccount();
	                        break;
	                    case 2:
	                        displayAllAccountDetails();
	                        break;
	                    case 3:
	                        updatecustomerNameByActNumber();
	                        break;
	                    case 4:
	                        deleteAccountById();
	                        break;
	                    case 5:
	                        findAccByactNumber();
	                        break;
	                    case 6:
	                        findAccByCustomerName();
	                        break;
	                    case 7:
	                        findAccByBranchCode();
	                        break;
	                    case 8:
	                        groupByActNumberCustomerNameCity();
	                        break;
	                    default:
	                        System.out.println("Invalid Option!");
	                        break;
	                }
	                
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid Input! Please enter a number between 1 and 8 or 'no' to exit.");
	            }
	        }
	 }
	
	private static void createAccount() {
		sc = new Scanner(System.in);
		System.out.println("Enter actNumber: ");
		int actNumber = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter customerName: ");
		String customerName = sc.nextLine();
		System.out.println("Enter accountBalance: ");
		double actBalance = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter City: ");
		String city = sc.nextLine();
		System.out.println("Enter Branch Code: ");
		int branchCode = sc.nextInt();
		
		BankAccount bankAccount = new BankAccount();
		bankAccount.setActNumber(actNumber);
		bankAccount.setCustomerName(customerName);
		bankAccount.setActBalance(actBalance);
		bankAccount.setCity(city);
		bankAccount.setBranchCode(branchCode);
		
		bankAccountService = new BankAccountServiceImpl();
		bankAccountService.createAccount(bankAccount);
	}
	
	private static void displayAllAccountDetails() {
		BankAccountService bankAccountService = new BankAccountServiceImpl();
		bankAccountService.displayAllAccountDetails();
	}
	
	private static void updatecustomerNameByActNumber() {
		sc = new Scanner(System.in);
		System.out.println("Enter account number to update customer name: ");
		int actNumber  = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter New Customer Name: ");
		String customerName = sc.nextLine();
		
		BankAccountService bankAccountService = new BankAccountServiceImpl();
		bankAccountService.updatecustomerNameByActNumber(actNumber, customerName);
	}
	
	private static void deleteAccountById() {
		sc = new Scanner(System.in);
		System.out.println("Enter account number: ");
		int actNumber =sc.nextInt();
		
		BankAccountService bankAccountService = new BankAccountServiceImpl();
		bankAccountService.deleteAccountById(actNumber);
	}
	
	private static void findAccByactNumber() {
		sc = new Scanner(System.in);
		System.out.println("Enter account number: ");
		int actNumber =sc.nextInt();
		
		BankAccountService bankAccountService = new BankAccountServiceImpl();
		bankAccountService.findAccByactNumber(actNumber);
	}
	
	private static void findAccByCustomerName() {
		sc = new Scanner(System.in);
		System.out.println("Enter Customer Name: ");
		String customerName = sc.nextLine();
		BankAccountService bankAccountService = new BankAccountServiceImpl();
		bankAccountService.findAccByCustomerName(customerName);
	}
	
	private static void findAccByBranchCode() {
		sc = new Scanner(System.in);
		System.out.println("Enter bankch Code: ");
		int branchCode = sc.nextInt();
		BankAccountService bankAccountService = new BankAccountServiceImpl();
		bankAccountService.findAccByBranchCode(branchCode);
		
	}
	
	private static void groupByActNumberCustomerNameCity() {
		
		BankAccountService bankAccountService = new BankAccountServiceImpl();
		bankAccountService.groupByActNumberCustomerNameCity();
	}
}
