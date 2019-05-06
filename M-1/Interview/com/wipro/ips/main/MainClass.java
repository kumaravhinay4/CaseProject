package com.wipro.ips.main;

import com.wipro.ips.entity.Applicant;
import com.wipro.ips.exception.DataValidationException;
import com.wipro.ips.service.ProfileEvaluator;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//write code here
		ProfileEvaluator pe = new ProfileEvaluator();

        pe.setJobId(101);

        pe.setJobName("Java Developer");

        pe.setExpMinExperience(2);

        pe.setExpMaxExperience(5);

        pe.setRequiredSkill("java,sql");

       

        int applicantId = 1001;

        String applicantName = "abc";

        int yrsOfExp = 2;

        String skills = "dos,oracle,sql,java,servlets,jsp,spring";

        double expSalary = 120000;

        char referralType = 'I';

        String referralInfo = "12345";


        Applicant applicant = pe.createObject(referralType, applicantId, applicantName, yrsOfExp, skills, expSalary, referralInfo);

       

        try

        {

               String status = pe.validateObject(applicant);

               if(status.equals("VALID"))

               {

                     String result = pe.processProfile(applicant);

                     System.out.println("Process Result is :"+result);

               }

        }

        catch (DataValidationException e) {

               e.printStackTrace();

        }            
	}

}
