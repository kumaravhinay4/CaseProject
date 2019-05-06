package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {

	public boolean validate(int currentReading, int previousReading, String type)
			throws InvalidReadingException, InvalidConnectionException {
		boolean res;
		if ((currentReading < previousReading) || currentReading < 0 || previousReading < 0) {

			throw new InvalidReadingException();
		} else if (!(type.equalsIgnoreCase("Domestic") || type.equalsIgnoreCase("Commercial"))) {
			throw new InvalidConnectionException();
		} else {
			res = true;
		}
		return res;
	}

	public float calculateBillAmt(int currentReading, int previousReading, String type) {
		
		float billa = 0.0f;

		try {
			if (validate(currentReading, previousReading, type) == true) {
				if (type=="Domestic") {
					
					Domestic domestic = new Domestic(currentReading, previousReading, new float[] { 2.3f, 4.2f, 5.5f });
					billa = domestic.computeBill();
				} else if (type=="Commercial") {
					Commercial commercial = new Commercial(currentReading, previousReading,
							new float[] { 5.2f, 6.8f, 8.3f });
					billa = commercial.computeBill();

				}
			}
		}
		
		
		
		catch (InvalidReadingException e) {

			billa = -1;

		} catch (InvalidConnectionException e) {
			billa = -2;
		}
		return billa;
	}

	public String generateBill(int currentReading, int previousReading, String type) {

		String status = "";
		float result = calculateBillAmt(currentReading, previousReading, type);
		if (result == -1) {
			status = "Incorrect Reading";
		} else if (result == -2) {
			status = "Invalid ConnectionType";
		} else	
			status = "Amount to be paid:" + result;
	
		return status;
	}

}
