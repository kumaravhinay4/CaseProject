package com.wipro.ips.service;

import com.wipro.ips.entity.Applicant;
import com.wipro.ips.entity.ExternalReferral;
import com.wipro.ips.entity.InternalReferral;
import com.wipro.ips.exception.DataValidationException;

public class ProfileEvaluator {
	private int JobId;
	private String JobName;
	private String requiredSkill;
	private int expMinExperience;
	private int expMaxExperience;
	
	
	/**
	 * @return the jobId
	 */
	public int getJobId() {
		return JobId;
	}

	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(int jobId) {
		JobId = jobId;
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return JobName;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		JobName = jobName;
	}

	/**
	 * @return the requiredSkill
	 */
	public String getRequiredSkill() {
		return requiredSkill;
	}

	/**
	 * @param requiredSkill the requiredSkill to set
	 */
	public void setRequiredSkill(String requiredSkill) {
		this.requiredSkill = requiredSkill;
	}

	/**
	 * @return the expMinExperience
	 */
	public int getExpMinExperience() {
		return expMinExperience;
	}

	/**
	 * @param expMinExperience the expMinExperience to set
	 */
	public void setExpMinExperience(int expMinExperience) {
		this.expMinExperience = expMinExperience;
	}

	/**
	 * @return the expMaxExperience
	 */
	public int getExpMaxExperience() {
		return expMaxExperience;
	}

	/**
	 * @param expMaxExperience the expMaxExperience to set
	 */
	public void setExpMaxExperience(int expMaxExperience) {
		this.expMaxExperience = expMaxExperience;
	}
	

	public Applicant createObject(char referralType, int applicantId,
			String applicantName, int yrsOfExp, String skills,
			double expSalary, String referralInfo) {
		// write code here
		if(referralType=='I'){
			int empi=Integer.parseInt(referralInfo);
			InternalReferral IRO=new InternalReferral(applicantId, applicantName, yrsOfExp, skills, expSalary, empi);
			return IRO;
		}else if(referralType=='E'){
			ExternalReferral ERO=new ExternalReferral(applicantId, applicantName, yrsOfExp, skills, expSalary,referralInfo );
				return ERO;	
		}else{
		return null;
		}
	}

	public String validateObject(Applicant applicant)
			throws DataValidationException {
		// write code here
		
		if(applicant==null||applicant.getApplicantName()==""||applicant.getApplicantName()==null){
			throw new DataValidationException();
		}else if(applicant.getYrsOfExp()<=0){
			return "INVALID EXPERIENCE";
		}else if(applicant.getExpectedSalary()<=0){
			return "INVALID SALARY";
		}else{
		return "VALID";
		}
	}
	

	public String processProfile(Applicant applicant) {
		// write code here
		   String[] str=applicant.getSkills().split(",");
		    int len=str.length;
		    int count=0;
		   String[] reqs=requiredSkill.split(",");
		   int len2=reqs.length;
		  
		   for(int i=0;i<=len-1;i++){ 
			   for(int j=0;j<=len2-1;j++){
		 if((str[i].equalsIgnoreCase(reqs[j]))){
			count++;
		 }
		}
		} 
		   if(count==0){
			   return "NON ELIGIBLE SKILLS";
		   }
		   else if(!(applicant.getYrsOfExp()>=expMinExperience && applicant.getYrsOfExp()<=expMaxExperience)){
				return "NON ELIGIBLE EXPERIENCE";
			}
		else{
		return "SELECTED";
		}
	}

}
