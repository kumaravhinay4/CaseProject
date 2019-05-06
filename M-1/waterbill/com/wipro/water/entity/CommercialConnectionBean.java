package com.wipro.water.entity;

public class CommercialConnectionBean extends ConnectionBean {

	public CommercialConnectionBean(int currentReading, int previousReading,float slabs[]) {
		super(currentReading, previousReading,slabs);
		//write code here
	}

	
	public float evaluateBill() {
				float amount=0.0f;
				float bill =0.0f;
				float duty = 0.0f;
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
				
				if(bill<5000)
				{
					 duty = (float) (bill*0.03);
				}
				else if((bill>=5000)&&(bill<9000))
				{
					 duty = (float) (bill*0.06);
				}
				else if(bill>=9000)
				{
					duty = (float) (bill*0.08);
				}
				amount= bill+duty;
				return amount;
	}

}
 
