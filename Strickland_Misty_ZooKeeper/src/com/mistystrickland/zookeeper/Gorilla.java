package com.mistystrickland.zookeeper;

public class Gorilla extends Mammal{
	
	public Gorilla() {
		super();
	}
	
	public void throwSomething() {
		System.out.println("The gorilla threw something!");
		this.setEnergyLevel(getEnergyLevel() - 5);
	}
	
	public void eatBananas() {
		System.out.println("Yummy bananas! Gorilla is happy!");
		this.setEnergyLevel(getEnergyLevel() + 10);
	}
	
	public void climb() {
		System.out.println("The gorilla has climbed a tree!");
		this.setEnergyLevel(getEnergyLevel() - 10);
	}
}
