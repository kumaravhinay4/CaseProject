package com.wipro.eb.entity;

public class Domestic extends Connection {

	public Domestic(int currentReading, int previousReading, float slabs[]) {
		super(currentReading, previousReading, slabs);

	}

	public float computeBill() {

		float billamount = 0.0f;

		int units = currentReading - previousReading;

		if (units <= 50) {
			billamount = units * 2.3f;

		} else {

			if (units > 50 && units <= 100) {
				billamount = (units - 50) * 4.2f + (50 * 2.3f);
			} else {
				billamount = (units - 100) * 5.5f + (50 * 2.3f) + (50 * 4.2f);
			}

		}
		System.out.println("billamount" + billamount);
		return billamount;
	}

}
