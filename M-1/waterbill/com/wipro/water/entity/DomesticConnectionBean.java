package com.wipro.water.entity;

public class DomesticConnectionBean extends ConnectionBean {

	public DomesticConnectionBean(int currentReading, int previousReading,float slabs[]) {
		super(currentReading, previousReading,slabs);
		//write code here
	}

	@Override
	public float evaluateBill() {
		float bill =0.0f;
		float read = currentReading-previousReading;
		if((read>=1)&&(read<=60))
		{
			bill = read*slabs[0];
		}
		else if((read>=61)&&(read<=120))
		{
			bill = (60*slabs[0]+((read-60)*slabs[1]));
		}
		else if(read>120)
		{
			bill = (60*slabs[0]+60*slabs[1]+((read-120)*slabs[2]));
		}
		return bill;
	}
}