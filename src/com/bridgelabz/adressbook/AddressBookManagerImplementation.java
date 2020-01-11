package com.bridgelabz.adressbook;


import java.io.File;
import java.io.IOException;

public class AddressBookManagerImplementation implements AddressBookManager {

	//private static final String String = null;

	@Override
	public void create() throws IOException {
		Utility utility	=	new Utility();
		System.out.println("Enter the file name you want to create");
		String NewAddressBook	=	utility.read_String();
		File file	=	new File("/home/admin1/Desktop/Fellowship_Pranita_Jadhav/OOPsProjects/AddressBook/"+NewAddressBook+".json");
		 if(file.createNewFile()) {
			 System.out.println("New file is created");
		 }else {
			 System.out.println("File is already there");
		 }
		
	}

	@Override
	public void save(String file) {
		AdressBookImplementation ab	=	new AdressBookImplementation();
		ab.save(file);
	}

	@Override
	public void saveAs() {
		AdressBookImplementation ab	=	new AdressBookImplementation();
		ab.saveAs();
		
	}

	@Override
	public void close(String existingaddressBook) {
		AdressBookImplementation ab	=	new AdressBookImplementation();
		ab.close(existingaddressBook);
		
	}

	public boolean checkAddress(String existingAddressBook) {
		File f = new File("/home/admin1/Desktop/Fellowship_Pranita_Jadhav/OOPsProjects/AddressBook/");
		int count = 0;
		for (File file : f.listFiles()) {
			if (file.isFile()) {
				if (file.getName().equals(existingAddressBook+".json")) {
					count++;
					break;
				}
			}
		}
			if (count == 1)
			return true;
		else
			return false;
	}

	
	public void readAddress() {
		File f = new File("/home/admin1/Desktop/Fellowship_Pranita_Jadhav/OOPsProjects/AddressBook/");
		int count = 0;
		for (File file : f.listFiles()) {
			if (file.isFile()) {
				System.out.println("\n\t\t\t"+file.getName());
				count++;
			}
		}
		System.out.println("\n\t\t\tNumber of files: " + count);
	}
	
	  @Override public void read(String existingAddressBook) throws Exception {
	  AdressBookImplementation ab = new AdressBookImplementation();
	  //ab.read(existingAddressBook);
	  
	  }
	 
	

}