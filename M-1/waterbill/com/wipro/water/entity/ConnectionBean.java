package com.wipro.water.entity;

public abstract class ConnectionBean {
	int previousReading;
	int currentReading;
	float[] slabs;
	
	public float[] getSlabs() {
		return slabs;
	}
	public void setSlabs(float[] slabs) {
		this.slabs=slabs;
	}

	public ConnectionBean(int currentReading, int previousReading,float slabs[]) {
		this.currentReading = currentReading;
		this.previousReading = previousReading;
		this.slabs = slabs;
	}
	public int getPreviousReading() {
		return previousReading;
	}
	public void setPreviousReading(int previousReading) {
		this.previousReading=previousReading;
	}
	public int getCurrentReading() {
		return currentReading;
	}
	public void setCurrentReading(int currentReading) {
		this.currentReading=currentReading;
	}
	public abstract float evaluateBill();

}
