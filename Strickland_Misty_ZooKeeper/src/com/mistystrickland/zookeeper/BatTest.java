package com.mistystrickland.zookeeper;

public class BatTest {

	public static void main(String[] args) {
		System.out.println("--- Bat Test ---");
		
		Bat bat1 = new Bat(300);
		bat1.displayEnergy();
		bat1.fly();
		bat1.fly();
		bat1.displayEnergy();
		bat1.attackTown();
		bat1.eatHumans();
		bat1.displayEnergy();
		bat1.eatHumans();
		bat1.attackTown();
		bat1.displayEnergy();
		bat1.attackTown();
		bat1.displayEnergy();
	}

}
