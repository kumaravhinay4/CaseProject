package com.wipro.ips.entity;

public class Applicant {
	private int applicantId;
	private String applicantName;
	private int yrsOfExp;
	private String skills;
	private double expectedSalary;
	
	public Applicant(int applicantId,String applicantName,int yrsOfExp, String skills, double expSalary)
	{
		//write code here
		this.applicantId=applicantId;
		this.applicantName=applicantName;
		this.yrsOfExp=yrsOfExp;
		this.skills=skills;
		expectedSalary=expSalary;
	}

	/**
	 * @return the applicantId
	 */
	public int getApplicantId() {
		return applicantId;
	}

	/**
	 * @param applicantId the applicantId to set
	 */
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	/**
	 * @return the applicantName
	 */
	public String getApplicantName() {
		return applicantName;
	}

	/**
	 * @param applicantName the applicantName to set
	 */
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	/**
	 * @return the yrsOfExp
	 */
	public int getYrsOfExp() {
		return yrsOfExp;
	}

	/**
	 * @param yrsOfExp the yrsOfExp to set
	 */
	public void setYrsOfExp(int yrsOfExp) {
		this.yrsOfExp = yrsOfExp;
	}

	/**
	 * @return the skills
	 */
	public String getSkills() {
		return skills;
	}

	/**
	 * @param skills the skills to set
	 */
	public void setSkills(String skills) {
		this.skills = skills;
	}

	/**
	 * @return the expectedSalary
	 */
	public double getExpectedSalary() {
		return expectedSalary;
	}

	/**
	 * @param expectedSalary the expectedSalary to set
	 */
	public void setExpectedSalary(double expectedSalary) {
		this.expectedSalary = expectedSalary;
	}
	
	

}
