package com.bridgelabz.adressbook;

import java.util.Comparator;

public class SortByZip implements Comparator<Person>{

	
	public int compare(Person personOneZip, Person personTwoZip) {
		// TODO Auto-generated method stu

		if(personOneZip.adress.getZip() == personTwoZip.adress.getZip()) {
			return 0;
		}else if(personOneZip.adress.getZip() > personTwoZip.adress.getZip()) {
			
			return -1;
		}
		return 0;
	}

}
