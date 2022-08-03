package com.mistystrickland.inheritancedemo;

import java.util.ArrayList;

public class Developer {
	// attributes (private/protected)
	private String name;
	private ArrayList<String> languages;
	private int salary;
	private double hoursOfSleep;
	
	
	public Developer(String name, ArrayList<String> languages, int salary, double hoursOfSleep) {
		this.name = name;
		this.languages = languages;
		this.salary = salary;
		this.hoursOfSleep = hoursOfSleep;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<String> getLanguages() {
		return languages;
	}


	public void setLanguages(ArrayList<String> languages) {
		this.languages = languages;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public double getHoursOfSleep() {
		return hoursOfSleep;
	}


	public void setHoursOfSleep(double hoursOfSleep) {
		this.hoursOfSleep = hoursOfSleep;
	}
	
	
	
	
}
