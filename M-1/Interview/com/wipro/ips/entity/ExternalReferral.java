package com.wipro.ips.entity;

public class ExternalReferral extends Applicant{
	private String agencyName;
	public ExternalReferral (int applicantId,String applicantName,int yrsOfExp, String skills, 
			double expSalary, String agencyName)
	{
		super(applicantId,applicantName,yrsOfExp,skills,expSalary);
		//write code here
	}
}
