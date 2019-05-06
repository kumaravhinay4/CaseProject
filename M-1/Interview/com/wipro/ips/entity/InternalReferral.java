package com.wipro.ips.entity;

public class InternalReferral extends Applicant{

	private int employeeId;
	public InternalReferral (int applicantId,String applicantName,int yrsOfExp, 
			String skills, double expSalary, int employeeId)
	{
		super(applicantId, applicantName, yrsOfExp, skills, expSalary);
		//write code here
		this.employeeId=employeeId;
	}
}
