package com.caresoft.clinicapp;

public interface HIPAACompliantUser {
	
	// has to be completed when the interface is implemented
	abstract boolean assignPin(int pin);
	abstract boolean accessAuthorized(Integer confirmedAuthID);

}
