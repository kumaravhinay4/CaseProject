package com.wipro.water.main;

import com.wipro.water.service.ConnectionService;

public class WaterMain {

	
	public static void main(String a[])
	{
		

			System.out.println(new ConnectionService().computeFinalBill(20,100,"domestic"));

			
	}


}
