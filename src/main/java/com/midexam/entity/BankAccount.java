package com.midexam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankAccount {
	
	@Id
	private int actNumber;
	private String customerName;
	private double actBalance;
	private String city;
	private int branchCode;
	public BankAccount() {
		super();
	}
	public BankAccount(int actNumber, String customerName, double actBalance, String city, int branchCode) {
		super();
		this.actNumber = actNumber;
		this.customerName = customerName;
		this.actBalance = actBalance;
		this.city = city;
		this.branchCode = branchCode;
	}
	public int getActNumber() {
		return actNumber;
	}
	public void setActNumber(int actNumber) {
		this.actNumber = actNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getActBalance() {
		return actBalance;
	}
	public void setActBalance(double actBalance) {
		this.actBalance = actBalance;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(actBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + actNumber;
		result = prime * result + branchCode;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (Double.doubleToLongBits(actBalance) != Double.doubleToLongBits(other.actBalance))
			return false;
		if (actNumber != other.actNumber)
			return false;
		if (branchCode != other.branchCode)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BankAccount [actNumber=" + actNumber + ", customerName=" + customerName + ", actBalance=" + actBalance
				+ ", city=" + city + ", branchCode=" + branchCode + "]";
	}
	
}
