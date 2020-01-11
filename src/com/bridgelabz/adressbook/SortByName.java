package com.bridgelabz.adressbook;

import java.util.Comparator;

public class SortByName implements Comparator<Person>{

	@Override
	public int compare(Person personOne, Person personTwo) {
		if(personOne.getFirstName().contentEquals(personTwo.getFirstName())) {
			
			return 0;
		}else if(personOne.getFirstName().compareTo(personTwo.getFirstName())>0) {
			return 1;
		}
		return -1;
	}

	
	

}
