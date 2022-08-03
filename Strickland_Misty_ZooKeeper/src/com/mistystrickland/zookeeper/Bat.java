package com.mistystrickland.zookeeper;

public class Bat extends Mammal {
	
	public Bat(int energyLevel) {
		super(energyLevel);
	}
	
	public void fly() {
		System.out.println("Whooosh!");
		this.setEnergyLevel(getEnergyLevel() - 50);
	}
	
	public void eatHumans() {
		System.out.println("Eating human; yummy!");
		this.setEnergyLevel(getEnergyLevel() + 25);
	}
	
	public void attackTown() {
		System.out.println("Aaaaaaa, fire! ...fire crackling...");
		this.setEnergyLevel(getEnergyLevel() - 100);
	}
}
