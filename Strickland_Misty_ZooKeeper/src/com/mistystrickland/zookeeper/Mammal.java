package com.mistystrickland.zookeeper;

public class Mammal {
	// attributes
	private int energyLevel;

	// constructors
	public Mammal() {
		this.energyLevel = 100;
	}
	
	// other methods
	public int displayEnergy() {
		System.out.println("Energy Level: " + this.energyLevel);
		return energyLevel;
	}

	//getters & setters
	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	
	
	
}
