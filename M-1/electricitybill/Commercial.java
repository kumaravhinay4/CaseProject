package com.wipro.eb.entity;

public class Commercial extends Connection {

	public Commercial(int currentReading, int previousReading, float slabs[]) {
		super(currentReading, previousReading, slabs);

	}

	public float computeBill() {

		float billamount = 0.0f;
		float totalbillamout = 0.0f;

		int units = currentReading - previousReading;

		if (units <= 50) {
			billamount = units * 5.2f;

		} else {

			if (units > 50 && units <= 100) {
				billamount = (units - 50) * 6.8f + (50 * 5.2f);
			} else {
				billamount = (units - 100) * 8.3f + (50 * 5.2f) + (50 * 6.8f);
			}

		}
		if (billamount < 5000)
			totalbillamout = billamount + billamount * 0.02f;
		else if (billamount >= 5000)
			totalbillamout = billamount + billamount * 0.06f;
		else if (billamount >= 10000)
			totalbillamout = billamount + billamount * 0.09f;

		return totalbillamout;
	}

}
