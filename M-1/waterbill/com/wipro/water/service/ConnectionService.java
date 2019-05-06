package com.wipro.water.service;


import com.wipro.water.entity.CommercialConnectionBean;
import com.wipro.water.entity.DomesticConnectionBean;
import com.wipro.water.exception.IncorrectConnectionException;
import com.wipro.water.exception.IncorrectReadingException;
public class ConnectionService {

	public boolean validateData(int currentReading, int previousReading, String type)throws IncorrectReadingException, IncorrectConnectionException
	{
		if((currentReading<=0)||(previousReading<=0)||(currentReading<previousReading))
		{
			throw new IncorrectReadingException();
		}
		if((type.equalsIgnoreCase("domestic"))||(type.equalsIgnoreCase("commercial")))
		{
			
		}
		else
			throw new IncorrectConnectionException();
		return true;
	}

	public float generateBill(int currentReading, int previousReading,	String type) 
	{
		float bill=0.0f;
		boolean validate;
		try {
			 validate = validateData(currentReading, previousReading, type);
		} catch (IncorrectReadingException e) {
			toString();
			return -1;
			
		} catch (IncorrectConnectionException e) {
			toString();
			return -2;
		}
		if(validate==true)
		{
			if(type.equalsIgnoreCase("domestic"))
			{
				float slab[] = {3.9f,5.2f,8.3f};
				DomesticConnectionBean d = new DomesticConnectionBean(currentReading, previousReading, slab);
				bill = d.evaluateBill();
			}
			if(type.equalsIgnoreCase("commercial"))
			{
				float slab[] = {5.1f,6.8f,9.3f};
				CommercialConnectionBean c = new CommercialConnectionBean(currentReading, previousReading, slab);
				bill = c.evaluateBill();
			}
		}
		
		return bill;
	}
	
	public String computeFinalBill(int currentReading, int previousReading, String type)
	{
			String result="";
			float ret = 0.0f;
			ret = generateBill(currentReading, previousReading, type);
			if(ret==-1)
			{
				return "Enter correct Reading";
			}
			else if(ret==-2)
			{
				return "Enter a valid Connection";
			}
			else
			{
			result="Total Amount to be paid is : "+ret;
			return result;}
	}
	
}
