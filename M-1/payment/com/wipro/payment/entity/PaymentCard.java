package com.wipro.payment.entity;

import java.util.Date;

import com.wipro.payment.exception.InvalidInputException;

public class PaymentCard {
	private String paymentCard;
	private String customerId;
	private Date billDate;
	private CardTransaction monthTransactions[];
	
	public PaymentCard ()
	{}
	public PaymentCard (String paymentCard,String customerId, Date BillDate, CardTransaction monthTransactions[])
	{
		this.paymentCard=paymentCard;
		this.customerId=customerId;
		this.billDate=BillDate;
		this.monthTransactions=monthTransactions;
	}
	public double getTotalAmount(String transactionType)
	{
		
		double result=0;
	
		for(int i=0;i<monthTransactions.length;i++){
		if(monthTransactions[i].getTransactionType().equals(transactionType)){
			result=result+monthTransactions[i].getTransactionAmount();
		}
		else if(monthTransactions[i].getTransactionType().equals(transactionType)){
			result=result+monthTransactions[i].getTransactionAmount();
		}
		}
		return result;
	}
	public double calculateAmount() {
	double result=0.0;
	double result1=0.0;
	double a=0.0;
	double b=0.0;
	double c=0.0;
	double d=0.0;
	boolean val=false;
		try {
			val=validateInput().equalsIgnoreCase("valid");
	
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		
		if(val==true){
			
			if(monthTransactions!=null && monthTransactions.length>0){
			
				for(int i=0;i<monthTransactions.length;i++){
					if(monthTransactions[i].getTransactionType().equals("DB")){
					result=getTotalAmount("DB");
					}
					else if(monthTransactions[i].getTransactionType().equals("CR")){
						result1=getTotalAmount("CR");
					}
				}
				System.out.println(result+" "+result1);
				a=result-result1;
				
				b=(19.9/100)/12;
				c=(a*b);
				d=c+a;
				return d;
			}
			else{
				result=0.0;
			}
			
		}else{
			return 0.0;
		}
		
		
		return result;
	}
	public String validateInput() throws InvalidInputException
	{
		String status="";
		if(paymentCard==null){
			throw new InvalidInputException();
		}
		else if(!(paymentCard.length()==16)){
			throw new InvalidInputException();
		}
		else if(customerId==null){
			throw new InvalidInputException();
		}
		else if(!(customerId.length()>=6)){
			throw new InvalidInputException();
		}
		else {
			status="valid";
		}
		return status;
	}
}
