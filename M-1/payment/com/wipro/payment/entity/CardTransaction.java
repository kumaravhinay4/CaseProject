package com.wipro.payment.entity;

import java.util.Date;

public class CardTransaction {
	private String paymentCardNo;
	private Date dateOfTransaction;
	private String transactionDesc;
	private double transactionAmount;
	private String transactionType;
	public CardTransaction ()
	{
		
	}
	public CardTransaction (String paymentCardNo, Date dateOfTransaction, String transactionDesc, double transactionAmount, String transactionType)
	{
		this.paymentCardNo=paymentCardNo;
		this.dateOfTransaction=dateOfTransaction;
		this.transactionDesc=transactionDesc;
		this.transactionAmount=transactionAmount;
		this.transactionType=transactionType;
	}
	
	
	public String getPaymentCardNo() {
		return paymentCardNo;
	}
	
	public void setPaymentCardNo(String paymentCardNo) {
		this.paymentCardNo = paymentCardNo;
	}
	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public String getTransactionDesc() {
		return transactionDesc;
	}
	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}
